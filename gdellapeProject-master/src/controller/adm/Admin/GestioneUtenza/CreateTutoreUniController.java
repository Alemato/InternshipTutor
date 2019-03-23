package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.TutoreUniversitario;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateTutoreUniController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateTutore(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }


   private void CreateTutore(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
           TutoreUniversitario tutore = new TutoreUniversitario();

           tutore.setNome(request.getParameter("nome"));
           tutore.setCognome(request.getParameter("cognome"));
           tutore.setEmail(request.getParameter("email"));
           tutore.setTelefono(request.getParameter("telefono"));
           TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
           dao.setTutoreUni(tutore);
           dao.destroy();
            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
