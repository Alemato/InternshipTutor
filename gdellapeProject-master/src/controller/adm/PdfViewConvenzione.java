package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.DownloadPDF;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfViewConvenzione extends baseController {

    public Boolean isUrlValidConvenzione(String urlstring) throws MalformedURLException {
        URL url = new URL("http://localhost:8080" + urlstring);
        String path = url.getPath();
        String query = url.getQuery();
        String[] partiQuery = query.split("=");
        if (path.equals("/pdfview/convenzione")) {
            if (!query.contains("&") && partiQuery[0].equals("id")) {
                AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
                Azienda azienda;
                try {
                    azienda = aziendaDaoImp.getAziendaByID(Integer.parseInt(partiQuery[1]));
                    aziendaDaoImp.destroy();
                    if(azienda.getPathPDFConvenzione() != null){
                        return !azienda.getPathPDFConvenzione().isEmpty();
                    } else {
                        return false;
                    }
                } catch (DaoException e) {
                    return false;
                }
            }
        }
        return false;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getAttribute("tipo").equals(1) || request.getAttribute("tipo").equals(3)) {
            Boolean accessoproibito = false;
            if (request.getParameterMap().containsKey("id")) {
                if (request.getAttribute("tipo").equals(3)){
                    SingSessionContoller sessionContoller = SingSessionContoller.getInstance();
                    Azienda azienda1 = sessionContoller.getAzienda(request, response);
                    if (!azienda1.getIDAzienda().equals(Integer.parseInt(request.getParameter("id")))){
                        accessoproibito = true;
                        System.out.println("riporto 403 accesso non autorizzato azinda con id diverso ");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
                        dispatcher.forward(request, response);
                    }
                }
                int id = Integer.parseInt(request.getParameter("id"));
                AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
                Azienda azienda = new Azienda();
                try {
                    azienda = aziendaDaoImp.getAziendaByID(id);
                    aziendaDaoImp.destroy();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                if (!accessoproibito) {
                    String filename = azienda.getPathPDFConvenzione();
                    String saveDir = "PDF" + File.separator + "Convenzione" + File.separator + id;
                    DownloadPDF d = new DownloadPDF();
                    Boolean riuscito = d.DownloadPDF(request, response, filename, saveDir);
                    if (!riuscito) {
                        System.out.println("riporto 404 per errore pdf");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
                        dispatcher.forward(request, response);
                    } else {
                        System.out.println("riporto 404");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
                        dispatcher.forward(request, response);
                    }
                }
            }
        }else {
            System.out.println("riporto 403 accesso non autorizzato non hai le credenziali giuste ");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
            dispatcher.forward(request, response);
        }
    }
}
