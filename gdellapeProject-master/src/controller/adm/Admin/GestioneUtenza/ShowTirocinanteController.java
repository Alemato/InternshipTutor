package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
import model.Tirocinante;
import model.User;
import view.TemplateController;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowTirocinanteController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getTirocinanteAndUser(request,response);
        TemplateController.process("BackEndTemplates/show-tirocinante.ftl", datamodel, response, getServletContext());



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {




    }
    private void getTirocinanteAndUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            int idtr = Integer.parseInt(request.getParameter("ID"));
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tr = dao.getTirocianteByID(idtr);
            dao.destroy();
            UserDaoImp dao1=new UserDaoImp();
            User user= dao1.getUserByid(tr.getIDTirocinante());
            dao1.destroy();
            datamodel.put("user",user);
            datamodel.put("tirocinante", tr);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }





}
