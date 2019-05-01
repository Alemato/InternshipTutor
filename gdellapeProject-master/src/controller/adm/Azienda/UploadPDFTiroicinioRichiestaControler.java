package controller.adm.Azienda;

import controller.baseController;
import controller.utility.UploadFilePDF;
import dao.exception.DaoException;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@MultipartConfig
public class UploadPDFTiroicinioRichiestaControler extends baseController {
    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        int id = Integer.parseInt(request.getParameter("idRichiesta"));
        Part pdfRichiesta = request.getPart("PDFRichiesta");
        System.out.println("file : "+pdfRichiesta);
        if(pdfRichiesta!=null){
            TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
            try {
                Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(id);
                tirocinioDaoImp.destroy();
                TirocinioDaoImp tirocinioDaoImp1 = new TirocinioDaoImp();
                UploadFilePDF uploadFilePDF = new UploadFilePDF();
                String nomefile = uploadFilePDF.uploadPDF(request, pdfRichiesta, 1, tirocinio);
                tirocinio.setPdfTirocinante(nomefile);
                Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
                tirocinio.setDataConsegnaModuloRichiesta(new java.sql.Date(presente.getTimeInMillis()));
                tirocinioDaoImp1.updateTirocinio(tirocinio);
                tirocinioDaoImp1.destroy();
                response.sendRedirect("/account/moduli");
            } catch (DaoException e) {
                e.printStackTrace();
                er500(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        er500(request, response);
    }
}
