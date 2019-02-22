package controller.adm.Admin.GestioneUtenza;


import controller.baseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AdminGestioneUtentiController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        AdminFillTable dato = new AdminFillTable(datamodel, getServletContext(), request, response);
        dato.makeget();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        System.out.println("admingestioneutenticontroller datamodel");
        System.out.println(datamodel.toString());
        AdminFillTable dato = new AdminFillTable(datamodel, getServletContext(), request, response);
        dato.makeget();

    }

}
