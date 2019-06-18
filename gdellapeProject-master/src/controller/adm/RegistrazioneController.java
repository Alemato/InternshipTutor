package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.SecurityHash;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import org.unbescape.html.HtmlEscape;
import view.TemplateController;
import view.TemplateControllerMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

public class RegistrazioneController extends baseController {

    private boolean isLogged(HttpServletRequest request){
        SingSessionContoller session = SingSessionContoller.getInstance();
        if(session.isValidSession(request)){
            return session.isAdmin(request) || session.isAzienda(request) || session.isTirocinante(request);
        }
        return false;
    }

    private boolean primoControllo(String email,String password, String confermaPassword, String tipologia ){
        boolean validazione = true;
        if(Validation.isValidEmailAddress(email)){
            UserDaoImp userDaoImp = new UserDaoImp();
            try {
                User user = userDaoImp.getUserByMail(email);
                userDaoImp.destroy();
                validazione = false;
                datamodel.put("erroreEmail", true);
            } catch (DaoException e) {
                datamodel.put("email",email);
            }
        } else {
            validazione = false;
            datamodel.put("erroreEmail", true);
        }

        if(!password.isEmpty() && !confermaPassword.isEmpty()) {
            if (password.equals(confermaPassword)) {
                datamodel.put("password", password);
                datamodel.put("confermaPassword", confermaPassword);
            } else {
                validazione = false;
                datamodel.put("errorePassword", true);
            }
        }else {
            validazione = false;
            datamodel.put("errorePassword", true);
        }

        if(!(tipologia.equals("Tirocinante")||tipologia.equals("Ente-Azienda"))){
            validazione = false;
            datamodel.put("erroreTipologia", true);
        }

        return validazione;
    }

    private boolean primoStep(HttpServletRequest request){
        String email = "";
        String password = "";
        String confermaPassword ="";
        String tipologia ="";
        if(request.getParameter("Email") != null){
           if(!request.getParameter("Email").isEmpty()) {
               email = request.getParameter("Email");
           }
        }

        if(request.getParameter("Password") != null){
            if(!request.getParameter("Password").isEmpty()){
                password = request.getParameter("Password");
            }
        }

        if(request.getParameter("ConfermaPassword") != null){
            if(!request.getParameter("ConfermaPassword").isEmpty()){
                confermaPassword = request.getParameter("ConfermaPassword");
            }
        }

        if(request.getParameter("Tipologia") != null){
            if(!request.getParameter("Tipologia").isEmpty()){
                tipologia = request.getParameter("Tipologia");
            }
        }
        boolean primaValidazione = primoControllo(email,password,confermaPassword,tipologia);
        return primaValidazione;

    }

    private boolean secondoControlloAzienda(String nomeAzienda, String sedeLegale, String partitaIVA, String nomeRappresentante, String cognomeRappresentante, String nomeResponsabile, String cognomeResponsabile, String numeroTelefonoResponsabile, String emailResponsabile){
        boolean validazione = true;
        Map<String, Object> valNomeAzienda = Validation.text100(nomeAzienda, "Nome Azienda");
        Map<String, Object> valSedeLegale = Validation.text100(sedeLegale, "Sede Legale");
        Map<String, Object> valPatitaIVA = Validation.text50(partitaIVA, "Partita IVA");
        Map<String, Object> valNomeRappresentante= Validation.text50(nomeRappresentante, "Nome Rappresentante");
        Map<String, Object> valCognomeRappresentante = Validation.text100(cognomeRappresentante, "Cognome Rappresentante");
        Map<String, Object> valNomeResponsabile = Validation.text50(nomeResponsabile, "Nome Responsabile");
        Map<String, Object> valCognomeResponsabile = Validation.text50(cognomeResponsabile, "Cognome Responsabile");
        Map<String, Object> valEmailResponsabile = Validation.text100(emailResponsabile, "Email Responsabile");

        if((boolean)valNomeAzienda.get("valido")){
            datamodel.put("nomeAzineda", nomeAzienda);
        } else {
            validazione = false;
            datamodel.put("erroreNomeAzineda",valNomeAzienda.get("messaggio"));
        }

        if((boolean)valSedeLegale.get("valido")){
            datamodel.put("sedeLegale", sedeLegale);
        } else {
            validazione = false;
            datamodel.put("erroreSedeLegale",valSedeLegale.get("messaggio"));
        }

        if((boolean)valPatitaIVA.get("valido")){
            datamodel.put("partitaIVA", partitaIVA);
        } else {
            validazione = false;
            datamodel.put("errorePartitaIVA",valPatitaIVA.get("messaggio"));
        }

        if((boolean)valNomeRappresentante.get("valido")){
            datamodel.put("nomeRappresentante", nomeRappresentante);
        } else {
            validazione = false;
            datamodel.put("erroreNomeRappresentante",valNomeRappresentante.get("messaggio"));
        }

        if((boolean) valCognomeRappresentante.get("valido")){
            datamodel.put("cognomeRappresentante", cognomeRappresentante );
        } else {
            validazione = false;
            datamodel.put("erroreCognomeRappresentante",valCognomeRappresentante.get("messaggio"));
        }

        if((boolean) valNomeResponsabile.get("valido")){
            datamodel.put("nomeResponsabile", nomeResponsabile);
        } else {
            validazione = false;
            datamodel.put("erroreNomeResponsabile",valNomeResponsabile.get("messaggio"));
        }

        if((boolean) valCognomeResponsabile.get("valido")){
            datamodel.put("cognomeResponsabile", cognomeResponsabile);
        } else {
            validazione = false;
            datamodel.put("erroreCognomeResponsabile", valCognomeRappresentante.get("messaggio"));
        }

        if(Validation.isValidEmailAddress(emailResponsabile) && (boolean) valEmailResponsabile.get("valido")){
            datamodel.put("emailResponsabile",emailResponsabile);
        } else {
            validazione = false;
            datamodel.put("erroreEmailResponsabile", true);
        }

        datamodel.put("numeroTelefonoResponsabile", numeroTelefonoResponsabile);


        return validazione;
    }

    private  boolean secondoStepAzienda(HttpServletRequest request){
        String nomeAzienda = "";
        String sedeLegale = "";
        String partitaIVA = "";
        String nomeRappresentante="";
        String cognomeRappresentante="";
        String nomeResponsabile ="";
        String cognomeResponsabile ="";
        String numeroTelefonoResponsabile= "";
        String emailResponsabile="";

        if(request.getParameter("NomeAzienda")!=null){
            if(!request.getParameter("NomeAzienda").isEmpty()){
                nomeAzienda=request.getParameter("NomeAzienda");
            }
        }

        if(request.getParameter("SedeLegale")!=null){
            if(!request.getParameter("SedeLegale").isEmpty()){
                sedeLegale=request.getParameter("SedeLegale");
            }
        }

        if(request.getParameter("PartitaIVA")!=null){
            if(!request.getParameter("PartitaIVA").isEmpty()){
                partitaIVA=request.getParameter("PartitaIVA");
            }
        }

        if(request.getParameter("NomeRappresentante")!=null){
            if(!request.getParameter("NomeRappresentante").isEmpty()){
                nomeRappresentante=request.getParameter("NomeRappresentante");
            }
        }

        if(request.getParameter("CognomeRappresentante")!=null){
            if(!request.getParameter("CognomeRappresentante").isEmpty()){
                cognomeRappresentante=request.getParameter("CognomeRappresentante");
            }
        }

        if(request.getParameter("NomeResponsabile")!=null){
            if(!request.getParameter("NomeResponsabile").isEmpty()){
                nomeResponsabile=request.getParameter("NomeResponsabile");
            }
        }

        if(request.getParameter("CognomeResponsabile")!=null){
            if(!request.getParameter("CognomeResponsabile").isEmpty()){
                cognomeResponsabile=request.getParameter("CognomeResponsabile");
            }
        }

        if(request.getParameter("NumeroTelefonoResponsabile")!=null){
            if(!request.getParameter("NumeroTelefonoResponsabile").isEmpty()){
                numeroTelefonoResponsabile= request.getParameter("NumeroTelefonoResponsabile");
            } else datamodel.put("erroreNumeroTelefonoResponsabile", true);
        }

        if(request.getParameter("EmailResponsabile")!=null){
            if(!request.getParameter("EmailResponsabile").isEmpty()){
                emailResponsabile=request.getParameter("EmailResponsabile");
            }
        }

        boolean secondaValidazioneAzienda = secondoControlloAzienda(nomeAzienda,sedeLegale,partitaIVA,nomeRappresentante,cognomeRappresentante,nomeResponsabile,cognomeResponsabile,numeroTelefonoResponsabile,emailResponsabile);
        return secondaValidazioneAzienda;
    }

    private boolean secondoControlloTirocinante(String nome,String cognome,String luogoNascita,String provinciaNascita,String dataNascita,String luogoResidenza,String provinciaResidenza,String codiceFiscale,String numeroTelefono,Integer ckStudenteCorsoLaurea,String studenteCorsoLaurea,Integer ckDiplomaUniversitario,String diplomaUniversitario,Integer ckLaureaIn,String laureaIn,Integer ckDottoratoRicerca,String dottoratoRicerca,Integer ckScuolaAltro,String scuolaAltro,String handicap){
        boolean validazione = true;
        Map<String, Object> valNome = Validation.text100(nome, "Nome ");
        Map<String, Object> valCognome = Validation.text100(cognome, "Nome ");
        Map<String, Object> valProvinciaNascita = Validation.text50(provinciaNascita, "Provincia di Nascita");
        Map<String, Object> valProvinciaResidenza = Validation.text100(provinciaResidenza, "Provincia di Residenza");
        Map<String, Object> valCodiceFiscale= Validation.text100(codiceFiscale, "Codice Fiscale");
        Map<String, Object> valNumeroTelefono = Validation.text50(numeroTelefono, "Numero di Telefono");

        if((boolean)valNome.get("valido")){
            datamodel.put("nome", nome);
        } else {
            validazione = false;
            datamodel.put("erroreNome",valNome.get("messaggio"));
        }

        if((boolean)valCognome.get("valido")){
            datamodel.put("cognome", cognome);
        } else {
            validazione = false;
            datamodel.put("erroreCognome",valCognome.get("messaggio"));
        }

        if((boolean)valProvinciaNascita.get("valido")){
            datamodel.put("provinciaNascita", provinciaNascita);
        } else {
            validazione = false;
            datamodel.put("erroreProvinciaNascita",valProvinciaNascita.get("messaggio"));
        }

        if((boolean)valProvinciaResidenza.get("valido")){
            datamodel.put("provinciaResidenza", provinciaResidenza);
        } else {
            validazione = false;
            datamodel.put("erroreProvinciaResidenza",valProvinciaResidenza.get("messaggio"));
        }

        if((boolean)valCodiceFiscale.get("valido")){
            datamodel.put("codiceFiscale", codiceFiscale);
        } else {
            validazione = false;
            datamodel.put("erroreCodiceFiscale",valCognome.get("messaggio"));
        }

        if((boolean)valNumeroTelefono.get("valido")){
            datamodel.put("numeroTelefono", numeroTelefono);
        } else {
            validazione = false;
            datamodel.put("erroreNumeroTelefono",valCognome.get("messaggio"));
        }

        if(!luogoNascita.isEmpty()){
            datamodel.put("luogoNascita",luogoNascita);
        } else {
            validazione = false;
            datamodel.put("erroreLuogoNascita",true);
        }

        if(!dataNascita.isEmpty()){
            Date dataNascitaDate = java.sql.Date.valueOf(dataNascita);
            datamodel.put("dataNascita", dataNascitaDate);
        } else {
            validazione = false;
            datamodel.put("erroreDataNascita", true);
        }

        if(!luogoResidenza.isEmpty()){
            datamodel.put("luogoResidenza", luogoResidenza);
        } else {
            validazione = false;
            datamodel.put("erroreLuogoResidenza", true);
        }

        if(ckStudenteCorsoLaurea==1){
            if(!studenteCorsoLaurea.isEmpty()){
                datamodel.put("ckStudenteCorsoLaurea", ckStudenteCorsoLaurea);
                datamodel.put("studenteCorsoLaurea",studenteCorsoLaurea);
            } else {
                validazione = false;
                datamodel.put("erroreStudenteCorsoLaurea",true);
            }
        }

        if(ckDiplomaUniversitario==1){
            if(!diplomaUniversitario.isEmpty()){
                datamodel.put("ckDiplomaUniversitario", ckDiplomaUniversitario);
                datamodel.put("diplomaUniversitario",diplomaUniversitario);
            } else {
                validazione = false;
                datamodel.put("erroreDiplomaUniversitario",true);
            }
        }

        if(ckLaureaIn==1){
            if(!laureaIn.isEmpty()){
                datamodel.put("ckLaureaIn", ckLaureaIn);
                datamodel.put("laureaIn",laureaIn);
            } else {
                validazione = false;
                datamodel.put("erroreLaureaIn",true);
            }
        }

        if(ckDottoratoRicerca==1){
            if(!dottoratoRicerca.isEmpty()){
                datamodel.put("ckDottoratoRicerca", ckDottoratoRicerca);
                datamodel.put("dottoratoRicerca",dottoratoRicerca);
            } else {
                validazione = false;
                datamodel.put("erroreDottoratoRicerca",true);
            }
        }

        if(ckScuolaAltro==1){
            if(!scuolaAltro.isEmpty()){
                datamodel.put("ckScuolaAltro", ckScuolaAltro);
                datamodel.put("scuolaAltro",scuolaAltro);
            } else {
                validazione = false;
                datamodel.put("erroreScuolaAltro",true);
            }
        }

        if(handicap.equals("Si")||handicap.equals("NO")){
            datamodel.put("handicap",handicap);
        }else {
            validazione = false;
            datamodel.put("erroreHandicap", true);
        }

        return validazione;
    }

    private boolean secondoStepTirocinante(HttpServletRequest request){
        String nome="";
        String cognome="";
        String luogoNascita="";
        String provinciaNascita="";
        String dataNascita="";
        String luogoResidenza="";
        String provinciaResidenza="";
        String codiceFiscale="";
        String numeroTelefono="";
        Integer ckStudenteCorsoLaurea=0;
        String studenteCorsoLaurea="";
        Integer ckDiplomaUniversitario=0;
        String diplomaUniversitario="";
        Integer ckLaureaIn=0;
        String laureaIn="";
        Integer ckDottoratoRicerca=0;
        String dottoratoRicerca="";
        Integer ckScuolaAltro=0;
        String scuolaAltro="";
        String handicap="";

        if(request.getParameter("Nome")!=null){
            if(!request.getParameter("Nome").isEmpty()){
                nome=request.getParameter("Nome");
            }
        }

        if(request.getParameter("Cognome")!=null){
            if(!request.getParameter("Cognome").isEmpty()){
                cognome = request.getParameter("Cognome");
            }
        }

        if(request.getParameter("LuogoNascita")!=null){
            if(!request.getParameter("LuogoNascita").isEmpty()){
                luogoNascita = request.getParameter("LuogoNascita");
            }
        }

        if(request.getParameter("DataNascita")!=null){
            if(!request.getParameter("DataNascita").isEmpty()){
                dataNascita = request.getParameter("DataNascita");
            }
        }

        if(request.getParameter("ProvinciaResidenza")!=null){
            if(!request.getParameter("ProvinciaResidenza").isEmpty()){
                provinciaResidenza = request.getParameter("ProvinciaResidenza");
            }
        }

        if(request.getParameter("CodiceFiscale")!=null){
            if(!request.getParameter("CodiceFiscale").isEmpty()){
                codiceFiscale=request.getParameter("CodiceFiscale");
            }
        }

        if(request.getParameter("NumeroTelefono")!=null){
            if(!request.getParameter("NumeroTelefono").isEmpty()){
                numeroTelefono = request.getParameter("NumeroTelefono");
            }
        }

        if(request.getParameter("CKStudenteCorsoLaurea")!=null){
            if(!request.getParameter("CKStudenteCorsoLaurea").isEmpty()){
                ckStudenteCorsoLaurea=Integer.parseInt(request.getParameter("CKStudenteCorsoLaurea"));
            }
        }

        if(request.getParameter("StudenteCorsoLaurea")!=null){
            if(!request.getParameter("StudenteCorsoLaurea").isEmpty()){
                studenteCorsoLaurea=request.getParameter("StudenteCorsoLaurea");
            }
        }

        if(request.getParameter("CKDiplomaUniversitario")!=null){
            if(!request.getParameter("CKDiplomaUniversitario").isEmpty()){
                ckDiplomaUniversitario=Integer.parseInt(request.getParameter("CKDiplomaUniversitario"));
            }
        }

        if(request.getParameter("DiplomaUniversitario")!=null){
            if(!request.getParameter("DiplomaUniversitario").isEmpty()){
                diplomaUniversitario = request.getParameter("DiplomaUniversitario");
            }
        }

        if(request.getParameter("CKLaureaIn")!=null){
            if(!request.getParameter("CKLaureaIn").isEmpty()){
                ckLaureaIn= Integer.parseInt(request.getParameter("CKLaureaIn"));
            }
        }

        if(request.getParameter("LaureaIn")!=null){
            if(!request.getParameter("LaureaIn").isEmpty()){
                laureaIn=request.getParameter("LaureaIn");
            }
        }

        if(request.getParameter("CKDottoratoRicerca")!=null){
            if(!request.getParameter("CKDottoratoRicerca").isEmpty()){
                ckDottoratoRicerca=Integer.parseInt(request.getParameter("CKDottoratoRicerca"));
            }
        }

        if(request.getParameter("DottoratoRicerca")!=null){
            if(!request.getParameter("DottoratoRicerca").isEmpty()){
                dottoratoRicerca=request.getParameter("DottoratoRicerca");
            }
        }

        if(request.getParameter("CKScuolaAltro")!=null){
            if(!request.getParameter("CKScuolaAltro").isEmpty()){
                ckScuolaAltro=Integer.parseInt(request.getParameter("CKScuolaAltro"));
            }
        }

        if(request.getParameter("ScuolaAltro")!=null){
            if(!request.getParameter("ScuolaAltro").isEmpty()){
                scuolaAltro= request.getParameter("ScuolaAltro");
            }
        }

        if(request.getParameter("Handicap")!=null){
            if(!request.getParameter("Handicap").isEmpty()){
                handicap= request.getParameter("Handicap");
            }
        }

        if(request.getParameter("ProvinciaNascita")!=null){
            if(!request.getParameter("ProvinciaNascita").isEmpty()){
                provinciaNascita= request.getParameter("ProvinciaNascita");
            }
        }

        if(request.getParameter("LuogoResidenza")!=null){
            if(!request.getParameter("LuogoResidenza").isEmpty()){
                luogoResidenza= request.getParameter("LuogoResidenza");
            }
        }

        boolean valutazione = secondoControlloTirocinante( nome, cognome, luogoNascita, provinciaNascita, dataNascita, luogoResidenza, provinciaResidenza, codiceFiscale, numeroTelefono, ckStudenteCorsoLaurea, studenteCorsoLaurea, ckDiplomaUniversitario, diplomaUniversitario, ckLaureaIn, laureaIn, ckDottoratoRicerca, dottoratoRicerca, ckScuolaAltro, scuolaAltro, handicap);
        return valutazione;
    }

    private void deleteAccountAzienda(){
        UserDaoImp userDaoImp = new UserDaoImp();
        try {
            User user = userDaoImp.getUserByMail((String) datamodel.get("email"));
            userDaoImp.destroy();
            AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
            try{
                Azienda azienda = aziendaDaoImp.getAziendaByIDuser(user.getIDUser());
                aziendaDaoImp.destroy();
                AziendaDaoImp aziendaDaoImp1 = new AziendaDaoImp();
                aziendaDaoImp1.deleteAzienda(azienda);
            }catch (DaoException ex){
            }
            // posso distrugere
            UserDaoImp userDaoImp1 = new UserDaoImp();
            userDaoImp1.delete(user);
            userDaoImp1.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void caricoAccountAzienda() throws DaoException {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User();
        user.setEmail((String) datamodel.get("email"));
        user.setPassword(SecurityHash.SetHash((String) datamodel.get("password")));
        user.setTipologiaAccount(3);
        userDaoImp.setUser(user);
        userDaoImp.destroy();
        UserDaoImp userDaoImp1 = new UserDaoImp();
        user = userDaoImp1.getUserByMail((String) datamodel.get("email"));
        int idUser = user.getIDUser();
        AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
        Azienda azienda = new Azienda();
        azienda.setRagioneSociale((String) datamodel.get("nomeAzineda"));
        azienda.setIndirizzoSedeLegale((String) datamodel.get("sedeLegale"));
        azienda.setCFiscalePIva((String) datamodel.get("partitaIVA"));
        azienda.setNomeLegaleRappresentante((String) datamodel.get("nomeRappresentante"));
        azienda.setCognomeLegaleRappresentante((String) datamodel.get("cognomeRappresentante"));
        azienda.setNomeResponsabileConvenzione((String) datamodel.get("nomeResponsabile"));
        azienda.setCognomeResponsabileConvenzione((String) datamodel.get("cognomeResponsabile"));
        azienda.setTelefonoResponsabileConvenzione((String) datamodel.get("numeroTelefonoResponsabile"));
        azienda.setEmailResponsabileConvenzione((String) datamodel.get("emailResponsabile"));
        azienda.setUser(idUser);
        aziendaDaoImp.setRegisterazienda(azienda, user);
        aziendaDaoImp.destroy();
        AziendaDaoImp aziendaDaoImp1 = new AziendaDaoImp();
        azienda = aziendaDaoImp1.getAziendaByIDuser(idUser);
        aziendaDaoImp1.destroy();
        datamodel.put("nomeAzineda", azienda.getRagioneSociale());
        String[] to = new String[1];
        to[0]= "azienda@matteifamily.net";
        String subject = "Registrazione Azienda : " + HtmlEscape.unescapeHtml( azienda.getRagioneSociale()+" id:" + azienda.getIDAzienda());
        TemplateControllerMail.process("email/registrazione-azienda.ftl", datamodel, to, subject, getServletContext());
    }

    private void deleteAccountTirocinante(){
        UserDaoImp userDaoImp = new UserDaoImp();
        try {
            User user = userDaoImp.getUserByMail((String) datamodel.get("email"));
            userDaoImp.destroy();
            TirocinanteDaoImp tirocinanteDaoImp= new TirocinanteDaoImp();
            try{
                Tirocinante tirocinante = tirocinanteDaoImp.getTirocianteByIDuser(user.getIDUser());
                tirocinanteDaoImp.destroy();
                TirocinanteDaoImp tirocinanteDaoImp1= new TirocinanteDaoImp();
                tirocinanteDaoImp1.delete(tirocinante);
            }catch (DaoException ex){
            }
            // posso distrugere
            UserDaoImp userDaoImp1 = new UserDaoImp();
            userDaoImp1.delete(user);
            userDaoImp1.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void caricamentoTirocinante() throws DaoException {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User();
        user.setEmail((String) datamodel.get("email"));
        user.setPassword(SecurityHash.SetHash((String) datamodel.get("password")));
        user.setTipologiaAccount(2);
        userDaoImp.setUser(user);
        userDaoImp.destroy();
        UserDaoImp userDaoImp1 = new UserDaoImp();
        user = userDaoImp1.getUserByMail((String) datamodel.get("email"));
        int idUser = user.getIDUser();
        TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
        Tirocinante tirocinante = new Tirocinante();
        tirocinante.setNome((String) datamodel.get("nome"));
        tirocinante.setCognome((String) datamodel.get("cognome"));
        tirocinante.setLuogoDiNascita((String) datamodel.get("luogoNascita"));
        tirocinante.setDataDiNascita((java.sql.Date) datamodel.get("dataNascita"));
        tirocinante.setLuogoDiResidenza((String) datamodel.get("luogoResidenza"));
        tirocinante.setProvinciaDiResidenza((String) datamodel.get("provinciaResidenza"));
        tirocinante.setProvinciaDiNascita((String) datamodel.get("provinciaNascita"));
        tirocinante.setCodiceFiscale((String) datamodel.get("codiceFiscale"));
        tirocinante.setTelefono((String) datamodel.get("numeroTelefono"));
        if(datamodel.get("studenteCorsoLaurea")!=null){
            tirocinante.setCorsoDiLaurea((String) datamodel.get("studenteCorsoLaurea"));
        }
        if(datamodel.get("diplomaUniversitario")!=null){
            tirocinante.setDiplomaUniversitario((String) datamodel.get("diplomaUniversitario"));
        }
        if(datamodel.get("laureaIn")!=null){
            tirocinante.setLaureato((String) datamodel.get("laureaIn"));
        }
        if(datamodel.get("dottoratoRicerca")!=null){
            tirocinante.setDottoratoDiRicerca((String) datamodel.get("dottoratoRicerca"));
        }
        if(datamodel.get("scuolaAltro")!=null){
            tirocinante.setScuolaAltro((String) datamodel.get("scuolaAltro"));
        }
        if(datamodel.get("handicap")!=null){
            if(datamodel.get("handicap")=="Si"){
                tirocinante.setHandicap(true);
            }else tirocinante.setHandicap(false);
        }
        tirocinante.setUser(idUser);
        tirocinanteDaoImp.setTirocinante(tirocinante);
        tirocinanteDaoImp.destroy();
        TirocinanteDaoImp tirocinanteDaoImp1 = new TirocinanteDaoImp();
        tirocinante= tirocinanteDaoImp1.getTirocianteByIDuser(idUser);
        String[] to = new String[1];
        to[0]= "tirocinante@matteifamily.net";
        datamodel.put("nomeUtente", tirocinante.getNome());
        datamodel.put("cognomeUtente", tirocinante.getCognome());
        String subject = "Registrazione Tirocinante: " + HtmlEscape.unescapeHtml( tirocinante.getNome()+" "+ tirocinante.getCognome() +" id:" + tirocinante.getIDTirocinante());
        TemplateControllerMail.process("email/registrazione-tirocinante.ftl", datamodel, to, subject, getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = params.nextElement();
        }
        if(isLogged(request)){
            response.sendRedirect("/home");
        }else {
            if(request.getParameterMap().containsKey("Email") && request.getParameterMap().containsKey("Password") && request.getParameterMap().containsKey("ConfermaPassword") && request.getParameterMap().containsKey("Tipologia")){
                if(request.getParameterMap().containsKey("Nome") || request.getParameterMap().containsKey("Cognome") || request.getParameterMap().containsKey("LuogoNascita") || request.getParameterMap().containsKey("ProvinciaNascita") || request.getParameterMap().containsKey("DataNascita") || request.getParameterMap().containsKey("LuogoResidenza") || request.getParameterMap().containsKey("ProvinciaResidenza") || request.getParameterMap().containsKey("CodiceFiscale")|| request.getParameterMap().containsKey("NumeroTelefono")){
                    if(primoStep(request)){
                        if(secondoStepTirocinante(request)){
                            try {
                                caricamentoTirocinante();

                                HttpSession sessionFalse = request.getSession(false);
                                if (sessionFalse != null) {
                                    if (sessionFalse.getAttribute("Tirocinio") != null) {
                                        response.sendRedirect("/login");
                                    }
                                }else {
                                    response.sendRedirect("/home");
                                }
                            } catch (DaoException e) {
                                e.printStackTrace();
                                deleteAccountTirocinante();
                                datamodel.put("ErroreCaricamentoDati", true);
                                TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
                            }

                        } else {
                            TemplateController.process("registrazione_step2_tirocinante.ftl", datamodel, response, getServletContext());
                        }
                    } else {
                        TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
                    }

                } else if(request.getParameterMap().containsKey("NomeAzienda") || request.getParameterMap().containsKey("SedeLegale")|| request.getParameterMap().containsKey("PartitaIVA")|| request.getParameterMap().containsKey("NomeRappresentante") || request.getParameterMap().containsKey("CognomeRappresentante") || request.getParameterMap().containsKey("NomeResponsabile") || request.getParameterMap().containsKey("CognomeResponsabile") || request.getParameterMap().containsKey("NumeroTelefonoResponsabile")|| request.getParameterMap().containsKey("EmailResponsabile")){
                    if(primoStep(request)){
                        if(secondoStepAzienda(request)){
                            try {
                                caricoAccountAzienda();
                                response.sendRedirect("/home");
                            } catch (DaoException e) {
                                e.printStackTrace();
                                deleteAccountAzienda();
                                datamodel.put("ErroreCaricamentoDati", true);
                                TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
                            }

                        } else {
                            TemplateController.process("registrazione_step2_azienda.ftl", datamodel, response, getServletContext());
                        }
                    } else {
                        TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
                    }
                } else {
                    if(primoStep(request)){
                        if(request.getParameter("Tipologia").equals("Ente-Azienda")){
                            TemplateController.process("registrazione_step2_azienda.ftl", datamodel, response, getServletContext());
                        } else {
                            TemplateController.process("registrazione_step2_tirocinante.ftl", datamodel, response, getServletContext());
                        }
                    } else {
                        TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
                    }
                }
            } else {
                primoStep(request);
                TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if(isLogged(request)){
            response.sendRedirect("/home");
        }else {
            TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
        }

    }
}
