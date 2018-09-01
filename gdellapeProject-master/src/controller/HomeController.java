package controller;

import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;

import dao.implementation.TutoreUniversitarioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.TutoreUniversitario;
import view.TemplateController;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.lang.String;

public class HomeController extends baseController {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request, response);
        LastFiveOfferte(request, response);
        LastFiveConvenz(request, response);
        TemplateController.process("index.ftl", datamodel, response, getServletContext());


    }

    protected void LastFiveOfferte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OffertaTirocinioDaoImp offerta = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> LastFiveOfferta = offerta.getLastFiveOfferte();
            offerta.destroy();
            datamodel.put("LastFiveOfferta", LastFiveOfferta);
            TutoreUniversitarioDaoImp tutore = new TutoreUniversitarioDaoImp();
            List<TutoreUniversitario> LastFiveTutore = new ArrayList<TutoreUniversitario>();
            for (OffertaTirocinio element : LastFiveOfferta) {
                LastFiveTutore.add(tutore.getTutoreUniByID(element.getTutoreUniversitario()));
            }
            tutore.destroy();
            datamodel.put("LastFiveTutore",LastFiveTutore);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void LastFiveConvenz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AziendaDaoImp azienda = new AziendaDaoImp();
            List<Azienda> LastFiveConvenzioni = azienda.getLastFiveConvenzioni();
            azienda.destroy();
            datamodel.put("LastFiveConvenzioni", LastFiveConvenzioni);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
