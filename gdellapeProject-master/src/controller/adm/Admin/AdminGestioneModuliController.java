package controller.adm.Admin;

import controller.adm.Azienda.BackEndAziendaController;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminGestioneModuliController extends BackEndAziendaController{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateController.process("BackEndTemplates/gestione-moduli.ftl", datamodel, response, getServletContext());
    }
    /**protected void fillTablePendenti(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
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
    }**/

}
