package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.GestioneUtenza.AdminFillTable;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import controller.utility.Validation;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.TutoreUniversitario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateTutoreUni extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        createTutUni(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createTutUni(request,response);


    }





   private void createTutUni(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        super.init(request,response);
        if(valiadazioneTutUni(request,response))
        {
            System.out.println("sto salvando il tutore");
            //InsertTutoreUni(request, response);
            //response.sendRedirect("/gestione-utenti");
        }




    }

    private void InsertTutoreUni(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try{
            TutoreUniversitario tutUni= new TutoreUniversitario();
            tutUni.setNome(request.getParameter("Nome_tutore"));
            tutUni.setCognome(request.getParameter("Cognome_tutore"));
            tutUni.setTelefono(request.getParameter("Numero_telefono_tutore"));
            tutUni.setEmail(request.getParameter("Email_tutore"));

            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            dao.setTutoreUni(tutUni);
            dao.destroy();

        }
        catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    private Boolean valiadazioneTutUni(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        Map<String,Object> map= new HashMap<>();

        try {
            if (request.getParameter("Nome_tutore").isEmpty()) {
                map.put("ErroreNomeTutore", "Nome tutore non presente");
            } else if (request.getParameter("Nome_tutore").length() > 100) {
                map.put("ErroreNomeTutore", "Nome tutore troppo lungo");

            }

            if (request.getParameter("Cognome_tutore").isEmpty()) {
                map.put("ErroreCognomeTutore", "Cognome tutore non presente");
            } else if (request.getParameter("Cognome_tutore").length() > 100) {
                map.put("ErroreCognomeTutore", "Cognome tutore universitario");
            }

            if (request.getParameter("Email_tutore").isEmpty()) {
                map.put("ErroreEmailTutore", "Email tutore non presente");
            } else if (!(Validation.isValidEmailAddress(request.getParameter("Email_tutore")))) {
                map.put("ErroreEmailTutore", "Email tutore non corretta");
            } else if (Validation.isStoreThisMailTutore(request.getParameter("Email_tutore"))) {
                map.put("ErroreEmailTutore", "Email tutore gia presente");
            }

            if (request.getParameter("Numero_telefono_tutore").isEmpty()) {
                map.put("ErroreTelefonoTutore", "Telefono tutore non presente");
            } else if (request.getParameter("Numero_telefono_tutore").length() > 50) {
                map.put("ErroreTelefonoTutore", "Telefono non congruo");
            }

            if (map.isEmpty()) {
               System.out.println("validazione andata a buon fine");
                return true;
            } else {
                System.out.println("validazione in errore");
                refreshPage(request,response,map);
                return false;
            }
        }catch (DaoException e )
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return false;
        }

    }
    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori) throws IOException,ServletException
    {

        System.out.println("Errori validazine" + errori);
        List<String> dati = new ArrayList<>();
        if(!(errori.containsKey("ErroreNomeTutote")))
        {
           dati.add("Nome_tutore");
        }
        if(!(errori.containsKey("ErroreCognomeTutore")))
        {
            dati.add("Cognome_tutore");
        }
        if(!(errori.containsKey("ErroreEmailTutore")))
        {
           dati.add("Email_tutore");
        }
        if(!(errori.containsKey("ErroreTelefonoTutore"))) {
            dati.add("Numero_telefono_tutore");
        }
        System.out.println("Dati ricaricati");
        datamodel.putAll(Utility.AddAllData(request,response,dati));

        System.out.println(Utility.AddAllData(request,response,dati));
        datamodel.putAll(errori);

        AdminFillTable page = new AdminFillTable(datamodel,getServletContext(),request,response);
        page.makeget();





    }






}
