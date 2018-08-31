package controller.adm.Azienda;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import view.TemplateController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndAziendaController extends baseController{
    protected void accessLogin(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))){

                response.sendRedirect("/login");

        }
    }
    protected void accessAzienda(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if( !(session.isValidSession(request))){

            response.sendRedirect("/401");

        }
    }

    protected void init(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException{
        accessLogin(request,response);
        accessAzienda(request,response);

    }
}
