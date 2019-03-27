package controller.adm.Admin.GestioneUtenza;

import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.TutoreUniversitario;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MasterSlave
 */
public class AdminFillTable {

    private Map<String, Object> datamodel;
    private ServletContext servletContext;
    private HttpServletRequest request;
    private HttpServletResponse response;


    AdminFillTable(Map<String, Object> datamodel, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

    void makeGet() throws IOException, ServletException,DaoException
    {

        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();

        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);



    }

    void makeSuccessGet(String message) throws IOException,ServletException,DaoException
    {

        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);

    }

    void makeInsuccessGet(String message) throws IOException,ServletException,DaoException
    {

            filltableTirocinante();
            fillAziendaTable();
            fillTableAdmin();
            fillTutUniTable();
            datamodel.put("WarningInsuccess", message);

            TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);

    }



    private void filltableTirocinante() throws IOException,DaoException {
        List<Tirocinante> tirocinate = new ArrayList<>();
        TirocinanteDaoImp dao = new TirocinanteDaoImp();
        tirocinate = dao.getAllTirociante();
        dao.destroy();
        datamodel.put("tirocinanti", tirocinate);

    }

    private void fillAziendaTable() throws IOException,DaoException {
        List<Azienda> aziende = new ArrayList<>();
        AziendaDaoImp dao = new AziendaDaoImp();
        aziende = dao.getAllAzienda();
        dao.destroy();
        datamodel.put("aziende", aziende);
    }


    private void fillTutUniTable() throws IOException,DaoException {
        List<TutoreUniversitario> tutori = new ArrayList<>();
        TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
        tutori = dao.getAllTutUni();
        dao.destroy();
        datamodel.put("tutori", tutori);
    }

    private void fillTableAdmin() throws IOException,DaoException{
        List<Admin> gliadmin = new ArrayList<>();

        AdminDaoImp dao = new AdminDaoImp();
        gliadmin = dao.getAllAdmin();
        dao.destroy();
        datamodel.put("listadmin", gliadmin);
    }





}
