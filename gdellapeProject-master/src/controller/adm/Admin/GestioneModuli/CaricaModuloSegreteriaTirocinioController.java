package controller.adm.Admin.GestioneModuli;



import controller.adm.Admin.GestioneTirocinio.FillGestioniModuliTirocini;
import controller.baseController;
import controller.utility.UploadFilePDF;
import dao.exception.DaoException;
import dao.implementation.TirocinioDaoImp;
import model.Tirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;

@MultipartConfig
public class CaricaModuloSegreteriaTirocinioController extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        caricaConvezione(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.init(request,response);
        RequestDispatcher page = request.getRequestDispatcher("/404");
        page.forward(request,response);



    }
    private void caricaConvezione(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {

        try{
            datamodel.put("urlpage","/admin/Gestione-tirocinio");
            TirocinioDaoImp dao = new TirocinioDaoImp();
            Tirocinio tr = dao.getRichiestatrByID(Integer.parseInt(request.getParameter("ID")));
            dao.destroy();


           FillGestioniModuliTirocini page = new FillGestioniModuliTirocini(request,response,getServletContext(),datamodel);
            if(validate(request,response,tr))
            {
                Part PDF = request.getPart("PDF");
                UploadFilePDF pdf = new UploadFilePDF();

                String path=pdf.uploadPDF(request,PDF,3,tr);

                tr.setPdfSegreteria(path);

                TirocinioDaoImp dao2=new TirocinioDaoImp();
                dao2.updateTirocinio(tr);
                dao2.destroy();
                //TODO Manda mail per avvisare che il moludo é stato caricato
                page.makegetWithSuccess("Caricamento &egrave; andato a buon fine");

            }else{
                page.makegetWithInsuccess("Caricamento non &egrave; andato a buon fine");
            }


        }catch (DaoException e)
        {
           e.printStackTrace();
            RequestDispatcher page= request.getRequestDispatcher("/500");
            page.forward(request,response);
        }

    }
    private boolean validate(HttpServletRequest request,HttpServletResponse response,Tirocinio tirocinio)throws IOException,ServletException{

        if(tirocinio.getStato()<2){
            return false;
        }else if(tirocinio.getStato()==5) {
            return false;
        }else if(request.getPart("PDF")==null){
            return false;
        }
        else if(tirocinio.getDataConsegnaModuloSegreteria()!=null&&tirocinio.getDataConsegnaModuloSegreteria()!=null&&tirocinio.getEsitoTirocinio()!=null&&tirocinio.getCreditiRiconosciuti()!=null){
            return true;

        }else{
            return false;
        }

    }
}
