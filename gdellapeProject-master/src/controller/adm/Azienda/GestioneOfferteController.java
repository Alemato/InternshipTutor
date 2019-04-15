package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GestioneOfferteController extends baseController {

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void  processaGet(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session ) throws IOException {
        Azienda azienda = session.getAzienda(request, response);
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        try {
            List<OffertaTirocinio> listOfferte = offertaTirocinioDaoImp.getOffertatrBYAzienda(azienda);
            offertaTirocinioDaoImp.destroy();
            datamodel.put("listaOfferte", listOfferte);
        } catch (DaoException e) {
            System.out.println("non ha offerte");
        }
        TemplateController.process("GestioneOfferteAzienda.ftl", datamodel, response, getServletContext());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)){
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            processaGet(request, response, session);
        } else {
            er403(request, response);
        }

    }
}
