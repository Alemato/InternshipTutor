package controller.adm.Azienda;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import model.Azienda;
import view.TemplateController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class BackEndAziendaController extends baseController{
    protected Boolean accessLogin(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(!(session.isValidSession(request))){

                response.sendRedirect("/login");
                return false;

        }else{return true;}
    }
    protected Boolean accessAzienda(HttpServletRequest request, HttpServletResponse response)throws IOException,ServerException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if( !(session.isValidSession(request))&&session.isAzienda(request)){

            response.sendRedirect("/401");
            return false;

        }else{return true;}
    }
    protected Azienda getAzienda(HttpServletRequest request, HttpServletResponse response) throws IOException,ServerException
    {

            if (!(accessAzienda(request, response) && accessLogin(request, response))) {
               response.sendRedirect("/401");
               throw new ServerException("Errore accesso");
            }
            SingSessionContoller session = SingSessionContoller.getInstance();
        return (session.getAzienda(request, response));

    }


    protected void init(HttpServletRequest request,HttpServletResponse response)throws IOException,ServerException{
      try {
          super.init(request,response);

      }catch (Exception e){
          e.printStackTrace();
      }


    }
}
