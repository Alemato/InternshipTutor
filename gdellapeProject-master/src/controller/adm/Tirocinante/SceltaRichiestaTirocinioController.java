package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinio;
import model.Tirocinante;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SceltaRichiestaTirocinioController extends BackEndTrController {

    private void creoSessione(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idoftr = Integer.parseInt(request.getParameter("Tirocinio"));
        System.out.println(idoftr);
        request.getSession().setAttribute("Tirocinio", idoftr);
        response.sendRedirect("/login");

    }

    private void Richiesta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (!(session.isValidSession(request))) {
            creoSessione(request, response);
        } else if (session.isTirocinante(request)) {
            ifsend(request, response);
        } else {
            response.sendRedirect("/404");
        }

    }

    private void ifsend(HttpServletRequest request, HttpServletResponse response) {
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tr = session.getTirocinate(request, response);
            TirocinioDaoImp dao = new TirocinioDaoImp();
            boolean status = dao.ifTirocinanteSendRichiesta(tr);
            System.out.println(status);
            if (!status) {
                System.out.println("non hai richieste pendenti o attive");
                response.sendRedirect("/inviorichiesta");

            } else {
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/Tirocinio?ID=" + idOfferta);
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
