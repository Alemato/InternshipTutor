package controller.errori;

import controller.baseController;
import view.TemplateController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class Errore403Controller extends baseController {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServerException,IOException {
        TemplateController.process("403.ftl", datamodel, response, getServletContext());

    }
}
