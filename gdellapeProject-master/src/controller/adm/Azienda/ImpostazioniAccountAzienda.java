package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.User;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ImpostazioniAccountAzienda {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;

    public ImpostazioniAccountAzienda(HttpServletRequest request, HttpServletResponse response, ServletContext context, Map<String, Object> datamodel){
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
    }

    protected Azienda ritornaAzienda(SingSessionContoller session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return session.getAzienda(request,response);
    }
    protected User ritornUser(Azienda azienda) throws DaoException {
        UserDaoImp dao = new UserDaoImp();
        User user = dao.getUserByid(azienda.getUser());
        dao.destroy();
        return user;
    }

    protected void caricaDatiAzineda(Azienda azienda, User user){
        datamodel.put("email", user.getEmail());
        datamodel.put("descrizione", azienda.getDescrizione());
        datamodel.put("link", azienda.getLink());
    }
    public void get() throws IOException, DaoException {
        System.out.println(request.getRequestURI()+" sto in ImpostazioniAccountAzienda");
        SingSessionContoller session = SingSessionContoller.getInstance();
        Azienda azienda = ritornaAzienda(session, request, response);
        User user = ritornUser(azienda);
        caricaDatiAzineda(azienda,user);
        TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
    }
}
