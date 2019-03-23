package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;
import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.util.*;


public class ModificaAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.init(request,response);
        modificaAziendaandUser(request, response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        super.init(request,response);
        fillForm(request,response);




    }

    private void modificaAziendaandUser(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {

            Azienda azienda= BackEndAdminController.getAzienda(request,response,Integer.parseInt(request.getParameter("IDAzienda")));
            User user = BackEndAdminController.getUser(request,response,azienda.getUser());
            if(validation(request,response,user))
            {
                System.out.println("Sto aggiornando i dati");
//                updateAziendaandUser(request,response,azienda,user);
//                response.sendRedirect("/gestione-utenti");
            }


    }

   private void fillForm(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
   {
       Azienda azienda= BackEndAdminController.getAzienda(request,response,Integer.parseInt(request.getParameter("IDAzienda")));
       User user = BackEndAdminController.getUser(request,response,azienda.getUser());
       datamodel.put("user",user);
       datamodel.put("azienda",azienda);
       TemplateController.process("BackEndTemplates/modifica-Azienda.ftl", datamodel, response, getServletContext());
   }

   private Boolean validation(HttpServletRequest request,HttpServletResponse response,User user) throws IOException,ServletException
   {
       try {
           Map<String, Object> errori = new HashMap<>();

           if (request.getParameter("email").isEmpty()) {

               errori.put("ErroreEmail", "Email non presente");

           } else if (!(Validation.isValidEmailAddress(request.getParameter("email")))) {

               errori.put("ErroreEmail", "Email non congrua");
               //nel caso l'email immessa e uguale a quella gia presente non do errore
               //Vado in errore solo se l'email immessa e diversa da quella salvata e trovo una email uguale a quella salvata
           } else if (!(request.getParameter("email").equals(user.getEmail())) && Validation.isStoredThisAddress(request.getParameter("email"))) {

               errori.put("ErroreEmail", "Email non congrua ");
           }



           if (request.getParameter("ragionesociale").isEmpty()) {
               errori.put("ErroreRagioneSociale", "Nome Azienda  non presente");
           } else if (request.getParameter("ragionesociale").length() > 100) {
               errori.put("ErroreRagioneSociale", "Nome Azienda troppo lungo ");
           }


           if (request.getParameter("indirizzosedelegale").isEmpty()) {
               errori.put("ErroreIndirizzoSedeLegale", "Indirizzo sede legale non presente");
           } else if (request.getParameter("indirizzosedelegale").length() > 100) {
               errori.put("ErroreIndirizzoSedeLegale", "Indirizzo sede legale troppo lungo ");
           }


           if (request.getParameter("cfiscalepiva").isEmpty()) {
               errori.put("ErroreCFiscalePIva", "Codice Fiscale O partita non presente");
           } else if (request.getParameter("cfiscalepiva").length() > 16) {
               errori.put("ErroreCFiscalePIva", "Codice Fiscale O partita troppo lungo");
           }

           if (request.getParameter("nomelegalerappresentante").isEmpty()) {
               errori.put("ErroreNomeLegaleRappresentante", "Nome Legale Rappresentante non presente");
           } else if (request.getParameter("nomelegalerappresentante").length() > 50) {
               errori.put("ErroreNomeLegaleRappresentante", "Nome Legale Rappresentante troppo lungo ");
           }

           if (request.getParameter("cognomelegalerappresentante").isEmpty()) {
               errori.put("ErroreCognomeLegaleRappresentante", "Cognome Legale Rappresentante non presente");
           } else if (request.getParameter("cognomelegalerappresentante").length() > 50) {
               errori.put("ErroreCognomeLegaleRappresentante", "Cognome Legale Rappresentante troppo lungo ");
           }
           //puo essere null
           if (!(request.getParameter("nomeresponsabileconvenzione").isEmpty()))
           {

               if (request.getParameter("nomeresponsabileconvenzione").length() > 50) {
                   errori.put("ErroreNomeResponsabileConvenzione", "Nome Responsabile Convenzione troppo lungo ");
               }
           }
           //puo essere null
           if (!(request.getParameter("cognomeresponsabileconvenzione").isEmpty()))
           {

               if (request.getParameter("cognomeresponsabileconvenzione").length() > 50) {
                   errori.put("ErroreCognomeResponsabileConvenzione", "Cognome Responsabile Convenzione troppo lungo ");
               }
           }

           //puo essere null
           if (!(request.getParameter("telefonoresponsabileconvenzione").isEmpty())) {

               if (request.getParameter("telefonoresponsabileconvenzione").length() == 10) {
                   errori.put("ErroreTelefonoResponsabileConvenzione", "Cognome Responsabile Convenzione troppo lungo ");
               }
           }

           if (!(request.getParameter("emailresponsabileconvenzione").isEmpty())) {

           if (!(Validation.isValidEmailAddress(request.getParameter("emailresponsabileconvenzione")))) {
               errori.put("ErroreEmailResponsabileConvenzione", "Email Responsabile Convenzione non congrua");
           }
           }


           if (!(request.getParameter("durataconvenzione").isEmpty())) {

           if (Integer.parseInt(request.getParameter("durataconvenzione")) < 0) {
               errori.put("ErroreDurataConvenzione", "Durata Convenzione non congrua");
           }
           }

           if (request.getParameter("forocontroversia").isEmpty()) {

               if (request.getParameter("forocontroversia").length() > 300) {
                   errori.put("ErroreForoControversia", "Foro Controversia troppo lunga");
               }
           }


           if (!(request.getParameter("descrizione").isEmpty())) {

               if (request.getParameter("descrizione").length() > 500) {
                   errori.put("ErroreDescrizione", "Descrizione troppo lunga");
               }
           }

           if (!(request.getParameter("link").isEmpty())) {

               if (request.getParameter("link").length() > 100) {
                   errori.put("ErroreLink", "Link  troppo lungo");
               }
           }

           if (errori.isEmpty()) {
               return true;
           } else {
               refreshPage(request,response,errori);
               return false;
           }
       }catch (DaoException e)
       {
           e.printStackTrace();
           response.sendRedirect("/404");
           return false;
       }




   }

   private void refreshPage(HttpServletRequest request,HttpServletResponse response,Map<String,Object> errori) throws IOException,ServletException
   {
       List<String> dati = new ArrayList<>();
       if(!(errori.containsKey("ErroreEmail")))
       {
           dati.add("email");
       }

       if(!(errori.containsKey("ErroreRagioneSociale")))
       {
           dati.add("ragionesociale");
       }

       if(!(errori.containsKey("ErroreIndirizzoSedeLegale")))
       {
           dati.add("indirizzosedelegale");
       }


       if(!(errori.containsKey("ErroreCFiscalePIva")))
       {
           dati.add("cfiscalepiva");
       }

       if(!(errori.containsKey("ErroreNomeLegaleRappresentante")))
       {
           dati.add("nomelegalerappresentante");
       }

       if(!(errori.containsKey("ErroreCognomeLegaleRappresentante")))
       {
           dati.add("cognomelegalerappresentante");
       }

       if(!(errori.containsKey("ErroreNomeResponsabileConvenzione")))
       {
           dati.add("nomeresponsabileconvenzione");
       }

       if(!(errori.containsKey("ErroreCognomeResponsabileConvenzione")))
       {
           dati.add("cognomeresponsabileconvenzione");
       }

       if(!(errori.containsKey("ErroreTelefonoResponsabileConvenzione")))
       {
           dati.add("telefonoresponsabileconvenzione");
       }

       if(!(errori.containsKey("ErroreEmailResponsabileConvenzione")))
       {
           dati.add("emailresponsabileconvenzione");
       }

       if(!(errori.containsKey("ErroreDurataConvenzione")))
       {
           dati.add("durataconvenzione");
       }

       if(!(errori.containsKey("ErroreForoControversia")))
       {
           dati.add("forocontroversia");
       }

       if(!(errori.containsKey("ErroreDescrizione")))
       {
           dati.add("descrizione");
       }

       if(!(errori.containsKey("ErroreLink")))
       {
           dati.add("link");
       }

       datamodel.putAll(errori);

       datamodel.putAll(Utility.AddAllData(request,response,dati));

       fillForm(request,response);

   }








    private void updateAziendaandUser(HttpServletRequest request,HttpServletResponse response,Azienda azienda,User user)throws IOException,ServletException
    {
        try {
            if(!(user.getEmail().equals(request.getParameter("email"))))
            {
                user.setEmail(request.getParameter("email"));
            }


            azienda.setRagioneSociale(request.getParameter("ragionesociale"));
            azienda.setIndirizzoSedeLegale(request.getParameter("indirizzosedelegale"));
            azienda.setCFiscalePIva(request.getParameter("cfiscalepiva"));
            azienda.setNomeLegaleRappresentante(request.getParameter("nomelegalerappresentante"));
            azienda.setCognomeLegaleRappresentante(request.getParameter("cognomelegalerappresentante"));

            if(!(request.getParameter("nomeresponsabileconvenzione").isEmpty()))
            {
                azienda.setNomeResponsabileConvenzione(request.getParameter("nomeresponsabileconvenzione"));
            }
            if(!(request.getParameter("cognomeresponsabileconvenzione").isEmpty()))
            {
                azienda.setCognomeLegaleRappresentante(request.getParameter("cognomeresponsabileconvenzione"));
            }
            if(!( request.getParameter("telefonoResponsabileConvenzione").isEmpty()))
            {
                azienda.setTelefonoResponsabileConvenzione(request.getParameter("telefonoResponsabileConvenzione"));
            }

            if(!(request.getParameter("emailresponsabileconvenzione").isEmpty()))
            {
                azienda.setEmailResponsabileConvenzione(request.getParameter("emailresponsabileconvenzione"));
            }

            if(!(request.getParameter("durataconvenzione").isEmpty()))
            {
                azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("durataconvenzione")));
            }

            if(!(request.getParameter("forocontroversia").isEmpty()))
            {
                azienda.setForoControversia(request.getParameter("forocontroversia"));
            }

            if(!(request.getParameter("descrizione").isEmpty()))
            {
                azienda.setDescrizione(request.getParameter("descrizione"));
            }

            if(!(request.getParameter("link").isEmpty()))
            {
                azienda.setLink(request.getParameter("link"));
            }



            UserDaoImp dao1= new UserDaoImp();
            dao1.update(user);
            dao1.destroy();


            AziendaDaoImp dao = new AziendaDaoImp();
            dao.updateAzienda(azienda);
            dao.destroy();

            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
