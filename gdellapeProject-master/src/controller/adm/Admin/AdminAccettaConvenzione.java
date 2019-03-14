package controller.adm.Admin;

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
       validate(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    private void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            String name = request.getParameter("nome");
            Integer stato = Integer.parseInt(request.getParameter("stato"));
            AziendaDaoImp dao = new AziendaDaoImp();
            Azienda azienda = dao.getAziendaByRS(name);
            dao.destroy();
            AziendaDaoImp dao1 = new AziendaDaoImp();
            boolean make=dao1.ifAziendaMakeModulo(azienda);
            dao1.destroy();
            System.out.println(azienda.getAttivo());
            if (!(azienda.getAttivo()==0)&&make) {

                activeUser(request, response, azienda);

            } else {
                response.sendRedirect("/400");

            }
        }
        catch(DaoException e)
        {
            response.sendRedirect("/400");
        }
    }

    private void notActiveUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {

    }

    /**
     * Attivo azienda in modo che essa posso pubblicare tirocini ed
      * @param request
     * @param response
     * @param azienda
     * @throws ServletException
     * @throws IOException
     */

    private void activeUser(HttpServletRequest request,HttpServletResponse response,Azienda azienda) throws ServletException,IOException
    {
        try {

        Part file=request.getPart("pdf");
        String path=request.getServletContext().getInitParameter("uploads.directory");
       String name= Utility.action_upload(file,path);
       azienda.setAttivo(1);
       azienda.setPathPDFConvenzione(name);

        AziendaDaoImp dao= new AziendaDaoImp();
            dao.updateAzienda(azienda);
            dao.destroy();


            response.sendRedirect("/richisteconvezioni");
        }
        catch(DaoException e)
        {
            response.sendRedirect("/400");
        }
    }



}
