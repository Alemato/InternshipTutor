package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;
import model.Tirocinante;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InvalidaConvenzioneAziendaController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        invalidaConvezione(request,response);


    }
    private void invalidaConvezione(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        try{
            AziendaDaoImp dao  = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
            FillGestioniModuli page = new FillGestioniModuli(request,response,getServletContext(),datamodel);
            if(!(azienda.getPathPDFConvenzione().isEmpty())&&(azienda.getAttivo().equals(2)))
            {
                azienda.setPathPDFConvenzione(null);
                azienda.setDataConvenzione(null);
                azienda.setAttivo(0);
                AziendaDaoImp dao2=new AziendaDaoImp();
                dao2.updateAzienda(azienda);
                dao2.destroy();
                //TODO Manda mail per avvisare che la convenzione è scaduta
                page.makegetWithSuccess("Invalidazione della convenzione per l'azienda"+azienda.getRagioneSociale()+" andata a buon fine");

            }else{
                page.makegetWithInsuccess("Invalidazione della convenzione per l'azienda"+azienda.getRagioneSociale()+" andata in errore");

            }


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }

    }
















}
