package controller.adm.Azienda;

import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class ModuloRichiestaTirocinioController extends baseController {
    private Azienda azienda;
    private Tirocinio tirocinio;
    private OffertaTirocinio offertaTirocinio;
    private TutoreUniversitario tutoreUniversitario;
    private Tirocinante tirocinante;

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if(request.getAttribute("tipo").equals(3)){
            if(request.getParameter("idRichiesta")!=null){
                if(request.getParameterMap().containsKey("PeriodoInizio") && request.getParameterMap().containsKey("PeriodoFine") && request.getParameterMap().containsKey("NumeroOreTirocinio") && request.getParameterMap().containsKey("NumeroCfu")){
                    if(request.getParameter("PeriodoInizio")!= null && request.getParameter("PeriodoFine")!=null && request.getParameter("NumeroOreTirocinio")!=null && request.getParameter("NumeroCfu")!=null){
                        if(!request.getParameter("PeriodoInizio").isEmpty() && !request.getParameter("PeriodoFine").isEmpty() && !request.getParameter("NumeroOreTirocinio").isEmpty() && !request.getParameter("NumeroCfu").isEmpty()){
                            try {
                                creaOggetti(Integer.valueOf(request.getParameter("idRichiesta")));
                                this.tirocinio.setCFU(Integer.valueOf(request.getParameter("NumeroCfu")));
                                this.tirocinio.setDurataOre(Integer.valueOf(request.getParameter("NumeroOreTirocinio")));
                                this.tirocinio.setPeriodoEffettivoIniziale(Date.valueOf(request.getParameter("PeriodoInizio")));
                                this.tirocinio.setPeriodoEffettivoFinale(Date.valueOf(request.getParameter("PeriodoFine")));
                                TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                                tirocinioDaoImp.updateTirocinio(this.tirocinio);
                                tirocinioDaoImp.destroy();
                                response.sendRedirect("/account/moduli");
                            } catch (DaoException e) {
                                e.printStackTrace();
                                er500(request, response);
                            }
                        } else {
                            System.out.println("Errore un parametro vuoto");
                            er500(request,response);
                        }
                    } else{
                        System.out.println("Errore un parametro nullo");
                        er500(request,response);
                    }
                } else{
                    System.out.println("Errore un parametro manca");
                    er500(request,response);
                }
            } else {
                System.out.println("Errore un parametro richiesta assente");
                er500(request, response);
            }
        } else {
            er403(request, response);
        }
    }

    private void creaOggetti(Integer idTirocinio) throws DaoException {
        this.azienda = new Azienda();
        this.offertaTirocinio = new OffertaTirocinio();
        this.tutoreUniversitario = new TutoreUniversitario();
        this.tirocinio = new Tirocinio();
        this.tirocinante = new Tirocinante();
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
        TutoreUniversitarioDaoImp tutoreUniversitarioDaoImp= new TutoreUniversitarioDaoImp();
        OffertaTirocinioDaoImp offertaTirocinioDaoImp=new OffertaTirocinioDaoImp();
        TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
        this.tirocinio=tirocinioDaoImp.getRichiestatrByID(idTirocinio);
        tirocinioDaoImp.destroy();
        this.offertaTirocinio= offertaTirocinioDaoImp.getOffertatrByID(this.tirocinio.getOffertaTirocinio());
        offertaTirocinioDaoImp.destroy();
        this.azienda = aziendaDaoImp.getAziendaByID(this.offertaTirocinio.getAzienda());
        aziendaDaoImp.destroy();
        this.tutoreUniversitario= tutoreUniversitarioDaoImp.getTutoreUniByID(this.tirocinio.getTutoreUniversitario());
        tutoreUniversitarioDaoImp.destroy();
        this.tirocinante = tirocinanteDaoImp.getTirocianteByID(this.tirocinio.getTirocinante());
        tirocinanteDaoImp.destroy();
    }

    private void fillModulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            creaOggetti(Integer.valueOf(request.getParameter("id")));
            datamodel.put("idRichiesta", Integer.valueOf(request.getParameter("id")));
            datamodel.put("notview", true);
            datamodel.put("azienda", this.azienda);
            datamodel.put("tirocinio", this.tirocinio);
            datamodel.put("offerta", this.offertaTirocinio);
            datamodel.put("tutore", this.tutoreUniversitario);
            datamodel.put("tirocinante", this.tirocinante);
            Calendar data = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            data.setTime(this.tirocinante.getDataDiNascita());
            datamodel.put("giorno", data.get(Calendar.DAY_OF_MONTH));
            datamodel.put("mese",data.get(Calendar.MONTH));
            datamodel.put("anno", Integer.toString(data.get(Calendar.YEAR)));
            TemplateController.process("modulo-richiesta-tirocinante-aziendale.ftl", datamodel, response, getServletContext());
        } catch (DaoException e) {
            e.printStackTrace();
            er500(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        if(request.getAttribute("tipo").equals(3)){
            fillModulo(request, response);
        } else {
            er403(request, response);
        }
    }
}
