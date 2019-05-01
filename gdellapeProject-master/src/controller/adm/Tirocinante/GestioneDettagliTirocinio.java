package controller.adm.Tirocinante;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GestioneDettagliTirocinio extends baseController {

    private OffertaTirocinio ritornaOffertaTirocinio(Integer idTirocinio) throws DaoException {
        TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
        Tirocinio tirocinio = daoTirocinio.getRichiestatrByID(idTirocinio);
        OffertaTirocinioDaoImp daoOffertaTirocinio = new OffertaTirocinioDaoImp();
        OffertaTirocinio offertaTirocinio = daoOffertaTirocinio.getOffertatrByID(tirocinio.getOffertaTirocinio());
        daoOffertaTirocinio.destroy();
        daoTirocinio.destroy();
        return offertaTirocinio;
    }

    private Tirocinio ritornaTirocinio(Integer idTirocinio) throws DaoException {
        TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
        Tirocinio tirocinio = daoTirocinio.getRichiestatrByID(idTirocinio);
        daoTirocinio.destroy();
        return tirocinio;
    }

    private Azienda ritornaAzienda(OffertaTirocinio offertaTirocinio) throws DaoException {
        AziendaDaoImp daoAzienda = new AziendaDaoImp();
        Azienda azienda = daoAzienda.getAziendaByID(offertaTirocinio.getAzienda());
        daoAzienda.destroy();
        return azienda;
    }

    private void fillDatamodel(HttpServletRequest request) {
        try {
            Integer idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
            datamodel.put("offertaTirocinio", ritornaOffertaTirocinio(idTirocinio));
            datamodel.put("azienda", ritornaAzienda(ritornaOffertaTirocinio(idTirocinio)));
            datamodel.put("tirocinio", ritornaTirocinio(idTirocinio));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


    private float votazione(HttpServletRequest request) throws DaoException {

            int valutazioneTutoraggio = Integer.parseInt(request.getParameter("valutazioneTutoraggio"));
            Integer idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
            Azienda azienda = ritornaAzienda(ritornaOffertaTirocinio(idTirocinio));
            float totaleVoti = azienda.getValutazione() * azienda.getVoti();
            totaleVoti = totaleVoti + valutazioneTutoraggio;
            totaleVoti = totaleVoti / ((azienda.getVoti() + 1));
            return (float) (Math.round(totaleVoti * Math.pow(10, 2)) / Math.pow(10, 2));
    }

    private void caricaVotazioneSuAzienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
            Azienda azienda = ritornaAzienda(ritornaOffertaTirocinio(idTirocinio));
            azienda.setValutazione(votazione(request));
            int voti = azienda.getVoti();
            azienda.setVoti(voti + 1);
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            daoAzienda.updateAzienda(azienda);
            daoAzienda.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request, response);
        }
    }

    private void caricaVotazioneSuTirocinio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
            Tirocinio tirocinio;
            tirocinio = ritornaTirocinio(idTirocinio);
            tirocinio.setStato(4);
            TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
            System.out.println("Tirocinio votato");
            System.out.println(tirocinio);
            daoTirocinio.updateTirocinio(tirocinio);
            daoTirocinio.destroy();

        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        fillDatamodel(request);
        TemplateController.process("tirocinio-tirocinante.ftl", datamodel, response, getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        fillDatamodel(request);
        caricaVotazioneSuTirocinio(request, response);
        caricaVotazioneSuAzienda(request, response);
        response.sendRedirect("/account/moduli");
    }

}
