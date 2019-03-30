package controller.errori;

import controller.baseController;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Errore500Controller extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.init(request, response);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        Throwable throwable = new Throwable();
        if (request.getAttribute("javax.servlet.error.exception") != null) {
            throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        }
        if (statusCode != null) {
            datamodel.put("StatusCode", statusCode);
        }
        if (servletName != null) {
            datamodel.put("ServeletName", servletName);
        }
        if (request.getAttribute("MessaggioErrore") != null) {
            datamodel.put("Throwable", request.getAttribute("MessaggioErrore"));
        } else {
            if (throwable.getMessage() != null) {
                datamodel.put("Throwable", throwable.getMessage());
            }
        }
        if (throwable.getStackTrace() != null) {
            StackTraceElement[] stktrace = throwable.getStackTrace();
            StringBuilder stack = new StringBuilder();
            for (StackTraceElement stackTraceElement : stktrace) {
                stack.append(HtmlEscape.escapeHtml5(stackTraceElement.toString())).append("<br>");
            }
            datamodel.put("ThrowableStackTrace", stack);

        }
        if (throwable.getCause() != null) {
            datamodel.put("ThrowableCause", throwable.getCause());
        }
        TemplateController.process("500.ftl", datamodel, response, getServletContext());

    }
}
