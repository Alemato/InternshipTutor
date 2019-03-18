package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ConvenzioneController extends baseController {
    private Azienda azienda = new Azienda();

    private void creaOggeti(HttpServletRequest request ,HttpServletResponse response){
        SingSessionContoller session = SingSessionContoller.getInstance();
        try {
            this.azienda = session.getAzienda(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void gestioneRichiesta(HttpServletResponse response){
        if (azienda.getDataConvenzione() == null && azienda.getDurataConvenzione() == null){
            System.out.println("la richiesta è di tipo creazione convenzione");
            Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            richiestaUpdate(presente.getTime(), response);
        }else {
            Map<String,Object> scadenza = Validation.scadenza(azienda.getDataConvenzione(), azienda.getDurataConvenzione());
            Calendar presente = (Calendar) scadenza.get("presente");
            Boolean scaduto = (Boolean) scadenza.get("scaduto");
            //presente.set(2018,Calendar.SEPTEMBER,2);
            Date dataoggi = presente.getTime();
            if(!scaduto){
                System.out.println("la richiesta è di stampa o altro");
                richiestaStampaModullo(dataoggi,response);
            }else {
                System.out.println("la richiesta è di tipo agg");
                richiestaUpdate(dataoggi, response);
            }
        }

    }

    private void richiestaStampaModullo(Date dataoggi, HttpServletResponse response){
        if (azienda.getPathPDFConvenzione() == null){
            richiestaUpdate(dataoggi, response);
        }else {
            System.out.println("rispondi con il file");

        }

    }

    private void richiestaUpdate(Date dataoggi, HttpServletResponse response){
        //TODO implementare il controllo del esistenza dei valori null sul ftl
        System.out.println("richiesta agg convenzione");
        datamodel.put("notview", true);
        datamodel.put("azienda", azienda);
        datamodel.put("dataoggi", dataoggi);
        TemplateController.process("modulo-convenzione-aziendale.ftl", datamodel, response , getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        creaOggeti(request, response);
        gestioneRichiesta(response);
    }
}
