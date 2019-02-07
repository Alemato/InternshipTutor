package controller.utility;

import controller.baseController;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UploadPDF extends baseController {


    public Boolean Upload(String savePath, Part part) throws SecurityException, IOException, NoSuchAlgorithmException {



        MessageDigest md = MessageDigest.getInstance("MD5");
        File uploaded_file = File.createTempFile("upload_", "", new File(getServletContext().getInitParameter("uploads.directory")));

        try (InputStream is = part.getInputStream();
             OutputStream os = new FileOutputStream(uploaded_file)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) > 0) {
                //durante la copia, aggreghiamo i byte del file nel digest sha-1
                //while copying, we aggregate the file bytes in the sha-1 digest
                md.update(buffer, 0, read);
                os.write(buffer, 0, read);
            }
        }
        byte[] digest = md.digest();
        String sdigest = "";
        for (byte b : digest) {
            sdigest += String.valueOf(b);
        }

        // percorso assoluto dell'app
        // String appPath = request.getServletContext().getRealPath("");
        // percorso nel quale salvare il file
        // String savePath = appPath + File.separator + saveDir;
        File fileSaveDir = new File(savePath);
        // creo se non esiste la directory di destinazione
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = FileName(part);
        // Check se il file è un PDF                   Da migliorare
        if (fileName.endsWith(".pdf")) {
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName + sdigest);

            MessageDigest mdAfter = MessageDigest.getInstance("MD5");
            String hexAfter = checksum(savePath + File.separator + fileName + sdigest, mdAfter);
            if (sdigest.equals(hexAfter)) {
                return true;
            }
            else{
                Path path = FileSystems.getDefault().getPath(savePath, fileName + sdigest);
               //delete file
                Files.delete(path);
                return false;
            }
        }
        return false;
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

    private static String checksum(String pathpath, MessageDigest md) throws IOException {

        // DigestInputStream is better, but you also can hash file like this.
        try (InputStream fis = new FileInputStream(pathpath)) {
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