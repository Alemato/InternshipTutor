package controller.adm.Admin;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminRichiesteConvenzioniController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       fillTablePendenti(request,response);
    }
    private void fillTablePendenti(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            super.init(request, response);
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziende = dao.getAllAziendaPendenti();
            dao.destroy();
            datamodel.put("aziende", aziende);
            TemplateController.process("BackEndTemplates/richieste-convenzioni-admin.ftl", datamodel, response, getServletContext());
        }catch (DaoException e)
        {e.printStackTrace();
            response.sendRedirect("/400");
        }
    }


}
