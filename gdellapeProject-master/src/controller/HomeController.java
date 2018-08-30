package controller;

import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;

import model.Azienda;
import model.OffertaTirocinio;
import view.TemplateController;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.String;

public class HomeController extends baseController {




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request,response);
        //OffTir(request, response);
        //Convenz(request, response);
        LastFiveOfferte(request,response);
        LastFiveConvenz(request, response);
        TemplateController.process("index.ftl", datamodel, response, getServletContext());


    }
//    protected void OffTir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            OffertaTirocinioDaoImp daooff = new OffertaTirocinioDaoImp();
//            List<OffertaTirocinio> OfferteTirocini = daooff.getAllOffertatr();
//            daooff.destroy();
//            datamodel.put("OfferteTirocini",OfferteTirocini);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

    /*protected void Convenz (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            List<Azienda> Convenzioni = daoAzienda.getAllConvenzione();

            daoAzienda.destroy();


            datamodel.put("Convenzioni", Convenzioni);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }*/

    protected void LastFiveOfferte (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            OffertaTirocinioDaoImp offerta = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> LastFiveOfferta = offerta.getLastFiveOfferte();
            offerta.destroy();
            datamodel.put("LastFiveOfferta",LastFiveOfferta);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void LastFiveConvenz (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            AziendaDaoImp azienda = new AziendaDaoImp();
            List<Azienda> LastFiveConvenzioni = azienda.getLastFiveConvenzioni();
            azienda.destroy();
            datamodel.put("LastFiveConvenzioni", LastFiveConvenzioni);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
