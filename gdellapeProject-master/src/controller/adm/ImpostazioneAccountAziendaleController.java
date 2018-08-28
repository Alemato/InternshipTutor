package controller.adm;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImpostazioneAccountAziendaleController extends baseController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
    protected void ricaricadatiazienda(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(session.isAzienda(request)&& session.isAzienda(request)){

        }
    }
}
