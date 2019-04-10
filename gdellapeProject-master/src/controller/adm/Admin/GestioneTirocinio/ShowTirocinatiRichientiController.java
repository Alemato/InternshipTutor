package controller.adm.Admin.GestioneTirocinio;


import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowTirocinatiRichientiController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fillTirocinanti(request,response);

    }
    private void fillTirocinanti(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        try {
            String idOfferta=request.getParameter("IDOfferta");
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            OffertaTirocinio offerta= dao.getOffertatrByID(Integer.parseInt(idOfferta));
            dao.destroy();

            TirocinioDaoImp dao1 = new TirocinioDaoImp();
            List<Tirocinio> tirocini=dao1.getTrByOfferta(offerta);
            dao1.destroy();
            if(!tirocini.isEmpty()) {

                List<Tirocinante> tirocinati = new ArrayList<>();
                TirocinanteDaoImp dao2 = new TirocinanteDaoImp();
                for (Tirocinio tr : tirocini) {
                    tirocinati.add(dao2.getTirocianteByID(tr.getTirocinante()));

                }
                dao2.destroy();
                datamodel.put("Tirocinanti",tirocinati);
            }


            datamodel.put("Offerta",offerta);

            TemplateController.process("BackEndTemplates/show-TirocinantiRichiedenti.ftl", datamodel, response, getServletContext());
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher pageError = request.getRequestDispatcher("/500");
            pageError.forward(request,response);
        }

        

    }




}
