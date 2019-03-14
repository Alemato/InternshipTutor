package controller;

import controller.sessionController.SingSessionContoller;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.TutoreUniversitario;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SchedaTirocinioController  extends baseController{


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        ifisendRichiesta(request,response);
        setpage(request, response);
        TemplateController.process("scheda-tirocinio.ftl", datamodel, response, getServletContext());

    }

    private void setpage (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        try {
            Integer Idtrof = Integer.parseInt((String)request.getParameter("ID"));
            OffertaTirocinioDaoImp ofdao = new OffertaTirocinioDaoImp();

            OffertaTirocinio Oftr = ofdao.getOffertatrByID(Idtrof);

            ofdao.destroy();


            datamodel.put("IDTirocinio",Oftr.getIDOffertaTirocinio());
            datamodel.put("LuogoEffettuazione", Oftr.getLuogoEffettuazione());
            datamodel.put("Titolo",Oftr.getTitolo());
            datamodel.put("DescrizioneBreve",Oftr.getDescrizioneBreve());
            datamodel.put("Descrizione",Oftr.getDescrizione());
            datamodel.put("Orario",Oftr.getOrari());

            datamodel.put("PeriodoInizio",Oftr.getPeriodoInizio());
            datamodel.put("PeriodoFine",Oftr.getPeriodoFine());
            datamodel.put("Modalita",Oftr.getModalita());
            datamodel.put("Obbiettivi",Oftr.getObbiettivi());
            datamodel.put("Rimbosi",Oftr.getRimborsi());
            datamodel.put("Facilitazioni",Oftr.getFacilitazioni());
            datamodel.put("AziendaOspitante",Oftr.getAziendaOspitante());
            datamodel.put("NomeRespAz",Oftr.getNomeTutoreAziendale());
            datamodel.put("CognomeRepAz",Oftr.getCognomeTutoreAziendale());
            datamodel.put("TelRespAz",Oftr.getTelefonoTutoreAziendale());
            datamodel.put("EmailRespAZ",Oftr.getEmailTutoreAziendale());






            }catch (Exception e){
            e.printStackTrace();

        }




    }
    private void ifisendRichiesta(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();

            if (session.isTirocinante(request)&& session.isValidSession(request)){
                Tirocinante tr = session.getTirocinate(request,response);

            TirocinioDaoImp dao = new TirocinioDaoImp();
            boolean statusoldRC = dao.ifTirocinanteSendRichiesta(tr);
            dao.destroy();

            if(statusoldRC) {
                datamodel.put("Message", "Non puoi Richiedene altri Tirocini mentre ne stai svogendo uno o ne hai richiesto uno");

            }
        }


        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
