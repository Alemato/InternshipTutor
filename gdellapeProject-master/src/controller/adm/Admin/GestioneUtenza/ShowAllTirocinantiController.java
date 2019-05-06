package controller.adm.Admin.GestioneUtenza;

import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAllTirocinantiController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        makeGet(request,response);

    }

    private void makeGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            super.init(request, response);
            AdminFillTable objectFunction = new AdminFillTable(datamodel, getServletContext(), request, response);
            objectFunction.makeGetTirocinanti();
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }



}
