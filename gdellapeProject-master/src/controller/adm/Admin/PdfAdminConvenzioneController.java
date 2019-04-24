package controller.adm.Admin;

import controller.adm.PdfView;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PdfAdminConvenzioneController extends baseController {

    private void er404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if(request.getAttribute("tipo").equals(1)) {
            if (request.getParameter("id") != null) {
                AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
                Azienda azienda = null;
                try {
                    azienda = aziendaDaoImp.getAziendaByID(Integer.parseInt(request.getParameter("id")));
                    aziendaDaoImp.destroy();
                    PdfView pdfView = new PdfView((Integer) request.getAttribute("tipo"), "Convenzione", getServletContext());
                    String url = pdfView.createURLConvenzione(azienda);
                    datamodel.put("titoloDescrittivo", "Modulo Convenzione " + azienda.getRagioneSociale());
                    datamodel.put("Url", url);
                    datamodel.put("titolo", "Convenzione Aziendale");
                    TemplateController.process("/BackEndTemplates/PDF-View-Admin.ftl", datamodel, response, getServletContext());
                } catch (DaoException e) {
                    e.printStackTrace();
                    er404(request, response);
                }
            }else er404(request, response);
        }else er404(request, response);

    }
}
