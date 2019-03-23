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
        Tirocinante tr = BackEndAdminController.getTirocinante(request,response,Integer.parseInt(request.getParameter("ID")));
        datamodel.put("tirocinante",tr);
        datamodel.put("user",BackEndAdminController.getUser(request,response,tr.getUser()));
        TemplateController.process("BackEndTemplates/show-tirocinante.ftl", datamodel, response, getServletContext());



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {




    }






}
