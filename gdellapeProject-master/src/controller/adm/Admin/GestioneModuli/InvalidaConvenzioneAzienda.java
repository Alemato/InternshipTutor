package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
import controller.adm.Admin.GestioneUtenza.AdminFillTable;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class InvalidaConvenzioneAzienda  {

    private Map<String,Object> datamodel;
    private ServletContext context;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public InvalidaConvenzioneAzienda(Map<String, Object> datamodel, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.context = context;
        this.request = request;
        this.response = response;
    }


   public void invalidaConvezioneModuli()throws ServletException,IOException,DaoException
    {

            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
            FillGestioniModuli page = new FillGestioniModuli(request, response, context, datamodel);
            if ((!azienda.getPathPDFConvenzione().isEmpty()) && (azienda.getAttivo() == 1)) {
//                azienda.setPathPDFConvenzione(null);
//                azienda.setDataConvenzione(null);
//                azienda.setAttivo(0);
//                AziendaDaoImp dao2=new AziendaDaoImp();
//                dao2.updateAzienda(azienda);
//                dao2.destroy();
                //TODO Manda mail per avvisare che la convenzione è scaduta

                page.makegetWithSuccess("Invalidazione della convenzione per l'azienda " + azienda.getRagioneSociale() + " andata a buon fine");

            } else {
                page.makegetWithInsuccess("Invalidazione della convenzione per l'azienda " + azienda.getRagioneSociale() + " andata in errore");

            }
        }


    public void invalidaConvenzioneUtente() throws ServletException,IOException,DaoException
        {
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
           AdminFillTable page = new AdminFillTable(datamodel,context,request,response);
            if (azienda.getAttivo() == 1) {
//                azienda.setPathPDFConvenzione(null);
//                azienda.setDataConvenzione(null);
//                azienda.setAttivo(0);
//                AziendaDaoImp dao2=new AziendaDaoImp();
//                dao2.updateAzienda(azienda);
//                dao2.destroy();
                //TODO Manda mail per avvisare che la convenzione è scaduta

                page.makeSuccessGet("L'azienda "+azienda.getRagioneSociale()+" ora non può piu operare lui sito");

            } else {
                page.makeInsuccessGet("Operazione di invalidazione dell'azienda "+azienda.getRagioneSociale()+"non ha funzionato");

            }
        }


















}
