package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

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

    public void finalize(){System.out.println("object is garbage collected");}

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
        System.out.println("Azienda: " + azienda.toString());
        System.out.println("User: " + user.toString());
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
        return password.equals(user.getPassword());
    }

    private Boolean checkEmail(String email){
        return email.equals(user.getEmail());
    }


    private void changeEmail(String email, String emailRipetuta){
        System.out.println("le email inserite sono " + email + " " + emailRipetuta);
        String emailAttuleDB = user.getEmail();
        if (email.equals(emailRipetuta)){
            if(isValidEmailAddress(email)) {
                if(!emailAttuleDB.equals(email)) {
                    System.out.println("Modifico l' email ");
                    user.setEmail(email); // setto la nuova email
                    checkSessioneAndModifica(); // cambio le flag
                } else{
                    System.out.println("l'email attuale coincide con quella del DB");
                    String messaggio = HtmlEscape.escapeHtml5("l'email inserita coincide con quella del DB");
                    datamodel.put("MesWarningEmail", messaggio);
                }
            } else{
                System.out.println("l'email non è valida");
                String messaggio = HtmlEscape.escapeHtml5("l'email non è valida");
                datamodel.put("MesErrorEmailValidation", messaggio);
                chekErrori();
            }
        } else{
            System.out.println("l'email nuova non coincide con l'altra");
            String messaggio = HtmlEscape.escapeHtml5("l'email nuova non coincide con l'altra");
            datamodel.put("MesErrorEmail", messaggio);
            chekErrori();
        }
    }

    private void changePassword(String password, String passwordRipetuta, String passwordAttuale){
        System.out.println("le pwd inserite sono " + password + " " + passwordRipetuta);
        String passwordAttualeDB = user.getPassword();
        if (passwordAttualeDB.equals(passwordAttuale)){
            if(password.equals(passwordRipetuta)) {
                if (!passwordAttualeDB.equals(password)){
                    user.setEmail(password); // setto la nuova password
                    System.out.println("Modifico la pwd");
                    checkSessioneAndModifica(); // cambio le flag
                }else {
                    System.out.println("la password nuova è identica alla Attuale");
                    String messaggio = HtmlEscape.escapeHtml5("la password nuova è identica alla Attuale");
                    datamodel.put("MesWarningPWD", messaggio);
                }

            } else {
                System.out.println("la password nuova non coincide con l'altra");
                String messaggio = HtmlEscape.escapeHtml5("la password nuova non coincide con l'altra");
                datamodel.put("MesErrorValidationPWD", messaggio);
                chekErrori();
            }
        }else {
            System.out.println("la password attuale non coincide con quella del DB");
            String messaggio = HtmlEscape.escapeHtml5("la password attuale non coincide con quella del DB");
            datamodel.put("MesErrorPWD", messaggio);
            chekErrori();
        }
    }

    private void changeDescizione(String email, String password, String
                                  newDescrizione){
        System.out.println("la descrizione inserita è: " + newDescrizione);
        newDescrizione = HtmlEscape.escapeHtml5(newDescrizione); // Html Esceping
        if(!newDescrizione.equals(azienda.getDescrizione())){
            System.out.println("Modifico Descrizione ");
            azienda.setDescrizione(newDescrizione);
            checkModifica();
        } else {
            System.out.println("la descrizione è uguale a prima");
            String messaggio = HtmlEscape.escapeHtml5("la descrizione è uguale a prima");
            datamodel.put("MesWarningDEC", messaggio);
            }
    }

    private void changeLink(String email, String password, String
            newLink) {
        System.out.println("il linck inserito è " + newLink);
        if(!newLink.equals(azienda.getLink())){
            System.out.println("Modifico linck ");
            azienda.setLink(newLink);
            checkModifica();
        }else {
            System.out.println("il link è uguale a prima");
            String messaggio = HtmlEscape.escapeHtml5("il link è uguale a prima");
            datamodel.put("MesWarningLink", messaggio);
        }
    }

    private void updateAzienda(){
        User userAttuale = user;
        Azienda azziendaAttuale = azienda;
        String passwordAttuale;
        String emailAttuale;
        // Verifico la presenza dell'email e della password Attuale che mi serve per sicurezza
        if (request.getParameter("EmailAttuale").isEmpty() || request.getParameter("PasswordAttuale").isEmpty()){
            System.out.println("Modifiche non consentite manchano l'email o la password");
            String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite manchano l'email o la password");
            datamodel.put("MesError", messaggio);
        }else {
            emailAttuale = request.getParameter("EmailAttuale");
            passwordAttuale = request.getParameter("PasswordAttuale");
            if(emailAttuale.equals(userAttuale.getEmail()) && passwordAttuale.equals(userAttuale.getPassword())){

                // Modifico l'email primaria a cui segue l'INVALIDAZIONE DELLA SESSIONE
                if(!request.getParameter("Email").isEmpty() && !request.getParameter("EmailRipetuta").isEmpty()) {
                    changeEmail(request.getParameter("Email"), request.getParameter("EmailRipetuta"));
                }
                else if (request.getParameter("Email").isEmpty()){
                    System.out.println("email nuova vuota");

                }else  if (request.getParameter("EmailRipetuta").isEmpty()){
                    System.out.println("email nuova Ripetuta vuota");
                }

                // Modifico la password a cui segue l'INVALIDAZIONE DELLA SESSIONE
                if(!request.getParameter("Password").isEmpty() && !request.getParameter("PasswordRipetuta").isEmpty()){
                    changePassword(request.getParameter("Password"),request.getParameter("PasswordRipetuta"),passwordAttuale);
                }
                else if (request.getParameter("Password").isEmpty()){
                    System.out.println("password nuova vuota");

                }else  if (request.getParameter("PasswordRipetuta").isEmpty()){
                    System.out.println("password nuova Ripetuta vuota");
                }

                // Modifico la descrizione
                if (request.getParameter("Descrizione").isEmpty()){
                    System.out.println("descrizione vuota");
                } else {
                    changeDescizione(emailAttuale,passwordAttuale,request.getParameter("Descrizione"));
                }

                // Modifico il link
                if (request.getParameter("Link").isEmpty()){
                    System.out.println("link vuota");
                }else {
                    changeLink(emailAttuale,passwordAttuale,request.getParameter("Link"));
                }

                if (modificato){
                    System.out.println("applico le modifiche");
                    datamodel.put("ModApp", "Le modifiche sono state salvate");
                    //TODO implementare il salvataggio

                }else {
                    System.out.println("non applico le modifiche");
                }

                // Controllo se devo salvare qualche modifica
                /*if(modificato){
                    System.out.println("modificato");
                    // vedo chi è stato modificato e salvo le modifiche

                    if(user.equals(userAttuale)) {
                        try {
                            UserDaoImp userDao = new UserDaoImp();
                            userDao.update(user);
                            userDao.destroy();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if(azienda.equals(azziendaAttuale)){
                        try {
                            AziendaDaoImp aziendaDao = new AziendaDaoImp();
                            aziendaDao.updateAzienda(azienda);
                            aziendaDao.destroy();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }

                // Controllo se devo INVALIDARE LA SESSIONE
                if(sessionescaduta){
                    System.out.println("sessione scaduta");
                }

                */

            } else {
                System.out.println("Modifiche non consentite non conincidono l'email o la password email: " + emailAttuale + "  " + user.getEmail()  + "  password: "+ passwordAttuale + "  " + user.getPassword() );
                String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite non conincidono l'email o la password email");
                datamodel.put("MesError", messaggio);
            }
        }

    }

    public void get() throws IOException, DaoException {
        //TODO Inserire NomeResponsabileConvenzione CognomeResponsabileConvenzione TelefonoResponsabileConvenzione EmailResponsabileConvenzione
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountAzienda");
        creaOggetti();
        scaricaDatiAzinedaDB(azienda,user);
        TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
    }

    public void post() throws IOException, DaoException {
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountAzienda");
        creaOggetti();
        updateAzienda();
        if(!sessionescaduta){
            scaricaDatiAzinedaDB(azienda,user);
            TemplateController.process("impostazione-account-aziendale.ftl", datamodel, response, context);
        }else {
            System.out.println("sessione invalidata");
        }
    }
}
