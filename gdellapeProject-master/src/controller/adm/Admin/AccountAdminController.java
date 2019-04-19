package controller.adm.Admin;

import controller.adm.Azienda.BackEndAziendaController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

public class AccountAdminController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Accoutadmin(request,response);

    }

    private void Accoutadmin(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException
    {
        try {
           // super.accessLogin(request, response);
           // super.accessAzienda(request, response);
            FillTableRicheste(request, response);
            TemplateController.process("BackEndTemplates/admin-dashboard.ftl", datamodel, response, getServletContext());
        }catch (Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }

    }
    private void FillTableRicheste(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziende = dao.getAllAziendaPendenti();
            dao.destroy();
            datamodel.put("aziende", aziende);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");

        }

    }
    private void FillTableOffTr(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try
        {
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> oftr= dao.getAllOffertatr();
            dao.destroy();
            datamodel.put("oftr",oftr);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/400");
        }

    }



}
