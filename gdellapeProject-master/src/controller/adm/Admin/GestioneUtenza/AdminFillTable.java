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
 *
 */
public class AdminFillTable {

    private Map<String,Object> datamodel;
    private ServletContext servletContext;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public AdminFillTable(Map<String, Object> datamodel, ServletContext sr, HttpServletRequest request, HttpServletResponse response)
    {
        this.datamodel=datamodel;
        this.servletContext=sr;
        this.request=request;
        this.response=response;
    }

    private AdminFillTable(){}


    private void filltableTirocinante()throws IOException
    {
        List<Tirocinante> tirocinate;
        try{
            TirocinanteDaoImp dao= new TirocinanteDaoImp();
            tirocinate = dao.getAllTirociante();
            dao.destroy();
            datamodel.put("tirocinanti",tirocinate);
        }catch (DaoException e)
        {
            response.sendRedirect("/404");
            e.printStackTrace();
        }

    }
    private void fillAziendaTable () throws IOException
    {
        try {
            List<Azienda> aziende = new ArrayList<>();
            AziendaDaoImp dao = new AziendaDaoImp();
            aziende= dao.getAllAzienda();
            dao.destroy();
            datamodel.put("aziende",aziende);
        }catch (DaoException e)
        { e.printStackTrace();
            response.sendRedirect("/404");}
    }

    private void fillTutUniTable()throws IOException
    {
        try{
            List<TutoreUniversitario> tutori = new ArrayList<>();
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            tutori= dao.getAllTutUni();
            dao.destroy();
            datamodel.put("tutori",tutori);

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    private void fillTableAdmin()throws IOException
    {
        try{
            List<Admin> gliadmin = new ArrayList<>();
            AdminDaoImp dao = new AdminDaoImp();
            gliadmin=dao.getAllAdmin();
            dao.destroy();
            datamodel.put("listadmin",gliadmin);

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }

    public void makeget() throws IOException,ServletException
    {
        filltableTirocinante();
        fillAziendaTable();
        fillTableAdmin();
        fillTutUniTable();
        TemplateController.process("BackEndTemplates/gestione-utenti.ftl", datamodel, response, servletContext);


    }


}
