package controller.adm.Admin.GestioneModuli;


import controller.adm.Admin.GestioneTirocinio.FillGestioniModuli;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.Tirocinio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InvalidaModuloRichiestaTirocinioController extends baseController {
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
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();
            FillGestioniModuli page = new FillGestioniModuli(request,response,getServletContext(),datamodel);
            if(!(tr.getPdfTirocinante().isEmpty()))
            {
                tr.setPdfTirocinante(null);

                TirocinioDaoImp dao2=new TirocinioDaoImp();
                dao2.updateTirocinio(tr);
                dao2.destroy();
                //TODO Manda mail per avvisare che il moludo e invlidato
                page.makegetWithSuccess("Invalidazione dell pdf del tirocinante è andata a buon fine");

            }else{
                page.makegetWithInsuccess("Invalidazione del pdf del tirocinante non è andata a buon fine");
            }


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }

    }
















}
