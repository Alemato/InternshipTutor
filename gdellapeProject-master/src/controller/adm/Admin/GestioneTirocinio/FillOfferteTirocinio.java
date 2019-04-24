package controller.adm.Admin.GestioneTirocinio;

import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FillOfferteTirocinio {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;
    private Map<String, Object> datamodel;


    //faccio il private per non farlo eseguire
    private FillOfferteTirocinio() {

    }

    public FillOfferteTirocinio(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, Map<String, Object> datamodel) {
        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
        this.datamodel = datamodel;


    }


    private List<OffertaTirocinio> getOfferteTirocinio() throws DaoException {

        OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
        List<OffertaTirocinio> offerte = dao.getAllOffertatr();
        dao.destroy();

        return offerte;
    }

    private List<OffertaTirocinio> getOfferteScadute(List<OffertaTirocinio> allOfferte) {
        List<OffertaTirocinio> scadute = new ArrayList<>();
        for (OffertaTirocinio of : allOfferte
        ) {
            if (of.getStato() == 0) {
                scadute.add(of);
            }

        }
        return scadute;
    }

    private List<OffertaTirocinio> getOfferteAttive(List<OffertaTirocinio> allOfferte) {
        List<OffertaTirocinio> attive = new ArrayList<>();
        for (OffertaTirocinio of : allOfferte
        ) {
            if (of.getStato() == 1) {
                attive.add(of);
            }

        }
        return attive;
    }

    public void makegetWithSuccess(String warning) throws IOException, ServletException, DaoException {
        List<OffertaTirocinio> offerte = getOfferteTirocinio();
        List<OffertaTirocinio> attive = getOfferteAttive(offerte);
        List<OffertaTirocinio> scadute = getOfferteScadute(offerte);

        datamodel.put("OfferteAttive", attive);
        datamodel.put("OfferteScadute", scadute);
        datamodel.put("WarningSuccess", warning);
        TemplateController.process("BackEndTemplates/tutteOfferteTr.ftl", datamodel, response, servletContext);

    }

    public void makegetWithInsuccess(String warning) throws IOException, ServletException, DaoException {
        List<OffertaTirocinio> offerte = getOfferteTirocinio();
        List<OffertaTirocinio> attive = getOfferteAttive(offerte);
        List<OffertaTirocinio> scadute = getOfferteScadute(offerte);

        datamodel.put("OfferteAttive", attive);
        datamodel.put("OfferteScadute", scadute);
        datamodel.put("WarningInsucess", warning);
        TemplateController.process("BackEndTemplates/tutteOfferteTr.ftl", datamodel, response, servletContext);


    }

    public void makeget() throws IOException, ServletException, DaoException {


        List<OffertaTirocinio> offerte = getOfferteTirocinio();
        List<OffertaTirocinio> attive = getOfferteAttive(offerte);
        List<OffertaTirocinio> scadute = getOfferteScadute(offerte);

        datamodel.put("OfferteAttive", attive);
        datamodel.put("OfferteScadute", scadute);
        TemplateController.process("BackEndTemplates/tutteOfferteTr.ftl", datamodel, response, servletContext);


    }


}









