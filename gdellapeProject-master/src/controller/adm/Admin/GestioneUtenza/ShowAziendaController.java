package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        showAzienda(request,response);

    }

    private void showAzienda(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        super.init(request,response);
        datamodel.put("urlpage","/admin/gestione-aziende");
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda az = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();

            datamodel.put("azienda", az);
            datamodel.put("user", BackEndAdminController.getUser(request, response, az.getUser()));
            TemplateController.process("BackEndTemplates/show-Azienda.ftl", datamodel, response, getServletContext());
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }






}
