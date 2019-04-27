package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class GestioneModuliAzienda {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    private Azienda azienda;
    private boolean error;

    public GestioneModuliAzienda(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = null;
        this.error = false;
    }

    GestioneModuliAzienda(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext context, Azienda azienda) {
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = azienda;
        this.error = false;
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.context.getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void ritornaAzienda(HttpServletRequest request, HttpServletResponse response) {
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            this.azienda = session.getAzienda(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillConvenzione() {
        datamodel.put("DataConvenzione", azienda.getDataConvenzione());
        datamodel.put("DataUpdate", azienda.getUpdateDate());
        datamodel.put("DataCreate", azienda.getCreateDate());
        datamodel.put("IDConvenzione", azienda.getIDAzienda());
    }

    List<OffertaTirocinio> ritornaOfferte() {
        OffertaTirocinioDaoImp daoOfferte = new OffertaTirocinioDaoImp();
        List<OffertaTirocinio> offertaTirocinios = new ArrayList<>();
        try {
            offertaTirocinios.addAll(daoOfferte.getOffertatrBYAzienda(azienda));
            daoOfferte.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        //System.out.println(offertaTirocinios.toString());
        return offertaTirocinios;
    }

     List<Tirocinio> ritornaTirocinii(List<OffertaTirocinio> offertaTirocinios) {
        TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
        List<Tirocinio> listaTirocini = new ArrayList<>();
        for (OffertaTirocinio offertaTirocinio : offertaTirocinios) {
            try {
                listaTirocini.addAll(daoTirocinio.getTrByOfferta(offertaTirocinio));
                daoTirocinio.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(listaTirocini.toString());
        return listaTirocini;
    }

     List<Tirocinante> ritornaTirocinanti(List<Tirocinio> listaTirocini) {
        TirocinanteDaoImp daoTirocinante = new TirocinanteDaoImp();
        List<Tirocinante> listaTirocinanti = new ArrayList<>();
        for (Tirocinio tirocinio : listaTirocini) {
            try {
                listaTirocinanti.add(daoTirocinante.getTirocianteByID(tirocinio.getTirocinante()));
                daoTirocinante.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(listaTirocinanti.toString());
        return listaTirocinanti;
    }

   void creaDatamodel(List<Tirocinante> tirocinantes, List<OffertaTirocinio> offertaTirocinios, List<Tirocinio> tirocinios) {
        List<Object> lista = new ArrayList<>();
        int idOfferta = 0;
        int idTircinante = 0;
        for (Tirocinio tirocinio : tirocinios) {
            Map<String, Object> mappa = new HashMap<String, Object>();
            idOfferta = tirocinio.getOffertaTirocinio();
            idTircinante = tirocinio.getTirocinante();

            mappa.put("tirocinio", tirocinio);
            for (OffertaTirocinio offertaTirocinio : offertaTirocinios) {
                if (offertaTirocinio.getIDOffertaTirocinio() == idOfferta) {
                    mappa.put("offerta", offertaTirocinio);
                    break;
                }
            }
            for (Tirocinante tirocinante : tirocinantes) {
                if (tirocinante.getIDTirocinante() == idTircinante) {
                    mappa.put("tirocinante", tirocinante);
                    UserDaoImp daoUser = new UserDaoImp();
                    try {
                        User user = daoUser.getUserByid(tirocinante.getUser());
                        mappa.put("userMail", user.getEmail());
                        daoUser.destroy();
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }

                    break;
                }
            }
            if (tirocinio.getStato().equals(1)||tirocinio.getStato().equals(2)){
                lista.add(mappa);
            }
        }
        datamodel.put("Lista", lista);
    }

    private void checkPdf(Azienda azienda) {
        if (azienda.getPathPDFConvenzione() == null) {
            datamodel.put("EsistePdf", false);
        } else {
            datamodel.put("EsistePdf", true);
        }
    }

    private void checkScadenzaConvenzione(Azienda azienda) {
        if (azienda.getDataConvenzione() == null && azienda.getDurataConvenzione() == null) {
            datamodel.put("CreaConvenzione", true);
        } else {
            Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
            Calendar passato = (Calendar) scadenza.get("passato");
            Calendar presente = (Calendar) scadenza.get("presente");
            Boolean scaduto = (Boolean) scadenza.get("scaduto");
            //presente.set(2018,Calendar.SEPTEMBER,3);
            //scaduto = false;
            System.out.println("data convenzione: " + azienda.getDataConvenzione() + " durata: " + azienda.getDurataConvenzione() + " scade il " + passato.getTime() + " oggi e" + presente.getTime() + " e scaduta: " + scaduto);

            //if (presente.before(passato)){
            if (!scaduto) {
                // Get the represented date in milliseconds
                long millis1 = presente.getTimeInMillis();
                long millis2 = passato.getTimeInMillis();

                // Calculate difference in milliseconds
                long diff = millis2 - millis1;

                long diffDays = diff / (24 * 60 * 60 * 1000);
                System.out.println("In days: " + diffDays + " days.");
                int ggAllaScadenza = (int) diffDays;
                datamodel.put("GiorniScadenza", ggAllaScadenza);
                datamodel.put("ConvenzioneScaduta", false);
            } else {
                datamodel.put("ConvenzioneScaduta", true);
            }
            checkPdf(azienda);
        }
    }

    private void aggiornaFini(List<String> parametriFIN) throws ServletException, IOException {
        for (String param : parametriFIN) {
            String[] parts = param.split("-");
            for (String part: parts) {
                System.out.println(part);
            }
            String p = request.getParameter(param);
            String[] nomeParts= parts[0].split("fin_");
            String nomeTirocinante = nomeParts[1];
            String cognomeTirocinante = parts[1];
            int idTirocinante = Integer.parseInt(parts[2]);
            int idTirocinio = Integer.parseInt(parts[3]);
            Tirocinio tiro = new Tirocinio();
            Tirocinante tirocinante = new Tirocinante();
            try {
                TirocinioDaoImp daoTiro = new TirocinioDaoImp();
                TirocinanteDaoImp daoTirocinante = new TirocinanteDaoImp();
                tirocinante = daoTirocinante.getTirocianteByID(idTirocinante);
                tiro = daoTiro.getRichiestatrByID(idTirocinio);
                daoTiro.destroy();
                daoTirocinante.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
                request.setAttribute("MessaggioErrore", "problemi db: lista tirocinii e tirocinante");
                er500(request, response);
                this.error = true;
            }
            if(!tirocinante.getNome().equals(nomeTirocinante)||!tirocinante.getCognome().equals(cognomeTirocinante)||!p.equals("1")){
                request.setAttribute("MessaggioErrore", "problemi con oggetto tirocinate");
                er500(request, response);
                this.error = true;
            }
            if (!error) {
                if ((tirocinante.getNome().equals(parts[0].split("fin_")[1])) && (tirocinante.getCognome().equals(parts[1]))) {
                    if (tiro.getTirocinante().equals(tirocinante.getIDTirocinante())) {
                        System.out.println("Si coincide");
                        tiro.setStato(2);
                        System.out.println("lo stato: " + tiro.getStato());
                        try {
                            TirocinioDaoImp daoTiro = new TirocinioDaoImp();
                            daoTiro.updateTirocinio(tiro);
                            daoTiro.destroy();
                        } catch (DaoException e) {
                            e.printStackTrace();
                            request.setAttribute("MessaggioErrore", "problemi con il set della richiesta fin sul db");
                            er500(request, response);
                            this.error = true;
                        }

                    }
                }
            }
        }
    }

    public void get() {
        ritornaAzienda(request, response);
        List<OffertaTirocinio> offert = ritornaOfferte();
        List<Tirocinio> tiro = ritornaTirocinii(offert);
        List<Tirocinante> tirocinante = ritornaTirocinanti(tiro);
        creaDatamodel(tirocinante, offert, tiro);
        fillConvenzione();
        checkScadenzaConvenzione(azienda);
        TemplateController.process("moduli-aziendale.ftl", datamodel, response, context);
    }

    /**
     * Faccio il post solo per settare i tirocini finiti
     */
    public void post() throws ServletException, IOException {
        Map params = request.getParameterMap();
        List<String> parametri = new ArrayList<String>();
        for (Object o : params.keySet()) {
            String key = (String) o;
            String value = ((String[]) params.get(key))[0];
            if (key.startsWith("fin_") && value.equals("1")) {
                parametri.add(key);
            }
        }
        System.out.println(parametri);
        aggiornaFini(parametri);
        this.get();
    }

}
