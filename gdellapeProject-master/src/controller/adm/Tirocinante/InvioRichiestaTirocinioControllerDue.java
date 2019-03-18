package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinio;
import model.Tirocinante;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InvioRichiestaTirocinioControllerDue extends BackEndTrController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Richiesta(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Richiesta(request, response);
    }
//    protected void RichiestaGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        SingSessionContoller session = SingSessionContoller.getInstance();
////        Integer idOfTr = Integer.parseInt(request.getParameter("Tirocinio"));
////        if (!(session.isValidSession(request))) {
////            request.getSession().setAttribute("Tirocinio", idOfTr);
////            System.out.println(idOfTr);
////            response.sendRedirect("/login");
////        } else {
//        if (super.loginTirocinante(request, response)) {
//            if (super.accessTirocinante(request, response)) {
//                ifsend(request,response);
//            }
//        }
////        }
//    }

    protected void Richiesta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        Integer idOfTr = Integer.parseInt(request.getParameter("Tirocinio"));
        if (!(session.isValidSession(request))) {
            request.getSession().setAttribute("Tirocinio", idOfTr);
            System.out.println(idOfTr);
            response.sendRedirect("/login");
        } else {
            if (super.loginTirocinante(request, response)) {
                if (super.accessTirocinante(request, response)) {
                    ifsend(request, response);
                }
            }
        }
    }

    protected void ifsend(HttpServletRequest request, HttpServletResponse response) {
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tr = session.getTirocinate(request, response);
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Boolean status = dao.ifTirocinanteSendRichiesta(tr);
            if (status) {
                invioRichiestaTr(request, response);

            } else {
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/Tirocinio?ID=" + idOfferta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @TODO da rivedere
    protected void invioRichiestaTr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            Integer idOfTr = Integer.parseInt(request.getParameter("Tirocinio"));


            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante Account = session.getTirocinate(request, response);


            Tirocinio richiestaTirocinio = new Tirocinio();
            richiestaTirocinio.setTirocinante(Account.getIDTirocinante());
            richiestaTirocinio.setOffertaTirocinio(idOfTr);

            TirocinioDaoImp rc = new TirocinioDaoImp();
            rc.firstRichiestatr(richiestaTirocinio);
            rc.destroy();
            response.sendRedirect("/home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
