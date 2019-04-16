package controller;

import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;

import model.Azienda;
import model.OffertaTirocinio;
import view.TemplateController;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class HomeController extends baseController {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request, response);
        try {
            LastFiveOfferte(request, response);
            LastFiveConvenzioni(request, response);
            TemplateController.process("index.ftl", datamodel, response, getServletContext());
        }catch (DaoException e){
            RequestDispatcher page= request.getRequestDispatcher("/500");
            page.forward(request,response);
        }


    }

    private void LastFiveOfferte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException {
            OffertaTirocinioDaoImp offerta = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> LastFiveOfferta = offerta.getLastFiveOfferte();
            offerta.destroy();
            datamodel.put("LastFiveOfferta", LastFiveOfferta);


    }

    private void LastFiveConvenzioni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException {

            AziendaDaoImp azienda = new AziendaDaoImp();
            List<Azienda> LastFiveConvenzioni = azienda.getLastFiveConvenzioni();
            azienda.destroy();
            datamodel.put("LastFiveConvenzioni", LastFiveConvenzioni);

    }

}
