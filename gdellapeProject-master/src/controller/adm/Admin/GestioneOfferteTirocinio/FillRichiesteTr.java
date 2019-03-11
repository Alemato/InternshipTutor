package controller.adm.Admin.GestioneOfferteTirocinio;

import dao.exception.DaoException;
import dao.implementation.*;
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
public class FillRichiesteTr
{


    //faccio il private per non farlo eseguire
   public void FillRichiesteTr()
    {

    }

    public void FillRichiesteTr(HttpServletRequest request,HttpServletResponse response)
    {


    }

    /**
     * La funzione prende tutti i tirocini che hanno sono nello stato di offerta richiesta
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */

    private List<Tirocinio> getTirocini(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            TirocinioDaoImp dao = new TirocinioDaoImp();
            List<Tirocinio> tirocini = dao.getTirociniByStato(0);
            dao.destroy();
            return tirocini;
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }

    }

    private Map<Integer,OffertaTirocinio> getOfferteTirocinio(HttpServletResponse response) throws IOException,ServletException
    {
        try{
            Map<Integer,OffertaTirocinio> mapOfferta = new HashMap<>();
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            List<OffertaTirocinio> offerte=dao.getAllOffertatr();
            dao.destroy();

            for (OffertaTirocinio oftr:offerte)
            {
                mapOfferta.put(oftr.getIDOffertaTirocinio(),oftr);
            }

            return mapOfferta;


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }
    }


    private Map<Integer, TutoreUniversitario> getTutoriUni(HttpServletResponse response) throws IOException,ServletException
    {
        try{
            Map<Integer, TutoreUniversitario> maptutori = new HashMap<>();
            TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
            List<TutoreUniversitario> tutUni=dao.getAllTutUni();
            dao.destroy();

            for (TutoreUniversitario tutore: tutUni)
            {
                maptutori.put(tutore.getIDTutoreUni(),tutore);
            }

            return maptutori;


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }
    }

    private Map<Integer,Tirocinante> getTirocinante(HttpServletResponse response) throws IOException,ServletException
    {
        try{
            Map<Integer,Tirocinante> maptirocinate = new HashMap<>();
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            List<Tirocinante> tirocinantes=dao.getAllTirociante();
            dao.destroy();

            for (Tirocinante tirocinante: tirocinantes)
            {
                maptirocinate.put(tirocinante.getIDTirocinante(),tirocinante);
            }

            return maptirocinate;


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }
    }

    private Map<Integer,Azienda> getAzienda(HttpServletResponse response) throws IOException,ServletException
    {
        try{
            Map<Integer,Azienda> mapAzienda = new HashMap<>();
            AziendaDaoImp dao = new AziendaDaoImp();
            List<Azienda> aziende=dao.getAllAzienda();
            dao.destroy();

            for (Azienda azienda: aziende)
            {
                mapAzienda.put(azienda.getIDAzienda(),azienda);
            }

            return mapAzienda;


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }
    }


    private Map<Tirocinio,List<String>> fillTableRichiesteTr(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException
    {

            Map<Tirocinio, List<String>> mapToTable = new HashMap<>();

            List<Tirocinio> tirocini = getTirocini(request, response);
            Map<Integer, TutoreUniversitario> mapTutori = getTutoriUni(response);
            Map<Integer, OffertaTirocinio> MapOfferte = getOfferteTirocinio(response);
            Map<Integer, Azienda> mapAzienda = getAzienda(response);
            Map<Integer, Tirocinante> mapTr = getTirocinante(response);

            for (Tirocinio tirocinio : tirocini) {

                List<String> tupla = new ArrayList<>();

                if (mapTr.containsKey(tirocinio.getTirocinante())) {
                    Tirocinante tirocinante = mapTr.get(tirocinio.getTirocinante());
                    //Carico il nome del tirocinante nella posizione 0
                    tupla.add(tirocinante.getNome());
                    //Carico il cognome del tirocinante nella posizione 1
                    tupla.add(tirocinante.getCognome());
                    //Carico il CF del tirocinante nella posizione 2
                    tupla.add(tirocinante.getCodiceFiscale());

                } else {
                    tupla.add("Tirocinante non presente");
                    //Carico il cognome del tirocinante nella posizione 1
                    tupla.add("Tirocinante non presente");
                    //Carico il CF del tirocinante nella posizione 2
                    tupla.add("Tirocinante non presente");
                }
                if (MapOfferte.containsKey(tirocinio.getOffertaTirocinio())) {
                    OffertaTirocinio offertaTirocinio = MapOfferte.get(tirocinio.getOffertaTirocinio());
                    if (mapAzienda.containsKey(offertaTirocinio.getIDOffertaTirocinio())) {
                        Azienda azienda = mapAzienda.get(offertaTirocinio.getIDOffertaTirocinio());
                        //Carico il nome della azienda nella posizone 3
                        tupla.add(azienda.getRagioneSociale());
                        //carico l'indirizzo legale della azienda pos 4
                        tupla.add(azienda.getIndirizzoSedeLegale());
                        //carico codice fiscale/p iva azienda pos 5
                        tupla.add(azienda.getCFiscalePIva());

                    } else { //Carico il nome della azienda nella posizone 3
                        tupla.add("Azienda non presente");
                        //carico l'indirizzo legale della azienda pos 4
                        tupla.add("Azienda non presente");
                        //carico codice fiscale/p iva azienda pos 5
                        tupla.add("Azinda non presente");

                    }
                    //carico nome tut.aziendale pos 6
                    tupla.add(offertaTirocinio.getNomeTutoreAziendale());
                    //carico cognome tut aziendale pos 7
                    tupla.add(offertaTirocinio.getCognomeTutoreAziendale());
                    //carico telefono tut azienddle pos 8
                    tupla.add(offertaTirocinio.getTelefonoTutoreAzindale());
                } else {
                    //Carico il nome della azienda nella posizone 3
                    tupla.add("Azienda non presente");
                    //carico l'indirizzo legale della azienda pos 4
                    tupla.add("Azienda non presente");
                    //carico codice fiscale/p iva azienda pos 5
                    tupla.add("Azinda non presente");
                    //carico nome tut.aziendale pos 6
                    tupla.add("Offerta tirocinio non presente");
                    //carico cognome tut aziendale pos 7
                    tupla.add("Offerta tirocinio non presente");
                    //carico telefono tut azienddle pos 8
                    tupla.add("Offerta tirocinio non presente");
                }

                if(mapTutori.containsKey(tirocinio.getTutoreUniversitario()))
                {
                    TutoreUniversitario tutoreUniversitario = mapTutori.get(tirocinio.getTutoreUniversitario());
                    //carico Nome tut.uni pos 9
                    tupla.add(tutoreUniversitario.getNome());
                    //carico Nome tut.uni pos 10
                    tupla.add(tutoreUniversitario.getCognome());
                    //carico Nome tut.uni pos 11
                    tupla.add(tutoreUniversitario.getTelefono());
                }else{
                    //carico Nome tut.uni pos 9
                    tupla.add("Tutore università non presente");
                    //carico Nome tut.uni pos 10
                    tupla.add("Tutore università non presente");
                    //carico Nome tut.uni pos 11
                    tupla.add("Tutore università non presente");
                }
                System.out.println(tupla);
                System.out.println(tirocinio);
                mapToTable.put(tirocinio, tupla);

            }

            return mapToTable;
    }


    private List<Azienda> fillTableRichieste(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try
        {
            AziendaDaoImp dao = new AziendaDaoImp();
           List<Azienda> aziende = dao.getAllAzienda();
            dao.destroy();
            return aziende;

        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
            return null;
        }
    }






    public Map<String,Object> fill(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        //make big map to add in data model
        Map<String,Object> data= new HashMap<>();

        // add the date to fill table OfferteTirocinio
        data.put("Richieste",fillTableRichiesteTr(request,response));
        // add the date to fill table OfferteTirocinio
        data.put("Aziende",fillTableRichieste(request,response));

        return data;

    }













}









