package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import controller.utility.SecurityHash;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Tirocinante;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.sql.Date;

import static controller.utility.Validation.isValidEmailAddress;

public class ImpostazioniAccountTirocinante {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    protected Tirocinante tirocinante;
    protected User user;
    private Boolean modificato;
    private Boolean modificatoTir;
    private Boolean modificatoUser;
    private Boolean sessionescaduta;
    private Boolean errori;

    public ImpostazioniAccountTirocinante(HttpServletRequest request, HttpServletResponse response, ServletContext context, Map<String, Object> datamodel) {
        this.request = request;
        this.response = response;
        this.context = context;
        this.datamodel = datamodel;
        this.tirocinante = null;
        this.user = null;
        this.modificato = false;
        this.modificatoTir = false;
        this.modificatoUser = false;
        this.sessionescaduta = false;
        this.errori = false;
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private Tirocinante ritornaTirocinante(SingSessionContoller session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return session.getTirocinate(request, response);
    }

    private User ritornUser(Tirocinante tirocinante) throws DaoException {
        UserDaoImp dao = new UserDaoImp();
        User user = dao.getUserByid(tirocinante.getUser());
        dao.destroy();
        return user;
    }

    private void checkModificaUser() {
        if (!modificatoUser && !errori) {
            this.modificatoUser = true;
        }
    }

    private void checkModificaTirocinante() {
        if (!modificatoTir && !errori) {
            this.modificatoTir = true;
        }
    }

    private void checkSessioneAndModifica() {
        if ((!errori && !modificato) || (!errori && !sessionescaduta)) {
            this.modificato = true;
            this.sessionescaduta = true;
        }
    }

    private void chekErrori() {
        if (!errori) {
            this.errori = true;
            this.modificato = false;
        }
    }


    private void scaricaDatiTirocinanteDB(User user, Tirocinante tirocinante) {
        datamodel.put("email", user.getEmail());
        datamodel.put("Tirocinante", tirocinante);

    }

    private void creaOggetti() throws IOException, ServletException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        try {

            this.tirocinante = ritornaTirocinante(session, request, response);
            this.user = ritornUser(tirocinante);
        } catch (DaoException e) {
            e.printStackTrace();
            er500(request, response);
        }
    }

//    private static boolean isValidEmailAddress(String email) {
//        boolean result = true;
//        try {
//            InternetAddress emailAddr = new InternetAddress(email);
//            emailAddr.validate();
//        } catch (AddressException ex) {
//            result = false;
//        }
//        return result;
//    }

    private void changeEmilTir(String email, String emailRipetuta) {
        System.out.println("le email inserite sono " + email + " " + emailRipetuta);
        String emailAttuleDB = user.getEmail();
        if (email.equals(emailRipetuta)) {
            if (isValidEmailAddress(email)) {
                if (!emailAttuleDB.equals(email)) {
                    System.out.println("Modifico l'email ");
                    user.setEmail(email); // setto la nuova email
                    checkSessioneAndModifica(); // cambio le flag
                    checkModificaUser();
                } else {
                    System.out.println("l'email attuale coincide con quella del DB");
                    String messaggio = HtmlEscape.escapeHtml5("l'email inserita coincide con quella del DB");
                    datamodel.put("MesWarningEmail", messaggio);
                }
            } else {
                System.out.println("l'email non è valida");
                String messaggio = HtmlEscape.escapeHtml5("l'email non è valida");
                datamodel.put("MesErrorEmailValidation", messaggio);
                chekErrori();
            }
        } else {
            System.out.println("l'email nuova non coincide con l'altra");
            String messaggio = HtmlEscape.escapeHtml5("l'email nuova non coincide con l'altra");
            datamodel.put("MesErrorEmail", messaggio);
            chekErrori();
        }
    }


    private void changePasswordTir(String password, String passwordRipetuta, String passwordAttuale) {
        System.out.println("le pwd inserite sono " + password + " " + passwordRipetuta);
        if (SecurityHash.equals(passwordAttuale, user)) {
            if (password.equals(passwordRipetuta)) {
                if (!SecurityHash.equals(password, user)) {
                    user.setPassword(SecurityHash.SetHash(password));
                    System.out.println("Modifico la password");
                    checkSessioneAndModifica(); // cambio le flag
                    checkModificaUser();
                } else {
                    System.out.println("la password nuova è identica alla Attuale");
                    String messaggio = HtmlEscape.escapeHtml5("la password nuova è identica alla Attuale");
                    datamodel.put("MesWarningPWD", messaggio);
                }

            } else {
                System.out.println("la password nuova non coincide con l'altra");
                String messaggio = HtmlEscape.escapeHtml5("la password nuova non coincide con l'altra");
                datamodel.put("MesErrorValidationPWD", messaggio);
            }
        } else {
            System.out.println("la password attuale non coincide con quella del DB");
            String messaggio = HtmlEscape.escapeHtml5("la password attuale non coincide con quella del DB");
            datamodel.put("MesErrorValidationPWD", messaggio);
        }
    }

    private void updateTirocinante(Tirocinante tirocinante) throws ServletException, IOException, DaoException {
        User userAttuale = user;
        String passwordAttuale;
        String emailAttuale;
        Tirocinante tirocinanteMod;
        tirocinanteMod = tirocinante;

        if (request.getParameter("EmailAttuale").isEmpty() || request.getParameter("PasswordAttuale").isEmpty()) {
            System.out.println("Modifiche non consentite, manchano l'email o la password");
            String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite manchano l'email o la password");
            datamodel.put("MesError", messaggio);
        } else {
            emailAttuale = request.getParameter("EmailAttuale");
            passwordAttuale = request.getParameter("PasswordAttuale");
            //if(emailAttuale.equals(userAttuale.getEmail()) && passwordAttuale.equals(userAttuale.getPassword())){
            if (emailAttuale.equals(userAttuale.getEmail()) && SecurityHash.equals(passwordAttuale, userAttuale)) {
                if (!request.getParameter("Email").isEmpty() && !request.getParameter("EmailRipetuta").isEmpty()) {
                    changeEmilTir(request.getParameter("Email"), request.getParameter("EmailRipetuta"));
                } else if (request.getParameter("Email").isEmpty()) {
                    System.out.println("email nuova vuota");

                } else if (request.getParameter("EmailRipetuta").isEmpty()) {
                    System.out.println("email nuova Ripetuta vuota");
                }

                if (!request.getParameter("Password").isEmpty() && !request.getParameter("PasswordRipetuta").isEmpty()) {
                    changePasswordTir(request.getParameter("Password"), request.getParameter("PasswordRipetuta"), passwordAttuale);
                } else if (request.getParameter("Password").isEmpty()) {
                    System.out.println("password nuova vuota");

                } else if (request.getParameter("PasswordRipetuta").isEmpty()) {
                    System.out.println("password nuova Ripetuta vuota");
                }


                if (!(request.getParameter("Nome").isEmpty())) {
                    tirocinanteMod.setNome(request.getParameter("Nome"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("Cognome").isEmpty())) {
                    tirocinanteMod.setCognome(request.getParameter("Cognome"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("LuogoNascita").isEmpty())) {
                    tirocinanteMod.setLuogoDiNascita(request.getParameter("LuogoNascita"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("ProvinciaNascita").isEmpty())) {
                    tirocinanteMod.setProvinciaDiNascita(request.getParameter("ProvinciaNascita"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("LuogoResidenza").isEmpty())) {
                    tirocinanteMod.setLuogoDiResidenza(request.getParameter("LuogoResidenza"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("ProvinciaResidenza").isEmpty())) {
                    tirocinanteMod.setProvinciaDiResidenza(request.getParameter("ProvinciaResidenza"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("CodiceFiscale").isEmpty())) {
                    tirocinanteMod.setCodiceFiscale(request.getParameter("CodiceFiscale"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("Telefono").isEmpty())) {
                    tirocinanteMod.setTelefono(request.getParameter("Telefono"));
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("DataNascita").isEmpty())) {
                    tirocinanteMod.setDataDiNascita(Date.valueOf(request.getParameter("DataNascita")));
                    checkModificaTirocinante();
                }
                if (!(request.getParameter("Handicap") == null)) {
                    if (!(request.getParameter("Handicap").isEmpty())) {
                        if (request.getParameter("Handicap").equals("Si")) {
                            tirocinanteMod.setHandicap(true);
                            checkModificaTirocinante();
                        } else if (request.getParameter("Handicap").equals("No")) {
                            tirocinante.setHandicap(false);
                            checkModificaTirocinante();
                        }
                    }
                }

                if (!(request.getParameter("CKStudenteCorsoLaurea") == null)) {
                    if (request.getParameter("CKStudenteCorsoLaurea").equals("1")) {
                        if (!(request.getParameter("StudenteCorsoLaurea").isEmpty())) {
                            tirocinanteMod.setCorsoDiLaurea(request.getParameter("StudenteCorsoLaurea"));
                            checkModificaTirocinante();
                        }
                    }
                }else {
                    tirocinanteMod.setCorsoDiLaurea(null);
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("CKDiplomaUniversitario") == null)) {
                    if (request.getParameter("CKDiplomaUniversitario").equals("1")) {
                        if (!(request.getParameter("DiplomaUniversitario").isEmpty())) {
                            tirocinanteMod.setDiplomaUniversitario(request.getParameter("DiplomaUniversitario"));
                            checkModificaTirocinante();
                        }
                    }
                }else {
                    tirocinanteMod.setDiplomaUniversitario(null);
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("CKLaureaIn") == null)) {
                    if (request.getParameter("CKLaureaIn").equals("1")) {
                        if (!(request.getParameter("LaureaIn").isEmpty())) {
                            tirocinanteMod.setLaureato(request.getParameter("LaureaIn"));
                            checkModificaTirocinante();
                        }
                    }
                }else {
                    tirocinanteMod.setLaureato(null);
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("CKDottoratoRicerca") == null)) {
                    if (request.getParameter("CKDottoratoRicerca").equals("1")) {
                        if (!(request.getParameter("DottoratoRicerca").isEmpty())) {
                            tirocinanteMod.setDottoratoDiRicerca(request.getParameter("DottoratoRicerca"));
                            checkModificaTirocinante();
                        }
                    }
                }else {
                    tirocinanteMod.setDottoratoDiRicerca(null);
                    checkModificaTirocinante();
                }

                if (!(request.getParameter("CKScuolaAltro") == null)) {
                    if (request.getParameter("CKScuolaAltro").equals("1")) {
                        if (!(request.getParameter("ScuolaAltro").isEmpty())) {
                            tirocinanteMod.setScuolaAltro(request.getParameter("ScuolaAltro"));
                            checkModificaTirocinante();
                        }
                    }
                }else {
                    tirocinanteMod.setScuolaAltro(null);
                    checkModificaTirocinante();
                }

                if (modificatoTir) {
                    System.out.println(tirocinanteMod);
                    System.out.println("applico le modifiche");
                    datamodel.put("ModApp", "Le modifiche sono state salvate");
                    TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
                    tirocinanteDaoImp.setUpdate(tirocinanteMod);
                    tirocinanteDaoImp.destroy();
                }
                if (modificatoUser) {
                    UserDaoImp userDaoImp = new UserDaoImp();
                    userDaoImp.update(user);
                    userDaoImp.destroy();

                }

            } else {
                System.out.println("Modifiche non consentite non conincidono l'email o la password email: " + emailAttuale + "  " + user.getEmail() + "  password: " + passwordAttuale + "  " + user.getPassword());
                String messaggio = HtmlEscape.escapeHtml5("Modifiche non consentite non conincidono l'email o la password");
                datamodel.put("MesError", messaggio);
            }
        }
    }

    public void get() throws IOException, ServletException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI() + " sto in ImpostazioniAccountTirocinante");
        creaOggetti();
        scaricaDatiTirocinanteDB(user, tirocinante);
        TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, context);
    }

    public void post() throws IOException, ServletException {
        System.out.println(request.getMethod() + ' ' + request.getRequestURI() + " sto in ImpostazioniAccountTirocinante");
        creaOggetti();
        try {
            updateTirocinante(tirocinante);
        } catch (DaoException e) {
            e.printStackTrace();
            er500(request, response);
        }
        if (!sessionescaduta) {
            scaricaDatiTirocinanteDB(user, tirocinante);
            TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, context);
        }else {
            response.sendRedirect("/logout");
        }
    }
}
