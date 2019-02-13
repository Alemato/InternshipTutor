package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.TutoreUniversitario;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

public class AdminGestioneUtentiController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        datamodel.put("tirocinanti",filltable(request,response));
        FillAziendaTable(request,response);
        FillTutUniTablde(request, response);
        FillTableAdmin(request, response);
        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, getServletContext());
    }

    private List<Tirocinante> filltable(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        List<Tirocinante> tirocinate= new ArrayList<>();
        try{
            TirocinanteDaoImp dao= new TirocinanteDaoImp();
            tirocinate = dao.getAllTirociante();
            dao.destroy();

        }catch (DaoException e)
        {
            response.sendRedirect("/404");
            e.printStackTrace();
        }
        return tirocinate;
    }
    private void  FillAziendaTable (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            List<Azienda> aziende = new ArrayList<>();
            AziendaDaoImp dao = new AziendaDaoImp();
           aziende= dao.getAllAzienda();
           dao.destroy();
           datamodel.put("aziende",aziende);
        }catch (DaoException e)
        { e.printStackTrace();
        response.sendRedirect("/404");}
    }
    private void FillTutUniTablde(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException
    {
        try{
            List<TutoreUniversitario> tutori = new ArrayList<>();
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            tutori= dao.getAllTutUni();
            dao.destroy();
            datamodel.put("tutori",tutori);

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    private void FillTableAdmin(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException
    {
        try{
            List<Admin> gliadmin = new ArrayList<>();
            AdminDaoImp dao = new AdminDaoImp();
            gliadmin=dao.getAllAdmin();
            dao.destroy();
            datamodel.put("listadmin",gliadmin);

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }


}
