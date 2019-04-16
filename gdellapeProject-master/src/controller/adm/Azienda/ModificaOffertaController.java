package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ModificaOffertaController extends baseController {

    private void er404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void processaPost(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws ServletException, IOException {
        boolean errore = false;
        int idOfferta = 0;
        HashMap<String, String> errori = new HashMap<>();
        OffertaTirocinio offertaTirocinio = new OffertaTirocinio();

        if (request.getParameter("IDOfferta") != null) {
            idOfferta = Integer.parseInt(request.getParameter("IDOfferta"));
        } else {
            errore = true;
            er500(request, response);
        }


        if(!errore && idOfferta > 0) {
            OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
            try {
                offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(idOfferta);
                offertaTirocinioDaoImp.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
                er500(request, response);
                errore = true;
            }

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


            if (request.getParameter("Periodo_fine") != null) {
                if (!request.getParameter("Periodo_fine").isEmpty()) {
                    Date datefine = Date.valueOf(request.getParameter("Periodo_fine"));
                    datamodel.put("ValueOfPeriodo_fine", datefine);
                    offertaTirocinio.setPeriodoFine(datefine);
                } else errori.put("ErrorePeriodo_fine", "Periodo fine non presente");
            } else errori.put("ErrorePeriodo_fine", "Periodo fine non presente");


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

            if (!errore) {
                if (!errori.isEmpty()) {
                    // riporta pagina creazione con errori
                    datamodel.putAll(errori);
                    datamodel.put("ValueOfDescrizione_Breve", offertaTirocinio.getDescrizioneBreve());
                    datamodel.put("ValueOfDescrizione_Completa", offertaTirocinio.getDescrizione());
                    datamodel.put("ValueOfDurara_Ora", offertaTirocinio.getDurataOre());
                    datamodel.put("ValueOfPeriodo_inizio", offertaTirocinio.getPeriodoInizio());
                    datamodel.put("ValueOfModalita", offertaTirocinio.getModalita());
                    datamodel.put("ValueOfObiettivi", offertaTirocinio.getObbiettivi());
                    datamodel.put("ValueOfRimborsi", offertaTirocinio.getRimborsi());
                    datamodel.put("ValueOfFacilitazioni", offertaTirocinio.getFacilitazioni());
                    datamodel.put("ValueOfSedeTirocinio", offertaTirocinio.getLuogoEffettuazione());
                    datamodel.put("ValueOfCodiceIdentTirocinio", offertaTirocinio.getCodIdentTirocinio());
                    datamodel.put("ValueOfSettoreInserimento", offertaTirocinio.getSettoreInserimento());
                    datamodel.put("ValueOfNomeTutoreAziendale", offertaTirocinio.getNomeTutoreAziendale());
                    datamodel.put("ValueOfCognomeTutoreAziendale", offertaTirocinio.getCognomeTutoreAziendale());
                    datamodel.put("ValueOfTelefono", offertaTirocinio.getTelefonoTutoreAziendale());
                    datamodel.put("ValueOfEmailTutoreAziendale", offertaTirocinio.getEmailTutoreAziendale());
                    TemplateController.process("modifica-offerta-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
                } else {
                    // salva i dati
                    OffertaTirocinioDaoImp offertaTirocinioDaoImpUPLOAD = new OffertaTirocinioDaoImp();
                    try {
                        offertaTirocinioDaoImpUPLOAD.updateOffertatr(offertaTirocinio);
                        offertaTirocinioDaoImpUPLOAD.destroy();
                        response.sendRedirect("/account/gestione-offerte");
                    } catch (DaoException e) {
                        e.printStackTrace();
                        er500(request, response);
                    }
                }
            }
        }
    }

    private void processaGet(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws ServletException, IOException {
        boolean errore = false;
        if (request.getParameter("id") != null) {
            if (!request.getParameter("id").isEmpty()) {
                datamodel.put("idofferta", request.getParameter("id"));
                OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
                OffertaTirocinio offertaTirocinio = new OffertaTirocinio();
                try {
                    offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(Integer.parseInt(request.getParameter("id")));
                    offertaTirocinioDaoImp.destroy();
                    if (offertaTirocinio.getAzienda().equals(session.getAzienda(request, response).getIDAzienda())) {
                        datamodel.put("ValueOfTitolo", offertaTirocinio.getTitolo());
                        datamodel.put("ValueOfDescrizione_Breve", offertaTirocinio.getDescrizioneBreve());
                        datamodel.put("ValueOfDescrizione_Completa", offertaTirocinio.getDescrizione());
                        datamodel.put("ValueOfOrari", offertaTirocinio.getOrari());
                        datamodel.put("ValueOfDurara_Ora", offertaTirocinio.getDurataOre());
                        datamodel.put("ValueOfDurara_Mesi", offertaTirocinio.getDurataMesi());
                        datamodel.put("ValueOfPeriodo_inizio", offertaTirocinio.getPeriodoInizio());
                        datamodel.put("ValueOfPeriodo_fine", offertaTirocinio.getPeriodoFine());
                        datamodel.put("ValueOfModalita", offertaTirocinio.getModalita());
                        datamodel.put("ValueOfObiettivi", offertaTirocinio.getObbiettivi());
                        datamodel.put("ValueOfRimborsi", offertaTirocinio.getRimborsi());
                        datamodel.put("ValueOfFacilitazioni", offertaTirocinio.getFacilitazioni());
                        datamodel.put("ValueOfSedeTirocinio", offertaTirocinio.getLuogoEffettuazione());
                        datamodel.put("ValueOfCodiceIdentTirocinio", offertaTirocinio.getCodIdentTirocinio());
                        datamodel.put("ValueOfSettoreInserimento", offertaTirocinio.getSettoreInserimento());
                        datamodel.put("ValueOfTempiAccessoLocaliAziendali", offertaTirocinio.getTempoAccessoLocaliAziendali());
                        datamodel.put("ValueOfNomeTutoreAziendale", offertaTirocinio.getNomeTutoreAziendale());
                        datamodel.put("ValueOfCognomeTutoreAziendale", offertaTirocinio.getCognomeTutoreAziendale());
                        datamodel.put("ValueOfTelefono", offertaTirocinio.getTelefonoTutoreAziendale());
                        datamodel.put("ValueOfEmailTutoreAziendale", offertaTirocinio.getEmailTutoreAziendale());
                    } else {
                        er403(request, response);
                        errore = true;
                    }
                } catch (DaoException e) {
                    e.printStackTrace();
                    er500(request, response);
                    errore = true;
                }
                if (!errore) {
                    TemplateController.process("modifica-offerta-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
                }
            } else {
                er500(request, response);
            }
        } else {
            er500(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)) {
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            if (request.getParameterMap().containsKey("IDOfferta") && request.getParameterMap().containsKey("Titolo") && request.getParameterMap().containsKey("Orari") && request.getParameterMap().containsKey("Durara_Mesi") && request.getParameterMap().containsKey("Periodo_fine") && request.getParameterMap().containsKey("TempiAccessoLocaliAziendali")) {
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String paramName = params.nextElement();
                    System.out.println("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
                }
                System.out.println("esegui post e salva i dati");
                processaPost(request, response, session);
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
            if (request.getParameterMap().containsKey("id")) {
                processaGet(request, response, session);
            } else {
                er404(request, response);
            }
        } else {
            er403(request, response);
        }
    }
}
