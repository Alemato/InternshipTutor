package controller;

import dao.implementation.OffertaTirocinioDaoImp;
import model.OffertaTirocinio;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListaOfferteTutoraggiController extends baseController {

    private void OfferteTut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();

            String spageid = request.getParameter("pageid");
            int pageid = 1;
            int elementiPerPagina = 4;
            String azienda = "Tutte le Aziende";
            String sede = "Tutte le sedi disponibili";
            String cerca = null;
            String sdatainizio;
            String sdatafine;
            Date datainizio;
            Date datafine;

            if (spageid != null) {
                pageid = Integer.parseInt(spageid);

            }
            String sElementiPerPagina = request.getParameter("risultati");
            if (sElementiPerPagina != null) {
                if (!sElementiPerPagina.equals("")) {
                    elementiPerPagina = Integer.parseInt(sElementiPerPagina);
                }
            }

            String sAzienda = request.getParameter("azienda");
            if (sAzienda != null) {
                if (!sAzienda.equals(""))
                    azienda = sAzienda;

            }

            String sSede = request.getParameter("sede");
            if (sSede != null) {
                if (!sSede.equals(""))
                    sede = sSede;
            }

            String sCerca = request.getParameter("search");
            if (sCerca != null) {
                if (!sCerca.equals(""))
                    cerca = sCerca;
            }

            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");


            if (request.getParameter("datainizio") != null && !request.getParameter("datainizio").equals("")) {
                sdatainizio = request.getParameter("datainizio");
                datainizio = format.parse(sdatainizio);

            }else{

                Calendar calIn = Calendar.getInstance();
                calIn.add(Calendar.YEAR, -500);
                datainizio = calIn.getTime();
            }
            System.out.println(datainizio);

            if (request.getParameter("datafine") != null && !request.getParameter("datafine").equals("")) {
                sdatafine = request.getParameter("datafine");
                datafine = format.parse(sdatafine);

            }else {

                Calendar calFin = Calendar.getInstance();
                calFin.add(Calendar.YEAR, 500);
                datafine = calFin.getTime();
            }
            System.out.println(datafine);

            List<OffertaTirocinio> allOfferte = offertaTirocinioDaoImp.getAllOffertatr();
            List<OffertaTirocinio> offerte = new ArrayList<>();
            for (OffertaTirocinio offertaTirocinio : allOfferte) {
                if (offertaTirocinio.getStato() == 1)
                    offerte.add(offertaTirocinio);
            }

            List<OffertaTirocinio> offerteFiltrate = new ArrayList<>();

            if ((!(azienda.equals("Tutte le Aziende")) && !(sede.equals("Tutte le sedi disponibili")) && cerca != null)) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getLuogoEffettuazione().equals(sede))
                            if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))
                                if (off.getPeriodoInizio().after(datainizio))
                                    if (off.getPeriodoFine().before(datafine))
                                        offerteFiltrate.add(off);
                }
            } else if (!azienda.equals("Tutte le Aziende") && !sede.equals("Tutte le sedi disponibili")) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getLuogoEffettuazione().equals(sede))
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine))
                                    offerteFiltrate.add(off);
                }
            } else if (!azienda.equals("Tutte le Aziende") && cerca != null) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine))
                                    offerteFiltrate.add(off);
                }
            } else if (!azienda.equals("Tutte le Aziende")) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getAziendaOspitante().equals(azienda))
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else if (!sede.equals("Tutte le sedi disponibili") && cerca != null) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getLuogoEffettuazione().equals(sede))
                        if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))
                            if (off.getPeriodoInizio().after(datainizio))
                                if (off.getPeriodoFine().before(datafine)) {
                                    offerteFiltrate.add(off);
                                }
                }
            } else if (!sede.equals("Tutte le sedi disponibili")) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getLuogoEffettuazione().equals(sede))
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else if (cerca != null) {
                for (OffertaTirocinio off : offerte) {
                    if (off.getTitolo().toLowerCase().contains(cerca.toLowerCase()))
                        if (off.getPeriodoInizio().after(datainizio))
                            if (off.getPeriodoFine().before(datafine))
                                offerteFiltrate.add(off);
                }
            } else {
                for (OffertaTirocinio off : offerte) {
                    if (off.getPeriodoInizio().after(datainizio))
                        if (off.getPeriodoFine().before(datafine))
                            offerteFiltrate.add(off);
                }
            }

            offertaTirocinioDaoImp.destroy();
            List<OffertaTirocinio> offerteInpaginate = new ArrayList<>();
            int from = (pageid * elementiPerPagina);
            if (offerteFiltrate.size() <= from)
                from = from - (from - offerteFiltrate.size());
            if (from == offerteFiltrate.size()) {

                offerteInpaginate.addAll(offerteFiltrate.subList((pageid * elementiPerPagina) - elementiPerPagina, offerteFiltrate.size()));
            } else {
                offerteInpaginate.addAll(offerteFiltrate.subList((pageid * elementiPerPagina) - elementiPerPagina, from));
            }


            datamodel.put("numeroPagina", pageid);
            datamodel.put("elementiPerPagina", elementiPerPagina);
            datamodel.put("numeroPagine", Math.ceil((float) offerteFiltrate.size() / elementiPerPagina));
            datamodel.put("offerte", offerteInpaginate);
            datamodel.put("offerteFiltro", offerte);

            datamodel.put("risultati", elementiPerPagina);
            datamodel.put("azienda", azienda);
            datamodel.put("cerca", cerca);
            datamodel.put("sede", sede);


            datamodel.put("datainizio", format.format(datainizio));
            datamodel.put("datafine", format.format(datafine));


        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/500");
            dispatcher.forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        OfferteTut(request, response);

        TemplateController.process("offerte-tutoraggi.ftl", datamodel, response, getServletContext());

    }
}
