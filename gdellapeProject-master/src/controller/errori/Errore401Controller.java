package controller.errori;

import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import controller.baseController;

public class Errore401Controller extends baseController{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        super.init(request, response);
        TemplateController.process("401.ftl", datamodel, response, getServletContext());

    }
}
