package controller.adm.Admin.GestioneTirocinio;

import controller.adm.Azienda.BackEndAziendaController;
import controller.baseController;
import dao.exception.DaoException;
import dao.implementation.*;
import model.*;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class OfferteTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fillOffrte(request, response);




    }
    private void fillOffrte(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        super.init(request,response);
        try{

          FillOfferteTirocinio page =new FillOfferteTirocinio(request,response,getServletContext(),datamodel);
          page.makeget();


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }









}
