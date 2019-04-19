package controller.adm.Admin.GestioneUtenza;

import controller.baseController;
import controller.utility.SecurityHash;
import controller.utility.Validation;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.Admin;
import model.User;
import org.unbescape.html.HtmlEscape;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static controller.utility.Validation.isStoredThisAddress;

/**
 * Servlet che serve a creare un nuovo amministratore quindi dovrà anche creare un nuovo user
 */

public class CreateAdminController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        insertNewUser(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);




    }
    private void insertNewUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            super.init(request, response);
            datamodel.put("urlpage","/admin/gestione-admin");
            if (validationUserAndAdmin(request, response)) {
                //insertUser(request,response);
                //insertAdmin(request,response);
                System.out.println("vali");
               AdminFillTable page = new AdminFillTable(datamodel,getServletContext(),request,response);
               page.makeSuccessGetAdmin("Il nuovo admin &egrave; stato inserito correttamente");
            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }


    }






    private void storeUser(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
            User user =new User();
            user.setEmail(request.getParameter("Email"));
            String hash = SecurityHash.SetHash(request.getParameter("Email"));
            user.setPassword(hash);
            user.setTipologiaAccount(1);

            UserDaoImp dao = new UserDaoImp();
            dao.setUser(user);
            dao.destroy();


    }
    private void insertAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
           UserDaoImp dao = new UserDaoImp();
           User user=dao.getUserByMail(request.getParameter("Email"));
           dao.destroy();


           Admin admin =new Admin();

           admin.setNome(HtmlEscape.escapeHtml5(request.getParameter("Nome")));
           admin.setCognome(HtmlEscape.escapeHtml5(request.getParameter("Cognome")));
           admin.setUser(user.getIDUser());

           UserDaoImp dao1 = new UserDaoImp();
           dao1.setUser(user);
           dao1.destroy();



    }
    private Boolean validationUserAndAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {

            Map<String, Object> map = new HashMap<>();

            if (request.getParameter("Email").isEmpty()) {
                map.put("ErroreEmail", "Email non presente");

            } else if (!(Validation.isValidEmailAddress(request.getParameter("Email")))) {
                map.put("ErroreEmail", "Email non conforme");
            } else if (isStoredThisAddress(request.getParameter("Email"))) {
                map.put("ErroreEmail", "Email gia presente");
            }


            if (request.getParameter("Password").isEmpty()) {
                map.put("ErrorePassword", "Password Non Presente");
            } else if (!(request.getParameter("Password").equals(request.getParameter("ConfermaPassword")))) {
                map.put("ErrorePassword", "Password differenti");
            } else if (request.getParameter("Password").length() > 50) {
                map.put("ErrorePassword", "Password troppo lunga");
            }

            if (request.getParameter("ConfermaPassword").isEmpty()) {
                map.put("ErroreConfermaPassword", "Password Non Presente");
            }

            if(request.getParameter("Nome").isEmpty())
            {
                map.put("ErroreNome","Nome non Presente");

            }else if (request.getParameter("Nome").length()>100)
            {
                map.put("ErroreNome","Nome troppo lungo");
            }

            if(request.getParameter("Cognome").isEmpty())
            {
                map.put("ErroreCognome","Cognome non Presente");
            }else if (request.getParameter("Cognome").length()>100)
            {
                map.put("ErroreCognome","Cognome troppo lungo");
            }

            if (map.isEmpty()) {
                return true;
            } else {

                refreshPage(request, response, map);
                return false;
            }


    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori)throws IOException,ServletException,DaoException
    {
        System.out.println("Sto ricaricando l'errore");

        List<String> dati = new ArrayList<>();
        if(!(errori.containsKey("ErroreEmail")))
        {  dati.add("Email");}

        if(!(errori.containsKey("ErroreNome")))
        {
            dati.add("Nome");
        }
        if(!(errori.containsKey("ErroreCognome")))
        { dati.add("Cognome");}

        if(!(errori.containsKey("ErrorePassword")))
        {
            dati.add("Password");
            dati.add("ConfermaPassword");
        }

        //ricarico i vecchi dati immessi nella form
        datamodel.putAll(Utility.AddAllData(request,response,dati));
        //Carico gli avvisi per gli errori trovati
        datamodel.putAll(errori);
        System.out.println("datamodel create admin");
        System.out.println(datamodel.toString());

        AdminFillTable page = new AdminFillTable(datamodel,getServletContext(),request,response);
        page.makeInsuccessGetAdmin("Errore inserimento del nuovo admin");

    }







}
