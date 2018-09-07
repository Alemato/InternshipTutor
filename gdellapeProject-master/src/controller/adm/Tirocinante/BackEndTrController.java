package controller.adm.Tirocinante;
import controller.baseController;
import controller.sessionController.SingSessionContoller;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndTrController extends baseController {
    protected Boolean loginTirocinante(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException,ServletException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))) {
          response.sendRedirect("/login");
          return false;
        }else{return true;}
    }
    protected Boolean accessTirocinante(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException,ServletException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isTirocinante(request))){
            response.sendRedirect("/401");
            return false;

        }else{return true;}
    }
    protected void init(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
        try{
            super.init(request,response);

        }catch (Exception e){
            e.printStackTrace();
            //devi mettere errore 500
        }
    }
}
