package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
        int durata = azienda.getDurataConvenzione();
        Date dataConvenzone = azienda.getDataConvenzione();
        Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
        Calendar passato = Calendar.getInstance();
        Date dataoggi = presente.getTime();
        passato.setTime(dataConvenzone);
        passato.add(Calendar.DAY_OF_MONTH, +durata);
        if(presente.before(passato)){
            System.out.println("la richiesta è di stampa o altro");
        }else {
            System.out.println("la richiesta è di tipo agg");
            richiestaUpdate(dataoggi, response);
        }

    }

    private void richiestaUpdate(Date dataoggi, HttpServletResponse response){
        System.out.println("richiesta agg convenzione");
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
