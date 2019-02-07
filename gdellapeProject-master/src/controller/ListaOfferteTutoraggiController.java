package controller;

import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListaOfferteTutoraggiController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);

        try {
            OfferteTut(request);
        } catch (DaoException | ParseException e) {
            e.printStackTrace();
        }
        TemplateController.process("offerte-tutoraggi.ftl", datamodel, response, getServletContext());

    }

    private void OfferteTut(HttpServletRequest request) throws
            ServletException, IOException, DaoException, ParseException {
        try {
            OffertaTirocinioDaoImp daouser = new OffertaTirocinioDaoImp();

            String spageid = request.getParameter("pageid");
            int pageid = 1;
            int ElementiPerPagina = 4;
            String azienda = "Tutte le Aziende";
            String sede = "Tutte le sedi disponibili";
            String cerca = null;
            String sdatainizio = "2000-01-01";
            String sdatafine = "3000-12-31";
            Date datainizio;
            Date datafine;


            if (spageid != null) {
                pageid = Integer.parseInt(spageid);

            }
            String sElementiPerPagina = request.getParameter("risultati");
            if (sElementiPerPagina != null) {
                ElementiPerPagina = Integer.parseInt(sElementiPerPagina);
            }
            String sAzienda = request.getParameter("azienda");
            if (sAzienda != null) {
                azienda = sAzienda;
            }
            String sSede = request.getParameter("sede");
            if (sSede != null) {
                sede = sSede;
            }
            System.out.println(request.getParameter("search"));
            String sCerca = request.getParameter("search");
            if (sCerca != null) {
                cerca = sCerca;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
            datainizio = format.parse(sdatainizio);

            if (request.getParameter("datainizio") != null && !request.getParameter("datainizio").equals("")) {
                sdatainizio = request.getParameter("datainizio");
                datainizio = format.parse(sdatainizio);
            }
            datafine = format.parse(sdatafine);
            if (request.getParameter("datafine") != null && !request.getParameter("datafine").equals("")) {
                sdatafine = request.getParameter("datafine");
                datafine = format.parse(sdatafine);
            }
            if (pageid != 1) {
                pageid = pageid - 1;
                pageid = pageid * ElementiPerPagina;
            }


            List<OffertaTirocinio> Offerte = daouser.getAllOffertatr();
            List<OffertaTirocinio> offerteFiltrate = new ArrayList<>();

            if ((!(azienda.equals("Tutte le Aziende")) && !(sede.equals("Tutte le sedi disponibili")) && cerca != null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getLuogoEffettuazione().equals(sede))
                            if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))                                                             //da rivedere
                                if (off.getPeriodoInizio().after(datainizio))
                                    if (off.getPeriodoFine().before(datafine))
                                        offerteFiltrate.add(off);
                }
            } else if ((!(azienda.equals("Tutte le Aziende")) && !(sede.equals("Tutte le sedi disponibili")) && cerca == null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getLuogoEffettuazione().equals(sede))
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine))
                                    offerteFiltrate.add(off);
                }
            } else if ((!(azienda.equals("Tutte le Aziende")) && sede.equals("Tutte le sedi disponibili") && cerca != null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))                                                                //da rivedere
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine))
                                    offerteFiltrate.add(off);
                }
            } else if ((!(azienda.equals("Tutte le Aziende")) && sede.equals("Tutte le sedi disponibili") && cerca == null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else if ((azienda.equals("Tutte le Aziende") && !(sede.equals("Tutte le sedi disponibili")) && cerca != null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getLuogoEffettuazione().equals(sede))
                        if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))                                                            //da rivedere
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine)) {
                                    offerteFiltrate.add(off);
                                }
                }
            } else if ((azienda.equals("Tutte le Aziende") && !(sede.equals("Tutte le sedi disponibili")) && cerca == null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getLuogoEffettuazione().equals(sede))
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else if ((azienda.equals("Tutte le Aziende") && sede.equals("Tutte le sedi disponibili") && cerca != null)) {
                for (OffertaTirocinio off : Offerte) {
                    System.out.println(off.getTitolo().indexOf(cerca));
                    if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))                                                              //da rivedere
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else if ((azienda.equals("Tutte le Aziende") && sede.equals("Tutte le sedi disponibili") && cerca == null)) {
                for (OffertaTirocinio off : Offerte) {
                    if (off.getPeriodoInizio().after(datainizio))
                        if (off.getPeriodoFine().before(datafine))
                            offerteFiltrate.add(off);
                }
            }

            daouser.destroy();
            int from = (pageid*ElementiPerPagina);
            if (offerteFiltrate.size() <= from)
                from = from - (from - offerteFiltrate.size());

            datamodel.put("numeroPagina", pageid);
            datamodel.put("elementiPerPagina", ElementiPerPagina);
            datamodel.put("numeroPagine",offerteFiltrate.size()/ElementiPerPagina);
            datamodel.put("offerte", offerteFiltrate.subList((pageid*ElementiPerPagina)-ElementiPerPagina,from));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
