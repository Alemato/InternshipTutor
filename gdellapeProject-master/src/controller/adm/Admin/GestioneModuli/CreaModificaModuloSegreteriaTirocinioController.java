package controller.adm.Admin.GestioneModuli;


import controller.baseController;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinante;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreaModificaModuloSegreteriaTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        updateTirocinio(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        fillModulo(request,response);


    }
    private Boolean ifmakeModulo(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException,DaoException
    {

            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();
            return(tr.getStato()==2);
    }


    private void updateTirocinio(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try{
            if(ifmakeModulo(request,response)) {
                if (validate(request, response)) {
                    storeModulo(request, response);
                }
            }
        }catch (DaoException e)
        {
        e.printStackTrace();
        response.sendRedirect("/404");
        }


    }



    private void fillModulo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        try {
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();

            TirocinanteDaoImp dao1 = new TirocinanteDaoImp();
            Tirocinante tirocinante = dao1.getTirocianteByID(tr.getTirocinante());
            dao1.destroy();

            if (ifmakeModulo(request,response)) {
                if (!(tr.getPdfSegreteria()==null)) {
                    datamodel.put("tirocinio", tr);
                }

                datamodel.put("tirocinante", tirocinante);
                datamodel.put("ID", tr.getIDTirocinio());

                TemplateController.process("BackEndTemplates/admin-create-modulo-tirocinio-segreteria.ftl", datamodel, response, getServletContext());
            }
            else
                {
                    RequestDispatcher pageError = request.getRequestDispatcher("/404");
                    pageError.forward(request,response);

                }
        }catch(DaoException e){
            e.printStackTrace();
            response.sendRedirect("/404");
        }


    }


    private Boolean validate(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        Map<String,String> errori = new HashMap<>();

        if(request.getParameter("Data_colloquio").isEmpty())
        {
            errori.put("ErroreDataColloquio","Data colloqui non presente");
        }


        if(request.getParameter("Cognome_tirocinante").isEmpty())
        {
            errori.put("ErroreCognome","Cognome del tirocinante non presente");
        }else if(request.getParameter("Cognome_tirocinante").length()>100){
            errori.put("ErroreCognome","Cognome del tirocinante troppo lungo");
        }

        if(request.getParameter("Nome_tirocinante").isEmpty())
        {
            errori.put("ErroreNome","Nome del tirocinante non presente");
        }else if(request.getParameter("Nome_tirocinante").length()>100){
            errori.put("ErroreNome","Nome del tirocinante troppo lungo");
        }

        if(request.getParameter("Esito_tirocinio").isEmpty())
        {
            errori.put("ErroreEsito","Esito tirocinio non presente");
        }else if(request.getParameter("Esito_tirocinio").length()>500)
        {
            errori.put("ErroreEsito","Esito tirocinio troppo lungo");
        }

        if(request.getParameter("Crediti_riconosciuti").isEmpty())
        {
            errori.put("ErroreCrediti","Crediti non presenti");
        }else if(Integer.parseInt(request.getParameter("Crediti_riconosciuti")) > 0 && Integer.parseInt(request.getParameter("Crediti_riconosciuti"))<100)
        {
            errori.put("ErroreCrediti","Crediti non congrui");
        }
        if(request.getParameter("Data_documento").isEmpty())
        {
            errori.put("ErroreDate","Data non presente");
        }

        if(errori.isEmpty())
        {
            return true;
        }else {
            refreshPage(request,response,errori);
            return false;
        }
    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,String> errori) throws ServletException,IOException{
        List<String> dati = new ArrayList<>();
        if(!(errori.containsKey("ErroreDataColloquio")))
        {
            dati.add("Data_colloquio");
        }
        if(!(errori.containsKey("ErroreCognome")))
        {
            dati.add("Cognome_tirocinante");
        }

        if(!(errori.containsKey("ErroreNome")))
        {
            dati.add("Nome_tirocinante");
        }

        if(!(errori.containsKey("ErroreEsito")))
        {
            dati.add("Esito_tirocinio");
        }

        if(!(errori.containsKey("ErroreCrediti")))
        {
            dati.add("Crediti_riconosciuti");
        }
        if(!(errori.containsKey("ErroreDate")))
        {
            dati.add("Data_documento");
        }

        datamodel.putAll(Utility.AddAllData(request,response,dati));
        datamodel.putAll(errori);
        fillModulo(request,response);

    }

    private void storeModulo(HttpServletRequest request,HttpServletResponse response ) throws IOException, ServerException,DaoException
    {

            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tirocinio = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("ID")));
            dao.destroy();

            tirocinio.setDataColloquioSegreteria(Date.valueOf(request.getParameter("Data_colloquio")));
            tirocinio.setEsitoTirocinio(request.getParameter("Esito_tirocinio"));
            tirocinio.setCreditiRiconosciuti(Integer.parseInt(request.getParameter("Crediti_riconosciuti")));
            tirocinio.setDataColloquioSegreteria(Date.valueOf(request.getParameter("Data_documento")));

            TirocinioDaoImp dao1= new TirocinioDaoImp();
            dao1.updateTirocinio(tirocinio);
            dao1.destroy();


    }
















}
