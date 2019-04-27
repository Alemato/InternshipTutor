package controller.utility;

import controller.Exeption.PdfException;
import model.Azienda;
import model.Tirocinio;

import java.io.File;
import java.io.IOException;
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