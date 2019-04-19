package controller.adm.Admin.GestioneUtenza;


import controller.adm.Admin.GestioneModuli.InvalidaConvenzioneAzienda;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.TutoreUniversitarioDaoImp;
import model.TutoreUniversitario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StatoTutoreUniversitarioController extends baseController {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        updateTirocinio(request,response);

    }



    private void updateTirocinio(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {

            super.init(request, response);
            datamodel.put("urlpage","/admin/gestione-tutoti");
            if (validate(request, response)){
                storeTirocinante(request,response);

            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            RequestDispatcher page = request.getRequestDispatcher("/500");
            page.forward(request,response);
        }
    }

    private boolean validate(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
        boolean result=true;

        if(request.getParameter("IDTutoreUni").isEmpty())
        {
            result=false;

        }else if(request.getParameter("stato").isEmpty())
        {
            result=false;
        }else if(!(request.getParameter("stato").equals("1")||(request.getParameter("stato").equals("0"))))
        {
            result=false;
        }

        if(result)
        {
            return true;
        }else{
            AdminFillTable date = new AdminFillTable(datamodel,getServletContext(),request,response);
            date.makeInsuccessGetTutori("Errore attivazione e disattivazione Tutore");
            return false;

        }


    }
    private void storeTirocinante(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,DaoException
    {
        TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
        TutoreUniversitario tutore = dao.getTutoreUniByID(Integer.parseInt(request.getParameter("IDTutoreUni")));
        dao.destroy();
        String stato = request.getParameter("stato");
        if(stato.equals("0")&&tutore.getAttivo())
        {
            tutore.setAttivo(false);
//            TutoreUniversitarioDaoImp dao1 = new TutoreUniversitarioDaoImp();
//            dao1.setTutoreUni(tutore);
//            dao1.destroy();
            AdminFillTable date = new AdminFillTable(datamodel,getServletContext(),request,response);
            date.makeSuccessGetTutori("Disattivazione del Tutore e andata a buon fine");
        }else if(stato.equals("1")&&!(tutore.getAttivo()))
        {
            tutore.setAttivo(false);
//            TutoreUniversitarioDaoImp dao2 = new TutoreUniversitarioDaoImp();
//            dao2.setTutoreUni(tutore);
//            dao2.destroy();
            AdminFillTable date = new AdminFillTable(datamodel,getServletContext(),request,response);
            date.makeSuccessGetTutori("Attivazione del tutore e andata a buon fine");

        }else{
            AdminFillTable date = new AdminFillTable(datamodel,getServletContext(),request,response);
            date.makeInsuccessGetTutori("Errore attivazione e disattivazione del azienda");

        }
    }




}
