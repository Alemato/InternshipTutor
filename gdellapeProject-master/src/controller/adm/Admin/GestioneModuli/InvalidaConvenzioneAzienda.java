package controller.adm.Admin.GestioneModuli;


import com.sun.javaws.exceptions.OfflineLaunchException;
import controller.adm.Admin.GestioneAzienda.FillGestioniModuliConvenzione;
import controller.adm.Admin.GestioneUtenza.AdminFillTable;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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
       datamodel.put("urlpage","/admin/Gestione-Convenzione") ;
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
            FillGestioniModuliConvenzione page = new FillGestioniModuliConvenzione(request, response, context, datamodel);
            if ((!azienda.getPathPDFConvenzione().isEmpty()) && (azienda.getAttivo() == 1)) {
//                azienda.setPathPDFConvenzione(null);
//                azienda.setDataConvenzione(null);
//                azienda.setAttivo(0);
//                AziendaDaoImp dao2=new AziendaDaoImp();
//                OffertaTirocinioDaoImp dao2 = new OffertaTirocinioDaoImp();
//                List<OffertaTirocinio> offerte = dao2.getOffertatrBYAzienda(azienda);
//                dao2.destroy();
                //disattivo tutte le offerta di tirocinio
//                for (OffertaTirocinio offerta: offerte
//                     ) {
//                    offerta.setStato(0);
//                    OffertaTirocinioDaoImp dao3 = new OffertaTirocinioDaoImp();
//                    dao3.updateOffertatr(offerta);
//                    dao3.destroy();
//
//                }


//                dao2.updateAzienda(azienda);
//                dao2.destroy();

                //TODO Manda mail per avvisare che la convenzione è scaduta
                page.makegetWithSuccess("Invalidazione della convenzione per l'azienda " + azienda.getRagioneSociale() + " andata a buon fine");

            } else {
                page.makegetWithInsuccess("Invalidazione della convenzione per l'azienda " + azienda.getRagioneSociale() + " andata in errore");

            }
        }
    public void disattivaAzienda()throws ServletException,IOException,DaoException
    {
        datamodel.put("urlpage","/admin/gestione-aziende");
        AziendaDaoImp dao = new AziendaDaoImp();
        Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
        dao.destroy();
       AdminFillTable page = new AdminFillTable(datamodel,context,request,response);
        if ((!azienda.getPathPDFConvenzione().isEmpty()) && (azienda.getAttivo() == 1)) {
//                azienda.setPathPDFConvenzione(null);
//                azienda.setDataConvenzione(null);
//                azienda.setAttivo(0);
//                AziendaDaoImp dao2=new AziendaDaoImp();
//            OffertaTirocinioDaoImp dao2 = new OffertaTirocinioDaoImp();
//            List<OffertaTirocinio> offerte = dao2.getOffertatrBYAzienda(azienda);
//            dao2.destroy();
            //disattivo tutte le offerta di tirocinio
//                for (OffertaTirocinio offerta: offerte
//                     ) {
//                    offerta.setStato(0)
//                    OffertaTirocinioDaoImp dao3 = new OffertaTirocinioDaoImp();
//                    dao3.updateOffertatr(offerta);
//                    dao3.destroy();
//
//                }


//                dao2.updateAzienda(azienda);
//                dao2.destroy();

            //TODO Manda mail per avvisare che la convenzione è scaduta
            page.makeSuccessGetAziende(" L&apos;azienda " + azienda.getRagioneSociale() + "$eacute stata Disattivata con successo ");

        } else {
            page.makeInsuccessGetAziende(" L&apos;azienda " + azienda.getRagioneSociale() + " non $eacute stata Disattivata con successo ");

        }
    }
}
