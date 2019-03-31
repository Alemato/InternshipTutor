package controller.adm.Admin.GestioneTirocinio;


import controller.adm.Admin.GestioneAzienda.FillGestioniModuliConvenzione;
import controller.baseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        FillGestioniModuliTirocini page = new FillGestioniModuliTirocini(request,response,getServletContext(),datamodel);
        page.makeget();
        System.out.println(datamodel);
    }



}
