package controller.adm.Admin.GestioneAzienda;

import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FillGestioniModuliConvenzione {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;
    private Map<String,Object> datamodel;



    //faccio il private per non farlo eseguire
    private FillGestioniModuliConvenzione() {

    }

    public FillGestioniModuliConvenzione(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, Map<String,Object> datamodel) {
        this.request=request;
        this.response=response;
        this.servletContext=servletContext;
        this.datamodel=datamodel;


    }






    public void makegetWithSuccess(String warning) throws IOException, ServletException,DaoException{
        //make big map to add in data model
        Map<String, Object> data = new HashMap<>();





            // add the date to fill table Gestione convenzioni attive
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziendas = dao.getAllAziendaAttive();
            dao.destroy();
            data.put("Aziende", aziendas);
            System.out.println(data.get("Aziende"));


//            Warning per il successo di una operazione
            data.put("WarningSuccess",warning);
            datamodel.putAll(data);
            TemplateController.process("BackEndTemplates/gestione-moduli-convenzione.ftl", datamodel, response, servletContext);

    }

    public void makegetWithInsuccess(String warning) throws IOException, ServletException,DaoException {
        //make big map to add in data model
        Map<String, Object> data = new HashMap<>();



            // add the date to fill table Gestione convenzioni attive
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziendas = dao.getAllAziendaAttive();
            dao.destroy();
            data.put("Aziende", aziendas);
            System.out.println(data.get("Aziende"));




            data.put("WarningInsuccess", warning);
            datamodel.putAll(data);
            TemplateController.process("BackEndTemplates/gestione-moduli-convenzione.ftl", datamodel, response, servletContext);

    }

        public void makeget() throws IOException, ServletException,DaoException{
            //make big map to add in data model
            Map<String, Object> data = new HashMap<>();


            // add the date to fill table Gestione convenzioni attive
                AziendaDaoImp dao = new AziendaDaoImp();
                List<Azienda> aziendas = dao.getAllAziendaAttive();
                dao.destroy();
                data.put("Aziende", aziendas);
                System.out.println(data.get("Aziende"));

                datamodel.putAll(data);
                TemplateController.process("BackEndTemplates/gestione-moduli-convenzione.ftl", datamodel, response, servletContext);


    }





}









