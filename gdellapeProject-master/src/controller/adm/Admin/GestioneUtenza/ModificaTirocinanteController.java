package controller.adm.Admin.GestioneUtenza;

import controller.adm.Azienda.BackEndAziendaController;
import dao.exception.DaoException;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.UserDaoImp;
import model.Tirocinante;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.util.Enumeration;


public class ModificaTirocinanteController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Enumeration d=request.getParameterNames();
            while (d.hasMoreElements()){
                System.out.println("="+request.getParameter(d.nextElement().toString()));
            }

            //UpdateTirocinante(request, response);


        }catch (Exception e)
        {
            e.printStackTrace();

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getTirocinante(request, response);
        TemplateController.process("BackEndTemplates/modifica-tirocinante.ftl", datamodel, response, getServletContext());



    }
    private void getTirocinante(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try {
            int idtr = Integer.parseInt(request.getParameter("ID"));
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tr = dao.getTirocianteByID(idtr);
            dao.destroy();
            UserDaoImp dao1=new UserDaoImp();
            User user= dao1.getUserByid(tr.getIDTirocinante());
            dao1.destroy();
            datamodel.put("user",user);
            datamodel.put("tirocinante", tr);
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
    }
    public Tirocinante check(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        Tirocinante tr = new Tirocinante();
        try {
           int id = Integer.parseInt(request.getParameter("ID"));
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            tr = dao.getTirocianteByID(id);
            dao.destroy();

            if(tr==null)
            {
                throw new ServletException();

            }


        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return tr;
    }
    private User checkUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        User user= new User();

        try{
            int idtr = Integer.parseInt(request.getParameter("ID"));
            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            Tirocinante tr = dao.getTirocianteByID(idtr);
            dao.destroy();
            UserDaoImp dao1=new UserDaoImp();
            user= dao1.getUserByid(tr.getIDTirocinante());
            dao1.destroy();
            if(user==null)
            {
                throw new ServletException();

            }



    }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }
        return user;
    }

    public void UpdateTirocinante(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            Tirocinante tr = check(request, response);
            User user = checkUser(request, response);
            user.setEmail(request.getParameter("email"));

            tr.setNome(request.getParameter("nome"));
            tr.setCognome(request.getParameter("cognome"));
            tr.setLuogoDiNascita(request.getParameter("luogodinascita"));
            tr.setLuogoDiResidenza(request.getParameter("luogodiresidenza"));
            tr.setProvinciaDiNascita(request.getParameter("provinciadinascita"));
            if(!(request.getParameter("datadinascita").isEmpty()))
            {
                tr.setDataDiNascita(Date.valueOf(request.getParameter("datadinascita")));
            }

            tr.setProvinciaDiResidenza(request.getParameter("provinciadiresidenza"));
            tr.setCodiceFiscale(request.getParameter("codicefiscale"));
            tr.setTelefono(request.getParameter("telefono"));
            if(!(request.getParameter("corsodilaurea")==null))
            {
                tr.setCorsoDiLaurea(request.getParameter("corsodilaurea"));
            }
            if(!(request.getParameter("diplomauniversitario")==null))
            {
                tr.setDiplomaUniversitario(request.getParameter("diplomauniversitario"));
            }
            if(!(request.getParameter("laureatouniversitario")==null))
            {
                tr.setLaureato(request.getParameter("laureatouniversitario"));
            }
            if(!(request.getParameter("scuolaaltro")==null))
            {
                tr.setScuolaAltro(request.getParameter("scuolaaltro"));
            }

            if(!(request.getParameter("dottoratodiricerca")==null))
            {
                tr.setDottoratoDiRicerca(request.getParameter("dottoratodiricerca"));
            }
            if(!(request.getParameter("diplomauniversitario")==null)) {
                tr.setDiplomaUniversitario(request.getParameter("diplomauniversitario"));
            }
            if(request.getParameter("handicap")!=null){
                if (request.getParameter("handicap").equals("1")) {
                    tr.setHandicap(true);
                } else {
                    tr.setHandicap(false);
                }
            }

            TirocinanteDaoImp dao = new TirocinanteDaoImp();
            dao.setUpdate(tr);
            dao.destroy();

            UserDaoImp dao1 = new UserDaoImp();
            dao1.update(user);
            dao1.destroy();
            response.sendRedirect("/gestione-utenti");
        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }



    }





}
