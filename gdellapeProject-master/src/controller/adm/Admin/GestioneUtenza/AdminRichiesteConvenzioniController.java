package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminRichiesteConvenzioniController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        super.init(request,response);
        AdminFillAziendeConTable objectFunction= new AdminFillAziendeConTable(datamodel,getServletContext(),request,response);
        objectFunction.makeget();


    }



}
