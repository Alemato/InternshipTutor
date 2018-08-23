package controller;

import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.OffertaTirocinio;
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
       try {
           setpage(request, response);
           TemplateController.process("scheda-tirocinio.ftl", datamodel, response, getServletContext());
       }catch (Exception e){
           e.printStackTrace();
       }






    }

    protected void setpage (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,DaoException {
        try {
            Integer Idtrof = Integer.parseInt((String)request.getParameter("ID"));
            OffertaTirocinioDaoImp ofdao = new OffertaTirocinioDaoImp();

            OffertaTirocinio Oftr = ofdao.getOffertatrByID(Idtrof);

            ofdao.destroy();

            TutoreUniversitarioDaoImp daotut = new TutoreUniversitarioDaoImp();
            TutoreUniversitario tutuni = daotut.getTutoreUniByID(Oftr.getAzienda());
            daotut.destroy();

            datamodel.put("LuogoEffettuazione", Oftr.getLuogoEffettuazione());
            datamodel.put("Titolo",Oftr.getTitolo());
            datamodel.put("DescrizioneBreve",Oftr.getDescrizioneBreve());
            datamodel.put("Descrizione",Oftr.getDescrizione());
            datamodel.put("Orario",Oftr.getOrario());

            datamodel.put("PeriodoInizio",Oftr.getPeriodoInizio());
            datamodel.put("PeriodoFine",Oftr.getPeriodoFine());
            datamodel.put("Modalita",Oftr.getModalita());
            datamodel.put("Obbiettivi",Oftr.getObbiettivi());
            datamodel.put("Rimbosi",Oftr.getRimborsi());
            datamodel.put("Facilitazioni",Oftr.getFacilitazioni());
            datamodel.put("AziendaOspitante",Oftr.getAziendaOspitante());
            datamodel.put("NomeRespAz",Oftr.getNomeTutoreAziendale());
            datamodel.put("CognomeRepAz",Oftr.getCognomeTutoreAziendale());
            datamodel.put("TelRespAz",Oftr.getTelefonoTutoreAzindale());
            datamodel.put("EmailRespAZ",Oftr.getEmailTutoreAziendale());

            datamodel.put("NomeTutUni",tutuni.getNome());
            datamodel.put("CognomeTutUni",tutuni.getCognome());
            datamodel.put("TelefonoTutUni",tutuni.getTelefono());
            datamodel.put("EmailTutUni",tutuni.getEmail());


            datamodel.put("IDazienda",Oftr.getAzienda());


            }catch (Exception e){
            e.printStackTrace();

        }




    }
}