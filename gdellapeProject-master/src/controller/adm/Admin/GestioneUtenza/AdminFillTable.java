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


   public AdminFillTable(Map<String, Object> datamodel, ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }


    public void makeGet() throws IOException, ServletException,DaoException
    {

        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();

        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);



    }

    public void makeSuccessGet(String message) throws IOException,ServletException,DaoException
    {

        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);

    }

   public void makeInsuccessGet(String message) throws IOException,ServletException,DaoException
    {

            filltableTirocinante();
            fillAziendaTable();
            fillTableAdmin();
            fillTutUniTable();
            datamodel.put("WarningInsuccess", message);

            TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);

    }

    //fine parte di caricamento dei dati per la pagina grande

    //inizio parte di caricamento pagina gestione utente tirocinante

    /**
     * Funzione che carica nella pagina tutti i tirocinanti presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeGetTirocinanti() throws IOException, ServletException,DaoException
    {

        filltableTirocinante();
        TemplateController.process("BackEndTemplates/gestione-tirocinanti.ftl", datamodel, response, servletContext);



    }

    /**
     * Funzione che carica nella pagina tutti i tirocinanti presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel
     *               file ftl nel box di avviso per il successo di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */


    public void makeSuccessGetTirocinanti(String message) throws IOException,ServletException,DaoException
    {

        filltableTirocinante();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-tirocinanti.ftl", datamodel, response, servletContext);

    }
    /**
     * Funzione che carica nella pagina tutti i tirocinanti presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel
     *               file ftl nel box di avviso per il FALLIMENTO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeInsuccessGetTirocinanti(String message) throws IOException,ServletException,DaoException
    {

        filltableTirocinante();
        datamodel.put("WarningInsuccess", message);

        TemplateController.process("BackEndTemplates/gestione-tirocinanti.ftl", datamodel, response, servletContext);

    }
    //fine parte di caricamento pagina gestione utente tirocinante

    /**
     * Funzione che carica nella pagina tutte le Aziende presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     *
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */


    public void makeGetAziende() throws IOException, ServletException,DaoException
    {

        fillAziendaTable();
        TemplateController.process("BackEndTemplates/gestione-aziende.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutte le Aziende presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il SUCCESSO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeSuccessGetAziende(String message) throws IOException,ServletException,DaoException
    {

        fillAziendaTable();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-aziende.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutte le Aziende presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il FALLIMENTO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeInsuccessGetAziende(String message) throws IOException,ServletException,DaoException
    {

        fillAziendaTable();
        datamodel.put("WarningInsuccess", message);

        TemplateController.process("BackEndTemplates/gestione-aziende.ftl", datamodel, response, servletContext);

    }



    /**
     * Funzione che carica nella pagina tutte le tutori presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     *
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */


    public void makeGetTutori() throws IOException, ServletException,DaoException
    {

        fillTutUniTable();
        TemplateController.process("BackEndTemplates/gestione-tutori.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutte le tutori presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il SUCCESSO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeSuccessGetTutori(String message) throws IOException,ServletException,DaoException
    {
        fillTutUniTable();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-tutori.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutti i tutori presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il FALLIMENTO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeInsuccessGetTutori(String message) throws IOException,ServletException,DaoException
    {

        fillTutUniTable();
        datamodel.put("WarningInsuccess", message);

        TemplateController.process("BackEndTemplates/gestione-tutori.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutti i tutori presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     *
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */


    public void makeGetAdmin() throws IOException, ServletException,DaoException
    {

        fillTableAdmin();
        TemplateController.process("BackEndTemplates/gestione-admin.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutti gli admin presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il SUCCESSO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeSuccessGetAdmin(String message) throws IOException,ServletException,DaoException
    {

        fillTableAdmin();
        datamodel.put("WarningSuccess",message);

        TemplateController.process("BackEndTemplates/gestione-admin.ftl", datamodel, response, servletContext);

    }

    /**
     * Funzione che carica nella pagina tutti gli admin presenti nell sistema sul template ftl ed restituische
     * il file ftl
     *
     * @param message => messaggio che verra visualizzato nel file ftl nel box di avviso per il FALLIMENTO di una manipolazione del sistema
     * @throws IOException
     * @throws ServletException
     * @throws DaoException
     */

    public void makeInsuccessGetAdmin(String message) throws IOException,ServletException,DaoException
    {

        fillTableAdmin();
        datamodel.put("WarningInsuccess", message);

        TemplateController.process("BackEndTemplates/gestione-admin.ftl", datamodel, response, servletContext);

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
