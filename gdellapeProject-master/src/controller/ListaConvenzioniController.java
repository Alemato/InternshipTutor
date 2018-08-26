package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.exception.DaoException;
import model.Azienda;
import view.TemplateController;
import dao.implementation.AziendaDaoImp;


public class ListaConvenzioniController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request,response);
        ListaConvenzioni(request,response);
        TemplateController.process("lista-convenzioni.ftl", datamodel, response, getServletContext());


    }

    protected void ListaConvenzioni (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            List<Azienda> ListaConv = daoAzienda.getAllAzienda();
            daoAzienda.destroy();

            datamodel.put("ListaConv", ListaConv);


        }catch (Exception e) {
                e.printStackTrace();

            }

    }
}
