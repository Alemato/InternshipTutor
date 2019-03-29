package controller.adm.Admin;

import controller.adm.Admin.GestioneUtenza.AdminFillRichiesteAndAttive;
import controller.adm.Admin.GestioneUtenza.AdminFillTable;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAccettaConvenzione extends baseController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modificaAzienda(request,response);


    }

    private Boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException
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
        if(result)
        {
            return true;
        }else{
            AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
            page.makegetInsuccess("Errore scelta per attivazaione della azienda");
            return false;
        }


    }

    private void cambiaStato(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException,DaoException
    {
        String stato= request.getParameter("stato");

       AziendaDaoImp dao = new AziendaDaoImp();
       Azienda azienda= dao.getAziendaByID(Integer.parseInt(request.getParameter("IDUser")));
       dao.destroy();

       if(azienda.getAttivo()==0&&azienda.getPathPDFConvenzione()==null) {
           if (stato.equals("accetta")) {
               //caso in cui admin accetta la convenzione
               azienda.setAttivo(1);
//               AziendaDaoImp dao1 = new AziendaDaoImp();
//               dao1.updateAzienda(azienda);
//               dao1.destroy();
               AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
               page.makegetSuccess("Azienda "+azienda.getRagioneSociale()+" ora puo operare");

           } else {
               //caso in cui admin delclina la convenzione
               azienda.setAttivo(0);
               azienda.setPathPDFConvenzione(null);
//               AziendaDaoImp dao1 = new AziendaDaoImp();
//               dao1.updateAzienda(azienda);
//               dao1.destroy();
               AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
               page.makegetSuccess("Azienda "+azienda.getRagioneSociale()+" e stata declinata");

           }

           AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
           page.makegetSuccess("Errore scelta per attivazaione della azienda");
       }else{
           AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
           page.makegetInsuccess("Errore scelta per attivazaione della azienda");
       }

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
