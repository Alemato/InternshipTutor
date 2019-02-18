package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
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
    protected Azienda azienda;
    protected User user;

    public ImpostazioniAccountAzienda(HttpServletRequest request, HttpServletResponse response, ServletContext context, Map<String, Object> datamodel){
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = null;
        this.user = null;
    }

    private Azienda ritornaAzienda(SingSessionContoller session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return session.getAzienda(request,response);
    }

    private User ritornUser(Azienda azienda) throws DaoException {
        UserDaoImp dao = new UserDaoImp();
        User user = dao.getUserByid(azienda.getUser());
        dao.destroy();
        return user;
    }

    private void scaricaDatiAzinedaDB(Azienda azienda, User user){
        datamodel.put("email", user.getEmail());
        datamodel.put("descrizione", azienda.getDescrizione());
        datamodel.put("link", azienda.getLink());
    }

    private void creaOggetti() throws IOException, DaoException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        this.azienda = ritornaAzienda(session, request, response);
        this.user = ritornUser(azienda);
    }

    private void changeEmail(String email, String emailAttuale){
        String emailAttuleDB = user.getEmail();
        if (emailAttuleDB.equals(emailAttuale)){
            user.setEmail(email);
            try {
                UserDaoImp userDao = new UserDaoImp();
                userDao.update(user);
                userDao.destroy();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private void updateAzienda(){
        if(request.getParameter("Email").isEmpty()){
            System.out.println("email vuota");
        }else{
            if(!request.getParameter("EmailNuova").isEmpty()) {
                changeEmail(request.getParameter("EmailNuova"), request.getParameter("Email"));
            }
        }
        if(request.getParameter("Password").isEmpty()){
            System.out.println("password vuota");
        }
        if (request.getParameter("PasswordNuova").isEmpty()){
            System.out.println("password nuova vuota");
        }
        if (request.getParameter("PasswordNuova1").isEmpty()){
            System.out.println("password nuova1 vuota");
        }
        if (request.getParameter("Descrizione").isEmpty()){
            System.out.println("descrizione vuota");
        }
        if (request.getParameter("Link").isEmpty()){
            System.out.println("link vuota");
        }

//        try {
//            AziendaDaoImp aziendaDao = new AziendaDaoImp();
//            aziendaDao.updateAzienda(azienda);
//            aziendaDao.destroy();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public void get() throws IOException, DaoException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountAzienda");
        creaOggetti();
        scaricaDatiAzinedaDB(azienda,user);
        TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
    }

    public void post() throws IOException, DaoException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountAzienda");
        creaOggetti();
        updateAzienda();
    }
}
