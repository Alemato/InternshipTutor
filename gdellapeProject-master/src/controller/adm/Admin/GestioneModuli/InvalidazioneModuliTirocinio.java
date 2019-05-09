package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuliTirocini;
import dao.exception.DaoException;
import dao.implementation.TirocinioDaoDaoImp;
import model.Tirocinio;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class InvalidazioneModuliTirocinio {

    private Map<String, Object> datamodel;
    private ServletContext context;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public InvalidazioneModuliTirocinio(Map<String, Object> datamodel, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.datamodel = datamodel;
        this.context = context;
        this.request = request;
        this.response = response;
    }


    public void invalidaPDfTirocinio() throws ServletException, IOException, DaoException {
        TirocinioDaoDaoImp dao = new TirocinioDaoDaoImp();
        Tirocinio tirocinio = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
        dao.destroy();
        FillGestioniModuliTirocini page = new FillGestioniModuliTirocini(request, response, context, datamodel);
        if (tirocinio.getPdfTirocinante()!=null) {

            tirocinio.setPdfTirocinante(null);
             TirocinioDaoDaoImp dao1= new TirocinioDaoDaoImp();
             dao1.updateTirocinio(tirocinio);
             dao1.destroy();
            //TODO Manda mail per avvisare è estato invalidato il pdf tirociante

            page.makegetWithSuccess("Invalidazione del PDF richiesta tirocinio &egrave andata a buon fine");

        } else {
            page.makegetWithInsuccess("Invalidazione del PDF della convenzione &egrave andata in errore");

        }
    }


    public void invalidaPDFAzienda() throws ServletException, IOException, DaoException {
        TirocinioDaoDaoImp dao = new TirocinioDaoDaoImp();
        Tirocinio tirocinio = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
        dao.destroy();
        FillGestioniModuliTirocini page = new FillGestioniModuliTirocini(request, response, context, datamodel);
        if (tirocinio.getPdfAzienda()!=null) {
                tirocinio.setPdfAzienda(null);
                TirocinioDaoDaoImp dao1= new TirocinioDaoDaoImp();
                dao1.updateTirocinio(tirocinio);
                dao1.destroy();
            //TODO Manda mail per avvisare che pdf aziende da rifare

            page.makegetWithSuccess("Il PDF dell&rsquo; azienda &egrave stato invalidato con successo");

        } else {
            page.makegetWithInsuccess("Invalidazione del PDf aziende &egrave andata in errore");

        }
    }

}
