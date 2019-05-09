package controller;

import dao.implementation.AziendaDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class data extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        AziendaDaoImp daoaz = new AziendaDaoImp();
        try{

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
