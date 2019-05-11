package controller.adm;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PdfSegreteriaController extends baseController {

    private void er404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if(!request.getAttribute("tipo").equals(0)) {
            if (request.getParameter("id") != null) {
                int idTirocinio = Integer.parseInt(request.getParameter("id"));
                Tirocinio tirocinio;
                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                try {
                    tirocinio = tirocinioDaoImp.getRichiestatrByID(idTirocinio);
                    tirocinioDaoImp.destroy();
                    PdfView pdfView = new PdfView((Integer) request.getAttribute("tipo"), "Segreteria", getServletContext());
                    String url = pdfView.createURL(tirocinio);
                    datamodel.put("titolo", "Fine Tirocinio");
                    datamodel.put("titoloDescrittivo", "Modulo Fine Tirocinio (Segreteria)");
                    datamodel.put("Url", url);
                    TemplateController.process("PDF-View-Front-End.ftl", datamodel, response, getServletContext());
                } catch (DaoException e) {
                    e.printStackTrace();
                    er404(request, response);
                }
            } else er404(request, response);
        } else er404(request, response);
    }
}
