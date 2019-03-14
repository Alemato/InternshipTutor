package controller.adm.Azienda;

import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.UserDaoImp;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GestioneTirociniaAziendaController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        fillTablePendenti(request,response);
    }
    protected void fillTable(HttpServletRequest request,HttpServletResponse response)throws  ServletException,IOException{

    }
    private void fillTablePendenti(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        try {
            SingSessionContoller session = SingSessionContoller.getInstance();
            Azienda azienda = session.getAzienda(request,response);


            OffertaTirocinioDaoImp daoof = new OffertaTirocinioDaoImp();
            List<List<String>> tabella = new ArrayList<>();
            List<OffertaTirocinio> offertetrAzienda = daoof.getOffertatrBYAzienda(azienda);
            //Ho tutte le offerte che qualla azienda a fatto
            daoof.destroy();
            for (OffertaTirocinio of : offertetrAzienda) {//predo la singola offerta

                TirocinioDaoImp trDao = new TirocinioDaoImp();
                List<Tirocinio> tr = trDao.getTrByOfferta(of);
                trDao.destroy();

                for (Tirocinio tr1 : tr) {//prendo il singolo tirocinio
                    TirocinanteDaoImp daotr = new TirocinanteDaoImp();
                    Tirocinante tirocinante = daotr.getTirocianteByID(tr1.getTirocinante());
                    daotr.destroy();

                    UserDaoImp daouser = new UserDaoImp();
                    User user = daouser.getUserByid(tirocinante.getUser());
                    daouser.destroy();
                    List<String> tupla = new ArrayList<>();
                    tupla.add(tirocinante.getNome());
                    tupla.add(tirocinante.getCognome());
                    tupla.add(user.getEmail());
                    tupla.add(of.getTitolo());
                    tupla.add(of.getIDOffertaTirocinio().toString());
                    tupla.add(tr1.getStato().toString());
                    tupla.add(tr1.getIDTirocinio().toString());
                    tabella.add(tupla);

                }
            }
            for (List<String> lista1: tabella){
                for(String lista2 : lista1){
                    System.out.println(lista2);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void UpdateOfferta(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        try {
            OffertaTirocinioDaoImp dao = new OffertaTirocinioDaoImp();
            OffertaTirocinio of = dao.getOffertatrByID(Integer.parseInt(request.getParameter("ID")));
            dao.destroy();
            of.setTitolo(request.getParameter("Titolo"));
            of.setDescrizioneBreve(request.getParameter("Descrizione_Breve"));
            of.setDescrizione(request.getParameter("Descrizione_Completa"));
            of.setOrari(request.getParameter("Orari"));
            of.setDurataOre(Integer.parseInt(request.getParameter("Durara_Ora")));
            of.setDurataMesi(Integer.parseInt(request.getParameter("Durara_Mesi")));
            of.setPeriodoInizio(Date.valueOf(request.getParameter("Periodo_inizio")));
            of.setPeriodoFine(Date.valueOf(request.getParameter("Periodo_fine")));
            of.setModalita(request.getParameter("Modalita"));
            of.setObbiettivi(request.getParameter("Obiettivi"));
            of.setRimborsi(request.getParameter("Rimborsi"));
            of.setFacilitazioni(request.getParameter("Facilitazioni"));
            of.setLuogoEffettuazione(request.getParameter("SedeTirocinio"));
            of.setCodIdentTirocinio(request.getParameter("CodiceIdentTirocinio"));
            of.setSettoreInserimento(request.getParameter("SettoreInserimento"));
            of.setTempoAccessoLocaliAziendali(request.getParameter("TempiAccessoLocaliAziendali"));
            of.setNomeTutoreAziendale(request.getParameter("NomeTutoreAziendale"));
            of.setCognomeTutoreAziendale(request.getParameter("CognomeTutoreAziendale"));
            of.setTelefonoTutoreAziendale(request.getParameter("TelefonoTutoreAziendale"));
            of.setEmailTutoreAziendale(request.getParameter("EmailTutoreAziendale"));

            OffertaTirocinioDaoImp dao1 = new OffertaTirocinioDaoImp();
            dao1.setOffertatr(of);
            dao1.destroy();



        }catch (DaoException e)
        {
            e.printStackTrace();
            response.sendRedirect("/404");
        }

    }

}
