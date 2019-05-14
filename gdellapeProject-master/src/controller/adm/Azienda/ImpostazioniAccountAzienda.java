package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import controller.utility.SecurityHash;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;
import view.TemplateControllerMail;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static controller.utility.Validation.isValidEmailAddress;

public class ImpostazioniAccountAzienda {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected Azienda azienda;
    protected User user;
    private Boolean modificato;
    private Boolean sessionescaduta;
    private Boolean errori;

    public void finalize(){}

    public ImpostazioniAccountAzienda(HttpServletRequest request, HttpServletResponse response, ServletContext context, Map<String, Object> datamodel){
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = null;
        this.user = null;
        this.modificato = false;
        this.sessionescaduta = false;
        this.errori = false;
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

    private void chekErrori(){
        if(!errori){
            this.errori = true;
            this.modificato = false;
        }
    }

    private  void checkModifica(){
        if(!modificato && !errori){
            this.modificato = true;
        }
    }

    private void checkSessioneAndModifica(){
        if((!errori && !modificato) || (!errori && !sessionescaduta)) {
            this.modificato = true;
            this.sessionescaduta = true;
        }
    }

    private Boolean checkPassword(String password){
        return SecurityHash.equals(password, user);
    }

    private Boolean checkEmail(String email){
        return email.equals(user.getEmail());
    }


    private void changeEmail(String email, String emailRipetuta){
        String emailAttuleDB = user.getEmail();
        if (email.equals(emailRipetuta)){
            if(isValidEmailAddress(email)) {
                if(!emailAttuleDB.equals(email)) {
                    user.setEmail(email); // setto la nuova email
                    checkSessioneAndModifica(); // cambio le flag
                } else{
                    String messaggio = HtmlEscape.escapeHtml5("l'email inserita coincide con quella del DB");
                    datamodel.put("MesWarningEmail", messaggio);
                }
            } else{
                String messaggio = HtmlEscape.escapeHtml5("l'email non è valida");
                datamodel.put("MesErrorEmailValidation", messaggio);
                chekErrori();
            }
        } else{
            String messaggio = HtmlEscape.escapeHtml5("l'email nuova non coincide con l'altra");
            datamodel.put("MesErrorEmail", messaggio);
            chekErrori();
        }
    }

    private void changePassword(String password, String passwordRipetuta, String passwordAttuale){

        //String passwordAttualeDB = user.getPassword();
        //if (passwordAttualeDB.equals(passwordAttuale)){
        if(SecurityHash.equals(passwordAttuale, user)){
            if(password.equals(passwordRipetuta)) {
                //if (!passwordAttualeDB.equals(password)){
                if(!SecurityHash.equals(password, user)){
                    //user.setEmail(password); // setto la nuova password
                    user.setPassword(SecurityHash.SetHash(password));
                    checkSessioneAndModifica(); // cambio le flag
                }else {
                    String messaggio = HtmlEscape.escapeHtml5("la password nuova è identica alla Attuale");
                    datamodel.put("MesWarningPWD", messaggio);
                }

            } else {
                String messaggio = HtmlEscape.escapeHtml5("la password nuova non coincide con l'altra");
                datamodel.put("MesErrorValidationPWD", messaggio);
                chekErrori();
            }
        }else {
            String messaggio = HtmlEscape.escapeHtml5("la password attuale non coincide con quella del DB");
            datamodel.put("MesErrorPWD", messaggio);
            chekErrori();
        }
    }

    private void changeDescizione(String email, String password, String
                                  newDescrizione){
        newDescrizione = HtmlEscape.escapeHtml5(newDescrizione); // Html Esceping
        if(!newDescrizione.equals(azienda.getDescrizione())){
            azienda.setDescrizione(newDescrizione);
            checkModifica();
        } else {
            String messaggio = HtmlEscape.escapeHtml5("la descrizione è uguale a prima");
            datamodel.put("MesWarningDEC", messaggio);
            }
    }

    private void changeLink(String email, String password, String
            newLink) {
        if(!newLink.equals(azienda.getLink())){
            azienda.setLink(newLink);
            checkModifica();
        }else {
            String messaggio = HtmlEscape.escapeHtml5("il link è uguale a prima");
            datamodel.put("MesWarningLink", messaggio);
        }
    }

    private void salvaAzienda(Azienda azienda) throws DaoException {
        AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
        aziendaDaoImp.updateAzienda(azienda);
        aziendaDaoImp.destroy();
    }

    private void salvaUser(User user) throws DaoException {
        UserDaoImp userDaoImp = new UserDaoImp();
        userDaoImp.update(user);
        userDaoImp.destroy();
    }

    private void updateAzienda(){
        User userAttuale = user;
        Azienda azziendaAttuale = azienda;
        boolean sendemail = false;
        String passwordAttuale;
        String emailAttuale;
        // Verifico la presenza dell'email e della password Attuale che mi serve per sicurezza
        if (request.getParameter("EmailAttuale").isEmpty() || request.getParameter("PasswordAttuale").isEmpty()){
            String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite manchano l'email o la password");
            datamodel.put("MesError", messaggio);
        }else {
            emailAttuale = request.getParameter("EmailAttuale");
            passwordAttuale = request.getParameter("PasswordAttuale");
//            if(emailAttuale.equals(userAttuale.getEmail()) && passwordAttuale.equals(userAttuale.getPassword())){
            if(emailAttuale.equals(userAttuale.getEmail()) && SecurityHash.equals(passwordAttuale, userAttuale)){
                // Modifico l'email primaria a cui segue l'INVALIDAZIONE DELLA SESSIONE
                if(!request.getParameter("Email").isEmpty() && !request.getParameter("EmailRipetuta").isEmpty()) {
                    changeEmail(request.getParameter("Email"), request.getParameter("EmailRipetuta"));
                }
                else if (request.getParameter("Email").isEmpty()){

                }else  if (request.getParameter("EmailRipetuta").isEmpty()){
                }

                // Modifico la password a cui segue l'INVALIDAZIONE DELLA SESSIONE
                if(!request.getParameter("Password").isEmpty() && !request.getParameter("PasswordRipetuta").isEmpty()){
                    changePassword(request.getParameter("Password"),request.getParameter("PasswordRipetuta"),passwordAttuale);
                    sendemail = true;
                }
                else if (request.getParameter("Password").isEmpty()){

                }else  if (request.getParameter("PasswordRipetuta").isEmpty()){
                }

                // Modifico la descrizione
                if (request.getParameter("Descrizione").isEmpty()){
                } else {
                    changeDescizione(emailAttuale,passwordAttuale,request.getParameter("Descrizione"));
                }

                // Modifico il link
                if (request.getParameter("Link").isEmpty()){
                }else {
                    changeLink(emailAttuale,passwordAttuale,request.getParameter("Link"));
                }

                if (modificato){
                    try {
                        salvaAzienda(azienda);
                        salvaUser(user);
                        datamodel.put("ModApp", "Le modifiche sono state salvate");
                        if(sendemail){
                            String[] to = new String[1];
                            to[0] = "azienda@matteifamily.net";
                            String subject = "Notifica di avvenuta modifica della password";
                            TemplateControllerMail.process("email/modifica-password.ftl", datamodel, to, subject, request.getServletContext());
                        }
                        if(sessionescaduta){
                            SingSessionContoller session = SingSessionContoller.getInstance();
                            session.destroy(request);
                            response.sendRedirect("/login");
                        }
                    } catch (DaoException | IOException e) {
                        e.printStackTrace();
                    }
                }else {
                }

            } else {
                String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite non conincidono l'email o la password email");
                datamodel.put("MesError", messaggio);
            }
        }

    }

    public void get() throws IOException, DaoException {
        //TODO Inserire NomeResponsabileConvenzione CognomeResponsabileConvenzione TelefonoResponsabileConvenzione EmailResponsabileConvenzione
        creaOggetti();
        scaricaDatiAzinedaDB(azienda,user);
        TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
    }

    public void post() throws IOException, DaoException {
        creaOggetti();
        updateAzienda();
        if(!sessionescaduta){
            scaricaDatiAzinedaDB(azienda,user);
            TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
        }else {
        }
    }
}
