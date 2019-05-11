package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.implementation.TirocinioDaoDaoImp;
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

public class SceltaRichiestaTirocinioController extends BackEndTrController {

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void creoSessione(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idoftr = Integer.parseInt(request.getParameter("Tirocinio"));
        System.out.println(idoftr);
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
            System.out.println("sessione non valida, quindi la creo");
            creoSessione(request, response);
        } else if (session.isTirocinante(request)) {
            System.out.println("sessione validae di tipo Tirocinante");
            ifsend(request, response);
        } else {
            notTirocinante(request, response);
        }

    }

    private void ifsend(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("sono nel metodo ifSend");
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tr = session.getTirocinate(request, response);
            TirocinioDaoDaoImp dao = new TirocinioDaoDaoImp();
            boolean status = dao.ifTirocinanteSendRichiesta(tr);
            System.out.println(status);
            if (!status) {
                System.out.println("non hai richieste pendenti o attive");
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/listaofferte/tirocinio/inviorichiesta?Tirocinio=" + idOfferta);

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
