package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import controller.utility.utility;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.UserDaoImp;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class CreateTirocinioController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        TemplateController.process("creazione-tirocinio-aziendale.ftl", datamodel, response, getServletContext());

    }
    private void createtr(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
        Azienda azienda = this.getAzienda(request,response);


    }
    private void validation(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        OffertaTirocinio of = new OffertaTirocinio();
        if (request.getParameter("Titolo")!=null) {
            String titolo = request.getParameter("Titolo");

            if (titolo.isEmpty())
            {
                throw new IOException("I don't have Titolo");


            }else if(titolo.length() > 100)
            {
                throw new IOException("Title is more long");
            }
            of.setTitolo(titolo);

        }else{ throw new IOException("I don't have Titolo");}



        if (request.getParameter("Descrizione_Breve")!=null) {

            String descrBreve = request.getParameter("Descrizione_Breve");
            if (descrBreve.isEmpty())
            {
                throw new IOException("I don't have Descrizione Breve");


            }else if(descrBreve.length() > 200)
            {
                throw new IOException("Descrizione Breve is longer ");
            }
            of.setDescrizioneBreve(descrBreve);

        }else{throw new IOException("I don't have Descrizione Breve");}

        if (request.getParameter("Descrizione_Completa")!=null) {

            String descr=request.getParameter("Descrizione_Completa");
            if (descr.isEmpty())
            {
                throw new IOException("I don't have Descrizione Completa");


            }
            of.setDescrizioneBreve(descr);

        }else{throw new IOException("I don't have Descrizione Completa");}

        if (request.getParameter("Orari")!=null) {

            String orari = request.getParameter("Orari");
            if (orari.isEmpty())
            {
                throw new IOException("I don't have orari");


            }
            of.setDescrizioneBreve(orari);

        }else{   throw new IOException("I don't have orari");}


        String durateore=request.getParameter("Durara_Ora");
        String durMesi=request.getParameter("Durara_Mesi");
        Date datainizio= utility.getDataToHTML(request.getParameter("Periodo_inizio"));
        Date datefine=utility.getDataToHTML(request.getParameter("Periodo_fine"));
        String modalitasvol=request.getParameter("Modalita");
        String Obiettivi=request.getParameter("Obiettivi");
        String rimborsi=request.getParameter("Rimborsi");
        String facilitazioni=request.getParameter("Facilitazioni");
        String sede=request.getParameter("AziendaOspitante");
        String codice=request.getParameter("CodiceIdentTirocinio");
        String settore=request.getParameter("SettoreInserimento");
        String tempiAccesso=request.getParameter("Tempi_Accesso_Locali");
        String nomeTuAz=request.getParameter("NomeTutoreAziendale");
        String cognomeTuAz=request.getParameter("CognomeTutoreAziendale");
        String telTutAz=request.getParameter("TelefonoTutoreAziendale");
        String emailTutAz=request.getParameter("EmailTutoreAziendale");
        Integer oldTutUni=Integer.parseInt(request.getParameter("TutoreUniversitario"));

        String nomeTutUni =request.getParameter("NomeTutoreUniversitario");
        String cognomeTutUni =request.getParameter("CognomeTutoreUniversitario");
        String telefonoTutUni =request.getParameter("TelefonoTutoreUniversitario");
        String EmailTutUni =request.getParameter("EmailTutoreUniversitario");
    }




}
