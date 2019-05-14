package controller;

import controller.utility.Mailer;
import controller.utility.Tokener;
import dao.exception.DaoException;
import model.User;
import dao.implementation.UserDaoImp;
import view.TemplateController;
import view.TemplateControllerMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResetController extends baseController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        List<String> errore = new ArrayList<String>();
        if (request.getParameterMap().containsKey("Token")){
            UserDaoImp user = new  UserDaoImp();
            try {
                String token = request.getParameter("Token");
                User users = user.getUserByToken(token);
                if (users.getToken().equals(token)){
                    datamodel.put("token", token);
                    TemplateController.process("reset-pwd.ftl", datamodel,response,getServletContext());
                    user.destroy();
                } else {
                    errore.add("2");
                    datamodel.put("errore",errore);

                    TemplateController.process("richiesta-reset-pwd.ftl", datamodel, response, getServletContext());
                    user.destroy();
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else {
            TemplateController.process("richiesta-reset-pwd.ftl", datamodel, response, getServletContext());
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        List<String> errore = new ArrayList<String>();
        if (request.getParameterMap().containsKey("Email")) {
            String emailUser = request.getParameter("Email"); // vedo se è presente il campo Email nella richiesta, cio mi fa capire che stiammo allo step di invio email
            UserDaoImp user = new UserDaoImp();
            List<String> data = new ArrayList<String>();
            try {
                User users = user.getUserByMail(emailUser);

                if (users.getEmail() == null) {  // controllo se l'email è presente nel sistema, se non è presente ritorna un errore a video
                    errore.add("1");
                    datamodel.put("errore",errore);
                    TemplateController.process("richiesta-reset-pwd.ftl", datamodel, response, getServletContext());
                } else {
                    String token = Tokener.generateResetToken(users.getIDUser().toString(), users.getTipologiaAccount().toString()); // genero un token
                    users.setToken(token);
                    user.setToken(users);
                    user.destroy();
//                    String msg = "<h1>Richiesta di Reset Password</h1>Caro utente<br><p>Abbiamo ricevuto una richiesta di reset della password per l&apos;account con email : <b>" + users.getEmail() + "</b> .<br> Per poter resettare la propia password clicca al seguente linck <a href=\"" + "http://localhost:8080/reset?Token=" + token + "\"" + ">http://localhost:8080/reset?Token=" + token + "</a></p>";
//                    Mailer.send(users.getEmail(), "Richiesta di Reset Password", msg);
                    datamodel.put("urlReset", "http://localhost:8080/reset?Token="+token);
                    String[] to = new String[1];
                    to[0]= "internshiptutor@matteifamily.net";
                    String subject = "Richiesta di reset Password";
                    TemplateControllerMail.process("email/richiesta-reset-password.ftl", datamodel, to, subject, getServletContext());
                    response.sendRedirect("/home");
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } else
            if (request.getParameterMap().containsKey("New_password") && request.getParameterMap().containsKey("Rep_password") && request.getParameterMap().containsKey("Token")){
                if (request.getParameter("New_password").equals(request.getParameter("Rep_password"))){
                    UserDaoImp user = new UserDaoImp();
                    try {
                        User users = user.getUserByToken(request.getParameter("Token"));
                        if (users.getToken().equals(request.getParameter("Token"))){
                            users.setPassword(request.getParameter("New_password"));
                            user.update(users);
//                            String msg = "<h1>Richiesta di Reset Password</h1>Caro utente<br><p>Abbiamo ricevuto una richiesta di reset della password per l&apos;account con email : <b>"+ users.getEmail() + "</b> .<br> La richesta &egrave; stata accettata. <br>La nuova password &egrave; :  "+ users.getPassword();
//                            Mailer.send(users.getEmail(), "Richiesta di Reset Password", msg);
                            String[] to = new String[1];
                            to[0]= "internshiptutor@matteifamily.net";
                            String subject = "Notifica di avvenuta modifica della password";
                            TemplateControllerMail.process("email/modifica-password.ftl", datamodel, to, subject, request.getServletContext());
                            user.destroy();
                            response.sendRedirect("/login");
                        }else {
                            errore.add("2");
                            datamodel.put("errore",errore);
                            TemplateController.process("richiesta-reset-pwd.ftl", datamodel, response, getServletContext());
                            user.destroy();
                        }
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }

                } else {
                    errore.add("2");
                    datamodel.put("errore",errore);
                    datamodel.put("token", request.getParameter("Token"));
                    TemplateController.process("reset-pwd.ftl", datamodel, response, getServletContext());
                }
            } else {
                errore.add("1");
                datamodel.put("errore",errore);
                TemplateController.process("reset-pwd.ftl", datamodel, response, getServletContext());
        }

    }
}
