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

        ricaricadatiazienda(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            caricaAccount(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void ricaricadatiazienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           super.init(request, response);
           SingSessionContoller session = SingSessionContoller.getInstance();
           Azienda azienda = (Azienda) session.getAccount(request);
           UserDaoImp dao = new UserDaoImp();
           User user = dao.getUserByid(azienda.getIDAzienda());
           dao.destroy();

           if (!(request.getParameter("Password").isEmpty()) && !(request.getParameter("PasswordNuova").isEmpty()) && !(request.getParameter("PasswordNuova1").isEmpty())) {
               changePassword(request, user);
           }
           System.out.println(request.getParameterMap().containsKey("Email"));
           user.setEmail(request.getParameter("Email"));

           azienda.setRagioneSociale(request.getParameter("NomeAzienda"));
           azienda.setIndirizzoSedeLegale(request.getParameter("SedeLegale"));
           azienda.setCFiscalePIva(request.getParameter("PartitaIVA"));
           azienda.setNomeLegaleRappresentante(request.getParameter("NomeRappresentante"));
           azienda.setCognomeLegaleRappresentante(request.getParameter("CognomeRappresentante"));
           azienda.setNomeResponsabileConvenzione(request.getParameter("NomeResponsabile"));
           azienda.setCognomeLegaleRappresentante(request.getParameter("CognomeResponsabile"));
           azienda.setTelefonoResponsabileConvenzione(request.getParameter("NumeroTelefonoResponsabile"));
           azienda.setEmailResponsabileConvenzione(request.getParameter("EmailResponsabile"));
           azienda.setForoControversia(request.getParameter("ForoControversia"));
           azienda.setDescrizione(request.getParameter("Descrizione"));
           azienda.setLink(request.getParameter("Link"));
           UserDaoImp userdao = new UserDaoImp();
           userdao.update(user);
           userdao.destroy();

           AziendaDaoImp azdao = new AziendaDaoImp();
           azdao.updateAzienda(azienda);
           azdao.destroy();
           response.sendRedirect("/account");
       }catch (Exception e){
           e.printStackTrace();

           //devi mette
       }







    }
    protected void chagemail(HttpServletRequest request,User user) throws ServerException,IOException{
        try {
            String email = request.getParameter("Email");
            user.setEmail(email);
            UserDaoImp dao = new UserDaoImp();
            dao.update(user);
            dao.destroy();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    protected void changePassword(HttpServletRequest request,User user)throws ServerException,IOException{
        String realpassword = user.getPassword();
        String password = request.getParameter("Password");
        String nuovaPassword = request.getParameter("PasswordNuova");
        String nuovaPassword1 = request.getParameter("PasswordNuova1");
        if(password.isEmpty() && nuovaPassword.isEmpty() && nuovaPassword1.isEmpty()){


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

            }else{}
        }else {}


        }

    }

    protected void caricaAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isValidSession(request)&& session.isAzienda(request)) {
            Azienda azienda = (Azienda) session.getAccount(request);
            UserDaoImp dao = new UserDaoImp();
            User user = dao.getUserByid(azienda.getIDAzienda());
            dao.destroy();
            datamodel.put("Azienda", azienda);
            datamodel.put("User",user);
            TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, getServletContext());

        }
    }
}
