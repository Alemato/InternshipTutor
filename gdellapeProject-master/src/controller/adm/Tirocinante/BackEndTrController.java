package controller.adm.Tirocinante;
import controller.baseController;
import controller.sessionController.SingSessionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndTrController extends baseController {
    protected void loginTirocinante(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))){
            response.sendRedirect("/login");
        }
    }
    protected void accessTirocinante(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isTirocinante(request))){
            response.sendRedirect("/401");
        }
    }
    protected void init(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
        try{
            loginTirocinante(request,response);
            accessTirocinante(request,response);
        }catch (Exception e){
            e.printStackTrace();
            //devi mettere errore 500
        }
    }
}
