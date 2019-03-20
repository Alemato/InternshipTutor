package controller.adm.Admin.GestioneModuli;

import controller.adm.Admin.GestioneUtenza.AdminFillAziendeConTable;
import controller.baseController;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ModificaModuloConvezioneAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        updateModulo(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        showpage(request, response);

    }


    private void showpage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {

        datamodel.put("azienda",fill(request,response));
        TemplateController.process("BackEndTemplates/admin-modulo-convenzione-aziendale.ftl", datamodel, response, getServletContext());
    }


    private void updateModulo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        if(validate(request,response))
        {
            storeModulo(request, response);
            AdminFillAziendeConTable page = new AdminFillAziendeConTable(datamodel,getServletContext(),request,response);
            page.makegetSucces("Aggiornameto della convenzione andato con successo");

        }
    }


    private void storeModulo(HttpServletRequest request,HttpServletResponse response)throws ServletException {
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();

            azienda.setRagioneSociale(request.getParameter("Ente_Azienda"));
            azienda.setIndirizzoSedeLegale(request.getParameter("SedeLegale"));
            azienda.setCFiscalePIva(request.getParameter(request.getParameter("Codice_fiscale")));
            azienda.setNomeLegaleRappresentante(request.getParameter("Rappresentante_legale_nome"));
            azienda.setCognomeLegaleRappresentante(request.getParameter("Rappresentante_legale_cognome"));
            azienda.setForoControversia(request.getParameter("foro_competente"));
            azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("durata_gg")));
            azienda.setDataConvenzione(Date.valueOf(request.getParameter("Data_documento")));
            //metto dato pdfconvezione a null in modo da fare ricaricare il nuovo modulo

            azienda.setPathPDFConvenzione(null);

            AziendaDaoImp dao1= new AziendaDaoImp();
            dao1.updateAzienda(azienda);
            dao1.destroy();


        } catch (DaoException  e) {
            try {
                e.printStackTrace();
                response.sendRedirect("/404");
            }catch (IOException d)
            {
                e.printStackTrace();

            }

        }
    }




    private Azienda fill(HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException
    {
        Azienda azienda = new Azienda();
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
        }catch (DaoException e)
        {
            e.printStackTrace();

        }
        return azienda;
    }

    private Boolean validate(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        Map<String,String> errori = new HashMap<>();

        if(request.getParameter("Ente_Azienda").isEmpty())
        {
            errori.put("DangerEnte_Azienda","Nome della azienda non presente");
        }else if(request.getParameter("Ente_Azienda").length()>100)
        {
            errori.put("DangerEnte_Azienda","Nome della azienda troppo lungo");
        }



        if(request.getParameter("SedeLegale").isEmpty())
        {
            errori.put("DangerSedeLegale","Sede Legale non presente");
        }else if(request.getParameter("SedeLegale").length()>100)
        {
            errori.put("DangerSedeLegale","Sede Legale troppo lungo");
        }



        if(request.getParameter("Codice_fiscale").isEmpty())
        {
            errori.put("DangerCodice_fiscale","Codice fiscale o partita iva non presente");
        }else if(request.getParameter("Codice_fiscale").length()!=11||request.getParameter("Codice_fiscale").length()!=16)
        {
            errori.put("DangerCodice_fiscale","Codice fiscale o partita iva non presente");

        }

        if(request.getParameter("Rappresentante_legale_nome").isEmpty())
        {
            errori.put("DangerRappresentante_legale_nome","Nome del rappresentante legale non presente");

        }else if(request.getParameter("Rappresentante_legale_nome").length()>50)
        {
            errori.put("DangerRappresentante_legale_nome","Nome del rappresentante legale non presente");
        }

        if(request.getParameter("Rappresentante_legale_cognome").isEmpty())
        {
            errori.put("DangerRappresentante_legale_cognome","Cognome del Rappresentante non presente");
        }else if(request.getParameter("Rappresentante_legale_cognome").length()>50)
        {
            errori.put("DangerRappresentante_legale_cognome","Cognome del rappresentante troppo lungo");
        }

        if(request.getParameter("foro_competente").isEmpty()){
            errori.put("Dangerforo_competente","Foro Compotente non presente");
        }else if(request.getParameter("foro_competente").length()>200)
        {
            errori.put("Dangerforo_competente","Foro competenze troppo lungo");
        }

        if(request.getParameter("durata_gg").isEmpty())
        {
            errori.put("Dangerdurata_gg","Durata giorni non presente");
        }else if (Integer.parseInt(request.getParameter("durata_gg")) < 0 && Integer.parseInt(request.getParameter("durata_gg"))>10000)
        {
            errori.put("Dangerdurata_gg","Durata giorni non congrua");
        }

        if(request.getParameter("Data_documento").isEmpty())
        {
            errori.put("DangerData_documento","Data del documento non presente");

        }


        if(errori.isEmpty())
        {
            return true;
        }else
            {
                refreshPage(request,response,errori);
                return false;

        }


    }



    private void refreshPage(HttpServletRequest request,HttpServletResponse response, Map<String,String> errori) throws IOException,ServletException
    {
        List<String> Data = new ArrayList<>();
        if(errori.containsKey("DangerEnte_Azienda"))
        {
            Data.add("Ente_Azienda");
        }
        if(errori.containsKey("DangerSedeLegale"))
        {
            Data.add("SedeLegale");
        }
        if(errori.containsKey("DangerSedeLegale"))
        {
            Data.add("SedeLegale");
        }
        if(errori.containsKey("DangerCodice_fiscale"))
        {
            Data.add("Codice_fiscale");
        }
        if(errori.containsKey("DangerRappresentante_legale_nome"))
        {
            Data.add("Rappresentante_legale_nome");
        }
        if(errori.containsKey("DangerRappresentante_legale_cognome"))
        {
            Data.add("Rappresentante_legale_cognome");

        }
        if(errori.containsKey("Dangerforo_competente"))
        {
            Data.add("foro_competente");
        }
        if(errori.containsKey("Dangerdurata_gg"))
        {
            Data.add("durata_gg");
        }
        if(errori.containsKey("DangerData_documento"))
        {
            Data.add("Data_documento");
        }

        datamodel.putAll(Utility.AddAllData(request,response,Data));
        datamodel.putAll(errori);
        showpage(request,response);

    }













}
