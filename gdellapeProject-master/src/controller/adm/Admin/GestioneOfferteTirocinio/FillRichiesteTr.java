package controller.adm.Admin.GestioneOfferteTirocinio;

import dao.exception.DaoException;
import dao.implementation.*;
import freemarker.template.utility.DateUtil;
import model.*;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO Posso riutilizzare i metodi per
public class FillRichiesteTr {


    //faccio il private per non farlo eseguire
    public void FillRichiesteTr() {

    }

    public void FillRichiesteTr(HttpServletRequest request, HttpServletResponse response) {


    }


    private List<Tirocinio> getTirocini(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        List<Tirocinio> tirocini = new ArrayList<>();
            TirocinioDaoImp dao = new TirocinioDaoImp();
            tirocini = dao.getTirociniByStato(0);
            dao.destroy();

        return tirocini;

    }


    private Map<Integer, OffertaTirocinio> getOfferteTirocinio(HttpServletResponse response) throws DaoException{
        Map<Integer, OffertaTirocinio> mapOfferta = new HashMap<>();

            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> offerte = dao.getAllOffertatr();
            dao.destroy();
            for (OffertaTirocinio oftr : offerte) {
                mapOfferta.put(oftr.getIDOffertaTirocinio(), oftr);
            }

        return mapOfferta;
    }


    private Map<Integer, TutoreUniversitario> getTutoriUni(HttpServletResponse response) throws DaoException
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

    private Map<Integer, Tirocinante> getTirocinante(HttpServletResponse response) throws DaoException {
        Map<Integer, Tirocinante> maptirocinate = new HashMap<>();
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            List<Tirocinante> tirocinantes = dao.getAllTirociante();
            dao.destroy();

            for (Tirocinante tirocinante : tirocinantes) {
                maptirocinate.put(tirocinante.getIDTirocinante(), tirocinante);
            }

        return maptirocinate;
    }

    private Map<Integer, Azienda> getAziende(HttpServletResponse response) throws DaoException {
        Map<Integer, Azienda> mapAzienda = new HashMap<>();

            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziende = dao.getAllAzienda();
            dao.destroy();
            for (Azienda azienda : aziende) {
                mapAzienda.put(azienda.getIDAzienda(), azienda);
            }

        return mapAzienda;
    }




    private List<Tirocinio> getTirociniConclusi(HttpServletRequest request,HttpServletResponse response)throws DaoException
    {
        List<Tirocinio> tirocini= new ArrayList<>();

            TirocinioDaoImp dao = new TirocinioDaoImp();
            tirocini = dao.getTirociniByStato(2);
            dao.destroy();


        return tirocini;
    }


    private Map<Tirocinio,List<String>> getCampiTabelle(List<Tirocinio> tirocini,HttpServletRequest request,HttpServletResponse response) throws DaoException
    {
        Map<Tirocinio,List<String>> table = new HashMap<>();

        Map<Integer, TutoreUniversitario> mapTutori = getTutoriUni(response);
        Map<Integer,Azienda> mapaziende = getAziende(response);
        Map<Integer,Tirocinante> maptirociante = getTirocinante(response);
        Map<Integer,OffertaTirocinio> mapOfferteTr = getOfferteTirocinio(response);

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




    public Map<String, Object> fill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //make big map to add in data model
        Map<String, Object> data = new HashMap<>();
        try {


            // add the date to fill table OfferteTirocinio
            List<Tirocinio> richisteTr = getTirocini(request, response);
            data.put("Richieste", getCampiTabelle(richisteTr, request, response));
            System.out.println(data.get("Richieste"));


            // add the date to fill table Gestione convenzionamento aziende
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziendas = dao.getAllAzienda();
            dao.destroy();
            data.put("Aziende", aziendas);
            System.out.println(data.get("Aziende"));


            // add the data to fill table Gestione tirocinii Conclusi
            List<Tirocinio> trconclusi = getTirociniConclusi(request, response);
            data.put("TirociniConclusi", getCampiTabelle(trconclusi, request, response));
            System.out.println(data.get("TirociniConclusi"));
        }catch (DaoException e)
        {
            e.printStackTrace();

        }

        return data;
    }

    public Map<String,Object> showTirocinioSingolo(Tirocinio tr,HttpServletRequest request,HttpServletResponse response)throws IOException
    {
        Map<String,Object> map = new HashMap<>();
        try {
            //per il riutilizzo della funzione getCampiTabella creo una lista con un solo elemento in modo che mi torni una
            //mappa con solo un elemento ad il suo interno da poter mostrare al admin
            List<Tirocinio> listTR = new ArrayList<>();
            listTR.add(tr);


            Map<Tirocinio, List<String>> map1 = getCampiTabelle(listTR, request, response);

            map.put("dati", map1.get(tr));
            map.put("Tirocinio", tr);
        }catch (DaoException e) {
            e.printStackTrace();
        }

        return map;
    }


}









