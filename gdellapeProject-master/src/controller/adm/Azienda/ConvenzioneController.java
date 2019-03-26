package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import model.Azienda;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ConvenzioneController extends baseController {
    private Azienda azienda = new Azienda();

    private void creaOggeti(HttpServletRequest request, HttpServletResponse response) {
        SingSessionContoller session = SingSessionContoller.getInstance();
        try {
            this.azienda = session.getAzienda(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void gestioneRichiesta(HttpServletResponse response) {
        if (azienda.getDataConvenzione() == null && azienda.getDurataConvenzione() == null) {
            System.out.println("la richiesta è di tipo creazione convenzione");
            Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            richiestaUpdate(presente.getTime(), response);
        } else {
            Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
            Calendar presente = (Calendar) scadenza.get("presente");
            Boolean scaduto = (Boolean) scadenza.get("scaduto");
            //presente.set(2018,Calendar.SEPTEMBER,2);
            Date dataoggi = presente.getTime();
            if (!scaduto) {
                System.out.println("la richiesta è di stampa o altro");
                richiestaStampaModullo(dataoggi, response);
            } else {
                System.out.println("la richiesta è di tipo agg");
                richiestaUpdate(dataoggi, response);
            }
        }

    }

    private void richiestaStampaModullo(Date dataoggi, HttpServletResponse response) {
        if (azienda.getPathPDFConvenzione() == null) {
            richiestaUpdate(dataoggi, response);
        } else {
            System.out.println("rispondi con il file");

        }

    }

    private void richiestaUpdate(Date dataoggi, HttpServletResponse response) {
        System.out.println("richiesta agg convenzione");
        datamodel.put("notview", true);
        datamodel.put("azienda", azienda);
        datamodel.put("data", dataoggi);
        TemplateController.process("modulo-convenzione-aziendale.ftl", datamodel, response, getServletContext());
    }

    private void processaRichiestaUpdate(HttpServletRequest request, HttpServletResponse response) {
        azienda.setRagioneSociale(HtmlEscape.escapeHtml5(request.getParameter("Ente_Azienda")));
        azienda.setIndirizzoSedeLegale(HtmlEscape.escapeHtml5(request.getParameter("SedeLegale")));
        azienda.setCFiscalePIva(HtmlEscape.escapeHtml5(request.getParameter("Codice_Fiscale")));
        azienda.setNomeLegaleRappresentante(HtmlEscape.escapeHtml5(request.getParameter("Rappresentante_Legale_Nome")));
        azienda.setCognomeLegaleRappresentante(HtmlEscape.escapeHtml5(request.getParameter("Rappresentante_Legale_Cognome")));
        azienda.setForoControversia(HtmlEscape.escapeHtml5(request.getParameter("Foro_Competente")));
        azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("Durata_GG")));
        azienda.setDataConvenzione(java.sql.Date.valueOf(request.getParameter("Data_Documento")));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameterMap().containsKey("Ente_Azienda") && request.getParameterMap().containsKey("SedeLegale") && request.getParameterMap().containsKey("Codice_Fiscale") && request.getParameterMap().containsKey("Rappresentante_Legale_Nome") && request.getParameterMap().containsKey("Rappresentante_Legale_Cognome") && request.getParameterMap().containsKey("Foro_Competente") && request.getParameterMap().containsKey("Durata_GG") && request.getParameterMap().containsKey("Data_Documento")) {
            if (azienda.getPathPDFConvenzione()== null){
                System.out.println("la richiesta è di creazione");
                creaOggeti(request, response);
                processaRichiestaUpdate(request, response);
            } else {
                if (azienda.getDataConvenzione() == null && azienda.getDurataConvenzione() == null) {
                    System.out.println("richiesta di update non valida con una grave errore perchè come fa ad avere il pdf?");
                }else {
                    Map<String, Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
                    Calendar presente = (Calendar) scadenza.get("presente");
                    Boolean scaduto = (Boolean) scadenza.get("scaduto");
                    if (!scaduto) {
                        System.out.println("la richiesta è inlecita");
                    } else {
                        System.out.println("la richiesta è di tipo agg");
                        creaOggeti(request, response);
                        processaRichiestaUpdate(request, response);
                    }
                }
            }
        } else {
            System.out.println("richiesta di update non valida");
            this.doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        creaOggeti(request, response);
        gestioneRichiesta(response);
    }
}
