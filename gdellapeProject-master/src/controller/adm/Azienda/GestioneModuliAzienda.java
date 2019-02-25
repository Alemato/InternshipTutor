package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestioneModuliAzienda {
    protected Map<String, Object> datamodel;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    private Azienda azienda;

    public  GestioneModuliAzienda(Map<String, Object> datamodel, HttpServletRequest request, HttpServletResponse response, ServletContext context){
        this.datamodel = datamodel;
        this.request = request;
        this.response = response;
        this.context = context;
        this.azienda = null;
    }

    private Azienda ritornaAzienda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SingSessionContoller session = SingSessionContoller.getInstance();
        return session.getAzienda(request,response);
    }

    private void fillConvenzione(Azienda azienda){
        datamodel.put("DataConvenzione", azienda.getDataConvenzione());
        datamodel.put("DataUpdate", azienda.getUpdateDate());
        datamodel.put("IDConvenzione", azienda.getIDAzienda());
    }

    private List<OffertaTirocinio> ritornaOfferte() throws DaoException {
        OffertaTirocinioDaoImp daoOfferte = new OffertaTirocinioDaoImp();
        List<OffertaTirocinio> offertaTirocinios = daoOfferte.getOffertatrBYAzienda(azienda);
        daoOfferte.destroy();
        return offertaTirocinios;
    }

    private List<Tirocinio> ritornaTirocinii(List<OffertaTirocinio> offertaTirocinios) throws DaoException {
        TirocinioDaoImp daoTirocinio = new TirocinioDaoImp();
        List<Tirocinio> listaTirocini = new ArrayList<>();
        for(OffertaTirocinio offertaTirocinio : offertaTirocinios){
            System.out.println(offertaTirocinio);
            listaTirocini.addAll(daoTirocinio.getTrByOfferta(offertaTirocinio));
        }
        daoTirocinio.destroy();
        return listaTirocini;
    }

    private List<Tirocinante> ritornaTirocinanti(List<Tirocinio> listaTirocini) throws DaoException {
        TirocinanteDaoImp daoTirocinante = new TirocinanteDaoImp();
        List<Tirocinante> listaTirocinanti = new ArrayList<>();
        for (Tirocinio tirocinio: listaTirocini){
            System.out.println(tirocinio);
            listaTirocinanti.add(daoTirocinante.getTirocianteByID(tirocinio.getTirocinante()));
        }
        daoTirocinante.destroy();
        return  listaTirocinanti;
    }


}
