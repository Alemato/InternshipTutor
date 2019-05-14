package controller.adm.Azienda;

import controller.adm.PdfView;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ConvenzioneController extends baseController {
    private Azienda azienda = new Azienda();
    private Integer tipoAccount;

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void creaOggeti(HttpServletRequest request, HttpServletResponse response) {
        SingSessionContoller session = SingSessionContoller.getInstance();
        try {
            this.azienda = session.getAzienda(request, response);
            this.tipoAccount = 3;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void gestioneRichiesta(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        if (azienda.getDataConvenzione() != null) {
            if (azienda.getDurataConvenzione() != null) {
                Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
                Calendar presente = (Calendar) scadenza.get("presente");
                Boolean scaduto = (Boolean) scadenza.get("scaduto");
                //presente.set(2018,Calendar.SEPTEMBER,2);
                Date dataoggi = presente.getTime();
                if (!scaduto) {
                    richiestaStampaModullo(dataoggi, response, request);
                } else {
                    richiestaUpdate(dataoggi, response);
                }
            } else {
                er500(request, response);
            }
        } else {
            Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            richiestaUpdate(presente.getTime(), response);
        }
    }

    private void richiestaStampaModullo(Date dataoggi, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        if (azienda.getPathPDFConvenzione() == null) {
            richiestaUpdate(dataoggi, response);
        } else {
            PdfView pdfView = new PdfView(this.tipoAccount, "Convenzione", getServletContext());
            String url = pdfView.createURLConvenzione(this.azienda);
            datamodel.put("Url", url);
            TemplateController.process("PDFConvenzione.ftl", datamodel,response, getServletContext());
        }

    }

    private void richiestaUpdate(Date dataoggi, HttpServletResponse response) {
        datamodel.put("notview", true);
        datamodel.put("azienda", azienda);
        datamodel.put("data", dataoggi);
        TemplateController.process("modulo-convenzione-aziendale.ftl", datamodel, response, getServletContext());
    }

    private void processaRichiestaUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameterMap().containsKey("Ente_Azienda") && request.getParameterMap().containsKey("SedeLegale") && request.getParameterMap().containsKey("Codice_Fiscale") && request.getParameterMap().containsKey("Rappresentante_Legale_Nome") && request.getParameterMap().containsKey("Rappresentante_Legale_Cognome") && request.getParameterMap().containsKey("Foro_Competente") && request.getParameterMap().containsKey("Durata_GG") && request.getParameterMap().containsKey("Data_Documento")) {
            if(!request.getParameter("Ente_Azienda").isEmpty() && !request.getParameter("SedeLegale").isEmpty() && !request.getParameter("Codice_Fiscale").isEmpty() && !request.getParameter("Rappresentante_Legale_Nome").isEmpty() && !request.getParameter("Rappresentante_Legale_Cognome").isEmpty() && !request.getParameter("Foro_Competente").isEmpty() && !request.getParameter("Durata_GG").isEmpty() && !request.getParameter("Data_Documento").isEmpty()){
                azienda.setRagioneSociale(HtmlEscape.escapeHtml5(request.getParameter("Ente_Azienda")));
                azienda.setIndirizzoSedeLegale(HtmlEscape.escapeHtml5(request.getParameter("SedeLegale")));
                azienda.setCFiscalePIva(HtmlEscape.escapeHtml5(request.getParameter("Codice_Fiscale")));
                azienda.setNomeLegaleRappresentante(HtmlEscape.escapeHtml5(request.getParameter("Rappresentante_Legale_Nome")));
                azienda.setCognomeLegaleRappresentante(HtmlEscape.escapeHtml5(request.getParameter("Rappresentante_Legale_Cognome")));
                azienda.setForoControversia(HtmlEscape.escapeHtml5(request.getParameter("Foro_Competente")));
                azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("Durata_GG")));
                azienda.setDataConvenzione(java.sql.Date.valueOf(request.getParameter("Data_Documento")));
                azienda.setPathPDFConvenzione(null);
                azienda.setModuloConvenzione(false);
                AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
                try {
                    aziendaDaoImp.updateAzienda(azienda);
                    aziendaDaoImp.destroy();
                    response.sendRedirect("/account/moduli");
                } catch (DaoException e) {
                    datamodel.put("ErroreDati", "Il caricamento avuto problemi, <br> se errore susiste contattare amministratore");
                    this.gestioneRichiesta(response, request);
                }
            } else {
                datamodel.put("ErroreDati", "Uno o più dati sono vuoti");
                this.gestioneRichiesta(response, request);
            }
        } else {
            datamodel.put("ErroreDati", "Uno o più dati sono mancanti") ;
            this.gestioneRichiesta(response, request);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        // CONTROLLO SE ESISTE UNA DATA DI CONVENZIONE
        if (azienda.getDataConvenzione() != null) {
            if (azienda.getDurataConvenzione() != null) {
                Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
                boolean scaduto = (boolean) scadenza.get("scaduto");
                if (!scaduto) {
                    if (azienda.getPathPDFConvenzione() == null){
                        creaOggeti(request, response);
                        processaRichiestaUpdate(request, response);
                    }else {
                        er500(request, response);
                    }
                } else {
                    creaOggeti(request, response);
                    processaRichiestaUpdate(request, response);
                }
            } else {
                er500(request, response);
            }
        } else {
            // ALLORA SE E NULLA DEVO CREARE UNA CONVENZIONE
            creaOggeti(request, response);
            processaRichiestaUpdate(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        creaOggeti(request, response);
        gestioneRichiesta(response, request);

    }
}
