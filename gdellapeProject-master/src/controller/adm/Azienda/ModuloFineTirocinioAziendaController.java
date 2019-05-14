package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class ModuloFineTirocinioAziendaController extends baseController {
    private void err403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void err404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    private void err500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private  void  processaRichiestaPost(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws IOException, ServletException {
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        try {
            Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(request.getParameter("ID_Tirocinio")));
            tirocinioDaoImp.destroy();
            TirocinioDaoImp tirocinioDaoImp1 = new TirocinioDaoImp();
            tirocinio.setPeriodoEffettivoIniziale(Date.valueOf(request.getParameter("Data_inizio")));
            tirocinio.setPeriodoEffettivoFinale(Date.valueOf(request.getParameter("Data_fine")));
            tirocinio.setDurataOre(Integer.parseInt(request.getParameter("Ore_totali")));
            tirocinio.setDescrizioneAttivitaSvolta(request.getParameter("Descrizione_attivita_svolta"));
            tirocinio.setRisultatoConseguito(request.getParameter("risultato_tirocinio"));
            tirocinio.setDataConsegnaModuloAzienda(Date.valueOf(request.getParameter("Data_documento")));
            tirocinioDaoImp1.updateTirocinio(tirocinio);
            tirocinioDaoImp1.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/account/moduli");
    }

    private void processaRichiesta(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws IOException, ServletException {
        Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
        datamodel.put("data", presente.getTime());
        Azienda azienda = session.getAzienda(request, response);
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        try {
            Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(request.getParameter("id")));
            tirocinioDaoImp.destroy();
            OffertaTirocinio offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(tirocinio.getOffertaTirocinio());
            offertaTirocinioDaoImp.destroy();
            Tirocinante tirocinante = tirocinanteDaoImp.getTirocianteByID(tirocinio.getTirocinante());
            tirocinanteDaoImp.destroy();
            datamodel.put("azienda", azienda);
            datamodel.put("tirocinio", tirocinio);
            datamodel.put("offertaTirocinio", offertaTirocinio);
            datamodel.put("tirocinante", tirocinante);
            datamodel.put("notview", true);
            TemplateController.process("modulo-tirocinio-aziendale.ftl", datamodel, response, getServletContext());
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("MessaggioErrore", "problemi con oggetti: Tirocinio, OffertaTirocinio, Tirocinante");
            err500(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameter("ID_Tirocinio") != null && request.getParameter("Data_inizio") != null && request.getParameter("Data_fine") != null && request.getParameter("Ore_totali") != null && request.getParameter("Descrizione_attivita_svolta") != null && request.getParameter("risultato_tirocinio") != null && request.getParameter("Data_documento") != null) {
            SingSessionContoller session = SingSessionContoller.getInstance();
            if (session.isAzienda(request)) {
                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                try {
                    Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(request.getParameter("ID_Tirocinio")));
                    tirocinioDaoImp.destroy();
                    if (tirocinio.getPdfAzienda() == null) {
                        processaRichiestaPost(request, response, session);
                    } else {
                        request.setAttribute("MessaggioErrore", "problemi ha il pdf non puo modificare il documento");
                        err500(request, response);
                    }
                } catch (DaoException e) {
                    e.printStackTrace();
                    request.setAttribute("MessaggioErrore", "problemi con oggetto: Tirocinio");
                    err500(request, response);
                }
            }else {
                err403(request, response);
            }
        } else {
            request.setAttribute("MessaggioErrore", "richiesta non valida mancano dati");
            err500(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameter("id") != null) {
            SingSessionContoller session = SingSessionContoller.getInstance();
            if (session.isAzienda(request)) {
                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                try {
                    Tirocinio tirocinio = tirocinioDaoImp.getRichiestatrByID(Integer.parseInt(request.getParameter("id")));
                    tirocinioDaoImp.destroy();
                    if (tirocinio.getPdfAzienda() == null) {
                        processaRichiesta(request, response, session);
                    } else {
                        response.sendRedirect("/account/moduli/tirocinio?id="+tirocinio.getIDTirocinio());
                    }
                } catch (DaoException e) {
                    e.printStackTrace();
                    request.setAttribute("MessaggioErrore", "problemi con oggetto: Tirocinio");
                    err500(request, response);
                }
            }
        } else {
            err404(request, response);
        }
    }
}
