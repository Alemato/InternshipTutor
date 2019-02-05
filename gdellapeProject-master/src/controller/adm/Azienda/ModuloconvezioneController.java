package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import controller.utility.utility;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ModuloconvezioneController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setdata(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       ifaccess(request,response);

    }
    private void convenzione(HttpServletRequest request,HttpServletResponse response ,Azienda azienda)throws  ServletException,IOException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dataconvezione=sdf.format(azienda.getDataConvenzione());
        System.out.println(dataconvezione);
        datamodel.put("data",dataconvezione);
        datamodel.put("azienda",azienda);
        TemplateController.process("modulo-convezione-aziendale.ftl", datamodel, response, getServletContext());

    }

    private void ifaccess(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        super.init(request,response);
        super.accessLogin(request,response);
        super.accessAzienda(request,response);
        Azienda azienda=super.getAzienda(request,response);
        if(!(azienda.getAttivo()))
        {
            convenzione(request,response,azienda);
        }else
        {
            response.sendRedirect("/400");
        }

    }
    private void ifactive(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        super.init(request,response);
        super.accessLogin(request,response);
        super.accessAzienda(request,response);
        Azienda azienda=super.getAzienda(request,response);
        if(azienda.getAttivo())
        {
            throw new ServletException("Can't access in this area");

        }

    }
    private void validazione(HttpServletRequest request,HttpServletResponse response,List<String> input)throws  ServletException ,IOException
    {
        for (String item:input)
        {
            if(request.getParameter(item)==null||request.getParameter(item).isEmpty())
            {
                throw new IOException("I don't have date " + item);
            }
        }

    }
    private void setdata(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException
    {
        try{
            ifactive(request,response);
            List<String> input=new ArrayList<String>();
            input.add("Ente_Azienda");
            input.add("SedeLegale");
            input.add("Codice_fiscale");
            input.add("foro_competente");
            input.add("Rappresentante_legale_nome");
            input.add("Rappresentante_legale_cognome");
            input.add("durata_gg");
            input.add("Data_documento");
            validazione(request, response,input);
            savedate(request,response);
            response.sendRedirect("/home");


        }catch ( ServletException e)
        {
            e.printStackTrace();
            response.sendRedirect("/400");
        }
        catch (IOException c){
            c.printStackTrace();
            response.sendRedirect("/convezione");
        }
    }
    private void savedate(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException
    {
        try {
            Azienda azienda=super.getAzienda(request,response);
            azienda.setRagioneSociale(request.getParameter("Ente_Azienda"));
            azienda.setIndirizzoSedeLegale(request.getParameter("SedeLegale"));
            azienda.setCFiscalePIva(request.getParameter("Codice_fiscale"));
            azienda.setNomeLegaleRappresentante(request.getParameter("Rappresentante_legale_nome"));
            azienda.setCognomeLegaleRappresentante(request.getParameter("Rappresentante_legale_cognome"));
            azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("durata_gg")));
            azienda.setForoControversia(request.getParameter("foro_competente"));
            azienda.setDataConvenzione(java.sql.Date.valueOf(request.getParameter("Data_documento")));
            AziendaDaoImp dao = new AziendaDaoImp();
            dao.updateAzienda(azienda);
            dao.setMakemoduloConv(azienda);
            dao.destroy();
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/400");
        }

    }




}
