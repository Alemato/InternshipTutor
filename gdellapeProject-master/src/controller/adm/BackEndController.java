package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import org.apache.catalina.Session;
import view.TemplateController;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import java.io.IOException;

public class BackEndController extends baseController {

    protected void access(HttpServletRequest request, HttpServletResponse response) throws DaoException,IOException,SerialException {

        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isValidSession(request)) {


            if (session.isAdmin(request)) {


            }
            if (session.isTirocinante(request)) {
                TemplateController.process("my-account-tirocinante.ftl", datamodel, response, getServletContext());


            }
            if (session.isAzienda(request)) {
                TemplateController.process("my-account-azienda.ftl", datamodel, response, getServletContext());

            }


        }else
            {response.sendRedirect("/login");}
    }




    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{  super.init(request,response);
            access(request,response);



        }catch (Exception e){
            e.printStackTrace();

        }


    }






}
