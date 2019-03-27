package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
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

    InvalidaConvenzioneAzienda(Map<String, Object> datamodel, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.context = context;
        this.request = request;
        this.response = response;
    }


    void invalidaConvezioneModuli()throws ServletException,IOException,DaoException
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


















}
