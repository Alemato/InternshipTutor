package controller.adm.Admin.GestioneUtenza;


import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminRichiesteConvenzioniController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        makeGet(request,response);

    }

    private void makeGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            super.init(request, response);
            AdminFillRichiesteAndAttive objectFunction = new AdminFillRichiesteAndAttive(datamodel, getServletContext(), request, response);
            objectFunction.makeget();
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/500");
        }
    }

}
