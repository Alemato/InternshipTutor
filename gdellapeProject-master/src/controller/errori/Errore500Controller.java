package controller.errori;
import controller.baseController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class Errore500Controller extends baseController {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        super.init(request, response);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        datamodel.put("StatusCode", statusCode);
        datamodel.put("ServeletName", servletName);
        datamodel.put("Throwable", throwable.getMessage());
        datamodel.put("ThrowableStackTrace",  throwable.getStackTrace());
        datamodel.put("ThrowableCause", throwable.getCause());
        TemplateController.process("500.ftl", datamodel, response, getServletContext());

    }
}
