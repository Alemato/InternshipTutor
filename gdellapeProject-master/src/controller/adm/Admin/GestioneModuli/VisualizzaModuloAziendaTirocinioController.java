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
import java.util.List;


public class VisualizzaModuloAziendaTirocinioController extends baseController {
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
       List<Object> dati = new ArrayList<>();
        try{
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();

            TirocinanteDaoImp dao1 = new TirocinanteDaoImp();
            Tirocinante tirocinante = dao1.getTirocianteByID(tr.getIDTirocinio());
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

//            dato posizione 0
            dati.add(azienda.getRagioneSociale());
            //dato posizione 1
            dati.add(azienda.getCFiscalePIva());
            //dato posizione 2
            dati.add(tirocinante.getCognome());
            //dato posizione 3
            dati.add(tirocinante.getNome());
            //dato posizione 4
            dati.add(offerta.getCodIdentTirocinio());
            //dato posizione 5
            dati.add(tr.getPeriodoEffettivoIniziale());
            //dato posizione 6
            dati.add(tr.getPeriodoEffettivoFinale());
            //dato posizione 7
            dati.add(tr.getDurataOre().toString());
            //dato posizione 8
            dati.add(offerta.getLuogoEffettuazione());
            //dato posizione 9
            dati.add(tr.getDescrizioneAttivitaSvolta());
            //dato posizione 10
            dati.add(tr.getRisultatoConseguito());
            //dato posizione 11
            dati.add(tr.getDataConsegnaModulo());
            datamodel.put("dato",dati);
            TemplateController.process("BackEndTemplates/admin-modulo-tirocinio-azienda.ftl", datamodel, response, getServletContext());

        }catch (DaoException e)
        {
            e.printStackTrace();


        }

    }
















}
