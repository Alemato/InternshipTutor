package controller.utility;

import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import dao.implementation.UserDaoImp;
import model.TutoreUniversitario;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.*;

public class Validation {
    /**
     * inserisco la data e giorni da quella data per la scadenza e mi da una mappa con
     * con calPresente "presente", calPassato "passato", BoleanScaduto "scaduto"
     * calPassato e' la data piu' i giorni alla scadenza
     *
     * @param data   data iniziale da cui iniziare a contare i giorni
     * @param giorni giorni alla scadenza
     * @return Map con "prensente" cal presente, "passato" cal data scandenza,
     * "scaduto" bolean per dire se e' scaduto o meno
     */
    public static Map<String, Object> scadenza(Date data, Integer giorni) {
        Map<String, Object> scadenze = new HashMap<>();
        Calendar presente = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
        scadenze.put("presente", presente);
        Calendar passato = Calendar.getInstance();
        passato.setTime(data);
        passato.add(Calendar.DAY_OF_MONTH, +giorni);
        scadenze.put("passato", passato);
        scadenze.put("scaduto", presente.after(passato));
        return scadenze;
    }

    private static Integer numChar(String s) {
        int charCount = 0;
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (isLetter(temp))
                charCount++;
        }
        return charCount;
    }

    private static Integer numDigit(String s) {
        int charCount = 0;
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (isDigit(temp))
                charCount++;
        }
        return charCount;
    }


    private static Integer numSpecialChar(String s) {
        int charCount = 0;
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (!isAlphabetic(temp) && !isDigit(temp))
                charCount++;
        }
        return charCount;
    }

    private static boolean EmailTrust(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if (EmailTrust(email)) {
            return mat.matches();
        } else {
            return false;
        }
    }

    public static boolean isStoredThisAddress(String email) throws DaoException {
        UserDaoImp dao = new UserDaoImp();
        boolean result = dao.existIsMail(email);
        dao.destroy();
        return result;

    }

    public static boolean isStoreThisMailTutore(String email) throws DaoException {
        TutoreUniversitarioDaoImp dao = new TutoreUniversitarioDaoImp();
        List<TutoreUniversitario> tutori = dao.getAllTutUni();
        List<String> listemail = new ArrayList<>();
        dao.destroy();
        for (TutoreUniversitario tutore : tutori
        ) {
            listemail.add(tutore.getEmail());

        }

        return listemail.contains(email);
    }

}
