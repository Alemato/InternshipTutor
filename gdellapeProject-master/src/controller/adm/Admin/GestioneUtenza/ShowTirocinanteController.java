package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
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


public class ShowTirocinanteController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        showTirocinante(request,response);


    }

    private void showTirocinante(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        super.init(request,response);
        try{
            TirocinanteDaoImp dao= new TirocinanteDaoImp();
            Tirocinante tr= dao.getTirocianteByID(Integer.parseInt(request.getParameter("IDTirocinante")));
            dao.destroy();
            datamodel.put("tirocinante",tr);
            datamodel.put("user",BackEndAdminController.getUser(request,response,tr.getUser()));
            TemplateController.process("BackEndTemplates/show-tirocinante.ftl", datamodel, response, getServletContext());


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/500");
        }


    }






}
