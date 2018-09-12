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
import java.io.IOException;
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





    public Tirocinante getTirocinate(HttpServletRequest request,HttpServletResponse response)throws IOException {
        Tirocinante tr = new Tirocinante();
        try {
        HttpSession session = request.getSession();


        int id = (int)session.getAttribute("IDUnivoco");
        if(isTirocinante(request)){


                TirocinanteDaoImp daotr = new TirocinanteDaoImp();
                tr = daotr.getTirocianteByID(id);
                daotr.destroy();
        }else{
            response.sendRedirect("/500");}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr;



    }



    public Admin getAdmin(HttpServletRequest request,HttpServletResponse response)throws IOException {
        Admin admin = new Admin();
        try{
        HttpSession session = request.getSession();


        int id = (int)session.getAttribute("IDUnivoco");
        if(isAdmin(request)){

                AdminDaoImp daoImp = new AdminDaoImp();
                admin = daoImp.getAdminByID(id);
                daoImp.destroy();
        }else{
            response.sendRedirect("/500");}

        } catch (Exception e) {
        e.printStackTrace();
    }
        return admin;


    }

    public Azienda getAzienda(HttpServletRequest request,HttpServletResponse response)throws IOException {

        Azienda az = new Azienda();
        try{
        HttpSession session = request.getSession();
        int id = (int)session.getAttribute("IDUnivoco");
        if(isAzienda(request)){



                    AziendaDaoImp daoImp = new AziendaDaoImp();
                    az = daoImp.getAziendaByID(id);
                    daoImp.destroy();
        }else{
            response.sendRedirect("/500");}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return az;




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




