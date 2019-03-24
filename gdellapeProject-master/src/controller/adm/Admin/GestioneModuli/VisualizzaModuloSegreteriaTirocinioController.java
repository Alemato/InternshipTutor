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


public class VisualizzaModuloSegreteriaTirocinioController extends baseController {
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
       Tirocinante tirocinante = new Tirocinante();
       Tirocinio tr = new Tirocinio();
        try{
            TirocinioDaoImp dao = new TirocinioDaoImp();
            tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("IDTirocinio")));
            dao.destroy();

            TirocinanteDaoImp dao1 = new TirocinanteDaoImp();
            tirocinante = dao1.getTirocianteByID(tr.getTirocinante());
            dao1.destroy();

            datamodel.put("tirocinante",tirocinante);
            datamodel.put("tirocinio",tr);
            TemplateController.process("BackEndTemplates/admin-modulo-tirocinio-segreteria.ftl", datamodel, response, getServletContext());

        }catch (DaoException e)
        {
            e.printStackTrace();


        }

    }
















}
