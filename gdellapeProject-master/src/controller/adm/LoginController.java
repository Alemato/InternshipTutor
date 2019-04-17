package controller.adm;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LoginController extends HttpServlet {
    public String Email;
    public String Password;

    protected Map<String, Object> datamodel = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            this.login(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            TemplateController.process("login.ftl", datamodel, response, getServletContext());


        }

        private int sessionDestroy(HttpServletRequest request, HttpServletResponse response){
            int tirocinio = (int) request.getSession().getAttribute("Tirocinio");
            System.out.println("id tirocinio");
            System.out.println(tirocinio);
            request.getSession(false).invalidate();
            return tirocinio;
        }

        protected void login (HttpServletRequest request, HttpServletResponse response) throws DaoException {
            int tirocinio = 0;
            boolean richiesta = false;
            if (request.getSession(false).getAttribute("Tirocinio") != null) {
                tirocinio = sessionDestroy(request, response);
                richiesta = true;
//                request.getSession().setAttribute("Tirocinio", tirocinio);
            }
            SingSessionContoller session = SingSessionContoller.getInstance();
            String Mail = request.getParameter("Email");
            String pass = request.getParameter("Password");

            if (session.isAccount(Mail)) {
                UserDaoImp dao = new UserDaoImp();
                User user = dao.getUserByMail(Mail);

                if (session.login(Mail, pass)) {
                    switch (user.getTipologiaAccount()) {
                        case 1:  //IMPORTANTE ricordiamoci di inserire sempre 1=>admin, 2=>tirociante 3 => azienda
                            AdminDaoImp daoAd = new AdminDaoImp();
                            Admin admin = daoAd.getAdminByIDuser(user.getIDUser());
                            daoAd.destroy();
                            session.initSession(request, admin);
                            break;
                        case 2:
                            TirocinanteDaoImp daoTr = new TirocinanteDaoImp();
                            Tirocinante tr = daoTr.getTirocianteByIDuser(user.getIDUser());
                            daoTr.destroy();
                            session.initSession(request, tr);
                            break;
                        case 3:
                            AziendaDaoImp daAz = new AziendaDaoImp();
                            Azienda az = daAz.getAziendaByIDuser(user.getIDUser());
                            daAz.destroy();
                            session.initSession(request, az);
                            break;

                    }
                    try {
                        if (richiesta){
                            request.getSession().setAttribute("Tirocinio", tirocinio);
                            System.out.println("TirocinioSettato");
                            System.out.println(request.getSession().getAttribute("Tirocinio"));
                            response.sendRedirect("/sceltarichiesta?Tirocinio="+ request.getSession().getAttribute("Tirocinio"));
//                            RequestDispatcher requestDispatcher;
//                            requestDispatcher = request.getRequestDispatcher("/inviorichiesta?Tirocinio="+ request.getSession().getAttribute("Tirocinio"));
//                            try {
//                                requestDispatcher.forward(request, response);
//                            } catch (ServletException | IOException e) {
//                                e.printStackTrace();
//                                try {
//                                    response.sendRedirect("404");
//                                } catch (IOException e1) {
//                                    e1.printStackTrace();
//                                }
//                            }
                        }else {
                        response.sendRedirect("/home");
                    }}catch (IOException e){
                        e.printStackTrace();
                    }

                }else{TemplateController.process("login.ftl", datamodel, response, getServletContext());}

            }else{TemplateController.process("login.ftl", datamodel, response, getServletContext());}





    }
}
