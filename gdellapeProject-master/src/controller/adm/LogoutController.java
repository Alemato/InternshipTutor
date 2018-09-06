package controller.adm;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import controller.baseController;

public class LogoutController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            logout(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }



    }
    protected void logout(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        session.destroy(request);
       response.sendRedirect("/home");


    }
}
