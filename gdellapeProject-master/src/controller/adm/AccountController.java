package controller.adm;

import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountController extends HttpServlet {
    protected Map<String, Object> datamodel = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateController.process("il-mio-account-tirocinante.ftl", datamodel, response, getServletContext());
    }
}
