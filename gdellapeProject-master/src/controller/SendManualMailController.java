package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;
import view.TemplateController;
import view.TemplateControllerMail;

public class SendManualMailController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if (request.getParameterMap().containsKey("to")) {
            String[] to = request.getParameter("to").split(";");
            String subject = request.getParameter("subject");
            String msg = request.getParameter("msg");
            datamodel.put("msg", msg);
            if (request.getParameterMap().containsKey("tipo")){
                String tipo = request.getParameter("tipo");
                if(tipo.equals("registrazioneAzienda")){
                    datamodel.put("nomeAzineda", "Mario srl");
                    TemplateControllerMail.process("email/registrazione-azienda.ftl", datamodel, to, subject, getServletContext());
                } else if (tipo.equals("registrazioneTirocinante")){
                    datamodel.put("nomeUtente", "Mario");
                    datamodel.put("cognomeUtente", "Rossi");
                    TemplateControllerMail.process("email/registrazione-tirocinante.ftl", datamodel, to, subject, getServletContext());
                } else if (tipo.equals("creazioneOferta")){
                    OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
                    OffertaTirocinio offertaTirocinio = null;
                    try {
                        offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(6);
                        offertaTirocinioDaoImp.destroy();
                        datamodel.put("Titolo", offertaTirocinio.getTitolo());
                        datamodel.put("LuogoEffettuazione", offertaTirocinio.getLuogoEffettuazione());
                        datamodel.put("Descrizione", offertaTirocinio.getDescrizione());
                        datamodel.put("DescrizioneBreve",offertaTirocinio.getDescrizioneBreve());
                        datamodel.put("Orario", offertaTirocinio.getOrari());
                        datamodel.put("PeriodoInizio", offertaTirocinio.getPeriodoInizio());
                        datamodel.put("PeriodoFine", offertaTirocinio.getPeriodoFine());
                        datamodel.put("Obbiettivi", offertaTirocinio.getObbiettivi());
                        datamodel.put("Modalita", offertaTirocinio.getModalita());
                        datamodel.put("Rimbosi", offertaTirocinio.getRimborsi());
                        datamodel.put("Facilitazioni", offertaTirocinio.getFacilitazioni());
                        datamodel.put("NomeRespAz", offertaTirocinio.getNomeTutoreAziendale());
                        datamodel.put("CognomeRepAz", offertaTirocinio.getCognomeTutoreAziendale());
                        datamodel.put("EmailRespAZ", offertaTirocinio.getEmailTutoreAziendale());
                        datamodel.put("TelRespAz", offertaTirocinio.getTelefonoTutoreAziendale());
                        datamodel.put("Url", "?id=6");
                        TemplateControllerMail.process("email/creazione-offerta.ftl", datamodel, to, subject, getServletContext());
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        TemplateController.process("sendmanualmail.ftl", datamodel, response, getServletContext());
    }
}
