package controller.utility;

import controller.Exeption.PdfException;
import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TirocinanteDaoDaoImp;
import model.Azienda;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import org.unbescape.html.HtmlEscape;
import view.TemplateControllerMail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadFilePDF{
    /**
     * @param request richiesta
     * @param part    variabile di tipo Part del file che si ricava tramite:
     *                *          Part parto = request.getPart("NOME FORM");
     * @param tipoPdf variabile intera che identifica il tipo di PDF da caicare:
     *                0 se si tratta di PDF della Convenzione
     *                1 se si tratta di PDF della Richiesta di Tirocinio
     *                2 se si tratta di PDF di Fine Tirocinio
     *                3 se si tratta di PDF di della Segreteria
     * @param object  oggetto che può essere di tipo Azienda se tipoPdf è uguale a 0
     *                o di tipo Tirocinio se tipoPdf è uguale a 1, 2, 3
     *                <p>
     *                albero cartelle Convenzione ./PDF/Convenzione/IDAzienda/NOMEPDF.pdf
     *                albero cartelle Richiesta di tirocinio ./PDF/RichestaTirocinio/IDTirocinio/IDTirocininate/NOMEPDF.pdf
     *                albero cartella Fine Tirocinio Azienda ./PDF/FineTirocinioAzienda/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     *                albero cartella Segreteria ./PDF/Segreteria/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     * @return torna il nome del file che serve per caricare sul DB o "" se si presenta un errore
     * @throws IOException    per il metodo write
     * @throws PdfException   se il file non ha estensione .pdf
     */
    public String uploadPDF(HttpServletRequest request, Part part, int tipoPdf, Object object) throws IOException, PdfException {

        // percorso assoluto dell'app
        String appPath = request.getServletContext().getRealPath("");
        if (!(tipoPdf == 0 || tipoPdf == 1 || tipoPdf == 2 || tipoPdf == 3))
            return "";
        String completeSavePath = appPath + File.separator + "PDF" + File.separator + checkTipoPdf(object, tipoPdf);

        File fileSaveDir = new File(completeSavePath);
        // creo se non esiste la directory di destinazione
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fileName = fileName(part);
        // Check se il file è un PDF

        if (!(fileName.endsWith(".pdf"))) {
            throw new PdfException("Errore: il file non è un PDF");
        }
        fileName = new File(fileName).getName();
        part.write(completeSavePath + File.separator + fileName);
        Map<String, Object> datamodel=new HashMap<>();
        if(tipoPdf==0){
            Azienda azienda = (Azienda)object;
            String[] to = new String[1];
            to[0]= "azienda@matteifamily.net";
            String subject = HtmlEscape.escapeHtml5( "Recezzione Modulo Convenzione dell'Azienda : " + azienda.getRagioneSociale());
            TemplateControllerMail.process("email/invio-modulo-convenzione-aziendale.ftl", datamodel, to, subject, request.getServletContext());
        } else if(tipoPdf==1){
            Tirocinio tirocinio = (Tirocinio) object;
            OffertaTirocinioDaoImp offertaTirocinioDaoImp = new OffertaTirocinioDaoImp();
            TirocinanteDaoDaoImp tirocinanteDaoImp = new TirocinanteDaoDaoImp();
            OffertaTirocinio offertaTirocinio=new OffertaTirocinio();
            Tirocinante tirocinante= new Tirocinante();
            try {
                offertaTirocinio=offertaTirocinioDaoImp.getOffertatrByID(tirocinio.getOffertaTirocinio());
                offertaTirocinioDaoImp.destroy();
                tirocinante=tirocinanteDaoImp.getTirocianteByID(tirocinio.getTirocinante());
                tirocinanteDaoImp.destroy();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            datamodel.put("Titolo",offertaTirocinio.getTitolo());
            datamodel.put("Descrizione",offertaTirocinio.getDescrizione());
            datamodel.put("DescrizioneBreve",offertaTirocinio.getDescrizioneBreve());
            datamodel.put("LuogoEffettuazione",offertaTirocinio.getLuogoEffettuazione());
            datamodel.put("Orario",offertaTirocinio.getOrari());
            datamodel.put("PeriodoInizio",offertaTirocinio.getPeriodoInizio());
            datamodel.put("PeriodoFine",offertaTirocinio.getPeriodoFine());
            datamodel.put("Obbiettivi",offertaTirocinio.getObbiettivi());
            datamodel.put("Modalita",offertaTirocinio.getModalita());
            datamodel.put("Rimbosi",offertaTirocinio.getRimborsi());
            datamodel.put("Facilitazioni",offertaTirocinio.getFacilitazioni());
            datamodel.put("NomeRespAz",offertaTirocinio.getNomeTutoreAziendale());
            datamodel.put("CognomeRepAz",offertaTirocinio.getCognomeTutoreAziendale());
            datamodel.put("EmailRespAZ",offertaTirocinio.getEmailTutoreAziendale());
            datamodel.put("TelRespAz",offertaTirocinio.getTelefonoTutoreAziendale());
            datamodel.put("tirocinante",tirocinante);
            String[] to = new String[2];
            to[0]= "azienda@matteifamily.net";
            to[1]= "tutore@matteifamily.net";
            String subject = HtmlEscape.escapeHtml5( "Recezzione Richesta di tirocinio da parte di : "+ tirocinante.getNome()+" "+tirocinante.getCognome() + "per l'offerta : " + offertaTirocinio.getTitolo());
            TemplateControllerMail.process("email/invio-richiesta-tirocinio-azienda-tutore.ftl", datamodel, to, subject, request.getServletContext());
            String[] toTirocinante = new String[1];
            toTirocinante[0]="tirocinante@matteifamily.net";
            TemplateControllerMail.process("email/invio-richiesta-tirocinio-tirocinante.ftl", datamodel, toTirocinante, subject, request.getServletContext());
            String subjectTirocinante = "Notifica di recezzione Modulo PDF della richiesta di tirocinio : " + offertaTirocinio.getTitolo();
            TemplateControllerMail.process("email/invio-modulo-richiesta-tirocinio.ftl", datamodel, toTirocinante, subjectTirocinante, request.getServletContext());
        }
        return fileName;
    }


    /**
     * @param part variabile di tipo Part del file che si ricava tramite:
     * @return il nome del file o "" se c'è stato un errore
     */

    private String fileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    /**
     * @param object  oggetto che può essere di tipo Azienda se tipoPdf è uguale a 0
     *                o di tipo Tirocinio se tipoPdf è uguale a 1, 2, 3
     * @param tipoPdf variabile intera che identifica il tipo di PDF da caicare:
     *                0 se si tratta di PDF della Convenzione
     *                1 se si tratta di PDF della Richiesta di Tirocinio
     *                2 se si tratta di PDF di Fine Tirocinio
     *                3 se si tratta di PDF di della Segreteria
     * @return percorso parziale nel quale andrà salvato il PDF
     */

    private String checkTipoPdf(Object object, int tipoPdf) {
        String savePath = "";
        if (object instanceof Azienda && tipoPdf == 0) {
//            PDF Convenzione Azienda
            savePath = savePath.concat("Convenzione" + File.separator);
            savePath = savePath.concat(((Azienda) object).getIDAzienda() + File.separator);
        } else if (object instanceof Tirocinio) {
            if (tipoPdf == 1) {
//                PDF della Richiesta di Tirocinio
                savePath = savePath.concat("RichiestaTirocinio" + File.separator);
            } else if (tipoPdf == 3) {
//                PDF della Segreteria
                savePath = savePath.concat("Segreteria" + File.separator);

            } else if (tipoPdf == 2) {
//                PDF di Fine Tirocinio
                savePath = savePath.concat("FineTirocinioAzienda" + File.separator);
            }
            savePath = savePath.concat(((Tirocinio) object).getIDTirocinio() + File.separator);
            savePath = savePath.concat(((Tirocinio) object).getTirocinante() + File.separator);
        }
        return savePath;
    }

}