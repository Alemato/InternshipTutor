package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;
import view.TemplateControllerMail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreazioneOffertaController extends baseController {

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void processaGet(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws IOException {
        Azienda azienda = session.getAzienda(request, response);
        datamodel.put("Azienda", azienda);
        TemplateController.process("creazione-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
    }


    private void processaPost(HttpServletRequest request, HttpServletResponse response, OffertaTirocinio offertaTirocinio, Azienda azienda) throws IOException, ServletException {
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        try {
            offertaTirocinioDaoImp.setOffertatr(offertaTirocinio);
            offertaTirocinioDaoImp.destroy();
            OffertaTirocinioDaoImp offertaTirocinioDaoImp1 = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> offertaTirocinios = offertaTirocinioDaoImp1.getOffertatrBYAzienda(azienda);
            offertaTirocinioDaoImp.destroy();
            datamodel.put("Titolo",offertaTirocinio.getTitolo());
            datamodel.put("Descrizione",offertaTirocinio.getDescrizione());
            datamodel.put("DescrizioneBreve",offertaTirocinio.getDescrizioneBreve());
            datamodel.put("LuogoEffettuazione",offertaTirocinio.getLuogoEffettuazione());
            datamodel.put("Orario",offertaTirocinio.getOrari());
            datamodel.put("PeriodoInizio",offertaTirocinio.getPeriodoInizio());
            datamodel.put("PeriodoFine",offertaTirocinio.getPeriodoFine());
            datamodel.put("Obbiettivi",offertaTirocinio.getObbiettivi());
            datamodel.put("Modalita",offertaTirocinio.getModalita());
            datamodel.put("Rimborsi",offertaTirocinio.getRimborsi());
            datamodel.put("Facilitazioni",offertaTirocinio.getFacilitazioni());
            datamodel.put("NomeRespAz",offertaTirocinio.getNomeTutoreAziendale());
            datamodel.put("CognomeRespAz",offertaTirocinio.getCognomeTutoreAziendale());
            datamodel.put("EmailRespAZ",offertaTirocinio.getEmailTutoreAziendale());
            datamodel.put("TelRespAz",offertaTirocinio.getTelefonoTutoreAziendale());
            datamodel.put("Url",offertaTirocinios.get(offertaTirocinios.size()-1).getIDOffertaTirocinio());
            String[] to = new String[1];
            to[0]= "azienda@matteifamily.net";
            String subject = "Registrazione Nuova Offerta di Tirocinio : "+ HtmlEscape.unescapeHtml(offertaTirocinio.getTitolo());
            TemplateControllerMail.process("email/creazione-offerta.ftl", datamodel, to, subject, getServletContext());
        } catch (DaoException e) {
            e.printStackTrace();
            er500(request, response);
        }
        response.sendRedirect("/account/gestione-offerte");
    }

    private void erroriPost(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws IOException, ServletException {
        HashMap<String, String> errori = new HashMap<>();
        OffertaTirocinio offertaTirocinio = new OffertaTirocinio();

        if (request.getParameter("Titolo") != null) {
            String titolo = HtmlEscape.escapeHtml5(request.getParameter("Titolo"));
            Map<String, Object> risultato = Validation.text100(titolo, "Titolo");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreTitolo", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfTitolo", titolo);
                offertaTirocinio.setTitolo(titolo);
            }
        } else errori.put("ErroreTitolo", "Titolo non presente");


        if (request.getParameter("Descrizione_Breve") != null) {
            String descrBreve = HtmlEscape.escapeHtml5(request.getParameter("Descrizione_Breve"));
            Map<String, Object> risultato = Validation.text200(descrBreve, "Descrizione Breve");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreDescrizione_Breve", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfDescrizione_Breve", descrBreve);
                offertaTirocinio.setDescrizioneBreve(descrBreve);
            }
        } else errori.put("ErroreDescrizione_Breve", "Descrizione Breve non Presente");


        if (request.getParameter("Descrizione_Completa") != null) {
            String descr = HtmlEscape.escapeHtml5(request.getParameter("Descrizione_Completa"));
            Map<String, Object> risultato = Validation.text1000(descr, "Descrizione");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreDescrizione_Completa", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfDescrizione_Completa", descr);
                offertaTirocinio.setDescrizione(descr);
            }
        } else errori.put("ErroreDescrizione_Completa", "Descrizione non Presente");


        if (request.getParameter("Orari") != null) {
            String orari = HtmlEscape.escapeHtml5(request.getParameter("Orari"));
            Map<String, Object> risultato = Validation.text100(orari, "Orari");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreOrari", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfOrari", orari);
                offertaTirocinio.setOrari(orari);
            }
        } else errori.put("ErroreOrari", "Orari non presenti");


        if (request.getParameter("Durara_Ora") != null) {
            if (!request.getParameter("Durara_Ora").isEmpty()) {
                Integer durateore = Integer.parseInt(request.getParameter("Durara_Ora"));
                Map<String, Object> risultato = Validation.durateUgualeMaggiore0Minore10000(durateore, "Durata in ore");
                if (!(boolean) risultato.get("valido")) {
                    errori.put("ErroreDurara_Ora", (String) risultato.get("messaggio"));
                } else {
                    datamodel.put("ValueOfDurara_Ora", durateore);
                    offertaTirocinio.setDurataOre(durateore);
                }
            } else {
                errori.put("ErroreDurara_Ora", "Durata in ore non presente");
            }
        } else errori.put("ErroreDurara_Ora", "Durata in ore non presente");


        if (request.getParameter("Durara_Mesi") != null) {
            if (!request.getParameter("Durara_Mesi").isEmpty()) {
                Integer durMesi = Integer.parseInt(request.getParameter("Durara_Mesi"));
                Map<String, Object> risultato = Validation.durateUgualeMaggiore0Minore10000(durMesi, "Durata in mesi");
                if (!(boolean) risultato.get("valido")) {
                    errori.put("ErroreDurara_Mesi", (String) risultato.get("messaggio"));
                } else {
                    datamodel.put("ValueOfDurara_Mesi", durMesi);
                    offertaTirocinio.setDurataMesi(durMesi);
                }
            } else errori.put("ErroreDurara_Mesi", "Durata in mesi non presente");
        } else errori.put("ErroreDurara_Mesi", "Durata in mesi non presente");


        if (request.getParameter("Periodo_inizio") != null) {
            if(!request.getParameter("Periodo_inizio").isEmpty()) {
                Date datainizio = Date.valueOf(request.getParameter("Periodo_inizio"));
                datamodel.put("ValueOfPeriodo_inizio", datainizio);
                offertaTirocinio.setPeriodoInizio(datainizio);
            } else errori.put("ErrorePeriodo_inizio", "Periodo inizio non presente");
        } else errori.put("ErrorePeriodo_inizio", "Periodo inizio non presente");


        if (request.getParameter("Periodo_fine") != null) {
            if(!request.getParameter("Periodo_fine").isEmpty()) {
                Date datefine = Date.valueOf(request.getParameter("Periodo_fine"));
                datamodel.put("ValueOfPeriodo_fine", datefine);
                offertaTirocinio.setPeriodoFine(datefine);
            } else errori.put("ErrorePeriodo_fine", "Periodo fine non presente");
        } else errori.put("ErrorePeriodo_fine", "Periodo fine non presente");


        if (request.getParameter("Modalita") != null) {
            String modalitasvol = HtmlEscape.escapeHtml5(request.getParameter("Modalita"));
            Map<String, Object> risultato = Validation.text500(modalitasvol, "Modalita di svolgimento");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreModalita", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfModalita", modalitasvol);
                offertaTirocinio.setModalita(modalitasvol);
            }
        } else errori.put("ErroreModalita", "Modalita di svolgimento non presente");


        if (request.getParameter("Obiettivi") != null) {
            String obiettivi = HtmlEscape.escapeHtml5(request.getParameter("Obiettivi"));
            Map<String, Object> risultato = Validation.text500(obiettivi, "Obiettivi di svolgimento");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreObiettivi", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfObiettivi", obiettivi);
                offertaTirocinio.setObbiettivi(obiettivi);
            }
        } else errori.put("ErroreObiettivi", "Obiettivi di svolgimento non presenti");


        if (request.getParameter("Rimborsi") != null) {
            String rimborsi = HtmlEscape.escapeHtml5(request.getParameter("Rimborsi"));
            Map<String, Object> risultato = Validation.text200(rimborsi, "Rimborsi");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreRimborsi", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfRimborsi", rimborsi);
                offertaTirocinio.setRimborsi(rimborsi);
            }
        } else errori.put("ErroreRimborsi", "Rimborsi non presenti");


        if (request.getParameter("Facilitazioni") != null) {
            String facilitazioni = HtmlEscape.escapeHtml5(request.getParameter("Facilitazioni"));
            Map<String, Object> risultato = Validation.text200(facilitazioni, "Facilitazioni");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreFacilitazioni", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfFacilitazioni", facilitazioni);
                offertaTirocinio.setFacilitazioni(facilitazioni);
            }
        } else errori.put("ErroreFacilitazioni", "Facilitazioni non presenti");


        if (request.getParameter("SedeTirocinio") != null) {
            String sede = HtmlEscape.escapeHtml5(request.getParameter("SedeTirocinio"));
            Map<String, Object> risultato = Validation.text200(sede, "SedeTirocinio");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreSedeTirocinio", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfSedeTirocinio", sede);
                offertaTirocinio.setLuogoEffettuazione(sede);
            }
        } else errori.put("ErroreSedeTirocinio", "SedeTirocinio non presente");


        if (request.getParameter("CodiceIdentTirocinio") != null) {
            String codice = HtmlEscape.escapeHtml5(request.getParameter("CodiceIdentTirocinio"));
            Map<String, Object> risultato = Validation.text10(codice, "Codice tirocinio");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreCodiceIdentTirocinio", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfCodiceIdentTirocinio", codice);
                offertaTirocinio.setCodIdentTirocinio(codice);
            }
        } else errori.put("ErroreCodiceIdentTirocinio", "Codice tirocinio non presente");


        if (request.getParameter("SettoreInserimento") != null) {
            String settore = HtmlEscape.escapeHtml5(request.getParameter("SettoreInserimento"));
            Map<String, Object> risultato = Validation.text100(settore, "Settore Inserimento");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreSettoreInserimento", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfSettoreInserimento", settore);
                offertaTirocinio.setSettoreInserimento(settore);
            }
        } else errori.put("ErroreSettoreInserimento", "Settore Inserimento non presente");


        if (request.getParameter("TempiAccessoLocaliAziendali") != null) {
            String tempiAccesso = HtmlEscape.escapeHtml5(request.getParameter("TempiAccessoLocaliAziendali"));
            Map<String, Object> risultato = Validation.text100(tempiAccesso, "Tempi di accesso ai locali");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreTempiAccessoLocaliAziendali", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfTempiAccessoLocaliAziendali", tempiAccesso);
                offertaTirocinio.setTempoAccessoLocaliAziendali(tempiAccesso);
            }
        } else errori.put("ErroreTempiAccessoLocaliAziendali", "Tempi di accesso ai locali non presente");


        if (request.getParameter("NomeTutoreAziendale") != null) {
            String nomeTuAz = HtmlEscape.escapeHtml5(request.getParameter("NomeTutoreAziendale"));
            Map<String, Object> risultato = Validation.text100(nomeTuAz, "Nome Tutore aziendale");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreNomeTutoreAziendale", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfNomeTutoreAziendale", nomeTuAz);
                offertaTirocinio.setNomeTutoreAziendale(nomeTuAz);
            }
        } else errori.put("ErroreNomeTutoreAziendale", "Nome Tutore aziendale non presente");


        if (request.getParameter("CognomeTutoreAziendale") != null) {
            String cognomeTuAz = HtmlEscape.escapeHtml5(request.getParameter("CognomeTutoreAziendale"));
            Map<String, Object> risultato = Validation.text100(cognomeTuAz, "Cognome Tutore aziendale");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreCognomeTutoreAziendale", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfCognomeTutoreAziendale", cognomeTuAz);
                offertaTirocinio.setCognomeTutoreAziendale(cognomeTuAz);
            }
        } else errori.put("ErroreCognomeTutoreAziendale", "Cognome Tutore aziendale non presente");


        if (request.getParameter("TelefonoTutoreAziendale") != null) {
            String telTutAz = HtmlEscape.escapeHtml5(request.getParameter("TelefonoTutoreAziendale"));
            Map<String, Object> risultato = Validation.text30(telTutAz, "Telefono Tutore aziendale");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreTelefonoTutoreAziendale", (String) risultato.get("messaggio"));
            } else {
                datamodel.put("ValueOfTelefono", telTutAz);
                offertaTirocinio.setTelefonoTutoreAziendale(telTutAz);
            }
        } else errori.put("ErroreTelefonoTutoreAziendale", "Telefono Tutore aziendale non presente");


        if (request.getParameter("EmailTutoreAziendale") != null) {
            String emailTutAz = HtmlEscape.escapeHtml5(request.getParameter("EmailTutoreAziendale"));
            Map<String, Object> risultato = Validation.text50(emailTutAz, "Email Tutore aziendale");
            if (!(boolean) risultato.get("valido")) {
                errori.put("ErroreEmailTutoreAziendale", (String) risultato.get("messaggio"));
            } else if (!Validation.isValidEmailAddress(emailTutAz)) {
                errori.put("ErroreEmailTutoreAziendale", "Non è un email valida");
            } else {
                datamodel.put("ValueOfEmailTutoreAziendale", emailTutAz);
                offertaTirocinio.setEmailTutoreAziendale(emailTutAz);
            }
        } else errori.put("ErroreEmailTutoreAziendale", "Email Tutore aziendale non presente");

        if (!errori.isEmpty()) {
            // riporta pagina creazione con errori
            datamodel.putAll(errori);
            TemplateController.process("creazione-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
        } else {
            // salva i dati
            Azienda azienda = session.getAzienda(request, response);
            offertaTirocinio.setAzienda(azienda.getIDAzienda());
            offertaTirocinio.setAziendaOspitante(azienda.getRagioneSociale());
            offertaTirocinio.setStato(1);
            processaPost(request, response, offertaTirocinio, azienda);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)) {
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            if (request.getParameterMap().containsKey("Titolo") && request.getParameterMap().containsKey("Descrizione_Breve") && request.getParameterMap().containsKey("Descrizione_Completa") && request.getParameterMap().containsKey("Orari") && request.getParameterMap().containsKey("Durara_Ora") && request.getParameterMap().containsKey("Durara_Mesi") && request.getParameterMap().containsKey("Periodo_inizio") && request.getParameterMap().containsKey("Periodo_fine") && request.getParameterMap().containsKey("Modalita") && request.getParameterMap().containsKey("Obiettivi") && request.getParameterMap().containsKey("Rimborsi") && request.getParameterMap().containsKey("Facilitazioni") && request.getParameterMap().containsKey("SedeTirocinio") && request.getParameterMap().containsKey("CodiceIdentTirocinio") && request.getParameterMap().containsKey("SettoreInserimento") && request.getParameterMap().containsKey("TempiAccessoLocaliAziendali") && request.getParameterMap().containsKey("NomeTutoreAziendale") && request.getParameterMap().containsKey("CognomeTutoreAziendale") && request.getParameterMap().containsKey("TelefonoTutoreAziendale") && request.getParameterMap().containsKey("EmailTutoreAziendale")) {
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String paramName = params.nextElement();
                }
                erroriPost(request, response, session);
            } else {
                er500(request, response);
            }
        } else {
            er403(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)) {
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            processaGet(request, response, session);
        } else {
            er500(request, response);
        }
    }
}
