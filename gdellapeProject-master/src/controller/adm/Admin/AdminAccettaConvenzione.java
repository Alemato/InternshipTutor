package controller.adm.Admin;

import controller.adm.Admin.GestioneUtenza.AdminFillTable;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAccettaConvenzione extends BackEndAdminController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modificaAzienda(request,response);


    }

    private Boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean result=true;
        if(request.getParameter("IDUser").isEmpty())
        {
            result=false;
        }else if(request.getParameter("stato").isEmpty())
        {
            result=false;
        }else if(!(request.getParameter("stato").equals("accetta") || request.getParameter("stato").equals("declina")))
        {
            result=false;
        }

       return result;


    }

    private void cambiaStato(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,DaoException
    {
        String stato= request.getParameter("stato");

       AziendaDaoImp dao = new AziendaDaoImp();
       Azienda azienda= dao.getAziendaByID(Integer.parseInt(request.getParameter("IDUser")));
       dao.destroy();

       if(stato.equals("accetta"))
       {
           //caso in cui admin accetta la convenzione
           azienda.setAttivo(1);
       }else{
           //caso in cui admin delclina la convenzione
           azienda.setAttivo(2);
           azienda.setPathPDFConvenzione(null);
       }
        AziendaDaoImp dao1=new AziendaDaoImp();
        dao1.updateAzienda(azienda);
        dao1.destroy();

    }


    private void modificaAzienda(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        try {
            if (validate(request, response)) {
                cambiaStato(request,response);

            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }


}
