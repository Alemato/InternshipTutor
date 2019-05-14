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
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@MultipartConfig
public class UploadPDFTirocinioFineController extends baseController {
    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        Part pdfAzienda = request.getPart("PDFAzienda");
        if(pdfAzienda!=null){
            TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
            try {
                Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(id);
                tirocinioDaoImp.destroy();
                TirocinioDaoImp tirocinioDaoImp1 = new TirocinioDaoImp();
                UploadFilePDF uploadFilePDF = new UploadFilePDF();
                String nomefile = uploadFilePDF.uploadPDF(request, pdfAzienda, 2, tirocinio);
                tirocinio.setPdfAzienda(nomefile);
                Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
                tirocinio.setDataConsegnaModuloAzienda(new java.sql.Date(presente.getTimeInMillis()));
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
