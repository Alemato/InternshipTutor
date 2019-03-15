package controller.adm;

import controller.baseController;
import controller.utility.DownloadPDF;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PdfView extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        DownloadPDF d = new DownloadPDF();
        d.DownloadPDF(request, response, "A.pdf", "PDF");
    }
}
