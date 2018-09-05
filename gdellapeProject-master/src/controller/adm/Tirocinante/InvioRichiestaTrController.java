package controller.adm.Tirocinante;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.RichiestaTirocinioDaoImp;
import model.OffertaTirocinio;
import model.RichiestaTirocinio;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InvioRichiestaTrController extends BackEndTrController  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        sendRichiestaTr(request,response);
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
    protected void sendRichiestaTr(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            super.init(request, response);

            int idOfTr = Integer.parseInt(request.getParameter("Tirocinio"));


            SingSessionContoller session = SingSessionContoller.getInstance();
            int idAccount = session.getUserId(request);


            RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();
            richiestaTirocinio.setTirocinante(idAccount);
            richiestaTirocinio.setOffertaTirocinio(idOfTr);

            RichiestaTirocinioDaoImp rc = new RichiestaTirocinioDaoImp();
            rc.setRichiestatr(richiestaTirocinio);
        }catch (Exception e){
            e.printStackTrace();
        }





    }

}
