package controller;

import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SchedaAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        setAzienda(request,response);
        TemplateController.process("scheda-azienda.ftl", datamodel, response, getServletContext());
    }
    protected void setAzienda (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer IDAzienda = Integer.parseInt(request.getParameter("ID"));

        try{
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            Azienda Azienda = daoAzienda.getAziendaByID(IDAzienda);
            daoAzienda.destroy();


            datamodel.put("RagioneSociale", Azienda.getRagioneSociale());
            datamodel.put("Link", Azienda.getLink());
            datamodel.put("Descrizione", Azienda.getDescrizione());
            datamodel.put("IndirizzoSedeLegale", Azienda.getIndirizzoSedeLegale());
            datamodel.put("CFiscalepiva", Azienda.getCFiscalePIva());
            datamodel.put("NomeLegaleRappresentante", Azienda.getNomeLegaleRappresentante());
            datamodel.put("CognomeLegaleRappresentante", Azienda.getCognomeLegaleRappresentante());
            datamodel.put("NomeResponsabileConvenzione", Azienda.getNomeResponsabileConvenzione());
            datamodel.put("CognomeResponsabileConvenzione", Azienda.getCognomeResponsabileConvenzione());
            datamodel.put("TelefonoResponsabileConvenzione", Azienda.getTelefonoResponsabileConvenzione());
            datamodel.put("EmailResponsabileConvenzione", Azienda.getEmailResponsabileConvenzione());
            datamodel.put("ForoControversia", Azienda.getForoControversia());


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
