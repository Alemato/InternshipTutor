package controller.adm.Admin.GestioneUtenza;

import controller.adm.Admin.BackEndAdminController;

import controller.baseController;
import controller.utility.Utility;
import controller.utility.Validation;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
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


public class ModificaTirocinanteController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
       modifieTitocinante(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        fill_form(request,response);


    }



    private void fill_form (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {

        Tirocinante tr = BackEndAdminController.getTirocinante(request, response,Integer.parseInt(request.getParameter("IDTirocinante")));
        datamodel.put("tirocinante",tr);
        User user = BackEndAdminController.getUser(request,response,tr.getUser());
        datamodel.put("user", user);
        TemplateController.process("BackEndTemplates/modifica-tirocinante.ftl", datamodel, response, getServletContext());
    }
    private void modifieTitocinante(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {

            UserDaoImp dao1 = new UserDaoImp();
            User user = dao1.getUserByid(Integer.parseInt(request.getParameter("IDUser")));
            dao1.destroy();

            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tirocinante = dao.getTirocianteByID(Integer.parseInt(request.getParameter("IDTirocinante")));
            if (validazione(request, response,user))
            {
                System.out.println("Validazione andata a buon fine");
//                UpdateTirocinante(request,response);

            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");

        }

    }



    private Boolean validazione(HttpServletRequest request,HttpServletResponse response,User user) throws ServletException,IOException
    {
        try {
            Map<String, Object> errori = new HashMap<>();
           //La validazione su gli id non la eseguo perchè gia nel dao vado in errore quando non trovo l'oggetto con
            //quel id


                if (request.getParameter("email").isEmpty()) {

                    errori.put("ErroreEmail", "Email non presente");

                } else if (!(Validation.isValidEmailAddress(request.getParameter("email")))) {

                    errori.put("ErroreEmail", "Email non congrua");
                    //nel caso l'email immessa e uguale a quella gia presente non do errore
                    //Vado in errore solo se l'email immessa e diversa da quella salvata e trovo una email uguale a quella salvata
                } else if (!(request.getParameter("email").equals(user.getEmail()))&&Validation.isStoredThisAddress(request.getParameter("email"))) {

                    errori.put("ErroreEmail", "Email non congrua ");
                }



            if(!(request.getParameter("newpassword").isEmpty()))
            {
                if (request.getParameter("newpassword").length() > 50) {
                    errori.put("ErrorePassword", "Password troppo lunga");

                } else if (request.getParameter("newpassword").length() < 6) {
                    errori.put("ErrorePassword", "Password troppo corta");

                }

                if (request.getParameter("repaetnewpassword").isEmpty()) {
                errori.put("ErroreConfermaPassword", " Immettere conferma password");

                } else if (request.getParameter("repaetnewpassword").equals(request.getParameter("newpassword"))) {
                errori.put("ErrorePassword", "Le password non solo uguali");
                }

            }


            if (request.getParameter("nome").isEmpty()) {
                    errori.put("ErroreNome", "Nome non presente");
            } else if (request.getParameter("nome").length() > 50) {
                    errori.put("ErroreNome", "Nome troppo lungo ");
            }



            if (request.getParameter("cognome").isEmpty()) {
                    errori.put("ErroreCognome", "Cognome non presente");
            } else if (request.getParameter("cognome").length() > 50) {
                    errori.put("ErroreCognome", "Cognome troppo lungo ");
            }



            if (request.getParameter("luogodinascita").isEmpty()) {
                    errori.put("ErroreLuogoDiNascita", "Luogo Di Nascita non presente");
            } else if (request.getParameter("luogodinascita").length() > 100) {
                    errori.put("ErroreLuogoDiNascita", "Luogo Di Nascita troppo lungo ");
            }


            //non eseguo validazione sulla data perchè nel caso non c'è non ricarico la dato nel caso c'è ed non è compatibile
            //vado in errore con la funzione Date.valueof()




            if (request.getParameter("luogodiresidenza").isEmpty()) {
                    errori.put("ErroreLuogoDiResidenza", "Luogo di residenza non presente");
            } else if (request.getParameter("luogodiresidenza").length() > 100) {
                    errori.put("ErroreLuogoDiResidenza", "Luogo di residenza troppo lungo");
            }

            if (request.getParameter("provinciadinascita").isEmpty()) {
                errori.put("ErroreProvinciaDiNascita", "Provincia Di Nascita non presente");
            } else if ((request.getParameter("provinciadinascita").length() > 2)) {
                errori.put("ErroreProvinciaDiNascita", "Provincia Di Nascita non congruo");
            }

            if (request.getParameter("provinciadiresidenza").isEmpty()) {
                errori.put("ErroreProvinciaDiResidenza", "Provincia Di residenza  non presente");
            } else if (request.getParameter("provinciadiresidenza").length() > 2) {
                errori.put("ErroreProvinciaDiResidenza", "Provincia Di residenza non congruo");
            }

            if (request.getParameter("codicefiscale").isEmpty()) {
                errori.put("ErroreCodiceFiscale", "Codice fiscale  non presente");

            }else if(!(request.getParameter("codicefiscale").length()==16))
            {
                errori.put("ErroreCodiceFiscale","Codice fiscale  non congruo");
            }

            if (request.getParameter("telefono").isEmpty()) {
                errori.put("ErroreTelefono", "Telefono non presente");
            }else if(!(request.getParameter("telefono").length()==10))
            {
                errori.put("ErroreTelefono", "Telefono non congruo");
            }

            //the code make validation when this date is not empty else not make validation
            if (!(request.getParameter("corsodilaurea").isEmpty())) {
                if (request.getParameter("corsodilaurea").length() > 200) {
                    errori.put("ErroreCorsoDiLaurea", "Corso Di Laurea troppo lungo");
                }

            }

            if (!(request.getParameter("diplomauniversitario")).isEmpty()) {
                if (request.getParameter("diplomauniversitario").length() > 200) {
                    errori.put("ErroreDiplomaUniversitario", "Diploma Universitario troppo lungo");
                }
            }

            if (!(request.getParameter("laureatouniversitario").isEmpty())) {
                if (request.getParameter("laureatouniversitario").length() > 200) {
                    errori.put("ErroreLaureatoUniversitario", "Laurea troppo lunga");
                }
            }

            if (!(request.getParameter("scuolaaltro").isEmpty())) {
                if (request.getParameter("scuolaaltro").length() > 200) {
                    errori.put("ErroreScuolaAltro", "Scuola Altro troppo lungo");
                }
            }

            if (!(request.getParameter("dottoratodiricerca").isEmpty())) {
                if (request.getParameter("dottoratodiricerca").length() > 200) {
                    errori.put("ErroreDottoratoDiRicerca", "Dottorato Di Ricerca troppo lungo");
                }
            }

            if(errori.isEmpty())
            {
                return true;
            }else{
                System.out.println("Validazione non validada ricarico la pagina");
                refreshPage(request,response,errori);
                return false;
            }
        }catch (DaoException e )
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return false;
        }

    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response, Map<String,Object> errori) throws IOException,ServletException
    {
        List<String> dati = new ArrayList<>();
        if(!(errori.containsKey("ErroreMail"))){
            dati.add("email");
        }
        if(!(errori.containsKey("ErroreNome")))
        {
            dati.add("nome");
        }
        if(!(errori.containsKey("ErroreCognome")))
        {
            dati.add("cognome");
        }
        if(!(errori.containsKey("ErroreLuogoDiNascita")))
        {
            dati.add("luogodinascita");
        }



        if(!(errori.containsKey("ErroreLuogoDiNascita")))
        {
            dati.add("luogodiresidenza");
        }
        if(!(errori.containsKey("ErroreLuogoDiResidenza")))
        {
            dati.add("luogodiresidenza");
        }
        if(!(errori.containsKey("ErroreProvinciaDiNascita")))
        {
            dati.add("provinciadinascita");
        }
        if(!(errori.containsKey("ErroreProvinciaDiResidenza")))
        {
            dati.add("provinciadiresidenza");
        }
        if(!(errori.containsKey("ErroreCodiceFiscale")))
        {
            dati.add("codicefiscale");
        }
        if(!(errori.containsKey("ErroreTelefono")))
        {
            dati.add("telefono");
        }
        if(!(errori.containsKey("ErroreCorsoDiLaurea"))&&(!(request.getParameter("corsodilaurea").isEmpty())))
        {
            dati.add("corsodilaurea");
        }
        if(!(errori.containsKey("ErroreDiplomaUniversitario"))&&(!(request.getParameter("diplomauniversitario").isEmpty())))
        {
            dati.add("diplomauniversitario");
        }
        if(!(errori.containsKey("ErroreLaureatoUniversitario"))&&(!(request.getParameter("laureatouniversitario").isEmpty())))
        {
            dati.add("laureatouniversitario");
        }
        if(!(errori.containsKey("ErroreDottoratoDiRicerca"))&&(!(request.getParameter("dottoratodiricerca").isEmpty())))
        {
            dati.add("dottoratodiricerca");
        }

        datamodel.putAll(errori);

        datamodel.putAll(Utility.AddAllData(request,response,dati));

        datamodel.put("WarningDataDiNascita","Rimmettere la data di nascita in caso la si e cambiata");

        datamodel.put("ErroreGenericoUpdate","I cambimenti effettuti non sono stati salvati");

        fill_form(request,response);







    }









    private void UpdateTirocinante(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            Tirocinante tr = BackEndAdminController.getTirocinante(request,response,Integer.parseInt(request.getParameter("ID")));
            User user = BackEndAdminController.getUser(request,response,Integer.parseInt(request.getParameter("IDUser")));
            user.setEmail(request.getParameter("email"));

            tr.setNome(request.getParameter("nome"));
            tr.setCognome(request.getParameter("cognome"));
            tr.setLuogoDiNascita(request.getParameter("luogodinascita"));
            tr.setLuogoDiResidenza(request.getParameter("luogodiresidenza"));
            tr.setProvinciaDiNascita(request.getParameter("provinciadinascita"));
            if(!(request.getParameter("datadinascita").isEmpty()))
            {
                tr.setDataDiNascita(Date.valueOf(request.getParameter("datadinascita")));
            }

            tr.setProvinciaDiResidenza(request.getParameter("provinciadiresidenza"));
            tr.setCodiceFiscale(request.getParameter("codicefiscale"));
            tr.setTelefono(request.getParameter("telefono"));
            if(!(request.getParameter("corsodilaurea").isEmpty()))
            {
                tr.setCorsoDiLaurea(request.getParameter("corsodilaurea"));
            }
            if(!(request.getParameter("diplomauniversitario").isEmpty()))
            {
                tr.setDiplomaUniversitario(request.getParameter("diplomauniversitario"));
            }
            if(!(request.getParameter("laureatouniversitario").isEmpty()))
            {
                tr.setLaureato(request.getParameter("laureatouniversitario"));
            }
            if(!(request.getParameter("scuolaaltro").isEmpty()))
            {
                tr.setScuolaAltro(request.getParameter("scuolaaltro"));
            }

            if(!(request.getParameter("dottoratodiricerca").isEmpty()))
            {
                tr.setDottoratoDiRicerca(request.getParameter("dottoratodiricerca"));
            }
            if(!(request.getParameter("diplomauniversitario").isEmpty())) {
                tr.setDiplomaUniversitario(request.getParameter("diplomauniversitario"));
            }

                if (request.getParameter("handicap").equals("1")) {
                    tr.setHandicap(true);
                } else {
                    tr.setHandicap(false);
                }


            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            dao.setUpdate(tr);
            dao.destroy();

            UserDaoImp dao1 = new UserDaoImp();
            dao1.update(user);
            dao1.destroy();
            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
