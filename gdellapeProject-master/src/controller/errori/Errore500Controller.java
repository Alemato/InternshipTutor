package controller.errori;

import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class Errore500Controller extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.init(request, response);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (statusCode != null){
            datamodel.put("StatusCode", statusCode);
        }
        if (servletName != null){
            datamodel.put("ServeletName", servletName);
        }
        if (throwable.getMessage() != null) {
            datamodel.put("Throwable", throwable.getMessage());
        }
        if (throwable.getStackTrace() != null){
            datamodel.put("ThrowableStackTrace", throwable.getStackTrace());
        }
        if (throwable.getCause() != null){
            datamodel.put("ThrowableCause", throwable.getCause());
        }
        TemplateController.process("500.ftl", datamodel, response, getServletContext());

    }
}
