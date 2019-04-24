package controller.adm.Admin.GestioneTirocinio;

import controller.baseController;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DisattivaOffertaTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        disativaOfferta(request, response);


    }


    private void disativaOfferta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        try {
            datamodel.put("urlpage", "/admin/offertetirocinioadmin");
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            OffertaTirocinio offerta = dao.getOffertatrByID(Integer.parseInt(request.getParameter("IDOfferta")));
            if (validate(request, response, offerta)) {
//                cambiaStato(request,response,offerta);
                //TODO Mail che l'offerta è stata disattivata
                FillOfferteTirocinio page = new FillOfferteTirocinio(request, response, getServletContext(), datamodel);
                page.makegetWithSuccess("Offerta Disattivata");
            }


        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher pageError = request.getRequestDispatcher("/500");
            pageError.forward(request, response);
        }
    }

    private Boolean validate(HttpServletRequest request, HttpServletResponse response, OffertaTirocinio offerta) throws ServletException, IOException, DaoException {

        if (offerta.getStato() == 0) {
            FillOfferteTirocinio page = new FillOfferteTirocinio(request, response, getServletContext(), datamodel);
            page.makegetWithInsuccess("Offerta gia disattivata");
            return false;

        } else if (Utility.GetCurrentDate().compareTo(offerta.getPeriodoFine()) == 1) {
            FillOfferteTirocinio page = new FillOfferteTirocinio(request, response, getServletContext(), datamodel);
            page.makegetWithInsuccess("Offerta scaduta");
            return false;

        } else {
            return true;
        }
    }

    private void cambiaStato(HttpServletRequest request, HttpServletResponse response, OffertaTirocinio offerta) throws DaoException, IOException, ServletException {
        offerta.setStato(0);

        OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
        dao.updateOffertatr(offerta);
        dao.destroy();

    }


}
