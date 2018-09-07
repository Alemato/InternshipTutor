package controller.adm.Tirocinante;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.RichiestaTirocinioDaoImp;
import model.OffertaTirocinio;
import model.RichiestaTirocinio;
import model.Tirocinante;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InvioRichiestaTrController extends BackEndTrController  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        Send(request,response);
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
    protected void sendRichiestaTr(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {


            Integer idOfTr = Integer.parseInt(request.getParameter("Tirocinio"));


            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante Account = (Tirocinante) session.getAccount(request);


            RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio();
            richiestaTirocinio.setTirocinante(Account.getIDTirocinante());
            richiestaTirocinio.setOffertaTirocinio(idOfTr);

            RichiestaTirocinioDaoImp rc = new RichiestaTirocinioDaoImp();
            rc.firstRichiestatr(richiestaTirocinio);
            rc.destroy();
            response.sendRedirect("/home");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    protected void ifsend(HttpServletRequest request, HttpServletResponse response){
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tr = (Tirocinante) session.getAccount(request);
            RichiestaTirocinioDaoImp dao = new RichiestaTirocinioDaoImp();
            Boolean status = dao.ifAreactiveOfferteByTr(tr);
            if(status){
                String idOfferta = request.getParameter("Tirocinio");
                response.sendRedirect("/Tirocinio?ID="+idOfferta);
            }else{sendRichiestaTr(request,response);}
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Send(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        if(super.loginTirocinante(request,response)){
            if(super.accessTirocinante(request,response)){
                ifsend(request,response);
            }
        }
    }



}
