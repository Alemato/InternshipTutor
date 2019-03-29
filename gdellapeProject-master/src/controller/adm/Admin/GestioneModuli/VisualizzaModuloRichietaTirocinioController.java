package controller.adm.Admin.GestioneModuli;


import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VisualizzaModuloRichietaTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        fillModulo(request,response);


    }
    private void fillModulo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       Tirocinante tirocinante =new Tirocinante();
       List<String> dati = new ArrayList<>();
        try{
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();

            TirocinanteDaoImp dao1 = new TirocinanteDaoImp();
            tirocinante = dao1.getTirocianteByID(tr.getTirocinante());
            dao1.destroy();

            OffertaTirocinioDaoImp dao2 =new OffertaTirocinioDaoImp();
            OffertaTirocinio offerta = dao2.getOffertatrByID(tr.getOffertaTirocinio());
            dao2.destroy();

            AziendaDaoImp dao3 = new AziendaDaoImp();
            Azienda azienda = dao3.getAziendaByID(offerta.getAzienda());
            dao3.destroy();

            TutoreUniversitarioDaoImp dao4=new TutoreUniversitarioDaoImp();
            TutoreUniversitario tutuni = dao4.getTutoreUniByID(tr.getTutoreUniversitario());
            dao4.destroy();

            dati.add(azienda.getRagioneSociale());
            dati.add(offerta.getLuogoEffettuazione());
            dati.add(offerta.getSettoreInserimento());
            dati.add(offerta.getTempoAccessoLocaliAziendali());
            dati.add(offerta.getDurataMesi().toString());
            dati.add(tr.getPeriodoEffettivoIniziale().toString());
            dati.add(tr.getPeriodoEffettivoFinale().toString());
            dati.add(tr.getDurataOre().toString());
            dati.add(tr.getCFU().toString());
            dati.add(tutuni.getNome());
            dati.add(tutuni.getCognome());
            dati.add(tutuni.getTelefono());
            dati.add(offerta.getNomeTutoreAziendale());
            dati.add(offerta.getCognomeTutoreAziendale());
            dati.add(offerta.getTelefonoTutoreAziendale());
            dati.add(offerta.getObbiettivi());
            dati.add(offerta.getModalita());
            dati.add(offerta.getFacilitazioni());

            datamodel.put("tirocinante",tirocinante);
            datamodel.put("dato",dati);
            TemplateController.process("BackEndTemplates/admin-modulo-tirocinio-tirocinante.ftl", datamodel, response, getServletContext());

        }catch (DaoException e)
        {
            e.printStackTrace();


        }

    }
















}
