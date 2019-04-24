package controller.adm.Tirocinante;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ModuloTirocinioTirocinanteController extends baseController {

    private void controlloCampiTirocinante(HttpServletRequest request, Tirocinante tirocinante) throws ParseException {

        String[] nominativo;
        String delimiter = " ";
        nominativo = request.getParameter("Nominativo").split(delimiter);

        if (!(nominativo[0].equals(tirocinante.getNome())))
            tirocinante.setNome(nominativo[0]);

        if (!(nominativo[1].equals(tirocinante.getCognome())))
            tirocinante.setCognome(nominativo[1]);

        if (!(request.getParameter("LuogoDiNnascita").equals(tirocinante.getLuogoDiNascita())))
            tirocinante.setLuogoDiNascita(request.getParameter("LuogoDiNnascita"));

        if (!(request.getParameter("ProvinciaDiNascita").equals(tirocinante.getProvinciaDiNascita())))
            tirocinante.setProvinciaDiNascita(request.getParameter("LuogoDiNnascita"));

        String stringDataDiNascita = request.getParameter("GiornoDiNascita") + "/" +
                request.getParameter("MeseDiNascita") + "/" +
                request.getParameter("AnnoDiNascita");
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date dataDiNascita = format.parse(stringDataDiNascita);
        java.sql.Date sqlDataDiNascita = new java.sql.Date(dataDiNascita.getTime());

        if (!(dataDiNascita.equals(tirocinante.getDataDiNascita())))
            tirocinante.setDataDiNascita(sqlDataDiNascita);

        if (!(request.getParameter("LuogoDiResidenza").equals(tirocinante.getLuogoDiResidenza())))
            tirocinante.setLuogoDiResidenza(request.getParameter("LuogoDiNnascita"));

        if (!(request.getParameter("ProvinciaDiResidenza").equals(tirocinante.getProvinciaDiResidenza())))
            tirocinante.setProvinciaDiResidenza(request.getParameter("ProvinciaDiResidenza"));

        if (!(request.getParameter("CodiceFiscale").equals(tirocinante.getCodiceFiscale())))
            tirocinante.setCodiceFiscale(request.getParameter("CodiceFiscale"));

        if (!(request.getParameter("NumeroTelefono").equals(tirocinante.getTelefono())))
            tirocinante.setTelefono(request.getParameter("NumeroTelefono"));

        if (!(request.getParameter("CorsoLaurea").equals(""))) {
            if (tirocinante.getCorsoDiLaurea() == null) {
                tirocinante.setCorsoDiLaurea(request.getParameter("CorsoLaurea"));
            } else if (!(request.getParameter("CorsoLaurea").equals(tirocinante.getCorsoDiLaurea())))
                tirocinante.setCorsoDiLaurea(request.getParameter("CorsoLaurea"));
        }

        if (!(request.getParameter("DiplomatoUniversitario").equals(""))) {
            if (tirocinante.getDiplomaUniversitario() == null) {
                tirocinante.setDiplomaUniversitario(request.getParameter("DiplomatoUniversitario"));
            } else if (!(request.getParameter("DiplomatoUniversitario").equals(tirocinante.getDiplomaUniversitario())))
                tirocinante.setDiplomaUniversitario(request.getParameter("DiplomatoUniversitario"));
        }

        if (!(request.getParameter("Laurea").equals(""))) {
            if (tirocinante.getLaureato() == null) {
                tirocinante.setLaureato(request.getParameter("Laurea"));
            } else if (!(request.getParameter("Laurea").equals(tirocinante.getLaureato())))
                tirocinante.setLaureato(request.getParameter("Laurea"));
        }

        if (!(request.getParameter("Dottorato").equals(""))) {
            if (tirocinante.getDottoratoDiRicerca() == null) {
                tirocinante.setDottoratoDiRicerca(request.getParameter("Dottorato"));
            } else if (!(request.getParameter("Dottorato").equals(tirocinante.getDottoratoDiRicerca())))
                tirocinante.setDottoratoDiRicerca(request.getParameter("Dottorato"));
        }

        if (!(request.getParameter("ScuolaAltro").equals(""))) {
            if (tirocinante.getScuolaAltro() == null) {
                tirocinante.setScuolaAltro(request.getParameter("ScuolaAltro"));
            } else if (!(request.getParameter("ScuolaAltro").equals(tirocinante.getScuolaAltro())))
                tirocinante.setScuolaAltro(request.getParameter("ScuolaAltro"));
        }

        boolean handicap = false;
        if (request.getParameter("Handicap").equals("Si"))
            handicap = true;
        if (handicap != tirocinante.getHandicap())
            tirocinante.setHandicap(handicap);
    }

    private void fillModulo(HttpServletRequest request, Tirocinante tirocinante) throws DaoException {
        Date dataDiNascita = tirocinante.getDataDiNascita();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String stringaDataDiNascita = df.format(dataDiNascita);
        String[] ggMMaaaa;
        String delimiter = "/";
        ggMMaaaa = stringaDataDiNascita.split(delimiter);
        String giorno = ggMMaaaa[0];
        String mese = ggMMaaaa[1];
        String anno = ggMMaaaa[2];

        boolean ckCorsoDilaurea = false;
        boolean ckDiplomaUniversitario = false;
        boolean ckLaureato = false;
        boolean ckDottoratoDiRicerca = false;
        boolean ckScuolaAltro = false;

        if (tirocinante.getCorsoDiLaurea() != null) {
            ckCorsoDilaurea = true;
        }
        if (tirocinante.getDiplomaUniversitario() != null) {
            ckDiplomaUniversitario = true;
        }
        if (tirocinante.getLaureato() != null) {
            ckLaureato = true;
        }
        if (tirocinante.getDottoratoDiRicerca() != null) {
            ckDottoratoDiRicerca = true;
        }
        if (tirocinante.getScuolaAltro() != null) {
            ckScuolaAltro = true;
        }


        int idOffertaTirocinio = 0;
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        List<Tirocinio> tirocini = tirocinioDaoImp.getOffertaTirByIDTirocinante(tirocinante.getIDTirocinante());
        for (Tirocinio tirocinio: tirocini){
            if (tirocinio.getIDTirocinio() == Integer.parseInt(request.getParameter("idTirocinio")))
                idOffertaTirocinio = tirocinio.getOffertaTirocinio();
        }
        Tirocinio tirocinio = new Tirocinio();
        for (Tirocinio tir: tirocini) {
            if (tirocinio.getIDTirocinio() == Integer.parseInt(request.getParameter("idTirocinio")))
                tirocinio = tir;
        }
        tirocinioDaoImp.destroy();

        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        OffertaTirocinio offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(idOffertaTirocinio);
        offertaTirocinioDaoImp.destroy();

        Integer idAzienda = offertaTirocinio.getAzienda();
        AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
        Azienda azienda = aziendaDaoImp.getAziendaByID(idAzienda);
        aziendaDaoImp.destroy();

        TutoreUniversitarioDaoImp tutoreUniversitarioDaoImp = new TutoreUniversitarioDaoImp();
        List<TutoreUniversitario> listaTutori = tutoreUniversitarioDaoImp.getAllTutUni();
        tutoreUniversitarioDaoImp.destroy();

        datamodel.put("tirocinio", tirocinio);
        datamodel.put("tirocinante", tirocinante);
        datamodel.put("offertatirocinio", offertaTirocinio);
        datamodel.put("azienda", azienda);
        datamodel.put("tutoreUniversitario", listaTutori);
        datamodel.put("giorno", giorno);
        datamodel.put("mese", mese);
        datamodel.put("anno", anno);
        datamodel.put("ckCorsoDilaurea", ckCorsoDilaurea);
        datamodel.put("ckDiplomaUniversitario", ckDiplomaUniversitario);
        datamodel.put("ckLaureato", ckLaureato);
        datamodel.put("ckDottoratoDiRicerca", ckDottoratoDiRicerca);
        datamodel.put("ckScuolaAltro", ckScuolaAltro);
        if (tirocinante.getHandicap()) {
            datamodel.put("handicap", true);
        } else datamodel.put("handicap", false);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        SingSessionContoller session = SingSessionContoller.getInstance();
        Tirocinante tirocinante = session.getTirocinate(request, response);
            try {
                controlloCampiTirocinante(request, tirocinante);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account/moduli");
            dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        datamodel.put("notview", true);
        SingSessionContoller session = SingSessionContoller.getInstance();
        Tirocinante tirocinante = session.getTirocinate(request, response);
        try {
            fillModulo(request,tirocinante);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        TemplateController.process("modulo-tirocinante.ftl", datamodel, response, getServletContext());
    }
}
