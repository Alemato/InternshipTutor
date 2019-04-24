package controller.adm.Tirocinante;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.Tirocinante;
import model.Tirocinio;
import model.*;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class GestioneModuliTirocinante {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    private Tirocinante tirocinante;

    public GestioneModuliTirocinante(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = servletContext;
        this.tirocinante = null;
    }

    private void ritornaTirocinate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        this.tirocinante = session.getTirocinate(request, response);
    }

    private List<TutoreUniversitario> ritornaTutoreUni(List<Integer> idTutoreUniversitario) throws DaoException {
        TutoreUniversitarioDaoImp tutoreUniversitarioDaoImp = new TutoreUniversitarioDaoImp();
        List<TutoreUniversitario> tutoreUniversitarios = new ArrayList<>();
        for (Integer id: idTutoreUniversitario){
            tutoreUniversitarios.add(tutoreUniversitarioDaoImp.getTutoreUniByID(id));
        }
        tutoreUniversitarioDaoImp.destroy();
        return tutoreUniversitarios;

    }

    private List<OffertaTirocinio> ritornaListaOff(List<Integer> idOffTirocini) throws DaoException {
        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
        List<OffertaTirocinio> offerteTirocini = new ArrayList<>();
        for (Integer id : idOffTirocini) {
            offerteTirocini.add(offertaTirocinioDaoImp.getOffertatrByID(id));
        }
        offertaTirocinioDaoImp.destroy();

        return offerteTirocini;
    }

    private List<Tirocinio> ritornaTirocini(int idTirocinante) throws DaoException{
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        List<Tirocinio> listaTirocini = new ArrayList<>(tirocinioDaoImp.getOffertaTirByIDTirocinante(idTirocinante));
        tirocinioDaoImp.destroy();

        return listaTirocini;
    }

    private void fillDatamodel(List<TutoreUniversitario> tutoriUniversitari, List<OffertaTirocinio> offerteTirocini, List<Tirocinio> tirocini) {
        List<Object> lista = new ArrayList<>();
        int idOfferta;
        int idTutoreUniversitario;
        for (Tirocinio tirocinio : tirocini) {
            Map<String, Object> mappa = new HashMap<>();
            idOfferta = tirocinio.getOffertaTirocinio();
            idTutoreUniversitario = tirocinio.getTutoreUniversitario();

            mappa.put("tirocinio", tirocinio);
            for (OffertaTirocinio offertaTirocinio : offerteTirocini) {
                if (offertaTirocinio.getIDOffertaTirocinio() == idOfferta) {
                    mappa.put("offertaTirocinio", offertaTirocinio);
                    break;
                }
            }
            for (TutoreUniversitario tutoreUniversitario : tutoriUniversitari) {
                if (tutoreUniversitario.getIDTutoreUni() == idTutoreUniversitario) {
                    mappa.put("tutoreUniversitario", tutoreUniversitario);
                    break;
                }
            }
            lista.add(mappa);

        }
        datamodel.put("lista", lista);
    }

    public void get() throws IOException, DaoException {
        ritornaTirocinate(request, response);

        System.out.println("ID del Tirocinante nella gestione moduli");
        System.out.println(tirocinante.getIDTirocinante());

        List<Tirocinio> tirocini = ritornaTirocini(tirocinante.getIDTirocinante());

        System.out.println("Lista Dei Tirocini");
        System.out.println(tirocini);

        List<Integer> idOffTirocini = new ArrayList<>();
        for (Tirocinio tirocinio: tirocini){
            idOffTirocini.add(tirocinio.getOffertaTirocinio());
        }
        List<OffertaTirocinio> offerteTirocini = ritornaListaOff(idOffTirocini);

        List<Integer> idTutoreUniversitario = new ArrayList<>();
        for (Tirocinio tirocinio: tirocini){
            idTutoreUniversitario.add(tirocinio.getTutoreUniversitario());
        }
        List<TutoreUniversitario> tutoriUniversitari = ritornaTutoreUni(idTutoreUniversitario);


        fillDatamodel(tutoriUniversitari, offerteTirocini, tirocini);
        TemplateController.process("moduli-tirocinante.ftl", datamodel, response, context);
    }

    public void post() throws IOException, DaoException {
        get();
    }

}
