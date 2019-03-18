package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.sql.SQLData;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class CreateTirocinioController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //makeform(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        gettutori(request,response);
        TemplateController.process("creazione-tirocinio-aziendale.ftl", datamodel, response, getServletContext());

    }
    private void gettutori(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        try{
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            List<TutoreUniversitario> tutori= dao.getAllTutUni();
            dao.destroy();
            datamodel.put("tutori",tutori);

        }catch (DaoException e)
        {
            response.sendRedirect("/404");
            e.printStackTrace();
        }
    }
//    private void createoftr(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
//        Azienda azienda = getAzienda(request, response);
//        if (validation(request, response)) {
//            OffertaTirocinio tr = getOfferta(request, response);
//            tr.setTutoreUniversitario(Integer.parseInt(request.getParameter("TutoreUniversitario")));
//            tr.setAzienda(azienda.getIDAzienda());
//            tr.setAziendaOspitante(azienda.getRagioneSociale());
//            makeOffertaTr(request, response, tr);
//            response.sendRedirect("/home");
//        }
//    }
//    private void makeform(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
//    {
//        if(super.accessLogin(request,response)&&super.accessAzienda(request,response))
//        {
//            if(request.getParameter("TutoreUniversitario").equals("NEW"))
//            {
//                createOffAndTutUni(request,response);
//            }else{createoftr(request,response);}
//        }
//    }


//    private void createOffAndTutUni(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
//    {
//        try {
//
//                Azienda azienda = getAzienda(request, response);
//                if (validation(request, response)&&validationTutUni(request, response))
//                {
//                    OffertaTirocinio tr = getOfferta(request, response);
//
//                    TutoreUniversitario tutuni = getTutoreUni(request, response);
//                    TutoreUniversitario tutwithid = makeNewTutoreUni(request, response, tutuni);
//                    tr.setTutoreUniversitario(tutwithid.getIDTutoreUni());
//                    tr.setAzienda(azienda.getIDAzienda());
//                    tr.setAziendaOspitante(azienda.getRagioneSociale());
//                    makeOffertaTr(request, response, tr);
//                    response.sendRedirect("/home");
//                }
//
//        }catch (Exception e)
//        { e.printStackTrace();}


//    }

    private OffertaTirocinio getOfferta(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {  OffertaTirocinio of = new OffertaTirocinio();
        of.setTitolo(request.getParameter("Titolo"));
        of.setDescrizioneBreve(request.getParameter("Descrizione_Breve"));
        of.setDescrizione(request.getParameter("Descrizione_Completa"));
        of.setOrari(request.getParameter("Orari"));
        of.setDurataOre(Integer.parseInt(request.getParameter("Durara_Ore")));
        of.setDurataMesi(Integer.parseInt(request.getParameter("Durara_Mesi")));
        of.setPeriodoInizio(Date.valueOf(request.getParameter("Periodo_inizio")));
        of.setPeriodoFine(Date.valueOf(request.getParameter("Periodo_fine")));
        of.setModalita(request.getParameter("Modalita"));
        of.setObbiettivi(request.getParameter("Obiettivi"));
        of.setRimborsi(request.getParameter("Rimborsi"));
        of.setFacilitazioni(request.getParameter("Facilitazioni"));
        of.setLuogoEffettuazione(request.getParameter("SedeTirocinio"));
        of.setCodIdentTirocinio(request.getParameter("CodiceIdentTirocinio"));
        of.setSettoreInserimento(request.getParameter("SettoreInserimento"));
        of.setTempoAccessoLocaliAziendali(request.getParameter("TempiAccessoLocaliAziendali"));
        of.setNomeTutoreAziendale(request.getParameter("NomeTutoreAziendale"));
        of.setCognomeTutoreAziendale(request.getParameter("CognomeTutoreAziendale"));
        of.setTelefonoTutoreAziendale(request.getParameter("TelefonoTutoreAziendale"));
        of.setEmailTutoreAziendale(request.getParameter("EmailTutoreAziendale"));
        return of;

    }




    private Boolean validation(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        HashMap<String,String> errori = new HashMap<>();


        if (request.getParameter("Titolo")!=null) {
            String titolo = request.getParameter("Titolo");

            if (titolo.isEmpty())
            {
               errori.put("ErroreTitolo","Titolo non presente");


            }else if(titolo.length() > 100)
            {
                errori.put("ErroreTitolo","Titolo troppo lungo");
            }


        }else{ errori.put("Titolo Non Presente","Titolo non presente"); }


            if (request.getParameter("Descrizione_Breve") != null) {

                String descrBreve = request.getParameter("Descrizione_Breve");
                if (descrBreve.isEmpty()) {

                    errori.put("ErroreDescrizione_Breve", "Descrizione Breve non Presente");

                } else if (descrBreve.length() > 200) {
                    errori.put("ErroreDescrizione_Breve", "Descrizione Breve troppo lunga");
                }


            } else {
                errori.put("ErroreDescrizione_Breve", "Descrizione Breve non Presente");
            }



            if (request.getParameter("Descrizione_Completa") != null) {

                String descr = request.getParameter("Descrizione_Completa");
                if (descr.isEmpty()) {
                    errori.put("ErroreDescrizione_Completa", "Descrizione non Presente");

                }else if(descr.length()>1000)
                {errori.put("ErroreDescrizione_Completa", "Descrizione troppo lunga");}


            } else { errori.put("ErroreDescrizione_Completa", "Descrizione non Presente");}



            if (request.getParameter("Orari") != null) {

                String orari = request.getParameter("Orari");
                if (orari.isEmpty()) {
                    errori.put("ErroreOrari", "Orari non presenti");


                }else if(orari.length()>100)
                {  errori.put("ErroreOrari", "Orari non presenti");}



            } else { errori.put("ErroreOrari", "Orari non presenti"); }


        if (request.getParameter("Durara_Ora") != null) {

            Integer durateore = Integer.parseInt(request.getParameter("Durara_Ora"));
            if (durateore <= 0) {
                errori.put("ErroreDurara_Ora", "Durata in ore non congrua");


            }else if(durateore >100000)
            {  errori.put("ErroreDurara_Ora", "Durata in ore non congrua");}



        } else { errori.put("ErroreDurara_Ora", "Durata in ore non presente");}


            if (request.getParameter("Durara_Mesi") != null) {

                Integer durMesi = Integer.parseInt(request.getParameter("Durara_Mesi"));
                if (durMesi <= 0) {
                    errori.put("ErroreDurara_Mesi", "Durata in mesi non congrua");


                }else if(durMesi >100000)
                {  errori.put("ErroreDurara_Mesi", "Durata in mesi non congrua");}


                } else { errori.put("ErroreDurara_Mesi", "Durata in mesi non presente");}

        if (request.getParameter("Periodo_inizio") != null) {

            Date datainizio = Date.valueOf(request.getParameter("Periodo_inizio"));


        } else { errori.put("ErrorePeriodo_inizio", "Periodo inizio non presente");}



        if (request.getParameter("Periodo_fine") != null) {

            Date datefine = Date.valueOf(request.getParameter("Periodo_fine"));


        } else { errori.put("ErrorePeriodo_fine", "Periodo fine non presente");}


        if (request.getParameter("Modalita") != null) {

            String modalitasvol = request.getParameter("Modalita");
            if (modalitasvol.isEmpty()) {
                errori.put("ErroreModalita", "Modalita di svolgimento non presente");


            }else if(modalitasvol.length() >500)
            {  errori.put("ErroreModalita", "Modalita di svolgimento troppo lungo");}



        } else {  errori.put("ErroreModalita", "Modalita di svolgimento non presente");}

        if (request.getParameter("Obiettivi") != null) {

            String Obiettivi = request.getParameter("Obiettivi");
            if (Obiettivi.isEmpty()) {
                errori.put("ErroreObiettivi", "Obiettivi di svolgimento non presenti");


            }else if(Obiettivi.length() >500)
            {  errori.put("ErroreObiettivi", "Obiettivi di svolgimento troppo lungo");}



        } else {  errori.put("ErroreObiettivi", "Obiettivi di svolgimento non presenti");}


        if (request.getParameter("Rimborsi") != null) {

            String rimborsi = request.getParameter("Rimborsi");
            if (rimborsi.isEmpty()) {
                errori.put("ErroreRimborsi", "Rimborsi non presenti");


            }else if(rimborsi.length() >200)
            {  errori.put("ErroreRimborsi", "Rimborsi troppo lungo");}



        } else { errori.put("ErroreRimborsi", "Rimborsi non presenti");}

        if (request.getParameter("Facilitazioni") != null) {

            String facilitazioni = request.getParameter("Facilitazioni");
            if (facilitazioni.isEmpty()) {
                errori.put("ErroreFacilitazioni", "Facilitazioni non presenti");


            }else if(facilitazioni.length() >200)
            {  errori.put("ErroreFacilitazioni", "Facilitazioni troppo lungo");}



        } else { errori.put("ErroreFacilitazioni", "Facilitazioni non presenti");}


        if (request.getParameter("SedeTirocinio") != null) {

            String sede = request.getParameter("SedeTirocinio");
            if (sede.isEmpty()) {
                errori.put("ErroreSedeTirocinio", "SedeTirocinio non presente");


            }else if(sede.length() >200)
            {  errori.put("ErroreSedeTirocinio", "SedeTirocinio troppo lungo");}



        } else { errori.put("ErroreSedeTirocinio", "SedeTirocinio non presente");}



        if (request.getParameter("CodiceIdentTirocinio") != null) {

            String codice = request.getParameter("CodiceIdentTirocinio");
            if (codice.isEmpty()) {
                errori.put("ErroreCodiceIdentTirocinio", "Codice tirocinio non presente");


            }else if(codice.length() >10)
            {  errori.put("ErroreCodiceIdentTirocinio", "Codice tirocinio troppo lungo");}



        } else {  errori.put("ErroreCodiceIdentTirocinio", "Codice tirocinio non presente");}

        if (request.getParameter("SettoreInserimento") != null) {

            String settore = request.getParameter("SettoreInserimento");
            if (settore.isEmpty()) {
                errori.put("ErroreSettoreInserimento", "Settore Inserimento non presente");


            }else if(settore.length() >100)
            {  errori.put("ErroreSettoreInserimento", "Settore Inserimento troppo lungo");}



        } else {errori.put("ErroreSettoreInserimento", "Settore Inserimento non presente");}

        if (request.getParameter("TempiAccessoLocaliAziendali") != null) {

            String tempiAccesso = request.getParameter("TempiAccessoLocaliAziendali");
            if (tempiAccesso.isEmpty()) {
                errori.put("ErroreSettoreInserimento", "Settore Inserimento non presente");


            }else if(tempiAccesso.length() >100)
            {  errori.put("ErroreTempiAccessoLocaliAziendali", "Settore Inserimento troppo lungo");}



        } else { errori.put("ErroreSettoreInserimento", "Settore Inserimento non presente");}

        if (request.getParameter("NomeTutoreAziendale") != null) {

            String nomeTuAz = request.getParameter("NomeTutoreAziendale");
            if (nomeTuAz.isEmpty()) {
                errori.put("ErroreNomeTutoreAziendale", "Nome Tutore aziendale non presente");


            }else if(nomeTuAz.length() >100)
            {  errori.put("ErroreNomeTutoreAziendale", "Nome Tutore aziendale troppo lungo");}



        } else { errori.put("ErroreNomeTutoreAziendale", "Nome Tutore aziendale non presente");}

        if (request.getParameter("CognomeTutoreAziendale") != null) {

            String cognomeTuAz = request.getParameter("CognomeTutoreAziendale");
            if (cognomeTuAz.isEmpty()) {
                errori.put("ErroreCognomeTutoreAziendale", "Cognome Tutore aziendale  non presente");


            }else if(cognomeTuAz.length() >100)
            {  errori.put("ErroreCognomeTutoreAziendale", "Cognome Tutore aziendale troppo lungo");}



        } else {  errori.put("ErroreCognomeTutoreAziendale", "Cognome Tutore aziendale non presente");}


        if (request.getParameter("TelefonoTutoreAziendale") != null) {

            String telTutAz = request.getParameter("TelefonoTutoreAziendale");
            if (telTutAz.isEmpty()) {
                errori.put("ErroreTelefonoTutoreAziendale", "Telefono Tutore aziendale non presente");


            }else if(telTutAz.length() >30)
            {  errori.put("ErroreTelefonoTutoreAziendale", "Telefono Tutore aziendale troppo lungo");}



        } else {   errori.put("ErroreTelefonoTutoreAziendale", "Telefono Tutore aziendale non presente");}

        if (request.getParameter("EmailTutoreAziendale") != null) {

            String emailTutAz = request.getParameter("EmailTutoreAziendale");
            if (emailTutAz.isEmpty()) {
                errori.put("ErroreEmailTutoreAziendale", "Email Tutore aziendale non presente");


            }else if(emailTutAz.length() >50)
            {  errori.put("ErroreEmailTutoreAziendale", "Email Tutore aziendale troppo lungo");}



        } else { errori.put("ErroreEmailTutoreAziendale", "Email Tutore aziendale non presente");}


        if(!(errori.isEmpty())){
            datamodel.putAll(errori);
            datamodel.putAll(refreshPage(request,response));
            showformCreateoff(request,response);
           return false;
        }
        return true;



    }
    private void showformCreateoff(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException
    {
        super.init(request,response);
        TemplateController.process("creazione-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
    }

    private void makeOffertaTr(HttpServletRequest request, HttpServletResponse response,OffertaTirocinio offtr)throws IOException,ServletException
    {
        try{
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            dao.setOffertatr(offtr);
            dao.destroy();

        }
        catch (DaoException e)
        {
            response.sendRedirect("/404");
            e.printStackTrace();
        }


    }

    private Boolean validationTutUni(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        HashMap<String,String> errori = new HashMap<>();


        if (request.getParameter("NomeTutoreUniversitario")!=null) {
            String nomeTutUni =request.getParameter("NomeTutoreUniversitario");

            if (nomeTutUni.isEmpty())
            {
                errori.put("ErroreNomeTutoreUniversitario","Nome Tutore Aziendale non presente");


            }else if(nomeTutUni.length() > 100)
            {
                errori.put("ErroreNomeTutoreUniversitario","Nome Tutore Aziendale troppo lungo");
            }


        }else{ errori.put("ErroreNomeTutoreUniversitario","Nome Tutore Aziendale non presente");}

        if (request.getParameter("CognomeTutoreUniversitario")!=null) {
        String cognomeTutUni =request.getParameter("CognomeTutoreUniversitario");

            if (cognomeTutUni.isEmpty())
            {
                errori.put("ErroreCognomeTutoreUniversitario","Cognome Tutore Universitario non presente");


            }else if(cognomeTutUni.length() > 40)
            {
                errori.put("ErroreCognomeTutoreUniversitario","Cognome Tutore Universitario troppo lungo");
            }


        }else{ errori.put("ErroreCognomeTutoreUniversitario","Cognome Tutore Universitario non presente");}



        if (request.getParameter("TelefonoTutoreUniversitario")!=null) {
            String telefonoTutUni =request.getParameter("TelefonoTutoreUniversitario");

            if (telefonoTutUni.isEmpty())
            {
                errori.put("ErroreTelefonoTutoreUniversitario","Telefono Tutore Universitario non presente");


            }else if(telefonoTutUni.length() > 40)
            {
                errori.put("ErroreTelefonoTutoreUniversitario","Telefono Tutore Universitario troppo lungo");
            }


        }else{ errori.put("ErroreTelefonoTutoreUniversitario","Telefono Tutore Universitario non presente");}

        if (request.getParameter("EmailTutoreUniversitario")!=null) {
            String EmailTutUni =request.getParameter("EmailTutoreUniversitario");

            if (EmailTutUni.isEmpty())
            {
                errori.put("ErroreEmailTutoreUniversitario","Email Tutore Universitario non presente");


            }else if(EmailTutUni.length() > 40)
            {
                errori.put("ErroreEmailTutoreUniversitario","Email Tutore Universitario troppo lungo");
            }


        }else{ errori.put("ErroreEmailTutoreUniversitario","Email Tutore Universitario non presente");}

        if(!(errori.isEmpty()))
        {
            datamodel.putAll(errori);
            datamodel.putAll(refreshPage(request,response));
            showformCreateoff(request, response);
            return false;

        }
        return true;


    }
    private TutoreUniversitario getTutoreUni(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        TutoreUniversitario tutore= new TutoreUniversitario();
        tutore.setNome(request.getParameter("NomeTutoreUniversitario"));
        tutore.setCognome(request.getParameter("CognomeTutoreUniversitario"));
        tutore.setTelefono(request.getParameter("TelefonoTutoreUniversitario"));
        tutore.setEmail(request.getParameter("EmailTutoreUniversitario"));
        return tutore;
    }

    private TutoreUniversitario makeNewTutoreUni(HttpServletRequest request, HttpServletResponse response,TutoreUniversitario tutuni) throws ServerException,IOException
    {
        try
        {
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            dao.setTutoreUni(tutuni);
            destroy();
            TutoreUniversitarioDaoImp dao1=new TutoreUniversitarioDaoImp();
            TutoreUniversitario tut1=dao1.getTutoreByEmail(tutuni.getEmail());
            dao1.destroy();
            return tut1;

        }catch (DaoException e)
        {
            response.sendRedirect("/404");
            e.printStackTrace();
            return null;
        }
    }
    private HashMap<String,Object> refreshPage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        List<String> lista = new ArrayList<>();
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements())
        {
            String param =(String)e.nextElement();
            lista.add(param);
        }
        return Utility.AddAllData(request,response,lista);

    }




}
