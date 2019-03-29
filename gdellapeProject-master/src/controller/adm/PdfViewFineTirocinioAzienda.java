package controller.adm;

import controller.baseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PdfViewFineTirocinioAzienda extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        PdfView pdfView = new PdfView((Integer) request.getAttribute("tipo"),"FineTirocinioAzienda", getServletContext());
        pdfView.processaRichiesta(request, response);
    }
}
