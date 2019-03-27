package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import model.Tirocinante;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InvalidaConvenzioneAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        makeGet(request,response);

    }

    private void makeGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            super.init(request, response);
            InvalidaConvenzioneAzienda page = new InvalidaConvenzioneAzienda(datamodel, getServletContext(), request, response);
            page.invalidaConvezioneModuli();
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/500");
        }
    }



















}
