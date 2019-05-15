package controller.adm.Admin.GestioneModuli;

import controller.adm.Admin.GestioneUtenza.AdminFillRichiesteAndAttive;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import org.unbescape.html.HtmlEscape;
import view.TemplateControllerMail;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAccettaConvenzione extends baseController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modificaAzienda(request,response);


    }

    private Boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException
    {
      boolean result=true;
        if(request.getParameter("IDAzienda").isEmpty())
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
       Azienda azienda= dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
       dao.destroy();

       if(azienda.getAttivo()==0&&azienda.getPathPDFConvenzione()!=null) {
           if (stato.equals("accetta")) {
               //caso in cui admin accetta la convenzione
               azienda.setAttivo(1);
               AziendaDaoImp dao1 = new AziendaDaoImp();
               dao1.updateAzienda(azienda);
               dao1.destroy();
               AdminFillRichiesteAndAttive page = new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
               page.makegetSuccess("Azienda "+azienda.getRagioneSociale()+" ora puo operare");
               datamodel.put("nomeAzineda", azienda.getRagioneSociale());
               String[] to = new String[1];
               to[0]= "azienda@matteifamily.net";
               String subject = "Accettazione Convenzionamento : " + HtmlEscape.unescapeHtml( azienda.getRagioneSociale()+" id:" + azienda.getIDAzienda());
               TemplateControllerMail.process("email/accettazione-azienda-convenzione.ftl", datamodel, to, subject, getServletContext());
           } else {
               //caso in cui admin delclina la convenzione
               azienda.setAttivo(0);
               azienda.setPathPDFConvenzione(null);
               AziendaDaoImp dao1 = new AziendaDaoImp();
               dao1.updateAzienda(azienda);
               dao1.destroy();
               AdminFillRichiesteAndAttive page = new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
               page.makegetInsuccess("Azienda "+azienda.getRagioneSociale()+" e stata declinata");

           }
       }else{
           AdminFillRichiesteAndAttive page= new AdminFillRichiesteAndAttive(datamodel,getServletContext(),request,response);
           page.makegetInsuccess("Errore scelta per attivazaione della azienda");
       }

    }


    private void modificaAzienda(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        super.init(request,response);
        try {
            datamodel.put("urlpage","/admin/richisteconvezioni");
            if (validate(request, response)) {
                cambiaStato(request,response);

            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }


}
