package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowAziendaController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getAziendaAndUser(request, response);
        TemplateController.process("BackEndTemplates/show-Azienda.ftl", datamodel, response, getServletContext());




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {



    }
    private void getAziendaAndUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            int idaz = Integer.parseInt(request.getParameter("ID"));
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda az=dao.getAziendaByID(idaz);
            dao.destroy();
            UserDaoImp dao1 = new UserDaoImp();
            User user = dao1.getUserByid(az.getUser());
            dao1.destroy();
            datamodel.put("azienda",az);
            datamodel.put("user",user);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }





}
