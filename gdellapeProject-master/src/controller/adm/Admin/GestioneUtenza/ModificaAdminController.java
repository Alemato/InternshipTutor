package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
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
import java.util.HashMap;
import java.util.Map;


public class ModificaAdminController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UpdateAdmin(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin=BackEndAdminController.getAdmin(request,response,Integer.parseInt(request.getParameter("ID")));
        User user = BackEndAdminController.getUser(request,response,admin.getUser());
        datamodel.put("admin",admin);
        datamodel.put("user",user);
        TemplateController.process("BackEndTemplates/modifica-admin.ftl", datamodel, response, getServletContext());



    }


    private Boolean validazione(HttpServletRequest request,HttpServletResponse response,Admin admin) throws ServletException,IOException
    {
        Map<String,Object> errori = new HashMap<>();

        if(!(request.getParameter("nome").isEmpty()))
        {
            errori.put("ErroreNome","Nome non presente");
        }else if(request.getParameter("nome").length()>50)
        {
            errori.put("ErroreNome","Nome troppo lungo");
        }

        if(!(request.getParameter("cognome").isEmpty())){

            errori.put("ErroreCognome","Cognomee non presente");

        }else if(request.getParameter("cognome").length()>50)
        {
            errori.put("ErroreCognome","Nome troppo lungo");
        }

        if(errori.isEmpty())
        {
            return true;
        }else{
            return false;
        }

    }






   private void UpdateAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {

            Admin admin=BackEndAdminController.getAdmin(request,response,Integer.parseInt(request.getParameter("ID")));
            admin.setNome(request.getParameter("nome"));
            admin.setCognome(request.getParameter("cognome"));
            AdminDaoImp dao = new AdminDaoImp();
            dao.updateAdmin(admin);
            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
