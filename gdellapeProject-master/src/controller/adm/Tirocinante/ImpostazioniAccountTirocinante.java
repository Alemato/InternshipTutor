package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.Tirocinante;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.sql.Date;


public class ImpostazioniAccountTirocinante {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected Tirocinante tirocinante;
    protected User user;
    private Boolean modificato;
    private Boolean sessionescaduta;

    public ImpostazioniAccountTirocinante (HttpServletRequest request, HttpServletResponse response, ServletContext context, Map<String, Object> datamodel){
        this.request = request;
        this.response = response;
        this.context = context;
        this.datamodel = datamodel;
        this.tirocinante = null;
        this.user = null;
        this.modificato = false;
        this.sessionescaduta = false;
    }

    private Tirocinante ritornaTirocinante(SingSessionContoller session, HttpServletRequest request, HttpServletResponse response) throws IOException{
        return session.getTirocinate(request,response);
    }

    private User ritornUser(Tirocinante tirocinante) throws DaoException {
        UserDaoImp dao = new UserDaoImp();
        User user = dao.getUserByid(tirocinante.getUser());
        dao.destroy();
        return user;
    }

    private void checkSessioneAndModifica(){
        if(!modificato || !sessionescaduta) {
            this.modificato = true;
            this.sessionescaduta = true;
        }
    }


    private void scaricaDatiTirocinanteDB( User user, Tirocinante tirocinante){
        datamodel.put("email", user.getEmail());
        datamodel.put("Tirocinante", tirocinante);

    }

    private void creaOggetti() throws IOException, DaoException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        this.tirocinante = ritornaTirocinante(session, request, response);
        this.user = ritornUser(tirocinante);
    }

    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    private void changeEmilTir(String email, String emailRipetuta){
        System.out.println("le email inserite sono " + email + " " + emailRipetuta);
        String emailAttuleDB = user.getEmail();
        if (email.equals(emailRipetuta)){
            if(isValidEmailAddress(email)) {
                if(!emailAttuleDB.equals(email)) {
                    System.out.println("Modifico l'email ");
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
            }
        } else{
            System.out.println("l'email nuova non coincide con l'altra");
            String messaggio = HtmlEscape.escapeHtml5("l'email nuova non coincide con l'altra");
            datamodel.put("MesErrorEmail", messaggio);
        }
    }

    private void changePasswordTir(String password, String passwordRipetuta, String passwordAttuale){
        System.out.println("le pwd inserite sono " + password + " " + passwordRipetuta);
        String passwordAttualeDB = user.getPassword();
        if (passwordAttualeDB.equals(passwordAttuale)){
            if(password.equals(passwordRipetuta)) {
                if (!passwordAttualeDB.equals(password)){
                    user.setEmail(password); // setto la nuova password
                    System.out.println("Modifico la password");
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
            }
        }else {
            System.out.println("la password attuale non coincide con quella del DB");
            String messaggio = HtmlEscape.escapeHtml5("la password attuale non coincide con quella del DB");
            datamodel.put("MesErrorValidationPWD", messaggio);
        }
    }
    //TODO tirocinantemod per aggiornare il db

    private void updateTirocinante(Tirocinante tirocinante) {
        User userAttuale = user;
        String passwordAttuale;
        String emailAttuale;
        Tirocinante tirocinanteMod = new Tirocinante();
        tirocinanteMod = tirocinante;

        if (!(request.getParameter("Nome").isEmpty())){
            tirocinanteMod.setNome(request.getParameter("Nome"));
        }

        if (!(request.getParameter("Cognome").isEmpty())){
            tirocinanteMod.setCognome(request.getParameter("Cognome"));
        }

        if (!(request.getParameter("LuogoNascita").isEmpty())){
            tirocinanteMod.setLuogoDiNascita(request.getParameter("LuogoNascita"));
        }

        if (!(request.getParameter("ProvinciaNascita").isEmpty())){
            tirocinanteMod.setProvinciaDiNascita(request.getParameter("ProvinciaNascita"));
        }

        if (!(request.getParameter("luogoDiResidenza").isEmpty())){
            tirocinanteMod.setLuogoDiResidenza(request.getParameter("luogoDiResidenza"));
        }

        if (!(request.getParameter("provinciaDiResidenza").isEmpty())){
            tirocinanteMod.setProvinciaDiResidenza(request.getParameter("provinciaDiResidenza"));
        }

        if (!(request.getParameter("codiceFiscale").isEmpty())){
            tirocinanteMod.setCodiceFiscale(request.getParameter("codiceFiscale"));
        }

        if (!(request.getParameter("telefono").isEmpty())){
            tirocinanteMod.setTelefono(request.getParameter("telefono"));
        }

        if (!(request.getParameter("Nascita").isEmpty())){
            tirocinanteMod.setDataDiNascita(Date.valueOf(request.getParameter("Nascita")));
        }

        if (!(request.getParameter("StudenteCorsoLaurea").isEmpty())){
            tirocinanteMod.setCorsoDiLaurea(request.getParameter("StudenteCorsoLaurea"));
        }

        if (!(request.getParameter("handicap").isEmpty())){
            if (request.getParameter("handicap").equals("Si"))
                tirocinanteMod.setHandicap(true);
            else if (request.getParameter("handicap").equals("No"))
                tirocinante.setHandicap(false);
        }

        if (request.getParameter("EmailAttuale").isEmpty() || request.getParameter("PasswordAttuale").isEmpty()){
            System.out.println("Modifiche non consentite, manchano l'email o la password");
            String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite manchano l'email o la password");
            datamodel.put("MesError", messaggio);
        }else {
            emailAttuale = request.getParameter("EmailAttuale");
            passwordAttuale = request.getParameter("PasswordAttuale");
            if(emailAttuale.equals(userAttuale.getEmail()) && passwordAttuale.equals(userAttuale.getPassword())){

                if(!request.getParameter("Email").isEmpty() && !request.getParameter("EmailRipetuta").isEmpty()) {
                    changeEmilTir(request.getParameter("Email"), request.getParameter("EmailRipetuta"));
                }
                else if (request.getParameter("Email").isEmpty()){
                    System.out.println("email nuova vuota");

                }else  if (request.getParameter("EmailRipetuta").isEmpty()){
                    System.out.println("email nuova Ripetuta vuota");
                }

                if(!request.getParameter("Password").isEmpty() && !request.getParameter("PasswordRipetuta").isEmpty()){
                    changePasswordTir(request.getParameter("Password"),request.getParameter("PasswordRipetuta"),passwordAttuale);
                }
                else if (request.getParameter("Password").isEmpty()){
                    System.out.println("password nuova vuota");

                }else  if (request.getParameter("PasswordRipetuta").isEmpty()){
                    System.out.println("password nuova Ripetuta vuota");
                }


            } else {
                System.out.println("Modifiche non consentite non conincidono l'email o la password email: " + emailAttuale + "  " + user.getEmail()  + "  password: "+ passwordAttuale + "  " + user.getPassword() );
                String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite non conincidono l'email o la password email");
                datamodel.put("MesError", messaggio);
            }
        }
    }

    public void get() throws IOException, DaoException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountTirocinante");
        creaOggetti();
        scaricaDatiTirocinanteDB(user, tirocinante);
        TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, context);
    }

    public void post() throws IOException, DaoException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI()+" sto in ImpostazioniAccountTirocinante");
        creaOggetti();
        updateTirocinante(tirocinante);
        if(!sessionescaduta){
            scaricaDatiTirocinanteDB(user, tirocinante);
            TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, context);
        }
    }
}
