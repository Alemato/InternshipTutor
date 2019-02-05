package controller.adm.Admin;

import controller.baseController;
import controller.sessionController.SingSessionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndAdminController extends baseController{
    protected Boolean accessLogin(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))){

                response.sendRedirect("/login");
                return false;

        }else{return true;}
    }
    protected Boolean accessAzienda(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if( !(session.isValidSession(request))){

            response.sendRedirect("/401");
            return false;

        }else{return true;}
    }

    protected void init(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException{
      try {
          super.init(request,response);

      }catch (Exception e){
          e.printStackTrace();
      }


    }
}
