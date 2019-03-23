package controller.adm.Admin.GestioneModuli;


import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VisualizzaConvenzioneAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        fillModulo(request,response);


    }
    private void fillModulo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       Tirocinante tirocinante =new Tirocinante();
       List<String> dati = new ArrayList<>();
        try{
            AziendaDaoImp dao  = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();

            datamodel.put("azienda",azienda);
            TemplateController.process("BackEndTemplates/admin-convenzione-azienda.ftl", datamodel, response, getServletContext());

        }catch (DaoException e)
        {
            e.printStackTrace();
        }

    }
















}
