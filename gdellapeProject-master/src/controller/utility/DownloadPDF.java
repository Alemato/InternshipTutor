package controller.utility;

import controller.baseController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadPDF extends baseController {

    /**
     * @param request  richiesta
     * @param response risposta
     * @param filename nome del file
     * @param saveDir  albero
     *                 albero cartelle Convenzione ./PDF/Covenzione/IDAzienda/NOMEPDF.pdf
     *                 albero cartelle Richiesta di tirocinio ./PDF/RichesteTirocinio/IDTirocinio/IDTirocininate/NOMEPDF.pdf
     *                 albero cartella Fine Tirocinio Azienda ./PDF/FineTirocinio/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     *                 albero cartella Segreteria ./PDF/Segreteria/IDTirocinio/IDTirocininante/NOMEPDF.pdf
     * @throws IOException
     */
    public Boolean DownloadPDF(HttpServletRequest request, HttpServletResponse response, String filename, String saveDir) throws IOException {
        String appPath = request.getServletContext().getRealPath("");
        if (Validation.fileDirValidation(appPath, saveDir, filename)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            response.setContentType("application/pdf");
//          response.setHeader("Content-Disposition", "attachment; filename=\""
//                + filename + "\"");
            FileInputStream fileInputStream = new FileInputStream(appPath + File.separator + saveDir + File.separator
                    + filename);


            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
            return true;
        } else {
            return false;
        }
    }
}
