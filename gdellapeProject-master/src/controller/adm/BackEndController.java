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

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{  super.init(request,response);

            switch ((int)request.getAttribute("tipo")) {
                case 0: response.sendRedirect("/403");
                    break;
                case 1: response.sendRedirect("/admin");
                    break;
                case 2: TemplateController.process("my-account-tirocinante.ftl", datamodel, response, getServletContext());
                    break;
                case 3: TemplateController.process("my-account-azienda.ftl", datamodel, response, getServletContext());
                    break;
                default: response.sendRedirect("/500");
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();

        }


    }






}
