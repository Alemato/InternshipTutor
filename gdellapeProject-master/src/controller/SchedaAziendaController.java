package controller;

import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SchedaAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setAzienda(request,response);
        TemplateController.process("scheda-azienda.ftl", datamodel, response, getServletContext());
    }
    protected void setAzienda (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer IDAzienda = Integer.parseInt((String)request.getParameter("ID"));

        try{
            AziendaDaoImp daoAzienda = new AziendaDaoImp();
            Azienda Azienda = daoAzienda.getAziendaByID(IDAzienda);
            daoAzienda.destroy();


            datamodel.put("RagioneSociale",Azienda.getRagioneSociale() );

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
