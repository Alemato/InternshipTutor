package controller.adm.Admin.GestioneTirocinio;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowOffertaTirocinio extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fillOfferta(request, response);


    }

    private void fillOfferta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        try {
            datamodel.put("urlpage","/admin/offertetirocinioadmin");
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            OffertaTirocinio offerta = dao.getOffertatrByID(Integer.parseInt(request.getParameter("IDOfferta")));
            dao.destroy();
            datamodel.put("offerta",offerta);
            TemplateController.process("BackEndTemplates/show-offertatirocinio.ftl", datamodel, response, getServletContext());

        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);

        }
    }


}









