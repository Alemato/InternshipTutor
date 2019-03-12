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

    public GestioneModuliTirocinante(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext context, Tirocinante tirocinante) {
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.tirocinante = tirocinante;
    }

    private void ritornaTirocinate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        this.tirocinante = session.getTirocinate(request, response);
    }

    private Map<Integer, TutoreUniversitario> ritornaTutoreUni(List<Integer> IDOff) throws DaoException {
        Map<Integer, TutoreUniversitario> tutori = new HashMap<>();
        TutoreUniversitarioDaoImp daoTut = new TutoreUniversitarioDaoImp();
        for (Integer ID : IDOff) {
            tutori.put(ID, null);
        }
        for (Integer ID : IDOff) {
            for (Map.Entry<Integer, TutoreUniversitario> tutore : tutori.entrySet()) {
                if (tutore.getKey().equals(ID)) {
                    tutori.put(ID, daoTut.getTutoreUniByID(ID));
                }
            }
        }

        return tutori;

    }

    private OffertaTirocinio ritornaListaOff(int IDOff) throws DaoException {
        OffertaTirocinioDaoImp daoOff = new OffertaTirocinioDaoImp();
        OffertaTirocinio offertaTir;
        offertaTir = daoOff.getOffertatrByID(IDOff);
        daoOff.destroy();

        return offertaTir;
    }

    private ArrayList<Integer> ritornaIDOffertaTir(int IDtir) throws DaoException {
        ArrayList<Integer> listaID = new ArrayList<>();
        TirocinioDaoImp daoTir = new TirocinioDaoImp();
        List<Tirocinio> IDoffertaTir = new ArrayList<>();
        IDoffertaTir.addAll(daoTir.getOffertaTirByIDTirocinante(IDtir));
        for (Tirocinio T : IDoffertaTir) {
            listaID.add(T.getOffertaTirocinio());
        }
        daoTir.destroy();

        return listaID;
    }

    public void get() throws IOException, DaoException {
        ritornaTirocinate(request, response);
        ArrayList<Integer> listaID = new ArrayList<Integer>();
        List<OffertaTirocinio> offertaTir = new ArrayList<>();
        listaID.addAll(ritornaIDOffertaTir(tirocinante.getIDTirocinante()));
        for (Integer I : listaID) {
            offertaTir.add(ritornaListaOff(I));
        }
        datamodel.put("ritornaListaOff", offertaTir);
        TemplateController.process("moduli-tirocinante.ftl", datamodel, response, context);
    }

    public void post() {

    }

}
