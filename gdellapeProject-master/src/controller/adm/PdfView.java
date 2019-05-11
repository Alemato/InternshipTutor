package controller.adm;


import controller.sessionController.SingSessionContoller;
import controller.utility.DownloadPDF;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinioDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfView {
    private boolean accessoProibito;
    private boolean errorNotFound;
    private boolean trovato;
    private int tipoAccount;
    private String tipoPdf;
    private ServletContext context;
    private Tirocinio tirocinio;
    private Azienda azienda;

    /**
     * @param tipoAccount inserire il tipo con (Integer) request.getAttribute("tipo")
     * @param tipoPdf inserire il tipo tra: RichiestaTirocinio, FineTirocinioAzienda, Segreteria, Convenzione
     * @param context inserire il context con getServletContext()
     */
    public PdfView(int tipoAccount, String tipoPdf, ServletContext context) {
        this.tipoAccount = tipoAccount;
        this.tipoPdf = tipoPdf;
        this.context = context;
        this.accessoProibito = false;
        this.errorNotFound = false;
        this.trovato = false;
        this.tirocinio = new Tirocinio();
        this.azienda = new Azienda();
    }

    /**
     * Creazione URL per Richieste di tipo: RichiestaTirocinio, FineTirocinioAzienda, Segreteria
     * @param tirocinio inserire oggetto tirocinio
     * @return stringa url da inserire nel tag <enbed>
     */
    public String createURL(Tirocinio tirocinio){
        this.tirocinio = tirocinio;
        String Url = "/pdfview/"+this.tipoPdf.toLowerCase()+"?id="+this.tirocinio.getIDTirocinio();
        return Url;
    }


    /**
     * Creazione URL per Richieste di tipo: Convenzione
     * @param azienda inserire oggetto Azienda
     * @return stringa url da inserire nel tag <enbed>
     */
    public String createURLConvenzione(Azienda azienda){
        this.azienda = azienda;
        String Url = "/pdfview/"+this.tipoPdf.toLowerCase()+"?id="+this.azienda.getIDAzienda();
        return Url;
    }

    private void inviaPDF(HttpServletResponse response, HttpServletRequest request, String filename, String saveDir) throws IOException {
        DownloadPDF d = new DownloadPDF();
        Boolean riuscito = d.DownloadPDF(request, response, filename, saveDir);
        if (!riuscito){
            errorNotFound = true;
            System.out.println("non trovo pdf");
            System.out.println("nome file: "+ filename);
            System.out.println("percorso file; "+ saveDir);
        }
    }

    private void inviaRisposta(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String filename;
        String saveDir;
        if(this.tipoPdf.equals("RichiestaTirocinio")){
            if(!this.errorNotFound && this.trovato){
                filename = this.tirocinio.getPdfTirocinante();
                saveDir = "PDF" + File.separator + this.tipoPdf + File.separator + this.tirocinio.getIDTirocinio() + File.separator + tirocinio.getTirocinante();
                inviaPDF(response, request, filename, saveDir);
            }
        } else if (this.tipoPdf.equals("FineTirocinioAzienda")){
            if(!this.errorNotFound && this.trovato){
                filename = this.tirocinio.getPdfAzienda();
                saveDir = "PDF" + File.separator + this.tipoPdf + File.separator + this.tirocinio.getIDTirocinio() + File.separator + tirocinio.getTirocinante();
                inviaPDF(response, request, filename, saveDir);
            }
        } else if (this.tipoPdf.equals("Segreteria")){
            if(!this.errorNotFound && this.trovato){
                filename = this.tirocinio.getPdfSegreteria();
                saveDir = "PDF" + File.separator + this.tipoPdf + File.separator + this.tirocinio.getIDTirocinio() + File.separator + tirocinio.getTirocinante();
                inviaPDF(response, request, filename, saveDir);
            }
        } else if (this.tipoPdf.equals("Convenzione")){
            if(!this.errorNotFound){
                filename = this.azienda.getPathPDFConvenzione();
                saveDir = "PDF" + File.separator + this.tipoPdf + File.separator + this.azienda.getIDAzienda();
                inviaPDF(response, request, filename, saveDir);
            }
        } else {
            this.errorNotFound = true;
        }

        if(this.errorNotFound){
            RequestDispatcher dispatcher = this.context.getRequestDispatcher("/404");
            dispatcher.forward(request, response);
        } else if (this.accessoProibito){
            RequestDispatcher dispatcher = this.context.getRequestDispatcher("/403");
            dispatcher.forward(request, response);
        }


    }

    /**
     * Metodo che processa le richieste di tipo: RichiestaTirocinio, FineTirocinioAzienda, Segreteria
     * @param request inserire request
     * @param response inserire response
     * @throws IOException nulla
     * @throws ServletException nulla
     */
    public void processaRichiesta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (this.tipoPdf.equals("RichiestaTirocinio") || this.tipoPdf.equals("FineTirocinioAzienda") || this.tipoPdf.equals("Segreteria")){
            if (this.tipoAccount != 0){
                if (request.getParameterMap().containsKey("id")) {
                    int idTirocinio = Integer.parseInt(request.getParameter("id"));
                    TirocinioDaoImp tirocinioDaoImp = new TirocinioDaoImp();
                    try {
                        this.tirocinio = tirocinioDaoImp.getRichiestatrByID(idTirocinio);
                        tirocinioDaoImp.destroy();
                        this.trovato = true;
                    } catch (DaoException e) {
                        this.errorNotFound = true;
                        System.out.println("tirocinio non trovato");
                    }

                    // TEST per vedere se l'Azienda e quella giusta
                    if (this.tipoAccount == 3 && !this.errorNotFound){
                        SingSessionContoller session = SingSessionContoller.getInstance();
                        this.azienda = session.getAzienda(request, response);
                        OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
                        List<OffertaTirocinio> offertaTirocinios;
                        try {
                            offertaTirocinios = offertaTirocinioDaoImp.getOffertatrBYAzienda(this.azienda);
                            offertaTirocinioDaoImp.destroy();
                            for(OffertaTirocinio offertaTirocinio : offertaTirocinios){
                                if(this.tirocinio.getOffertaTirocinio().equals(offertaTirocinio.getIDOffertaTirocinio())){
                                    this.trovato = true;
                                    System.out.println("tirocinio trovato Azienda");
                                    break;
                                }
                            }
                        } catch (DaoException e) {
                            this.errorNotFound = true;
                            System.out.println("tirocinio non trovato Azienda");
                        }
                    }
                    // TEST per verdere se il tirocinante e quello giusto
                    if ( this.tipoAccount == 2 && !this.errorNotFound){
                        SingSessionContoller session = SingSessionContoller.getInstance();
                        Tirocinante tirocinante = session.getTirocinate(request, response);
                        this.trovato = tirocinante.getIDTirocinante().equals(this.tirocinio.getTirocinante());
                        System.out.println("tirocinio stato " + this.trovato);
                    }
                } else {
                    this.errorNotFound = true;
                    System.out.println("non id");
                }
            } else {
                this.accessoProibito = true;
                System.out.println("account non diverso da 0");
            }
            inviaRisposta(response, request);
        }else {
            System.out.println("La richiesta non è di tipo: RichiestaTirocinio o FineTirocinioAzienda o Segreteria ");
            RequestDispatcher dispatcher = this.context.getRequestDispatcher("/500");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Metodo che processa le richieste di tipo: Convenzione
     * @param request inserire request
     * @param response inserire response
     * @throws ServletException nulla
     * @throws IOException nulla
     */
    public void processaRichiestaConvenzione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.tipoPdf.equals("Convenzione")){
            // Test per vedere se è Azienda o Admin
            if(this.tipoAccount == 1 || this.tipoAccount == 3){
                if (request.getParameterMap().containsKey("id")) {
                    int idConvenzione = Integer.parseInt(request.getParameter("id"));
                    // Test per vedere se è Azienda
                    if (this.tipoAccount == 3){
                        SingSessionContoller sessionContoller = SingSessionContoller.getInstance();
                        this.azienda = sessionContoller.getAzienda(request, response);
                        if(!this.azienda.getIDAzienda().equals(idConvenzione)){
                            this.accessoProibito = true;
                        }
                        // È sicuramente Admin
                    }else {
                        AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
                        try {
                            this.azienda = aziendaDaoImp.getAziendaByID(idConvenzione);
                            aziendaDaoImp.destroy();
                        } catch (DaoException e) {
                            this.errorNotFound = true;
                        }
                    }
                } else {
                    this.errorNotFound = true;
                }
            } else {
                this.accessoProibito = true;
            }
            // Carico risposta
            inviaRisposta(response, request);
        } else {
            System.out.println("La richiesta non è di tipo: Convenzione");
            RequestDispatcher dispatcher = this.context.getRequestDispatcher("/500");
            dispatcher.forward(request, response);
        }
    }
}
