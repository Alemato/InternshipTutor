package controller.adm.Admin.GestioneUtenza;

import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AdminFillAziendeConTable {

    private Map<String, Object> datamodel;
    private ServletContext servletContext;
    private HttpServletRequest request;
    private HttpServletResponse response;


    public AdminFillAziendeConTable(Map<String, Object> datamodel, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }
    private AdminFillAziendeConTable()
    {}

    private List<Azienda> getAziendePendenti() throws DaoException
    {
        AziendaDaoImp dao = new AziendaDaoImp();
        List<Azienda> aziende= dao.getAllAziendaPendenti();
        dao.destroy();
        return aziende;
    }

    private List<Azienda> getAziendeAttiva() throws DaoException
    {
        AziendaDaoImp dao = new AziendaDaoImp();
        List<Azienda> aziende= dao.getAllAziendaAttive();
        dao.destroy();
        return aziende;
    }

    public void makeget() throws IOException, ServletException {

        try {

            datamodel.put("AziendaAttiva", getAziendeAttiva());
            datamodel.put("AziendaPendenti", getAziendePendenti());

            TemplateController.process("BackEndTemplates/richieste-convenzioni-admin.ftl", datamodel, response, servletContext);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }


    }

    public void makegetSucces(String message) throws IOException, ServletException {

        try {
            datamodel.put("WarningSucess",message);
            datamodel.put("AziendaAttiva", getAziendeAttiva());
            datamodel.put("AziendaPendenti", getAziendePendenti());

            TemplateController.process("BackEndTemplates/richieste-convenzioni-admin.ftl", datamodel, response, servletContext);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }


    }
    public void makegetInsuccess(String message) throws IOException, ServletException {

        try {
            datamodel.put("WarningInsuccess",message);
            datamodel.put("AziendaAttiva", getAziendeAttiva());
            datamodel.put("AziendaPendenti", getAziendePendenti());

            TemplateController.process("BackEndTemplates/richieste-convenzioni-admin.ftl", datamodel, response, servletContext);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }


    }






}
