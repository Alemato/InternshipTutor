package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import model.Azienda;
import view.TemplateController;
import dao.implementation.AziendaDaoImp;


public class ListaConvenzioniController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request, response);
        listaConvenzioni(request, response);
        TemplateController.process("lista-convenzioni.ftl", datamodel, response, getServletContext());


    }

    private void listaConvenzioni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            List<Azienda> ListaConv = daoAzienda.getAllAziendaAttive();
            daoAzienda.destroy();

            datamodel.put("ListaConv", ListaConv);


        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/500");
            dispatcher.forward(request, response);
        }

    }
}
