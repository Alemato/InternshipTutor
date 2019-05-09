package controller.utility;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.TirocinioDaoDaoImp;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@MultipartConfig
public class servletUploadProva extends baseController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateController.process("ProvaUp.ftl", datamodel, response, getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part parto = request.getPart("filetoupload");
        System.out.println(parto);
        TirocinioDaoDaoImp tirocinioDaoImp = new TirocinioDaoDaoImp();
        Tirocinio tirocinio = new Tirocinio();
        try {
            tirocinio = tirocinioDaoImp.getRichiestatrByID(36);
            tirocinioDaoImp.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        UploadFilePDF uploadFilePDF = new UploadFilePDF();
        String mario = uploadFilePDF.uploadPDF(request, parto, 1, tirocinio);
        System.out.println("PDF");
        System.out.println(mario);
        if (!mario.equals(""))
            System.out.println("PDF caricato "+ mario);
        else
            System.out.println("PDF non caricato");

    }
}
