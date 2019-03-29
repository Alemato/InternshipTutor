package controller.errori;

import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class Errore403Controller extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        super.init(request, response);
        TemplateController.process("403.ftl", datamodel, response, getServletContext());

    }
}
