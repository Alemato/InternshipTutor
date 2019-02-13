package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Azienda;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;


public class ModificaAziendaController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //UpdateAzienda(request, response);
        System.out.println(request.getParameter("descrizione"));




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        datamodel.put("user",checkUser(request, response));
        datamodel.put("azienda",check(request,response));
        TemplateController.process("BackEndTemplates/modifica-Azienda.ftl", datamodel, response, getServletContext());



    }
    private void getazienda(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {

    }
    private Azienda check(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        Azienda azienda = new Azienda();
        try {
           int id = Integer.parseInt(request.getParameter("ID"));
            AziendaDaoImp dao = new AziendaDaoImp();
            azienda = dao.getAziendaByID(id);
            dao.destroy();
            if(azienda==null)
            {
                throw new ServletException();

            }


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return azienda;
    }
    private User checkUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        User user= new User();

        try{
            int idtr = Integer.parseInt(request.getParameter("ID"));
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tr = dao.getTirocianteByID(idtr);
            dao.destroy();
            UserDaoImp dao1=new UserDaoImp();
            user= dao1.getUserByid(tr.getIDTirocinante());
            dao1.destroy();
            if(user==null)
            {
                throw new ServletException();

            }



    }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return user;
    }

    private void UpdateAzienda(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            Azienda azienda = check(request, response);

           azienda.setRagioneSociale(request.getParameter("ragionesociale"));
            azienda.setIndirizzoSedeLegale(request.getParameter("indirizzosedelegale"));
            azienda.setCFiscalePIva(request.getParameter("cfiscalepiva"));
            azienda.setNomeLegaleRappresentante(request.getParameter("nomelegalerappresentante"));
            azienda.setCognomeLegaleRappresentante(request.getParameter("cognomelegalerappresentante"));
            azienda.setNomeResponsabileConvenzione(request.getParameter("nomeresponsabileconvenzione"));
            azienda.setCognomeLegaleRappresentante(request.getParameter("cognomeresponsabileconvenzione"));
            azienda.setTelefonoResponsabileConvenzione(request.getParameter("telefonoResponsabileConvenzione"));
            azienda.setEmailResponsabileConvenzione(request.getParameter("emailresponsabileconvenzione"));
            azienda.setDurataConvenzione(Integer.parseInt(request.getParameter("durataconvenzione")));
            azienda.setForoControversia(request.getParameter("forocontroversia"));
            azienda.setDescrizione(request.getParameter("descrizione"));


            azienda.setLink(request.getParameter("link"));


            AziendaDaoImp dao = new AziendaDaoImp();
            dao.updateAzienda(azienda);
            dao.destroy();

            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
