package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImpostazioniAzienda extends baseController {

    protected Azienda ritornaAzienda(SingSessionContoller session, HttpServletRequest request, HttpServletResponse response) throws IOException{
        return session.getAzienda(request,response);
    }

    protected User ritornUser(Azienda azienda) throws DaoException{
        UserDaoImp dao = new UserDaoImp();
        User user = dao.getUserByid(azienda.getUser());
        dao.destroy();
        return user;
    }

    protected void caricaDatiAzineda(Azienda azienda, User user){
        datamodel.put("email", user.getEmail());
        datamodel.put("descrizione", azienda.getDescrizione());
        System.out.println(azienda.getDescrizione());
        datamodel.put("link", azienda.getLink());
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request,response);
        if ((int)request.getAttribute("tipo") == 3){
            SingSessionContoller session = SingSessionContoller.getInstance();
            Azienda azienda = ritornaAzienda(session, request, response);
            try {
                User user = ritornUser(azienda);
                caricaDatiAzineda(azienda,user);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, getServletContext());
        }
        else response.sendRedirect("/403");
    }
}
