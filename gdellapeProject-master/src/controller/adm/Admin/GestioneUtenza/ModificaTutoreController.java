package controller.adm.Admin.GestioneUtenza;

import com.sun.org.apache.regexp.internal.RE;
import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import dao.implementation.UserDaoImp;
import model.Tirocinante;
import model.TutoreUniversitario;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.*;


public class ModificaTutoreController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        updateTutore(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       makeGet(request,response);



    }
    private void makeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            super.init(request, response);
            fillForm(request, response);
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }




    }


    private void fillForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,DaoException
    {
        TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
        TutoreUniversitario tutore = dao.getTutoreUniByID(Integer.parseInt(request.getParameter("IDTutoreUni")));
        dao.destroy();
        datamodel.put("urlpage","/admin/gestione-tutoti" );
        datamodel.put("tutore", tutore);
        TemplateController.process("BackEndTemplates/modifica-tutoreuni.ftl", datamodel, response, getServletContext());

    }

    private void updateTutore(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {

            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            TutoreUniversitario tutore = dao.getTutoreUniByID(Integer.parseInt(request.getParameter("IDTutoreUni")));
            dao.destroy();
            datamodel.put("urlpage","/admin/gestione-tutoti" );
            if (validation(request, response, tutore)) {
            storeTutoreUni(request,response,tutore);
                //redirigo sulla pagina di gestione utenti
                AdminFillTable page =new AdminFillTable(datamodel,getServletContext(),request,response);
                page.makeSuccessGetTutori("Il Tutore "+tutore.getNome()+" "+tutore.getCognome()+" e stato modifica corettamente" );

            }
        }catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);

        }
    }



    private Boolean validation(HttpServletRequest request,HttpServletResponse response,TutoreUniversitario tutore)throws ServletException,IOException,DaoException {

           Map<String, Object> errori = new HashMap<>();

           if (request.getParameter("email").isEmpty()) {
               errori.put("ErroreEmail", "Nome non presente");

           } else if (!(Validation.isValidEmailAddress(request.getParameter("email")))) {
               errori.put("ErroreEmail", "Nome non congrua");

           } else if ((Validation.isStoreThisMailTutore(request.getParameter("email"))) && !(request.getParameter("email").equals(tutore.getEmail()))) {
               errori.put("ErroreEmail", "Email gia presente");
           }


           if (request.getParameter("nome").isEmpty()) {
               errori.put("ErroreNome", "Nome non presente");
           } else if (request.getParameter("nome").length() > 50) {
               errori.put("ErroreNome", "Nome troppo lungo");
           }

           if (request.getParameter("cognome").isEmpty()) {
               errori.put("ErroreCognome", "Cognome non presente");
           } else if (request.getParameter("cognome").length() > 50) {
               errori.put("ErroreCognome", "Cognome troppo lungo");
           }

           if (request.getParameter("telefono").isEmpty()) {
               errori.put("ErroreTelefono", "Telefono non presente");
           } else if (request.getParameter("telefono").length() != 10) {
               errori.put("ErroreTelefono", "Telefono non contruo");
           }

           if (errori.isEmpty()) {
               System.out.println("Validazione NON in errore");
               return true;
           } else {
               System.out.println("Validazione in errore");
               refreshPage(request, response, errori);
               return false;
           }

    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori)throws ServletException,IOException,DaoException
    {
        List<String> dati = new ArrayList<>();

        if(!(errori.containsKey("ErroreEmail")))
        {
            dati.add("email");
        }
        if(!(errori.containsKey("ErroreNome")))
        {
            dati.add("nome");
        }


        if(!(errori.containsKey("ErroreCognome")))
        {
            dati.add("cognome");
        }

        if(!(errori.containsKey("ErroreTelefono")))
        {
            dati.add("telefono");
        }

        datamodel.putAll(errori);

        datamodel.put("WarningGenerico","Le modifiche apportate non sono state salvate");

        datamodel.putAll(Utility.AddAllData(request,response,dati));

        fillForm(request,response);


    }




   private void storeTutoreUni(HttpServletRequest request,HttpServletResponse response,TutoreUniversitario tutore)throws IOException,ServletException,DaoException
    {

            tutore.setNome(HtmlEscape.escapeHtml5(request.getParameter("nome")));
            tutore.setCognome(HtmlEscape.escapeHtml5(request.getParameter("cognome")));
            tutore.setEmail(request.getParameter("email"));
            tutore.setTelefono(request.getParameter("telefono"));

            System.out.println(tutore.toString());

            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
           dao.UpdateTutoreUni(tutore);
           dao.destroy();





    }





}
