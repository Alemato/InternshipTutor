package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuliTirocini;
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


public class VisualizzaModuloSegreteriaTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        try {
            fillModulo(request, response);
            datamodel.put("urlpage", "/admin/Gestione-tirocinio");
            if (ifshow(request, response)) {
                fillModulo(request, response);
            } else {
                FillGestioniModuliTirocini page = new FillGestioniModuliTirocini(request, response, getServletContext(), datamodel);
                page.makegetWithInsuccess("Modulo non presente");

            }
        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request, response);
        }
    }

    private Boolean ifshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException {
        TirocinioDaoImp dao = new TirocinioDaoImp();
        Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
        dao.destroy();
        return (tr.getPdfSegreteria() != null);
    }

    private void fillModulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tirocinante tirocinante = new Tirocinante();
        Tirocinio tr = new Tirocinio();
        try {
            datamodel.put("urlpage", "/admin/Gestione-tirocinio");
            TirocinioDaoImp dao = new TirocinioDaoImp();
            tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();

            TirocinanteDaoImp dao1 = new TirocinanteDaoImp();
            tirocinante = dao1.getTirocianteByID(tr.getTirocinante());
            dao1.destroy();

            datamodel.put("tirocinante", tirocinante);
            datamodel.put("tirocinio", tr);
            TemplateController.process("BackEndTemplates/admin-create-modulo-tirocinio-segreteria.ftl", datamodel, response, getServletContext());

        } catch (DaoException e) {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request, response);


        }

    }


}
