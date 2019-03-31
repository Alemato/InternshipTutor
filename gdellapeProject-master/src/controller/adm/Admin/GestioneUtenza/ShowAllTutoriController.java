package controller.adm.Admin.GestioneUtenza;

import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAllTutoriController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



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
            objectFunction.makeGetTutori();
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/500");
        }
    }



}
