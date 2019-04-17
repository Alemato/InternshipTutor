package controller.adm;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.Validation;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            datamodel.put("email",email);
        } else {
            validazione = false;
            datamodel.put("erroreEmail", true);
        }

        if (password.equals(confermaPassword)) {
            datamodel.put("password",password);
            datamodel.put("confermaPassword",confermaPassword);
        } else {
            validazione = false;
            datamodel.put("errorePassword", true);
        }

        if(tipologia.equals("Tirocinante")||tipologia.equals("Ente-Azienda")){
            datamodel.put("tipologia", tipologia);
        } else {
            validazione = false;
            datamodel.put("erroreTipologia", true);
        }

        return validazione;
    }

    private void halfRegistrazionePresentazione(HttpServletRequest request, HttpServletResponse response){
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

        if(!primoControllo(email,password,confermaPassword,tipologia)){
            TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());
        } else {
            if(tipologia.equals("Tirocinante")){
                TemplateController.process("registrazione_step2_tirocinante.ftl", datamodel, response, getServletContext());
            } else if(tipologia.equals("Ente-Azienda")){
                TemplateController.process("registrazione_step2_tirocinante.ftl", datamodel, response, getServletContext());
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = params.nextElement();
            System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
        }
        if(isLogged(request)){
            response.sendRedirect("/home");
        }else {
            if(request.getParameterMap().containsKey("Email") && request.getParameterMap().containsKey("Password") && request.getParameterMap().containsKey("ConfermaPassword") && request.getParameterMap().containsKey("Tipologia")){
                if(request.getParameterMap().containsKey("Nome") && request.getParameterMap().containsKey("Cognome") && request.getParameterMap().containsKey("LuogoNascita") && request.getParameterMap().containsKey("ProvinciaNascita") && request.getParameterMap().containsKey("DataNascita") && request.getParameterMap().containsKey("LuogoResidenza") && request.getParameterMap().containsKey("ProvinciaResidenza") && request.getParameterMap().containsKey("CodiceFiscale")&& request.getParameterMap().containsKey("NumeroTelefono")){
                    System.out.println("richiesta di tipo Tirocinante, doppio modulo registrazione ricevuto");

                } else if(request.getParameterMap().containsKey("NomeAzienda") && request.getParameterMap().containsKey("SedeLegale")&& request.getParameterMap().containsKey("PartitaIVA")&& request.getParameterMap().containsKey("NomeRappresentante") && request.getParameterMap().containsKey("CognomeRappresentante") && request.getParameterMap().containsKey("NomeResponsabile") && request.getParameterMap().containsKey("CognomeResponsabile") && request.getParameterMap().containsKey("NumeroTelefonoResponsabile")&& request.getParameterMap().containsKey("EmailResponsabile")){
                    System.out.println("richiesta di tipo Azienda, doppio modulo registrazione ricevuto");
                } else {
                    System.out.println("richiesta semi errata o solo prima parte");
                    //halfPresentazione
                    halfRegistrazionePresentazione(request, response);
                    System.out.println("datamodel");
                    System.out.println(datamodel);
                }
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
