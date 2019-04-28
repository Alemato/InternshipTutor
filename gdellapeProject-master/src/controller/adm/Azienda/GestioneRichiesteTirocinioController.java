package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.UserDaoImp;
import model.*;
import view.TemplateController;
import view.TemplateControllerMail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestioneRichiesteTirocinioController extends baseController {
    //gestione-richieste-tirocinio-aziendale.ftl

    private void er404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void creaLista(List<OffertaTirocinio> offertaTirocinios, List<Tirocinio> tirocinios, List<Tirocinante> tirocinantes) throws DaoException {
        List<Object> lista = new ArrayList<>();
        for (Tirocinio tirocinio : tirocinios) {
            Map<String, Object> mappa = new HashMap<>();
            mappa.put("tirocinio", tirocinio);
            int idoferta = tirocinio.getOffertaTirocinio();
            int idTirocinante = tirocinio.getTirocinante();
            for (OffertaTirocinio offertaTirocinio : offertaTirocinios) {
                if (idoferta == offertaTirocinio.getIDOffertaTirocinio()) {
                    mappa.put("offerta", offertaTirocinio);
                    break;
                }
            }
            for (Tirocinante tirocinante : tirocinantes) {
                if (idTirocinante == tirocinante.getIDTirocinante()) {
                    UserDaoImp daoUser = new UserDaoImp();
                    User user = daoUser.getUserByid(tirocinante.getUser());
                    daoUser.destroy();
                    mappa.put("tirocinante", tirocinante);
                    mappa.put("userMail", user.getEmail());
                    break;
                }
            }
            lista.add(mappa);
        }
        datamodel.put("Lista", lista);
    }

    private void creaOggetti(HttpServletRequest request, HttpServletResponse response, Azienda azienda) throws ServletException, IOException {
        GestioneModuliAzienda gestioneModuliAzienda = new GestioneModuliAzienda(datamodel, request, response, getServletContext(), azienda);
        List<OffertaTirocinio> offertaTirocinios = gestioneModuliAzienda.ritornaOfferte();
        List<Tirocinio> tirocinios = gestioneModuliAzienda.ritornaTirocinii(offertaTirocinios);
        List<Tirocinante> tirocinantes = gestioneModuliAzienda.ritornaTirocinanti(tirocinios);
//        System.out.println("+++++++++++++++++++++++DEBUG+++++++++++++++++++++++");
//        System.out.println("Lista offerte");
//        System.out.println(offertaTirocinios);
//        System.out.println("---------------------------------------------------");
//        System.out.println("Lista richieste tirocinio");
//        System.out.println(tirocinios);
//        System.out.println("---------------------------------------------------");
//        System.out.println("Lista Tirocinanti");
//        System.out.println(tirocinantes);
//        System.out.println("---------------------------------------------------");
        try {
            creaLista(offertaTirocinios, tirocinios, tirocinantes);
        } catch (DaoException e) {
            e.printStackTrace();
            er500(request, response);
        }
    }

    private void processaPost(HttpServletRequest request, HttpServletResponse response, List<String> parametri) throws DaoException, ServletException, IOException {
        boolean errore = false;
        String statoAc="";
        String statoDe="";
        for (String parametro: parametri){
            System.out.println("processo parametro: ");
            System.out.println(parametro);
            String[] parts1 = parametro.split("-");
            Tirocinio tirocinio= new Tirocinio();
            TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
            if(parts1[0].equals("ac")){
                tirocinio=tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(parts1[2]));
                tirocinioDaoImp.destroy();
                tirocinio.setStato(1);
                TirocinioDaoImp tirocinioDaoImp1 = new TirocinioDaoImp();
                tirocinioDaoImp1.updateTirocinio(tirocinio);
                tirocinioDaoImp1.destroy();
                TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
                Tirocinante tirocinante= tirocinanteDaoImp.getTirocianteByID(tirocinio.getTirocinante());
                tirocinanteDaoImp.destroy();
                statoAc= statoAc.concat("Trirocinante: " + tirocinante.getNome()+" "+ tirocinante.getCognome()+" &egrave; stato accettato <br>");
                String[] to = new String[3];
                to[0]= "azienda@matteifamily.net";
                to[1]= "tutore@matteifamily.net";
                to[2]= "tirocinante@matteifamily.net";
                String subject = "Notifica Accettazione richiesta di tirocinio effettuata da : "+ tirocinante.getNome()+" "+tirocinante.getCognome();
                TemplateControllerMail.process("email/accettazione-richiesta-tirocinio-azienda.ftl", datamodel, to, subject, getServletContext());
            } else if(parts1[0].equals("de")){
                tirocinio=tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(parts1[2]));
                tirocinioDaoImp.destroy();
                TirocinioDaoImp tirocinioDaoImp1 = new TirocinioDaoImp();
                tirocinio.setStato(5);
                tirocinioDaoImp1.updateTirocinio(tirocinio);
                tirocinioDaoImp1.destroy();
                TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
                Tirocinante tirocinante= tirocinanteDaoImp.getTirocianteByID(tirocinio.getTirocinante());
                statoDe= statoDe.concat("Trirocinante: " + tirocinante.getNome()+" "+ tirocinante.getCognome()+" &egrave; stato respinto <br>");
                tirocinanteDaoImp.destroy();
                OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
                OffertaTirocinio offertaTirocinio= offertaTirocinioDaoImp.getOffertatrByID(tirocinio.getOffertaTirocinio());
                offertaTirocinioDaoImp.destroy();
                datamodel.put("Titolo",offertaTirocinio.getTitolo());
                datamodel.put("Descrizione",offertaTirocinio.getDescrizione());
                datamodel.put("DescrizioneBreve",offertaTirocinio.getDescrizioneBreve());
                datamodel.put("LuogoEffettuazione",offertaTirocinio.getLuogoEffettuazione());
                datamodel.put("Orario",offertaTirocinio.getOrari());
                datamodel.put("PeriodoInizio",offertaTirocinio.getPeriodoInizio());
                datamodel.put("PeriodoFine",offertaTirocinio.getPeriodoFine());
                datamodel.put("Obbiettivi",offertaTirocinio.getObbiettivi());
                datamodel.put("Modalita",offertaTirocinio.getModalita());
                datamodel.put("Rimborsi",offertaTirocinio.getRimborsi());
                datamodel.put("Facilitazioni",offertaTirocinio.getFacilitazioni());
                datamodel.put("NomeRespAz",offertaTirocinio.getNomeTutoreAziendale());
                datamodel.put("CognomeRepAz",offertaTirocinio.getCognomeTutoreAziendale());
                datamodel.put("EmailRepAZ",offertaTirocinio.getEmailTutoreAziendale());
                datamodel.put("TelRepAz",offertaTirocinio.getTelefonoTutoreAziendale());
                datamodel.put("tirocinante",tirocinante);
                String[] to = new String[3];
                to[0]= "azienda@matteifamily.net";
                to[1]= "tutore@matteifamily.net";
                String subject = "Notifica Declinazione richiesta di tirocinio effettuata da : "+ tirocinante.getNome()+" "+tirocinante.getCognome() +" per offerta : " +offertaTirocinio.getTitolo();
                TemplateControllerMail.process("email/declinazione-richiesta-tirocinio-azienda-tutore.ftl", datamodel, to, subject, getServletContext());
                String[] toTiro = new String[1];
                toTiro[0]= "tirocinante@matteifamily.net";
                String subjectTiro = "Notifica Declinazione richiesta di tirocinio per offerta : " +offertaTirocinio.getTitolo();
                TemplateControllerMail.process("email/declinazione-richiesta-tirocinio-azienda-tutore.ftl", datamodel, toTiro, subjectTiro, getServletContext());

            } else {
                errore = true;
                er500(request, response);
            }
        }
        if(!errore){
            SingSessionContoller session = SingSessionContoller.getInstance();
            datamodel.put("StatoRic", statoAc+statoDe);
            get(request, response, session);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        datamodel.put("init", true);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)) {
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            Azienda azienda = session.getAzienda(request, response);
            Map<String, String[]> params = request.getParameterMap();
            List<String> parametri = new ArrayList<String>();
            for (Object o : params.keySet()) {
                String key = (String) o;
                String value = (params.get(key))[0];
                if ((key.startsWith("ac") && value.equals("1")) || (key.startsWith("de") && value.equals("2"))) {
                    parametri.add(key);
                }
            }
            for (int i = 1; i < parametri.size(); i++) {
                String primo = parametri.get(i - 1);
                String secondo = parametri.get(i);
                String[] parts1 = primo.split("-");
                String[] parts2 = secondo.split("-");
                if ((!parts1[0].equals(parts2[0])) && (parts1[1].equals(parts2[1])) && (parts1[2].equals(parts2[2]))){
                    System.out.println("errore " + primo +" uguale" + secondo);
                    // RIPORTO ERRORE
                    datamodel.put("errore","Errore nella richiesta!!!<br>Se errore persiste contattare un amministratore.");
                    creaOggetti(request, response,azienda);
                    TemplateController.process("gestione-richieste-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
                    break;
                }
            }
            System.out.println(parametri);
            try {
                processaPost(request, response, parametri);
            } catch (DaoException e) {
                e.printStackTrace();
                er500(request, response);
            }
        } else {
            er403(request, response);
        }
    }

    private void get(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session)throws ServletException, IOException{
        boolean scaduto = (boolean)request.getAttribute("Scaduto");
        datamodel.put("Scaduto", scaduto);
        Azienda azienda = session.getAzienda(request, response);
        creaOggetti(request, response,azienda);
        TemplateController.process("gestione-richieste-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)) {
            get(request, response, session);
        } else {
            er403(request, response);
        }
    }
}
