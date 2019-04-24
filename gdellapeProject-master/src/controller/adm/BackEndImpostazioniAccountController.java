package controller.adm;

import controller.adm.Azienda.ImpostazioniAccountAzienda;
import controller.adm.Tirocinante.ImpostazioniAccountTirocinante;
import controller.baseController;
import dao.exception.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackEndImpostazioniAccountController extends baseController {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        int tipo= (int)request.getAttribute("tipo");
        if (tipo == 3){
            ImpostazioniAccountAzienda az = new ImpostazioniAccountAzienda(request, response, getServletContext(), datamodel);
            try {
                az.get();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else if (tipo == 2){
            ImpostazioniAccountTirocinante tr = new ImpostazioniAccountTirocinante(request, response, getServletContext(), datamodel);
            try {
                tr.get();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/500");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        int tipo= (int)request.getAttribute("tipo");
        if (tipo == 3){
            ImpostazioniAccountAzienda az = new ImpostazioniAccountAzienda(request, response, getServletContext(), datamodel);
            try {
                az.post();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else if (tipo == 2){
            ImpostazioniAccountTirocinante tr = new ImpostazioniAccountTirocinante(request, response, getServletContext(), datamodel);
            try {
                tr.post();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/500");
        }
    }
}
