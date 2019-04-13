package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoImp;
import dao.implementation.TirocinioDaoImp;
import dao.implementation.UserDaoImp;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import model.User;
import view.TemplateController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewOffertaController extends baseController {
    // view-offerta-aziendale.ftl

    private void er404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/404");
        dispatcher.forward(request, response);
    }

    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }

    private void er403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/403");
        dispatcher.forward(request, response);
    }

    private List<Object> creaOggetti(HttpServletRequest request, HttpServletResponse response, OffertaTirocinio offertaTirocinio, boolean errore) throws ServletException, IOException, DaoException {
        TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
        List<Tirocinio> tirocinioList= new ArrayList<>();
        List<Object> lista = new ArrayList<>();
        try {
            tirocinioList = tirocinioDaoImp.getTrByOfferta(offertaTirocinio);
        } catch (DaoException e) {
            e.printStackTrace();
            errore = true;
            er404(request, response);
        }
        if (!errore){
            for (Tirocinio tirocinio: tirocinioList){
                Map<String, Object> mappa= new HashMap<String, Object> ();
                int idTircinante = tirocinio.getTirocinante();
                TirocinanteDaoImp tirocinanteDaoImp = new TirocinanteDaoImp();
                Tirocinante tirocinante = tirocinanteDaoImp.getTirocianteByID(idTircinante);
                tirocinanteDaoImp.destroy();
                UserDaoImp daoUser = new UserDaoImp();
                User user = daoUser.getUserByid(tirocinante.getUser());
                daoUser.destroy();
                mappa.put("tirocinio", tirocinio);
                mappa.put("userMail", user.getEmail());
                mappa.put("tirocinante", tirocinante);
                mappa.put("offerta", offertaTirocinio);
                lista.add(mappa);
            }
            lista.add(errore);
        }
        return lista;
    }

    private void processaGet(HttpServletRequest request, HttpServletResponse response, SingSessionContoller session) throws ServletException, IOException, DaoException {
        boolean errore = false;
        int idOfferta = 0;
        if (request.getParameter("id") != null) {
            idOfferta = Integer.parseInt(request.getParameter("id"));
            System.out.println("id del offerta è : " + idOfferta);
        } else {
            errore = true;
            er500(request, response);
        }
        if(!errore) {
            OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
            OffertaTirocinio offertaTirocinio = new OffertaTirocinio();
            try {
                offertaTirocinio = offertaTirocinioDaoImp.getOffertatrByID(idOfferta);
                offertaTirocinioDaoImp.destroy();
                System.out.println("ricavo offerta");
            } catch (DaoException e) {
                e.printStackTrace();
                errore = true;
                er404(request, response);
            }
            if(!errore) {
                if (!offertaTirocinio.getAzienda().equals(session.getAzienda(request, response).getIDAzienda())) {
                    errore = true;
                    er403(request, response);
                }
                if(!errore){
                    System.out.println("Richiedo lista oggetti");
                    List<Object> lista = creaOggetti(request, response, offertaTirocinio, false);
                    System.out.println("Contenuto lista : " + lista.get(lista.size()-1) );
                    if(!(boolean)lista.get(lista.size()-1)){
                        List<Object> listaAll = new ArrayList<>();
                        for (int i=0; i<lista.size()-1; i++){
                            listaAll.add(lista.get(i));
                        }
                        datamodel.put("Lista", listaAll);
                        datamodel.put("titoloOfferta", offertaTirocinio.getTitolo());
                        datamodel.put("LuogoEffettuazione", offertaTirocinio.getLuogoEffettuazione());
                        datamodel.put("Descrizione", offertaTirocinio.getDescrizione());
                        datamodel.put("DescrizioneBreve",offertaTirocinio.getDescrizioneBreve());
                        datamodel.put("Orario", offertaTirocinio.getOrari());
                        datamodel.put("PeriodoInizio", offertaTirocinio.getPeriodoInizio());
                        datamodel.put("PeriodoFine", offertaTirocinio.getPeriodoFine());
                        datamodel.put("Obbiettivi", offertaTirocinio.getObbiettivi());
                        datamodel.put("Modalita", offertaTirocinio.getModalita());
                        datamodel.put("Rimbosi", offertaTirocinio.getRimborsi());
                        datamodel.put("Facilitazioni", offertaTirocinio.getFacilitazioni());
                        datamodel.put("NomeRespAz", offertaTirocinio.getNomeTutoreAziendale());
                        datamodel.put("CognomeRepAz", offertaTirocinio.getCognomeTutoreAziendale());
                        datamodel.put("EmailRespAZ", offertaTirocinio.getEmailTutoreAziendale());
                        datamodel.put("TelRespAz", offertaTirocinio.getTelefonoTutoreAziendale());
                        System.out.println("termino il datamodel");
                        TemplateController.process("view-offerta-aziendale.ftl", datamodel, response, getServletContext());
                    }
                }
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        System.out.println("Ricevo richiesta");
        SingSessionContoller session = SingSessionContoller.getInstance();
        if (session.isAzienda(request)){
            try {
                System.out.println("invoco processoGet");
                processaGet(request, response, session);
                System.out.println("gettato");
            } catch (DaoException e) {
                e.printStackTrace();
                er404(request, response);
            }
        } else {
            er403(request, response);
        }
    }
}
