package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;

import controller.baseController;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.util.*;

//TODO fai testing sull eccezzione del dao
public class ReimpostaMailUserController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        updateMail(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        makeGet(request,response);


    }

    private void makeGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        try {
            super.init(request, response);
            fill_form(request, response);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/500");
        }

    }

    private void updateMail(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            UserDaoImp dao1 = new UserDaoImp();
            User user = dao1.getUserByid(Integer.parseInt(request.getParameter("IDUser")));
            dao1.destroy();
            if (validate(request, response, user)) {
                storeMail(request, response, user);
                AdminFillTable page = new AdminFillTable(datamodel,getServletContext(),request,response);
                page.makeSuccessGet("Cambiamento della mail andato a buon fine");
            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }

    }





    private void fill_form (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,DaoException {

        UserDaoImp dao1 = new UserDaoImp();
           User user = dao1.getUserByid(Integer.parseInt(request.getParameter("IDUser")));
           dao1.destroy();
           datamodel.put("user", user);
           TemplateController.process("BackEndTemplates/reimposta-mail-user.ftl", datamodel, response, getServletContext());

    }
    private void storeMail(HttpServletRequest request,HttpServletResponse response,User user) throws ServletException,IOException,DaoException
    {

 //      user.setEmail(request.getParameter(request.getParameter("email")));
//        UserDaoImp dao =new UserDaoImp();
//        dao.update(user);
//        dao.destroy();
        System.out.println("Cambio password andato bene");

    }



    private Boolean validate(HttpServletRequest request,HttpServletResponse response,User user) throws ServletException,IOException,DaoException
    {

            Map<String, Object> errori = new HashMap<>();


                if (request.getParameter("email").isEmpty()) {

                    errori.put("ErroreEmail", "Email non presente");

                } else if (!(Validation.isValidEmailAddress(request.getParameter("email")))) {

                    errori.put("ErroreEmail", "Email non congrua");
                    //nel caso l'email immessa e uguale a quella gia presente non do errore
                    //Vado in errore solo se l'email immessa e diversa da quella salvata e trovo una email uguale a quella salvata
                } else if (!(request.getParameter("email").equals(user.getEmail()))&&Validation.isStoredThisAddress(request.getParameter("email"))) {

                    errori.put("ErroreEmail", "Email gia presente");
                }
                System.out.println(errori.toString());

                if(errori.isEmpty())
            {
                return true;
            }else{
                System.out.println("Validazione non validada ricarico la pagina");
                refreshPage(request,response,errori);
                return false;
            }


    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response, Map<String,Object> errori) throws IOException,ServletException,DaoException
    {
        List<String> dati = new ArrayList<>();
        if(!(errori.containsKey("ErroreMail"))){
            dati.add("email");
        }
        datamodel.putAll(errori);

        datamodel.putAll(Utility.AddAllData(request,response,dati));

        fill_form(request,response);

    }















}
