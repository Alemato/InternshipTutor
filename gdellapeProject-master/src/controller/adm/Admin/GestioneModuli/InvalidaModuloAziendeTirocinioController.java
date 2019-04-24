package controller.adm.Admin.GestioneModuli;


import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InvalidaModuloAziendeTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        try{
            datamodel.put("urlpage","/admin/Gestione-tirocinio");
            InvalidazioneModuliTirocinio page = new InvalidazioneModuliTirocinio(datamodel,getServletContext(),request,response);
            page.invalidaPDFAzienda();
        }catch (DaoException e){
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }



    }

















}
