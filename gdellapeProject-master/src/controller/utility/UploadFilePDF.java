package controller.utility;

import controller.Exeption.PdfException;
import controller.baseController;

import java.io.File;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadFilePDF extends baseController {

    /**
     * @param request  richiesta
     * @param savePath albero cartelle Convenzione ./PDF/Covenzione/IDAzienda/NOMEPDF.pdf
     *                 albero cartelle Richiesta di tirocinio ./PDF/RichestaTirocinio/IDTirocinio/IDTirocininate/NOMEPDF.pdf
     *                 albero cartella Fine Tirocinio Azienda ./PDF/FineTirocinio/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     *                 albero cartella Segreteria ./PDF/Segreteria/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     * @param part     variabile di tipo Part del file che si ricava tramite:
     *                 Part parto = request.getPart("NOME FORM");
     * @return torna il nome del file che serve per caricare sul DB
     * @throws IOException
     * @throws PdfException
     */
    public String uploadPDF(HttpServletRequest request, String savePath, Part part) throws IOException, PdfException {

        // ...\out\artifacts\gdellapeProject_master_war_exploded\savePath

        // percorso assoluto dell'app
        String appPath = request.getServletContext().getRealPath("");
        String completeSavePath = appPath + File.separator + savePath;
        File fileSaveDir = new File(completeSavePath);
        // creo se non esiste la directory di destinazione
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
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

    // estrae il nome del file
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

}