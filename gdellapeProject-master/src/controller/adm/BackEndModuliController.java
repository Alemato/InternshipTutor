package controller.adm;

import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackEndModuliController extends baseController {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        super.init(request,response);
        int tipo= (int)request.getAttribute("tipo");
        if (tipo == 3){
            System.out.println("Devo entra dentro la pagina del azienda");
            TemplateController.process("moduli-aziendale.ftl", datamodel, response, getServletContext());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{

    }
}
