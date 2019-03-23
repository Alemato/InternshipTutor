package controller.adm.Admin;


import controller.adm.Admin.GestioneTirocinio.FillRichiesteTr;
import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        FillRichiesteTr tr = new FillRichiesteTr();
        datamodel.putAll(tr.fill(request,response));
        System.out.println(datamodel);
        TemplateController.process("BackEndTemplates/gestione-moduli.ftl", datamodel, response, getServletContext());
        System.out.println(datamodel);
    }


}
