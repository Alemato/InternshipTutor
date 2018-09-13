package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTirocinanteController extends BackEndTrController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ifCarica(request,response);
        }
        protected void caricadati(HttpServletRequest request ,HttpServletResponse response)throws IOException{
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tirocinante = session.getTirocinate(request,response);
            User user = session.getUserTirocinante(request,response);
            datamodel.put("Tirocinante",tirocinante);
            datamodel.put("User",user);
            TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, getServletContext());

        }
        protected void ifCarica(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        super.init(request,response);
        if(super.loginTirocinante(request,response)){
            if(super.accessTirocinante(request,response)){
                caricadati(request,response);
            }
        }
        }
}
