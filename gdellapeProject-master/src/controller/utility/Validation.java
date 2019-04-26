package controller.utility;

import dao.exception.DaoException;
import dao.implementation.OffertaTirocinioDaoImp;
import dao.implementation.TutoreUniversitarioDaoImp;
import dao.implementation.UserDaoImp;
import model.TutoreUniversitario;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.*;

public class Validation {

    /**
     * Funzione che valida um testo che abbia un massimo di 50 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text50(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 50){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
        risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 30 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text30(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 30){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
        risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 10 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text20(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 20){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
        risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 10 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text10(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 10){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
        risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 500 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text500(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 500){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
        return risulatato;
    }


    /**
     * Funzione che valida um numero (ore, mesi) ce siano maggiori o uguali a 0 e minori di 1000
     * @param integer contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> durateUgualeMaggiore0Minore10000(Integer integer, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(integer <= 0){
            messaggio = nomeVariabile + " non congrua";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if ( integer > 1000){
            messaggio = nomeVariabile + " non congrua";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 1000 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text1000(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 1000){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 200 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text200(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 200){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    /**
     * Funzione che valida um testo che abbia un massimo di 100 caratteri
     * @param text contenuto della variabile da validare
     * @param nomeVariabile nome della variabile, per il messaggio di errore
     * @return  ritona una mappa che contiene come chiave un booleano che rappresenta il risultato della validazione
     *          e una stringa che contiene il messaggio di errore
     */
    public static Map<String, Object> text100(String text, String nomeVariabile){
        Map<String, Object> risulatato = new HashMap<>();
        Boolean valido = true;
        String messaggio = "";
        if(text.isEmpty()){
            messaggio = nomeVariabile + " non prensente";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }else if (text.length() > 100){
            messaggio = nomeVariabile + " troppo lungo";
            valido = false;
            risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
            return risulatato;
        }
        risulatato.put("valido", valido);
            risulatato.put("messaggio", messaggio);
        return risulatato;
    }

    public static Boolean fileDirValidation(String appPath, String saveDir, String filename){
        File dir = new File(appPath+saveDir);
        File file = new File(appPath + saveDir + File.separator + filename);
        return dir.exists() && dir.isDirectory() && file.exists() && file.isFile();
    }

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
        if (data!=null) {
            Calendar passato = Calendar.getInstance();
            passato.setTime(data);
            passato.add(Calendar.DAY_OF_MONTH, +giorni);
            scadenze.put("passato", passato);
            scadenze.put("scaduto", presente.after(passato));
        }else {
            scadenze.put("passato", presente);
            scadenze.put("scaduto", true);
        }

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
