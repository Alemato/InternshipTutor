package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import controller.utility.Validation;
import controller.utility.utility;
import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.UserDaoImp;
import model.Admin;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static controller.utility.Validation.isStoredThisAddress;

/**
 * Servlet che serve a creare un nuovo amministratore quindi dovrà anche creare un nuovo user
 */

public class CreateAdmin extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        if(validationUserAndAdmin(request,response))
        {
            //insertUser(request,response);
            //insertAdmin(request,response);
            System.out.println("vali");
            response.sendRedirect("/gestione-utenti");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {





    }






    private void insertUser(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try{
            User user =new User();
            user.setEmail(request.getParameter("Email"));
            user.setPassword(request.getParameter("Password"));
            user.setTipologiaAccount(1);

            UserDaoImp dao = new UserDaoImp();
            dao.setUser(user);
            dao.destroy();

        }
        catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    private void insertAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try{
           UserDaoImp dao = new UserDaoImp();
           User user=dao.getUserByMail(request.getParameter("Email"));
           dao.destroy();


           Admin admin =new Admin();
           admin.setNome(request.getParameter("Nome"));
           admin.setCognome(request.getParameter("Cognome"));
           admin.setUser(user.getIDUser());

           UserDaoImp dao1 = new UserDaoImp();
           dao1.setUser(user);
           dao1.destroy();

        }
        catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    private Boolean validationUserAndAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {

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
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return false;
        }

    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori)throws IOException,ServletException
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
        datamodel.putAll(utility.AddAllData(request,response,dati));
        //Carico gli avvisi per gli errori trovati
        datamodel.putAll(errori);
        System.out.println("datamodel create admin");
        System.out.println(datamodel.toString());
        AdminFillTable page = new AdminFillTable(datamodel,getServletContext(),request,response);
        page.makeget();

    }







}
