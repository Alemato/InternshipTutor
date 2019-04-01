package controller.utility;

import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static Boolean isEmail(String mail) {

        String email = "vivek.mitra@gmail.com";
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if (mat.matches()) {

            return true;
        } else {

            return false;
        }
    }

    public static String action_upload(Part file, String path) throws IOException {

        File uploaded_file = File.createTempFile("upload_", ".pdf", new File(path));

        try (InputStream is = file.getInputStream();
             OutputStream os = new FileOutputStream(uploaded_file)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) > 0) {
                os.write(buffer, 0, read);
            }
        }
        return uploaded_file.getName();

    }

    public static Date getDataToHTML(String data) {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(data);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return date;
    }

    public static HashMap<String, Object> AddAllData(HttpServletRequest request, HttpServletResponse response, List<String> namedates) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();

        for (String namedata : namedates) {
            map.put("ValueOf" + namedata, request.getParameter(namedata));
        }
        return map;


    }

    public static java.sql.Date GetCurrentDate(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return (java.sql.Date.valueOf(LocalDateTime.now().format(formato)));
    }
}




