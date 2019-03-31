package controller.adm.Admin.GestioneAzienda;


import controller.baseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliConvenzioneController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        FillGestioniModuliConvenzione page = new FillGestioniModuliConvenzione(request,response,getServletContext(),datamodel);
        page.makeget();
        System.out.println(datamodel);
    }



}
