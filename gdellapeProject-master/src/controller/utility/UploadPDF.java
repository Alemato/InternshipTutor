package controller.utility;

import controller.baseController;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadPDF extends baseController {

    // ...\out\artifacts\gdellapeProject_master_war_exploded\Convenzioni
    private static final String SAVE_DIR = "Convenzioni";


    public void Upload(HttpServletRequest request, HttpServletResponse response, String saveDir) throws ServletException, IOException, NoSuchAlgorithmException {

        // ...\out\artifacts\gdellapeProject_master_war_exploded\savePath

        String hex;
        MessageDigest md = MessageDigest.getInstance("MD5");
        // percorso assoluto dell'app
        String appPath = request.getServletContext().getRealPath("");
        // percorso nel quale salvare il file
        String savePath = appPath + File.separator + saveDir;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);

        // se volessimo salvarlo un un'altra directory
        // File fileSaveDir = new File(saveDir);

        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        for (Part part : request.getParts()) {
            String fileName = FileName(part);
            // Check se il file è un PDF                   Da migliorare
            if (fileName.endsWith(".pdf")) {

                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);

            }
        }
    }

    // estrae il nome del file
    private String FileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private static String checksum(String filepath, MessageDigest md) throws IOException {

        // DigestInputStream is better, but you also can hash file like this.
        try (InputStream fis = new FileInputStream(filepath)) {
            byte[] buffer = new byte[1024];
            int nread;
            while ((nread = fis.read(buffer)) != -1) {
                md.update(buffer, 0, nread);
            }
        }

        // bytes to hex
        StringBuilder result = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        return result.toString();

    }

}