package controller;

import controller.utility.SecurityHash;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.security.*;
import java.util.List;

public class data extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        AziendaDaoImp daoaz = new AziendaDaoImp();
        try{

            List<Azienda> az = new ArrayList<>();
            az = daoaz.getAllAzienda();
            for(Azienda azienda : az) {

                System.out.println(azienda.getRagioneSociale());
            }

            daoaz.destroy();
        }catch(Exception e){ e.printStackTrace();}





        /*try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/webdb2");
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bella");

            while (rs.next()) {


                int id = rs.getInt("nome");
                System.out.println(id);
            }


        } catch (NamingException ex) {
            ex.printStackTrace();

        } catch (SQLException sq) {
            sq.printStackTrace();

        }*/

    }
}
