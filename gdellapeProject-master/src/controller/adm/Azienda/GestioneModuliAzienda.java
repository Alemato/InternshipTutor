package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.UserDaoImp;
import model.*;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.*;
import java.io.IOException;
import java.util.*;

public class GestioneModuliAzienda {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    private Azienda azienda;

    public  GestioneModuliAzienda(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext context){
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = null;
    }

    private void ritornaAzienda(HttpServletRequest request, HttpServletResponse response){
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            this.azienda = session.getAzienda(request,response);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void fillConvenzione(){
        //TODO Implementare controllo data di convenzione
        datamodel.put("DataConvenzione", azienda.getDataConvenzione());
        datamodel.put("DataUpdate", azienda.getUpdateDate());
        datamodel.put("DataCreate", azienda.getCreateDate());
    }

    private List<OffertaTirocinio> ritornaOfferte(){
        OffertaTirocinioDaoImp daoOfferte = new OffertaTirocinioDaoImp();
        List<OffertaTirocinio> offertaTirocinios = new ArrayList<>();
        try {
            offertaTirocinios.addAll(daoOfferte.getOffertatrBYAzienda(azienda));
            daoOfferte.destroy();
        }
        catch (DaoException e ){
            e.printStackTrace();
        }
        //System.out.println(offertaTirocinios.toString());
        return offertaTirocinios;
    }

    private List<Tirocinio> ritornaTirocinii(List<OffertaTirocinio> offertaTirocinios){
        TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
        List<Tirocinio> listaTirocini = new ArrayList<>();
        for(OffertaTirocinio offertaTirocinio : offertaTirocinios){
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

    private List<Tirocinante> ritornaTirocinanti(List<Tirocinio> listaTirocini) {
        TirocinanteDaoImp daoTirocinante = new TirocinanteDaoImp();
        List<Tirocinante> listaTirocinanti = new ArrayList<>();
        for (Tirocinio tirocinio: listaTirocini){
            try {
                listaTirocinanti.add(daoTirocinante.getTirocianteByID(tirocinio.getTirocinante()));
                daoTirocinante.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(listaTirocinanti.toString());
        return  listaTirocinanti;
    }

    private void creaDatamodel(List<Tirocinante> tirocinantes, List<OffertaTirocinio> offertaTirocinios, List<Tirocinio> tirocinios){
        List<Object> lista = new ArrayList<>();
        int idOfferta = 0;
        int idTircinante = 0;
        for (Tirocinio tirocinio : tirocinios){
            Map<String, Object> mappa = new HashMap<String, Object>();
            idOfferta = tirocinio.getOffertaTirocinio();
            idTircinante = tirocinio.getTirocinante();

            mappa.put("tirocinio", tirocinio);
            for (OffertaTirocinio offertaTirocinio: offertaTirocinios){
                if (offertaTirocinio.getIDOffertaTirocinio() == idOfferta){
                    mappa.put("offerta", offertaTirocinio);
                    break;
                }
            }
            for (Tirocinante tirocinante: tirocinantes){
                if (tirocinante.getIDTirocinante() == idTircinante){
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
            lista.add(mappa);
        }
        datamodel.put("Lista", lista);
    }

    private void checkScadenzaConvenzione(Azienda azienda){
        int durata = azienda.getDurataConvenzione();
        Date dataConvenzone = azienda.getDataConvenzione();
        Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
        Calendar passato = Calendar.getInstance();
        passato.setTime(dataConvenzone);
        passato.add(Calendar.DAY_OF_MONTH, +durata);
        //presente.set(2018,Calendar.SEPTEMBER,2);
        System.out.println("data convenzione: "+ dataConvenzone + " durata: "+ durata + " scade il " + passato.getTime() + " oggi e" + presente.getTime() + " e scaduta: " + presente.after(passato));

        if (presente.before(passato)){
            // Get the represented date in milliseconds
            long millis1 = presente.getTimeInMillis();
            long millis2 = passato.getTimeInMillis();

            // Calculate difference in milliseconds
            long diff = millis2 - millis1;

            long diffDays = diff / (24 * 60 * 60 * 1000);
            System.out.println("In days: " + diffDays + " days.");
            int ggAllaScadenza = (int) diffDays;
            datamodel.put("GiorniScadenza", ggAllaScadenza);
            datamodel.put("ConvenzioneScaduta", false );
        } else {
          datamodel.put("ConvenzioneScaduta", true );
        }






    }

    private void aggiornaFini(List<String> parametriFIN){
        //TODO finire di salvare i dati sul DB
        for(String param: parametriFIN){
            String[] parts = param.split("-");
            System.out.println(parts[0] + " " + parts[1] + " " + parts[2]+ " " + parts[3]);
            String p = request.getParameter(param);
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
            } catch (DaoException e){
                e.printStackTrace();
            }
            if ((tirocinante.getNome().equals(parts[0].split("fin_")[1])) && (tirocinante.getCognome().equals(parts[1]))){
                if(tiro.getTirocinante().equals(tirocinante.getIDTirocinante())){
                    System.out.println("Si coincide");
                    tiro.setStato(1);
                    System.out.println("lo stato: " + tiro.getStato());
//                    try {
//                        TirocinioDaoImp daoTiro = new TirocinioDaoImp();
//                        daoTiro.setRichiestatr(tiro);
//                        daoTiro.destroy();
//                    } catch (DaoException e){
//                        e.printStackTrace();
//                    }

                }
            }
        }
    }

    public void get(){
        ritornaAzienda(request,response);
        List<OffertaTirocinio> offert = ritornaOfferte();
        List<Tirocinio> tiro = ritornaTirocinii(offert);
        List<Tirocinante> tirocinante = ritornaTirocinanti(tiro);
        creaDatamodel(tirocinante,offert,tiro);
        fillConvenzione();
        checkScadenzaConvenzione(azienda);
        TemplateController.process("moduli-aziendale.ftl", datamodel, response, context);
    }

    public void post(){
        Map params = request.getParameterMap();
        List<String> parametri = new ArrayList<String>();
        for (Object o : params.keySet()) {
            String key = (String) o;
            String value = ((String[]) params.get(key))[0];
            if (key.startsWith("fin_") && value.equals("1")){
                parametri.add(key);
            }
        }
        System.out.println(parametri);
        aggiornaFini(parametri);
    }

}