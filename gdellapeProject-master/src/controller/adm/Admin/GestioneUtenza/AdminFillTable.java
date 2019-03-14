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



    private void filltableTirocinante() throws IOException {
        List<Tirocinante> tirocinate = new ArrayList<>();
        try {
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            tirocinate = dao.getAllTirociante();
            dao.destroy();

        } catch (DaoException e) {
            response.sendRedirect("/404");
            e.printStackTrace();
        }
        datamodel.put("tirocinanti", tirocinate);

    }

    private void fillAziendaTable() throws IOException {
        List<Azienda> aziende = new ArrayList<>();
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            aziende = dao.getAllAzienda();
            dao.destroy();

        } catch (DaoException e) {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        datamodel.put("aziende", aziende);
    }


    private void fillTutUniTable() throws IOException {
        List<TutoreUniversitario> tutori = new ArrayList<>();
        try {

            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            tutori = dao.getAllTutUni();
            dao.destroy();


        } catch (DaoException e) {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        datamodel.put("tutori", tutori);
    }

    private void fillTableAdmin() throws IOException {
        List<Admin> gliadmin = new ArrayList<>();
        try {

            AdminDaoImp dao = new AdminDaoImp();
            gliadmin = dao.getAllAdmin();
            dao.destroy();


        } catch (DaoException e) {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        datamodel.put("listadmin", gliadmin);
    }

    public void makeget() throws IOException, ServletException {
        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();
        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);


    }


}
