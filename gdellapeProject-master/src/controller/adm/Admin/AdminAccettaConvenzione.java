package controller.adm.Admin;

import controller.utility.HtmlEntities;
import controller.utility.Utility;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class AdminAccettaConvenzione extends BackEndAdminController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }





    private Boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,DaoException
    {//nel caso l'id non appartenga a nessuno si creerà una eccezione di tipo DaoException
        boolean errore = false;

        if(request.getParameter("IDAzienda").isEmpty())
        {
            errore=true;
        }else if(request.getParameter("stato").isEmpty())
        {
            errore=true;
        }else if(!(request.getParameter("stato").equals("accetta")||request.getParameter("stato").equals("declina")))
        {
            errore=true;
        }

        if(errore==true)
        {
            //mandalo in 404
        }else{
            //funzione che accetta o decline cabimbiando lo stato
            //
        }

        return errore;


    }





}
