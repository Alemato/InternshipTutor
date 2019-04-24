package controller.adm.Admin.GestioneUtenza;


import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.UserDaoImp;
import model.Admin;
import model.User;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ModificaAdminController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateAdmin(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        try {
            fillForm(request,response);

        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }

    }





    private void fill(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
        SingSessionContoller singleton = SingSessionContoller.getInstance();
        HttpSession session = singleton.getSession(request);
        int id = (Integer)session.getAttribute("IDUnivoco");
        AdminDaoImp dao1 = new AdminDaoImp();
        Admin admin = dao1.getAdminByID(id);
        dao1.destroy();

        UserDaoImp dao2 = new UserDaoImp();
        User user = dao2.getUserByid(admin.getUser());
        dao2.destroy();


        datamodel.put("admin",admin);
        datamodel.put("user",user);
    }
    private void fillForm(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
        fill(request,response);
        TemplateController.process("/BackEndTemplates/impostazioni-account-admin.ftl", datamodel, response, getServletContext());

    }
    private void successFillForm(HttpServletRequest request,HttpServletResponse response,String message)throws IOException,ServletException,DaoException
    {
        fill(request,response);
        datamodel.put("WarningSuccess",message);
        TemplateController.process("/BackEndTemplates/impostazioni-account-admin.ftl", datamodel, response, getServletContext());

    }
    private void insuccessFillForm(HttpServletRequest request,HttpServletResponse response,String message)throws IOException,ServletException,DaoException
    {
        fill(request,response);
        datamodel.put("WarningInsuccess",message);
        TemplateController.process("/BackEndTemplates/impostazioni-account-admin.ftl", datamodel, response, getServletContext());

    }


    private void updateAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        super.init(request,response);
        try{  SingSessionContoller singleton = SingSessionContoller.getInstance();
            HttpSession session = singleton.getSession(request);
            int id = (Integer)session.getAttribute("IDUnivoco");
            AdminDaoImp dao1 = new AdminDaoImp();
            Admin admin = dao1.getAdminByID(id);
            dao1.destroy();

            UserDaoImp dao2 = new UserDaoImp();
            User user = dao2.getUserByid(admin.getUser());
            dao2.destroy();
            if(validate(request,response,admin,user)) {
                storeAdmin(request,response,admin);
                System.out.println("Cambio dati admin");
                if(!user.getEmail().equals(request.getParameter("email")))
                {
                    storeEmail(request,response,user);
                    System.out.println("Cambio email");
                }
                if(!request.getParameter("newpassword").isEmpty())
                {
                    storePassword(request,response,user);
                    System.out.println("Cambio la password");
                }
                response.sendRedirect("/logout");

            }

        }catch (DaoException e){
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }


    private Boolean validate(HttpServletRequest request,HttpServletResponse response,Admin admin,User user) throws ServletException,IOException,DaoException
    {
        Map<String,Object> errori = new HashMap<>();

        if(request.getParameter("email").isEmpty())
        {
            errori.put("ErroreEmail","Email non presente");
        } else if (!(Validation.isValidEmailAddress(request.getParameter("email")))) {

        errori.put("ErroreEmail", "Email non congrua");
        //nel caso l'email immessa e uguale a quella gia presente non do errore
        //Vado in errore solo se l'email immessa e diversa da quella salvata e trovo una email uguale a quella salvata
        } else if (!(request.getParameter("email").equals(user.getEmail()))&&Validation.isStoredThisAddress(request.getParameter("email"))) {

        errori.put("ErroreEmail", "Email gia presente");
        }


        if((!request.getParameter("newpassword").isEmpty())||(!request.getParameter("repeatpassword").isEmpty()))
        {
            if(request.getParameter("newpassword").isEmpty())
            {
                errori.put("ErrorePassword","Password non presente");
            }else if(request.getParameter("repeatpassword").isEmpty())
            {
                errori.put("ErroreConfermaPassword","Convenferma password non presente");
            }else if(!request.getParameter("newpassword").equals(request.getParameter("repeatpassword")))
            {
                errori.put("ErrorePassword","Le Password non sono uguali");
            }else if(request.getParameter("newpassword").length()<6||request.getParameter("password").length()>16) {
                errori.put("ErrorePassword","La Password e troppo corta");
            }
        }

        if(request.getParameter("nome").isEmpty())
        {
            errori.put("ErroreNome","Nome non presente");
        }else if(request.getParameter("nome").length()>50)
        {
            errori.put("ErroreNome","Nome troppo lungo");
        }


        if(request.getParameter("cognome").isEmpty()){

            errori.put("ErroreCognome","Cognome non presente");

        }else if(request.getParameter("cognome").length()>50)
        {
            errori.put("ErroreCognome","Cognome troppo lungo");
        }

        if(errori.isEmpty())
        {
            return true;
        }else{
            refreshPage(request,response,errori);
            return false;
        }

    }
    private void storeAdmin(HttpServletRequest request,HttpServletResponse response,Admin admin)throws IOException,ServletException,DaoException {
        admin.setNome(request.getParameter("nome"));
        admin.setCognome(request.getParameter("cognome"));
        AdminDaoImp dao = new AdminDaoImp();
        dao.updateAdmin(admin);

    }

    private void storeEmail(HttpServletRequest request,HttpServletResponse response,User user)throws IOException,ServletException,DaoException{

        user.setEmail(request.getParameter("email"));
        UserDaoImp dao = new UserDaoImp();
        dao.update(user);
        dao.destroy();

    }
    private void storePassword(HttpServletRequest request,HttpServletResponse response,User user)throws IOException,ServletException,DaoException{

        user.setEmail(request.getParameter("password"));
        UserDaoImp dao = new UserDaoImp();
        dao.update(user);
        dao.destroy();

    }


    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori)throws IOException,ServletException,DaoException
    {
        List<String> date= new ArrayList<>();

        if(!(errori.containsKey("ErroreEmail")))
        {
            date.add("email");
        }
        if(!(errori.containsKey("ErroreNome")))
        {
            date.add("nome");
        }
        if(!(errori.containsKey("ErroreCognome")))
        {
        date.add("cognome");
        }
        datamodel.putAll(errori);
        datamodel.putAll(Utility.AddAllData(request,response,date));
        insuccessFillForm(request,response,"Errore compilazione Form");
    }






}
