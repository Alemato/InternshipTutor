package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.UserDao;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateTirocinanteController extends BackEndTrController {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ifCarica(request,response);
        }
        protected void caricadati(HttpServletRequest request ,HttpServletResponse response)throws IOException{
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tirocinante = session.getTirocinate(request,response);
            User user = session.getUserTirocinante(request,response);

            String data = new SimpleDateFormat("dd/MM/yyyy").format(tirocinante.getDataDiNascita());

            datamodel.put("Nascita",data);
            datamodel.put("Tirocinante",tirocinante);
            datamodel.put("User",user);
            TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, getServletContext());

        }
        protected void ifCarica(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        super.init(request,response);
        if(super.loginTirocinante(request,response)){
            if(super.accessTirocinante(request,response)){
                caricadati(request,response);
            }
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    protected void checkDate(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{

        if(request.getParameter("Email").isEmpty()){sendMessageError(request,response,"Immettere Mail");}
        if(request.getParameter("Nome").isEmpty()){sendMessageError(request,response,"Immettere Nome");}
        if(request.getParameter("LuogoNascita").isEmpty()){sendMessageError(request,response,"Immettere Luogo di nascita");}
        if(request.getParameter("ProvinciaNascita").isEmpty()){sendMessageError(request,response,"Immettere provincia di nascita");}
        if(request.getParameter("DataNascita").isEmpty()){sendMessageError(request,response,"Immettere Data di nascita");}
        if(request.getParameter("CodiceFiscale").isEmpty()){sendMessageError(request,response,"Immettere Codice Fiscale");}
        if(request.getParameter("NumeroTelefono").isEmpty()){sendMessageError(request,response,"Immettere Numero di telefono");}

        if((request.getParameter("StudenteCorsoLaurea").isEmpty()) || (request.getParameter("DiplomaUniversitario").isEmpty()) ||

        (request.getParameter("LaureaIn").isEmpty()) || (request.getParameter("DottoratoRicerca").isEmpty())||(request.getParameter("ScuolaAltro").isEmpty())

        ){sendMessageError(request,response,"Immettere Almeno un corso di studi");}


    }

    protected void sendMessageError(HttpServletRequest request,HttpServletResponse response,String message)throws IOException,ServletException {
        try {
            User user = new User();
            Tirocinante tirocinante = new Tirocinante();

            user.setEmail(request.getParameter("Email"));


            tirocinante.setNome(request.getParameter("Nome"));
            tirocinante.setCognome(request.getParameter("Cognome"));
            tirocinante.setLuogoDiNascita(request.getParameter("LuogoNascita"));
            tirocinante.setProvinciaDiNascita(request.getParameter("ProvinciaNascita"));

            String Nascita = request.getParameter("DataNascita");


            tirocinante.setLuogoDiResidenza(request.getParameter("LuogoResidenza"));
            tirocinante.setProvinciaDiResidenza(request.getParameter("ProvinciaResidenza"));
            tirocinante.setCodiceFiscale(request.getParameter("CodiceFiscale"));
            tirocinante.setTelefono(request.getParameter("NumeroTelefono"));
            tirocinante.setCorsoDiLaurea(request.getParameter("StudenteCorsoLaurea"));
            tirocinante.setDiplomaUniversitario(request.getParameter("DiplomaUniversitario"));
            tirocinante.setLaureatoUniversitario(request.getParameter("LaureaIn"));
            tirocinante.setDottoratoDiRicerca(request.getParameter("DottoratoRicerca"));
            tirocinante.setScuolaAltro(request.getParameter("ScuolaAltro"));


            String CKha = (String) request.getParameter("Handicap");
            if (CKha.equals("1")) {
                tirocinante.setHandicap(true);
            } else {
                tirocinante.setHandicap(false);
            }
            datamodel.put("Nascita",Nascita);
            datamodel.put("Tirocinante",tirocinante);
            datamodel.put("User",user);
            datamodel.put("Message",message);
            TemplateController.process("impostazione-account-tirocinante.ftl", datamodel, response, getServletContext());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    protected void UpdateTr(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Tirocinante tirocinante = session.getTirocinate(request, response);
            User user = session.getUserTirocinante(request, response);
            user.setEmail( request.getParameter("Email"));


            tirocinante.setNome(request.getParameter("Nome"));
            tirocinante.setCognome(request.getParameter("Cognome"));
            tirocinante.setLuogoDiNascita(request.getParameter("LuogoNascita"));
            tirocinante.setProvinciaDiNascita(request.getParameter("ProvinciaNascita"));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.util.Date parser = sdf.parse((String) request.getParameter("DataNascita"));
                java.sql.Date sqldate = new java.sql.Date(parser.getTime());
                tirocinante.setDataDiNascita(sqldate);


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
            if (CKdipuni.equals("1")) {
                tirocinante.setDiplomaUniversitario(request.getParameter("DiplomaUniversitario"));
            }


            String CKlaureain = (String) request.getParameter("CKLaureaIn");
            if (CKlaureain.equals("1")) {
                tirocinante.setLaureatoUniversitario(request.getParameter("LaureaIn"));
            }

            String CKdotRic = (String) request.getParameter("CKDottoratoRicerca");
            if (CKdotRic.equals("1")) {
                tirocinante.setDottoratoDiRicerca(request.getParameter("DottoratoRicerca"));
            }

            String CKalSc = (String) request.getParameter("CKScuolaAltro");
            if (CKalSc.equals("1")) {
                tirocinante.setScuolaAltro(request.getParameter("ScuolaAltro"));
            }

            String CKha = (String) request.getParameter("Handicap");
            if (CKha.equals("1")) {
                tirocinante.setHandicap(true);
            } else {
                tirocinante.setHandicap(false);
            }

            UserDaoImp userdao = new UserDaoImp();
            userdao.update(user);
            userdao.destroy();

            TirocinanteDaoImp daotr = new TirocinanteDaoImp();
            daotr.setUpdate(tirocinante);
            daotr.destroy();
        }catch (Exception e){
            e.printStackTrace();
        }





        }

}
