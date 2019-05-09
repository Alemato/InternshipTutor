package controller;

import controller.sessionController.SingSessionContoller;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
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
        setpage(request);
        TemplateController.process("scheda-tirocinio.ftl", datamodel, response, getServletContext());

    }

    private void setpage (HttpServletRequest request){
        try {
            int Idtrof = Integer.parseInt(request.getParameter("Tirocinio"));
            OffertaTirocinioDaoImp ofdao = new OffertaTirocinioDaoImp();
            OffertaTirocinio oftr = ofdao.getOffertatrByID(Idtrof);
            ofdao.destroy();
            AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
            Azienda azienda = aziendaDaoImp.getAziendaByID(oftr.getAzienda());
            aziendaDaoImp.destroy();
            datamodel.put("Offerta", oftr);
            datamodel.put("AziendaOspitante",azienda.getRagioneSociale());
            }catch (Exception e){
            e.printStackTrace();

        }

    }
    private void ifisendRichiesta(HttpServletRequest request,HttpServletResponse response){
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();

            if (session.isTirocinante(request)&& session.isValidSession(request)){
                Tirocinante tr = session.getTirocinate(request,response);

            TirocinioDaoDaoImp dao = new TirocinioDaoDaoImp();
            boolean statusoldRC = dao.ifTirocinanteSendRichiesta(tr);
            dao.destroy();

            if(statusoldRC) {
                datamodel.put("Message", " Non puoi Richiedene altri Tirocini mentre ne stai svogendo uno o ne hai richiesto uno");

            }
        }


        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
