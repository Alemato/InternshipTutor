package controller.adm.Admin.GestioneModuli;

import controller.adm.Admin.GestioneUtenza.AdminFillAziendeConTable;
import controller.baseController;
import controller.utility.UploadFilePDF;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Admin;
import model.Azienda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.rmi.ServerException;


public class CaricaPDFConvenzione extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        uploadFile(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    private void uploadFile(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        try {
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByID(Integer.parseInt(request.getParameter("IDAzienda")));
            dao.destroy();
            if (check(request,response,azienda)) {
                Part file = request.getPart("PDFConvenzione");
                storeFile(request,response,azienda,file);
            }
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");

        }catch (ServletException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }

    private Boolean check(HttpServletRequest request,HttpServletResponse response,Azienda azienda) throws IOException,ServletException
    {
        String errore= null;
        boolean result=false;

            if(!(azienda.getPathPDFConvenzione().isEmpty()))
            {
                errore="File gia presente ";
            }else if(request.getPart("PDFConvenzione")==null)
            {
                errore="File non caricato";
            }

            if(errore==null)
            {
                result=true;
            }else {
                refreshPage(request,response,errore);
            }


            return result;
    }

    private void refreshPage(HttpServletRequest request,HttpServletResponse response,String errore)throws ServletException,IOException
    {
        AdminFillAziendeConTable page = new AdminFillAziendeConTable(datamodel,getServletContext(),request,response);
        page.makegetInsuccess(errore);

    }


    private void storeFile(HttpServletRequest request,HttpServletResponse response,Azienda azienda,Part file) throws IOException,ServletException
    {
        UploadFilePDF uploder= new UploadFilePDF();


        String nome=uploder.uploadPDF(request,"PDF" + File.pathSeparator + "Covenzione" + File.pathSeparator + azienda.getIDAzienda().toString(),file);
        if(nome.equals(""))
        {
            AdminFillAziendeConTable page = new AdminFillAziendeConTable(datamodel,getServletContext(),request,response);
            page.makegetInsuccess("Caricamento non avvenuto");

        }else{
            AdminFillAziendeConTable page = new AdminFillAziendeConTable(datamodel,getServletContext(),request,response);
            page.makegetSucces("Caricamento avvenuto con successo");
        }
    }













}
