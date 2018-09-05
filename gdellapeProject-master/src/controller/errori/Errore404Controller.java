package controller.errori;

import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;


public class Errore404Controller extends baseController  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        super.init(request, response);
        TemplateController.process("404.ftl", datamodel, response, getServletContext());
    }
}
