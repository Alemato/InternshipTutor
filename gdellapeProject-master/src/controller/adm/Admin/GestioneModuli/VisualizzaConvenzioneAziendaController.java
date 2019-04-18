package controller.adm.Admin.GestioneModuli;


import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VisualizzaConvenzioneAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        fillModulo(request,response);


    }
    private void fillModulo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        pagefill(request,response);
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
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }

    }
    private void pagefill(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("page").equals("richiete")){
            datamodel.put("urlpage","/admin/richisteconvezioni");
        }else{
            datamodel.put("urlpage","/admin/Gestione-Convenzione");
        }

    }
















}
