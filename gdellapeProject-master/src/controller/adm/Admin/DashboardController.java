package controller.adm.Admin;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardController extends baseController {

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try {
            super.init(request, response);
            fillTable(request, response);
        }catch (DaoException e){
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);
    }


    private void fillTable(HttpServletRequest request,HttpServletResponse response)throws DaoException,ServletException,IOException{
        AziendaDaoImp dao = new AziendaDaoImp();
        List<Azienda> aziende = dao.getAllAzienda();
        dao.destroy();
        datamodel.put("Aziende", aziende);

        TutoreUniversitarioDaoImp dao1 = new TutoreUniversitarioDaoImp();
        List<TutoreUniversitario> tutori= dao1.getAllTutUni();
        dao1.destroy();

        datamodel.put("NTurori",tutori.size());

        datamodel.put("Tutori",getnumTirocinanti(tutori));

        TirocinioDaoImp dao2 = new TirocinioDaoImp();
        List<Tirocinio> trAttivi = dao2.getTirociniByStato(1);
        dao2.destroy();

        datamodel.put("TirociniAttivi" ,trAttivi.size());

        AziendaDaoImp dao3 = new AziendaDaoImp();
        List<Azienda> aziendeAttive = dao3.getAllAziendaAttive();
        dao.destroy();

        datamodel.put("AziendeConven",aziendeAttive.size());


        TirocinioDaoImp dao4 = new TirocinioDaoImp();
        List<Tirocinio> trrf = dao2.getTirociniByStato(5);
        dao2.destroy();

        datamodel.put("TirociniRF",trrf.size());

        TemplateController.process("BackEndTemplates/admin-dashboard.ftl", datamodel, response, getServletContext());


    }
    private  Map<TutoreUniversitario,Integer> getnumTirocinanti(List<TutoreUniversitario> tutori)throws DaoException{

        Map<TutoreUniversitario,Integer> map = new HashMap<>();

        for (TutoreUniversitario tutore: tutori) {

            TirocinioDaoImp dao1 = new TirocinioDaoImp();
            List<Tirocinio> tirocini = dao1.getAllTirocinioByTutore(tutore);
            dao1.destroy();

            map.put(tutore,tirocini.size());
        }
        return map;
    }



}
