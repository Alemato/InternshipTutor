package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestioneOfferteController extends baseController {

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void  processaGet(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session ) throws IOException {
        Azienda azienda = session.getAzienda(request, response);
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        try {
            List<OffertaTirocinio> listOfferte = offertaTirocinioDaoImp.getOffertatrBYAzienda(azienda);
            offertaTirocinioDaoImp.destroy();
            datamodel.put("listaOfferte", listOfferte);
        } catch (DaoException e) {
            System.out.println("non ha offerte");
        }
        TemplateController.process("GestioneOfferteAzienda.ftl", datamodel, response, getServletContext());
    }

    private void disattivaOfferta(Integer idOfferta) throws DaoException {
        System.out.println("ID OFFERTA: "+ idOfferta);
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        OffertaTirocinioDaoImp offertaTirocinioDaoImp1 = new OffertaTirocinioDaoImp();
        OffertaTirocinio offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(idOfferta);
        offertaTirocinioDaoImp.destroy();
        offertaTirocinio.setStato(0);
        offertaTirocinioDaoImp1.updateOffertatr(offertaTirocinio);
        offertaTirocinioDaoImp1.destroy();
    }

    private void disattivazione( List<String> parametriVeri, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean err = false;
        for (String parametro : parametriVeri){
            int id = Integer.parseInt(parametro);
            try {
                disattivaOfferta(id);
            } catch (DaoException e) {
                e.printStackTrace();
                err = true;
                er500(request, response);
                break;
            }
        }
        if(!err){
            response.sendRedirect("/account/gestione-offerte");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)){
            Map<String, String[]> params = request.getParameterMap();
            List<String> parametri = new ArrayList<String>();
            List<String> parametriVeri = new ArrayList<String>();
            for (Object o : params.keySet()) {
                String key = (String) o;
                String value = (params.get(key))[0];
                if (key.startsWith("Disattiva_") && value.equals("1")) {
                    parametri.add(key);
                }
            }
            System.out.println(parametri);
            for (int i = 0; i < parametri.size(); i++) {
                String primo = parametri.get(i);
                String[] parts1 = primo.split("Disattiva_");
                System.out.println(parts1[1]);
                parametriVeri.add(parts1[1]);
            }
            System.out.println(parametriVeri);
            disattivazione(parametriVeri, request, response);
        } else {
            er403(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)){
            boolean scaduto = (boolean)request.getAttribute("Scaduto");
            datamodel.put("Scaduto", scaduto);
            processaGet(request, response, session);
        } else {
            er403(request, response);
        }

    }
}
