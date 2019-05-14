package controller.adm.Admin.GestioneTirocinio;

import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FillGestioniModuliTirocini {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;
    private Map<String,Object> datamodel;



    //faccio il private per non farlo eseguire
    private FillGestioniModuliTirocini() {

    }

    public FillGestioniModuliTirocini(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, Map<String,Object> datamodel) {
        this.request=request;
        this.response=response;
        this.servletContext=servletContext;
        this.datamodel=datamodel;


    }

    private List<Tirocinio> getAllTirocini() throws DaoException{

        TirocinioDaoImp dao = new TirocinioDaoImp();
        List<Tirocinio> tirocini = dao.getAllTirocinio();
        dao.destroy();

        return tirocini;
    }


    private List<Tirocinio> getTirociniPendenti() throws DaoException {
        List<Tirocinio> allTirocinio = getAllTirocini();
        List<Tirocinio> tirocini = new ArrayList<>();
        for (Tirocinio tr: allTirocinio) {
            if(tr.getStato()==0){
                tirocini.add(tr);
            }

        }

        return tirocini;

    }


    private Map<Integer, OffertaTirocinio> getOfferteTirocinio() throws DaoException{
        Map<Integer, OffertaTirocinio> mapOfferta = new HashMap<>();

            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> offerte = dao.getAllOffertatr();
            dao.destroy();
            for (OffertaTirocinio oftr : offerte) {
                mapOfferta.put(oftr.getIDOffertaTirocinio(), oftr);
            }

        return mapOfferta;
    }


    private Map<Integer, TutoreUniversitario> getTutoriUni() throws DaoException
    {
        Map<Integer, TutoreUniversitario> maptutori = new HashMap<>();
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            List<TutoreUniversitario> tutUni = dao.getAllTutUni();
            dao.destroy();
            for (TutoreUniversitario tutore : tutUni) {
                maptutori.put(tutore.getIDTutoreUni(), tutore);
            }

        return maptutori;
    }

    private Map<Integer, Tirocinante> getTirocinante() throws DaoException {
        Map<Integer, Tirocinante> maptirocinate = new HashMap<>();
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            List<Tirocinante> tirocinantes = dao.getAllTirociante();
            dao.destroy();

            for (Tirocinante tirocinante : tirocinantes) {
                maptirocinate.put(tirocinante.getIDTirocinante(), tirocinante);
            }

        return maptirocinate;
    }

    private Map<Integer, Azienda> getAziende() throws DaoException {
        Map<Integer, Azienda> mapAzienda = new HashMap<>();

            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziende = dao.getAllAzienda();
            dao.destroy();
            for (Azienda azienda : aziende) {
                mapAzienda.put(azienda.getIDAzienda(), azienda);
            }

        return mapAzienda;
    }




    private List<Tirocinio> getTirociniConclusi()throws DaoException
    {
        List<Tirocinio> allTirocinio = getAllTirocini();
        List<Tirocinio> tirocini= new ArrayList<>();
        for (Tirocinio tr : allTirocinio)
        {
            if(tr.getStato()== 2 || tr.getStato()== 3 || tr.getStato()==4)
            {
                tirocini.add(tr);
            }

        }


        return tirocini;
    }
    private List<Tirocinio> getTirociniRifiutati()throws DaoException
    {
        List<Tirocinio> allTirocinio = getAllTirocini();
        List<Tirocinio> tirocini= new ArrayList<>();
        for (Tirocinio tr : allTirocinio)
        {
            if(tr.getStato()== 5)
            {
                tirocini.add(tr);
            }

        }


        return tirocini;
    }
    private List<Tirocinio> getTirociniAttivi()throws DaoException
    {
        List<Tirocinio> allTirocinio = getAllTirocini();
        List<Tirocinio> tirocini= new ArrayList<>();
        for (Tirocinio tr : allTirocinio)
        {
            if(tr.getStato()== 1)
            {
                tirocini.add(tr);
            }

        }

        return tirocini;
    }


    private Map<Tirocinio,List<String>> getCampiTabelle(List<Tirocinio> tirocini) throws DaoException
    {
        Map<Tirocinio,List<String>> table = new HashMap<>();

        Map<Integer, TutoreUniversitario> mapTutori = getTutoriUni();
        Map<Integer,Azienda> mapaziende = getAziende();
        Map<Integer,Tirocinante> maptirociante = getTirocinante();
        Map<Integer,OffertaTirocinio> mapOfferteTr = getOfferteTirocinio();

        for (Tirocinio tirocinio: tirocini)
        {
            List<String> dati =new ArrayList<>();
            if(maptirociante.containsKey(tirocinio.getTirocinante())){
               Tirocinante tr = maptirociante.get(tirocinio.getTirocinante());
                dati.add(tr.getNome());
                dati.add(tr.getCognome());
                dati.add(tr.getCodiceFiscale());
            }else{
                dati.add("Tirocinante non presente");
                //Carico il cognome del tirocinante nella posizione 1
                dati.add("Tirocinante non presente");
                //Carico il CF del tirocinante nella posizione 2
                dati.add("Tirocinante non presente");
            }

            if(mapOfferteTr.containsKey(tirocinio.getOffertaTirocinio()))
            {
                OffertaTirocinio of = mapOfferteTr.get(tirocinio.getOffertaTirocinio());
                if (mapaziende.containsKey(of.getAzienda())) {
                    Azienda azienda = mapaziende.get(of.getAzienda());
                    //Carico il nome della azienda nella posizone 3
                    dati.add(azienda.getRagioneSociale());
                    //carico l'indirizzo legale della azienda pos 4
                    dati.add(azienda.getIndirizzoSedeLegale());
                    //carico codice fiscale/p iva azienda pos 5
                    dati.add(azienda.getCFiscalePIva());

                } else { //Carico il nome della azienda nella posizone 3
                    dati.add("Azienda non presente");
                    //carico l'indirizzo legale della azienda pos 4
                    dati.add("Azienda non presente");
                    //carico codice fiscale/p iva azienda pos 5
                    dati.add("Azinda non presente");

                } //carico nome tut.aziendale pos 6
                dati.add(of.getNomeTutoreAziendale());
                //carico cognome tut aziendale pos 7
                dati.add(of.getCognomeTutoreAziendale());
                //carico telefono tut azienddle pos 8
                dati.add(of.getTelefonoTutoreAziendale());
            } else {
                //Carico il nome della azienda nella posizone 3
                dati.add("Azienda non presente");
                //carico l'indirizzo legale della azienda pos 4
                dati.add("Azienda non presente");
                //carico codice fiscale/p iva azienda pos 5
                dati.add("Azinda non presente");
                //carico nome tut.aziendale pos 6
                dati.add("Offerta tirocinio non presente");
                //carico cognome tut aziendale pos 7
                dati.add("Offerta tirocinio non presente");
                //carico telefono tut azienddle pos 8
                dati.add("Offerta tirocinio non presente");
            }

            if (mapTutori.containsKey(tirocinio.getTutoreUniversitario())) {
                TutoreUniversitario tutoreUniversitario = mapTutori.get(tirocinio.getTutoreUniversitario());
                //carico Nome tut.uni pos 9
                dati.add(tutoreUniversitario.getNome());
                //carico Nome tut.uni pos 10
                dati.add(tutoreUniversitario.getCognome());
                //carico Nome tut.uni pos 11
                dati.add(tutoreUniversitario.getTelefono());
            } else {
                //carico Nome tut.uni pos 9
                dati.add("Tutore università non presente");
                //carico Nome tut.uni pos 10
                dati.add("Tutore università non presente");
                //carico Nome tut.uni pos 11
                dati.add("Tutore università non presente");
            }

            table.put(tirocinio,dati);
        }

        return table;
    }




    public void makegetWithSuccess(String warning) throws IOException, ServletException,DaoException {
        //make big map to add in data model
        Map<String, Object> data = new HashMap<>();


            // add the date to fill table OfferteTirocinio
            List<Tirocinio> richisteTr = getTirociniPendenti();
            data.put("Richieste", getCampiTabelle(richisteTr));

            // add the date to fill table OfferteTirocinio
            List<Tirocinio> TrRifiutati = getTirociniRifiutati();
            data.put("Rifiutati", getCampiTabelle(TrRifiutati));

            // add the date to fill table OfferteTirocinio
            List<Tirocinio> TrAttivi = getTirociniAttivi();
            data.put("Attive", getCampiTabelle(TrAttivi));




            // add the data to fill table Gestione tirocinii Conclusi
            List<Tirocinio> trconclusi = getTirociniConclusi();
            data.put("TirociniConclusi", getCampiTabelle(trconclusi));
//            Warning per il successo di una operazione
            data.put("WarningSuccess",warning);
            datamodel.putAll(data);
            TemplateController.process("BackEndTemplates/gestione-moduli-tirocini.ftl", datamodel, response, servletContext);


    }

    public void makegetWithInsuccess(String warning) throws IOException, ServletException,DaoException {
        //make big map to add in data model
        Map<String, Object> data = new HashMap<>();


            // add the date to fill table OfferteTirocinio
            List<Tirocinio> richisteTr = getTirociniPendenti();
            data.put("Richieste", getCampiTabelle(richisteTr));

            // add the date to fill table OfferteTirocinio
            List<Tirocinio> TrRifiutati = getTirociniRifiutati();
            data.put("Rifiutati", getCampiTabelle(TrRifiutati));

            // add the date to fill table OfferteTirocinio
            List<Tirocinio> TrAttivi = getTirociniAttivi();
            data.put("Attive", getCampiTabelle(TrAttivi));



            // add the data to fill table Gestione tirocinii Conclusi
            List<Tirocinio> trconclusi = getTirociniConclusi();
            data.put("TirociniConclusi", getCampiTabelle(trconclusi));
//            Warning per il successo di una operazione

            data.put("WarningInsuccess", warning);
            datamodel.putAll(data);
            TemplateController.process("BackEndTemplates/gestione-moduli-tirocini.ftl", datamodel, response, servletContext);

    }

        public void makeget() throws IOException, ServletException,DaoException {
            //make big map to add in data model
            Map<String, Object> data = new HashMap<>();


                // add the date to fill table OfferteTirocinio
                List<Tirocinio> richisteTr = getTirociniPendenti();
                data.put("Richieste", getCampiTabelle(richisteTr));

                // add the date to fill table OfferteTirocinio
                List<Tirocinio> TrRifiutati = getTirociniRifiutati();
                data.put("Rifiutati", getCampiTabelle(TrRifiutati));

                // add the date to fill table OfferteTirocinio
                List<Tirocinio> TrAttivi = getTirociniAttivi();
                data.put("Attive", getCampiTabelle(TrAttivi));



                // add the data to fill table Gestione tirocinii Conclusi
                List<Tirocinio> trconclusi = getTirociniConclusi();
                data.put("TirociniConclusi", getCampiTabelle(trconclusi));
//            Warning per il successo di una operazione

                datamodel.putAll(data);
                TemplateController.process("BackEndTemplates/gestione-moduli-tirocini.ftl", datamodel, response, servletContext);


    }





}









