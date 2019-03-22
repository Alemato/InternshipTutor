package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.DownloadPDF;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PdfViewRichiestaTirocinio extends baseController {

    public Boolean isUrlValidRichiestaTirocinio(String urlstring) throws MalformedURLException {
        URL url = new URL("http://localhost:8080" + urlstring);
        String path = url.getPath().toLowerCase();
        String[] queryParts = url.getQuery().split("=");
        if (path.equals("/pdfview/richiestatirocinio")){
            if(!url.getQuery().contains("&") && queryParts[0].equals("id")){
                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                Tirocinio tirocinio = new Tirocinio();
                try {
                    tirocinio = tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(queryParts[1]));
                    tirocinioDaoImp.destroy();
                    if (tirocinio.getPdfTirocinante() != null){
                        return !tirocinio.getPdfTirocinante().isEmpty();
                    } else return false;
                } catch (DaoException e) {
                    return  false;
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
        PdfView pdfView = new PdfView((Integer) request.getAttribute("tipo"),"RichestaTirocinio", getServletContext());
        pdfView.processaRichiesta(request, response);
//        boolean accessoproibito = false;
//        boolean errorNotFound = false;
//        boolean trovato = false;
//        if (!request.getAttribute("tipo").equals(0)){
//            if (request.getParameterMap().containsKey("id")) {
//                int idTirocinio = Integer.parseInt(request.getParameter("id"));
//                Tirocinio tirocinio = new Tirocinio();
//                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
//                try {
//                    tirocinio = tirocinioDaoImp.getRichiestatrByID(idTirocinio);
//                    tirocinioDaoImp.destroy();
//                } catch (DaoException e) {
//                    errorNotFound = true;
//                }
//
//                // TEST per vedere se l'Azienda e quella giusta
//                if (request.getAttribute("tipo").equals(3) && !errorNotFound){
//                    SingSessionContoller session = SingSessionContoller.getInstance();
//                    Azienda az = new Azienda();
//                    az = session.getAzienda(request, response);
//                    OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
//                    List<OffertaTirocinio> offertaTirocinios = new ArrayList<>();
//                    try {
//                        offertaTirocinios = offertaTirocinioDaoImp.getOffertatrBYAzienda(az);
//                        offertaTirocinioDaoImp.destroy();
//                        for(OffertaTirocinio offertaTirocinio : offertaTirocinios){
//                            if(tirocinio.getOffertaTirocinio().equals(offertaTirocinio.getIDOffertaTirocinio())){
//                                trovato = true;
//                                break;
//                            }
//                        }
//                    } catch (DaoException e) {
//                        errorNotFound = true;
//                    }
//                }
//
//                // TEST per verdere se il tirocinante e quello giusto
//                if (request.getAttribute("tipo").equals(2) && !errorNotFound){
//                    SingSessionContoller session = SingSessionContoller.getInstance();
//                    Tirocinante tirocinante = new Tirocinante();
//                    tirocinante = session.getTirocinate(request, response);
//                    trovato = tirocinante.getIDTirocinante().equals(tirocinio.getTirocinante());
//                }
//
//                if(!errorNotFound && trovato){
//                    String filename = tirocinio.getPdfTirocinante();
//                    String saveDir = "PDF" + File.separator + "RichestaTirocinio" + tirocinio.getIDTirocinio() + File.separator + tirocinio.getTirocinante();
//                    DownloadPDF d = new DownloadPDF();
//                    Boolean riuscito = d.DownloadPDF(request, response, filename, saveDir);
//                    if (!riuscito){
//                        errorNotFound = true;
//                    }
//                }
//            } else {
//                errorNotFound = true;
//            }
//        } else {
//            accessoproibito = true;
//        }
//
//        if (accessoproibito && !trovato){
//            System.out.println("riporto 403 accesso non autorizzato non hai le credenziali giuste ");
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
//            dispatcher.forward(request, response);
//        }
//
//        if (errorNotFound && !accessoproibito){
//            System.out.println("riporto 404");
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
//            dispatcher.forward(request, response);
//        }
    }
}
