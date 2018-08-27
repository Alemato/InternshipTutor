package controller.adm;


import controller.sessionController.SingSessionContoller;
import controller.utility.utility;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;

public class RegistrationController extends HttpServlet  {
    HashMap<String,Object> datamodel = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
           this.Registration(request,response);
       }catch ( Exception e){
           e.printStackTrace();

       }





    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());



        }

        protected void Registration(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException,DaoException {
            logged(request, response);
            AccountEsistente(request, response);
            String tipo = (String)request.getParameter("Tipologia");


            if(tipo.equals("Tirocinante")) {
                String nome = request.getParameter("Nome");
                if (nome == null)
                {
                    halfRegistration(request, response);
                }
                else
                    {
                    registrationTirocinante(request,response);
                    }
            }
            if(tipo.equals("Ente-Azienda"))
            {
                String azienda = request.getParameter("NomeAzienda");

                if (azienda == null) {
                    halfRegistration(request, response);
                } else {
                    registrationAzienda(request, response);
                }
            }
            else{
                //errore
            }




        }


        protected void halfRegistration(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");

           //farei un check dei campi tipo validazione mail poi se e le password sono uguali ed se ha messo il tipo di account
            if (email.isEmpty() || password.isEmpty()) {
                //errore
            }
            datamodel.put("Email", email);
            datamodel.put("Password", password);
            String type = request.getParameter("Tipologia");
            if (type.equals("Tirocinante")) {
                TemplateController.process("registrazione_step2_tirocinante.ftl", datamodel, response, getServletContext());
            } else {
                TemplateController.process("registrazione_step2_azienda.ftl", datamodel, response, getServletContext());
            }
        }

        protected void registrationAzienda(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
        {
            try {


                User user = new User();
                Azienda azienda = new Azienda();

                user.setEmail((String) request.getParameter("Email"));
                user.setPassword((String) request.getParameter("Password"));
                user.setTipologiaAccount(3);

                azienda.setRagioneSociale((String) request.getParameter("NomeAzienda"));
                azienda.setIndirizzoSedeLegale((String) request.getParameter("SedeLegale"));
                azienda.setCFiscalePIva((String) request.getParameter("PartitaIVA"));
                azienda.setNomeLegaleRappresentante((String) request.getParameter("NomeRappresentante"));
                azienda.setCognomeLegaleRappresentante((String) request.getParameter("CognomeRappresentante"));
                azienda.setNomeResponsabileConvenzione((String) request.getParameter("NomeResponsabile"));
                azienda.setCognomeResponsabileConvenzione((String) request.getParameter("CognomeResponsabile"));
                azienda.setTelefonoResponsabileConvenzione((String) request.getParameter("NumeroTelefonoResponsabile"));
                azienda.setEmailResponsabileConvenzione((String) request.getParameter("NumeroTelefonoResponsabile"));

                UserDaoImp daouser = new UserDaoImp();

                daouser.setUser(user);
                User userconid = daouser.getUserByMail(user.getEmail());
                daouser.destroy();

                AziendaDaoImp daoAzienda = new AziendaDaoImp();

                daoAzienda.setRegisterazienda(azienda, userconid);
                daoAzienda.destroy();
            }catch (Exception e){
                e.printStackTrace();
            }








        }
        protected void AccountEsistente(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
        {try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            String email = (String) request.getParameter("Email");
            if (session.isAccount(email)) {
                //pagina di errore
            }
        }
            catch(Exception e){
            e.printStackTrace();

            }



        }

        protected void logged(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{


        SingSessionContoller session = SingSessionContoller.getInstance();
        if(session.isValidSession(request)){
            //pagina di e di errore
        }

        }
    protected void registrationTirocinante(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        try {


            User user = new User();
            Tirocinante tirocinante = new Tirocinante();

            user.setEmail((String) request.getParameter("Email"));
            user.setPassword((String) request.getParameter("Password"));
            user.setTipologiaAccount(2);

            tirocinante.setNome(request.getParameter("Nome"));
            tirocinante.setCognome(request.getParameter("Cognome"));
            tirocinante.setLuogoDiNascita(request.getParameter("LuogoNascita"));
            tirocinante.setProvinciaDiNascita(request.getParameter("ProvinciaNascita"));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            try {
                java.util.Date parser = sdf.parse((String) request.getParameter("DataNascita"));
                java.sql.Date sqldate = new java.sql.Date(parser.getTime());
                tirocinante.setDataDiNascita(sqldate);
                System.out.println(parser.toString());

            } catch (ParseException e) {
                e.printStackTrace();
            }


            tirocinante.setLuogoDiResidenza(request.getParameter("LuogoResidenza"));
            tirocinante.setProvinciaDiResidenza(request.getParameter("ProvinciaResidenza"));
            tirocinante.setCodiceFiscale(request.getParameter("CodiceFiscale"));
            tirocinante.setTelefono(request.getParameter("NumeroTelefono"));

            String CKstudCorso = (String) request.getParameter("CKStudenteCorsoLaurea");
            if (CKstudCorso.equals("1")) {
                tirocinante.setCorsoDiLaurea(request.getParameter("StudenteCorsoLaurea"));
            }

            String CKdipuni = request.getParameter("CKDiplomaUniversitario");
            if (CKdipuni != null) {
                tirocinante.setDiplomaUniversitario(request.getParameter("DiplomaUniversitario"));
            }


            String CKlaureain = (String) request.getParameter("CKLaureaIn");
            if (CKdipuni != null) {
                tirocinante.setLaureatoUniversitario(request.getParameter("LaureaIn"));
            }

            String CKdotRic = (String) request.getParameter("CKDottoratoRicerca");
            if (CKdipuni != null) {
                tirocinante.setDottoratoDiRicerca(request.getParameter("DottoratoRicerca"));
            }

            String CKalSc = (String) request.getParameter("CKScuolaAltro");
            if (CKdipuni != null) {
                tirocinante.setScuolaAltro(request.getParameter("ScuolaAltro"));
            }

            String CKha = (String) request.getParameter("Handicap");
            if (CKdipuni != null
                    ) {
                tirocinante.setHandicap(true);
            }else{tirocinante.setHandicap(false);}


            UserDaoImp daouser = new UserDaoImp();

            daouser.setUser(user);

            User userconid = daouser.getUserByMail(user.getEmail());

            daouser.destroy();

            tirocinante.setUser(userconid.getIDUser());


            TirocinanteDaoImp daotr = new TirocinanteDaoImp();

            daotr.setTirocinante(tirocinante);
            daotr.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void halfControl(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String mail = request.getParameter("Email");
        String Password = request.getParameter("Password");
        String CPassword = request.getParameter("ConfermaPassword");
        if(utility.isEmail(mail)&& Password.equals(CPassword)){


        }else{ TemplateController.process("registrazione.ftl", datamodel, response, getServletContext());

        }
    }






}
