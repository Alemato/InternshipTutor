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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LoginController extends HttpServlet {
    public String Email;
    public String Password;

    protected Map<String, Object> datamodel = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.login(request, response);
        } catch (DaoException e) {
            e.printStackTrace();
            datamodel.put("errore", true);
            if (datamodel.get("errorePassword")!= null){
                datamodel.remove("errorePassword");
            }
            TemplateController.process("login.ftl", datamodel, response, getServletContext());
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(session.isTirocinante(request)||session.isAzienda(request)||session.isAdmin(request)) {
            RequestDispatcher page = request.getRequestDispatcher("/home");
            page.forward(request,response);
        }else{
            TemplateController.process("login.ftl", datamodel, response, getServletContext());
        }


    }

    private String urlRIC(HttpServletRequest request) {
        String url = (String) request.getSession().getAttribute("URI");
        return url;
    }

    private int idTirocinio(HttpServletRequest request) {
        int tirocinio = (int) request.getSession().getAttribute("Tirocinio");
        request.getSession(false).invalidate();
        return tirocinio;
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        int tirocinio = 0;
        boolean richiesta = false;
        String url = "";
        HttpSession sessionFalse = request.getSession(false);

        if (sessionFalse != null) {
            if (sessionFalse.getAttribute("URI") != null) {
                url = urlRIC(request);
            }
        }
        if (sessionFalse != null) {
            if (sessionFalse.getAttribute("Tirocinio") != null) {
                tirocinio = idTirocinio(request);
                richiesta = true;
            }
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
                    if (richiesta) {
                        request.getSession().setAttribute("Tirocinio", tirocinio);
                        response.sendRedirect("/sceltarichiesta?Tirocinio=" + request.getSession().getAttribute("Tirocinio"));

                    } else if (!url.equals("")) {
                        response.sendRedirect(url);
                    } else response.sendRedirect("/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                datamodel.put("errorePassword", true);
                TemplateController.process("login.ftl", datamodel, response, getServletContext());
            }

        } else {
            TemplateController.process("login.ftl", datamodel, response, getServletContext());
        }


    }
}
