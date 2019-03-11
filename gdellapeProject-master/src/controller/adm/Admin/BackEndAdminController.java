package controller.adm.Admin;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndAdminController extends HttpServlet {

    public static Tirocinante getTirocinante(HttpServletRequest request,HttpServletResponse response,int idtr) throws IOException, ServletException
    {
        Tirocinante tirocinante=  new Tirocinante();

        try {
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tr = dao.getTirocianteByID(idtr);
            dao.destroy();
            tirocinante=tr;
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return tirocinante;

    }

    public static User getUser(HttpServletRequest request, HttpServletResponse response,int iduser) throws IOException, ServletException
    {
        User user= new User();

        try {
            UserDaoImp dao = new UserDaoImp();
            user=dao.getUserByid(iduser);
            dao.destroy();

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return user;

    }
    public static Admin getAdmin(HttpServletRequest request, HttpServletResponse response,int idAdmin) throws IOException, ServletException
    {
       Admin admin= new Admin();

        try {
            AdminDaoImp dao = new AdminDaoImp();
            admin = dao.getAdminByID(idAdmin);
            dao.destroy();

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return admin;


    }
    public static Azienda getAzienda(HttpServletRequest request, HttpServletResponse response,int idAzienda)throws IOException,ServletException
    {
        Azienda azienda= new Azienda();

        try {
          AziendaDaoImp dao = new AziendaDaoImp();
           azienda=dao.getAziendaByID(idAzienda);
           dao.destroy();
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return azienda;

    }
    public static Tirocinio getTirocinio(HttpServletRequest request, HttpServletResponse response,int idTirocinio)throws IOException,ServletException
    {
       Tirocinio tirocinio=new Tirocinio();

        try {
           TirocinioDaoImp dao = new TirocinioDaoImp();
           tirocinio=dao.getRichiestatrByID(idTirocinio);
           dao.destroy();

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return tirocinio;

    }
    public static TutoreUniversitario getTutoreUni(HttpServletRequest request, HttpServletResponse response,int idtut)throws IOException,ServletException
    {
        TutoreUniversitario tutuni=new TutoreUniversitario();

        try {
            TutoreUniversitarioDaoImp dao= new TutoreUniversitarioDaoImp();
            tutuni=dao.getTutoreUniByID(idtut);
            dao.destroy();

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return tutuni;

    }
    public static OffertaTirocinio getOffertaTr(HttpServletRequest request, HttpServletResponse response,int idOf)throws IOException,ServletException
    {
       OffertaTirocinio Offtirocinio=new OffertaTirocinio();

        try {
           OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
           Offtirocinio = dao.getOffertatrByID(idOf);
           dao.destroy();

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return Offtirocinio;

    }


}
