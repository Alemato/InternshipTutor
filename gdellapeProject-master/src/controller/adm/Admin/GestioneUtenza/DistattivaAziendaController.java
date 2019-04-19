package controller.adm.Admin.GestioneUtenza;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import controller.adm.Admin.GestioneModuli.InvalidaConvenzioneAzienda;
import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;


public class DistattivaAziendaController extends baseController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        makeGet(request,response);
    }
    private void makeGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        try {
            super.init(request, response);
            InvalidaConvenzioneAzienda page = new InvalidaConvenzioneAzienda(datamodel, getServletContext(), request, response);
            page.disattivaAzienda();
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }

    }





}
