package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.utility.Mailer;
import view.TemplateController;

public class SendManualMailController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameterMap().containsKey("to")) {
            System.out.println("SI");
            String to = request.getParameter("to");
            String subject = request.getParameter("subject");
            String msg = request.getParameter("msg");
            Mailer.send(to, subject, msg);
            System.out.println("INVIATO");
        }
        TemplateController.process("sendmanualmail.ftl", datamodel, response, getServletContext());
    }
}
