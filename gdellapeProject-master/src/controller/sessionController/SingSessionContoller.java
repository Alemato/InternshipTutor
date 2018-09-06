package controller.sessionController;

import com.sun.deploy.net.HttpRequest;
import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Calendar;


public class SingSessionContoller {
    private static SingSessionContoller ourInstance = new SingSessionContoller();

    public static SingSessionContoller getInstance() {
        return ourInstance;
    }

    private SingSessionContoller() {

    }

    //sono minuti
    private int time_life = 15;


    //la uso alla login
    public HttpSession initSession(HttpServletRequest request, Object account) {
        HttpSession session = request.getSession(true);

        if (account instanceof Tirocinante) {
            Tirocinante tirocinante = (Tirocinante) account;
            session.setAttribute("IDUnivoco", tirocinante.getIDTirocinante());
            session.setAttribute("Tipo", "Tirocinante");
            session.setAttribute("Nome", tirocinante.getNome());

        } else if (account instanceof Admin) {
            Admin admin = (Admin) account;
            session.setAttribute("IDUnivoco", admin.getIDadmin());
            session.setAttribute("Tipo", "Admin");
            session.setAttribute("Nome",admin.getNome());

        } else if (account instanceof Azienda) {
            Azienda azienda = (Azienda) account;
            session.setAttribute("IDUnivoco", azienda.getIDAzienda());
            session.setAttribute("Tipo", "Azienda");
            session.setAttribute("Nome",azienda.getRagioneSociale());
        }
        //poi lo vediamo
        session.setMaxInactiveInterval(time_life * 60);


        return session;
    }


    public void destroy(HttpServletRequest request) {
        HttpSession session= request.getSession();
        session.invalidate();


    }

    //prima di fare la loging mi serve una funzione che sanifica i dati inseriti

    public boolean isValidSession(HttpServletRequest request) {
        return (request.getSession(false) != null);
    }


    public Object getAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String tipo = (String) session.getAttribute("Tipo");
        int id = (int)session.getAttribute("IDUnivoco");

        switch (tipo) {
            case "Admin":
                try {
                    AdminDaoImp daoImp = new AdminDaoImp();
                    Admin admin = daoImp.getAdminByID(id);
                    daoImp.destroy();
                    return admin;


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case "Azienda":

                try {
                    AziendaDaoImp daoImp = new AziendaDaoImp();
                    Azienda az = daoImp.getAziendaByID(id);
                    daoImp.destroy();
                    return az;


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Tirocinante":

                try {
                    TirocinanteDaoImp daotr = new TirocinanteDaoImp();
                    Tirocinante tr = daotr.getTirocianteByID(id);
                    daotr.destroy();
                    return tr;



                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;



        }
        return null;



    }
    public boolean login(String mail , String password) throws DaoException{
        UserDaoImp dao = new UserDaoImp();

        User user = dao.getUserByMail(mail);
        if(user.getPassword().equals(password)){
            return true;

        }else {return false;}


    }
    public boolean isAccount(String mail) throws DaoException{

            UserDaoImp dao = new UserDaoImp();
            User user = dao.getUserByMail(mail);
            if(user != null){return true;}
            else {return false;}


    }
    public HttpSession getSession(HttpServletRequest request){
        if(isValidSession(request)){
            return request.getSession();
        }else return null;
    }
    public Integer getUserId(HttpServletRequest request){
        if(isValidSession(request)){
             HttpSession session = request.getSession();
             Integer id = Integer.parseInt((String)session.getAttribute("IDUnivoco"));
             return id;
        }else return null;
    }
    public boolean isAdmin(HttpServletRequest request) {
        if(isValidSession(request)) {
            HttpSession session = getSession(request);
            String tipo = (String) session.getAttribute("Tipo");
            if (tipo.equals("Admin")) {
                return true;
            }
        }
        return false;

    }
    public boolean isTirocinante(HttpServletRequest request) {
        if(isValidSession(request)){
            HttpSession session = getSession(request);
            String tipo = (String) session.getAttribute("Tipo");

            if(tipo.equals("Tirocinante")){
                return true;
            }
        }
        return false;
    }
    public boolean isAzienda(HttpServletRequest request){
        if(isValidSession(request)){
            HttpSession session = getSession(request);
            String tipo = (String) session.getAttribute("Tipo");
            if(tipo.equals("Azienda")){
                return true;
            }
        }
        return false;
    }
   /* non fuziona bo vediamo
    public User getUser(HttpServletRequest request,HttpServletResponse response)throws DaoException {



        int IDuser;
        User user = new User();
        HttpSession session = getSession(request);
        String tipo = (String) session.getAttribute("Tipo");
        Object account = getAccount(request);
        UserDaoImp dao = new UserDaoImp();


        if (tipo.equals("Admin")) {

            Admin admin = (Admin) account;
            IDuser = admin.getUser();

            user = dao.getUserByid(IDuser);
            dao.destroy();
        }

        if (tipo.equals("Azienda")) {

            Azienda azienda = (Azienda) account;
            IDuser = azienda.getUser();

            user = dao.getUserByid(IDuser);
            dao.destroy();

        }

        if (tipo.equals("Tirocinante")) {

            Tirocinante tirocinante = (Tirocinante) account;
            IDuser = tirocinante.getUser();

            user = dao.getUserByid(IDuser);
            dao.destroy();


        }
        return user;

    }*/





}




