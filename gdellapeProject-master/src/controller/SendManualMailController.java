package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import controller.utility.Mailer;
import freemarker.template.Template;
import view.TemplateController;
import view.TemplateControllerMail;

public class SendManualMailController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameterMap().containsKey("to")) {
            String[] to = request.getParameter("to").split(";");
            String subject = request.getParameter("subject");
            String msg = request.getParameter("msg");
            datamodel.put("msg", msg);
            Calendar cal = Calendar.getInstance();
            // Informazioni relative alla data
            int giorno =  cal.get(Calendar.DATE);
            int mese = cal.get(Calendar.MONTH);
            int anno = cal.get(Calendar.YEAR);
            // Informazione relative all'ora
            int ora = cal.get(Calendar.HOUR);
            int minuti = cal.get(Calendar.MINUTE);
            int secondi = cal.get(Calendar.SECOND);
            String datainvio = Integer.toString(giorno) + "\\" + Integer.toString(mese) + "\\" + Integer.toString(anno) + " " + Integer.toString(ora) + ":" + Integer.toString(minuti) + ":" + Integer.toString(secondi);
            datamodel.put("datainvio", datainvio);
            TemplateControllerMail.process("mailtemplateprova.ftl", datamodel, to, subject, getServletContext());
        }
        TemplateController.process("sendmanualmail.ftl", datamodel, response, getServletContext());
    }
}
