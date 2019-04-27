package controller.adm.Tirocinante;
import controller.baseController;
import controller.sessionController.SingSessionContoller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackEndTrController extends baseController {
     protected Boolean loginTirocinante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))) {
          response.sendRedirect("/login");
          return false;
        }else{return true;}
    }
   protected Boolean accessTirocinante(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isTirocinante(request))){
            RequestDispatcher page = request.getRequestDispatcher("/401");
            page.forward(request,response);
            return false;

        }else{return true;}
    }
    protected void init(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        try{
            super.init(request,response);

        }catch (Exception e){
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }
}
