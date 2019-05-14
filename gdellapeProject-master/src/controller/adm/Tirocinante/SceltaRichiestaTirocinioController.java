package controller.adm.Tirocinante;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SceltaRichiestaTirocinioController extends baseController {

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void creoSessione(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idoftr = Integer.parseInt(request.getParameter("Tirocinio"));
        request.getSession().setAttribute("Tirocinio", idoftr);
        response.sendRedirect("/login");

    }

    private void notTirocinante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int Idtrof = Integer.parseInt(request.getParameter("Tirocinio"));
            OffertaTirocinioDaoImp ofdao = new OffertaTirocinioDaoImp();
            OffertaTirocinio oftr = ofdao.getOffertatrByID(Idtrof);
            ofdao.destroy();
            AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
            Azienda azienda = aziendaDaoImp.getAziendaByID(oftr.getAzienda());
            aziendaDaoImp.destroy();
            datamodel.put("Offerta", oftr);
            datamodel.put("AziendaOspitante", azienda.getRagioneSociale());
            datamodel.put("Message", " Non puoi richiedere un tirocinio perche non sei registrato come Tirocinante");
            TemplateController.process("scheda-tirocinio.ftl", datamodel, response, getServletContext());
        } catch (Exception e) {
            e.printStackTrace();
            er500(request, response);
        }

    }


    private void Richiesta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (!(session.isValidSession(request))) {
            creoSessione(request, response);
        } else if (session.isTirocinante(request)) {
            ifsend(request, response);
        } else {
            notTirocinante(request, response);
        }

    }

    private void ifsend(HttpServletRequest request, HttpServletResponse response) {
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tr = session.getTirocinate(request, response);
            TirocinioDaoImp dao = new TirocinioDaoImp();
            boolean status = dao.ifTirocinanteSendRichiesta(tr);
            if (!status) {
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/listaofferte/tirocinio/inviorichiesta?idOffertaTirocinio=" + idOfferta);

            } else {
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/listaofferte/tirocinio?Tirocinio=" + idOfferta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Richiesta(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Richiesta(request, response);
    }
}
