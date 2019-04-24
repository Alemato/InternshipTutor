package controller.adm.Admin.GestioneAzienda;


import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliConvenzioneController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        super.init(request,response);
        try {
            FillGestioniModuliConvenzione page = new FillGestioniModuliConvenzione(request, response, getServletContext(), datamodel);
            page.makeget();
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher errorpage = request.getRequestDispatcher("/500");
            errorpage.forward(request,response);
        }
    }



}
