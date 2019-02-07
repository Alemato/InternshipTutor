package controller.utility;

import controller.baseController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadPDF extends baseController  {


    public void DownloadPDF( HttpServletRequest request, HttpServletResponse response, String filename, String saveDir ) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + filename + "\"");
        String appPath = request.getServletContext().getRealPath("");
        FileInputStream fileInputStream = new FileInputStream(appPath + File.separator + saveDir + File.separator
                + filename);

        int i;
        while( (i = fileInputStream.read()) != -1 )
        {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }

}
