package controller.adm.Azienda;
import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
import model.Azienda;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class ImpostazioneAccountAziendaleController extends BackEndAziendaController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request,response);
        serveletUpdateAzienda(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    serveltgetUpdateAzienda(request,response);

    }

    protected void ricaricadatiazienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           super.init(request, response);
           SingSessionContoller session = SingSessionContoller.getInstance();
           Azienda azienda = session.getAzienda(request,response);


           UserDaoImp dao = new UserDaoImp();
           User user = dao.getUserByid(azienda.getUser());



           if (!(request.getParameter("Password").isEmpty())) {
               changePassword(request,response, user);
           }

           user.setEmail(request.getParameter("Email"));


           azienda.setDescrizione((String)request.getParameter("Descrizione"));

           azienda.setLink(request.getParameter("Link"));


           dao.update(user);
           dao.destroy();

           AziendaDaoImp azdao = new AziendaDaoImp();
           azdao.updateAzienda(azienda);
           azdao.destroy();
           response.sendRedirect("/account");


       }catch (Exception e){
          e.printStackTrace();


       }







    }

    protected void changePassword(HttpServletRequest request,HttpServletResponse response,User user)throws ServerException,IOException{
        try {
            String realpassword = user.getPassword();
            String password = request.getParameter("Password");
            String nuovaPassword = request.getParameter("PasswordNuova");
            String nuovaPassword1 = request.getParameter("PasswordNuova1");
            if(password.isEmpty() && nuovaPassword.isEmpty() && nuovaPassword1.isEmpty()){
                reloadOldInfomation(request,response,"Rimpire Tutti i campi per cambire la password");


            }
            else{
                if(realpassword.equals(password)){

                    if(nuovaPassword.equals(nuovaPassword1)){
                        user.setPassword(nuovaPassword);
                        try {
                            UserDaoImp dao = new UserDaoImp();
                            dao.update(user);
                            dao.destroy();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }else{reloadOldInfomation(request,response,"Vecchia password non corretta");}
                }else {reloadOldInfomation(request,response,"Le password sono differenti");}


            }
        }catch (Exception e){
            e.printStackTrace();

        }


    }
    protected void reloadOldInfomation(HttpServletRequest request,HttpServletResponse response,String errorMessage)throws ServletException,IOException{
        Azienda azienda = new Azienda();
        User user = new User();
        user.setEmail(request.getParameter("Email"));


        azienda.setDescrizione(request.getParameter("Descrizione"));
        azienda.setLink(request.getParameter("Link"));
        datamodel.put("Azienda",azienda);
        datamodel.put("User",user);
        datamodel.put("Message",errorMessage);
        TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, getServletContext());
    }

    protected Boolean importantimputareload(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        if(request.getParameter("Email").isEmpty()){
            reloadOldInfomation(request,response,"Immettere mail valida");
            return false;
        }else{return true;}











    }

    protected void caricaAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isValidSession(request)&& session.isAzienda(request)) {
            Azienda azienda = session.getAzienda(request,response);
            UserDaoImp dao = new UserDaoImp();
            User user = dao.getUserByid(azienda.getUser());
            dao.destroy();
            datamodel.put("Azienda", azienda);
            datamodel.put("User",user);
            TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, getServletContext());

        }
    }
    protected void serveletUpdateAzienda(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        if(super.accessLogin(request,response)){
            if(super.accessAzienda(request,response)){
                if(importantimputareload(request,response)){
                    ricaricadatiazienda(request,response);
                }
            }
        }
    }
    protected void serveltgetUpdateAzienda(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try {
            if(super.accessLogin(request,response)){
                if(super.accessAzienda(request,response)){
                    caricaAccount(request, response);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
