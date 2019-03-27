package controller.adm.Admin;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
import controller.baseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        FillGestioniModuli page = new FillGestioniModuli(request,response,getServletContext(),datamodel);
        page.makeget();
        System.out.println(datamodel);
    }



}
