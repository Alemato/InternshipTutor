package controller.utility;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.*;

public class Validation {
    private static Integer numChar(String s){
        int charCount = 0;
        char temp;
        for( int i = 0; i < s.length( ); i++ )
        {
            temp = s.charAt( i );
            if(isLetter(temp))
                charCount++;
        }
        return charCount;
    }

    private static Integer numDigit(String s){
        int charCount = 0;
        char temp;
        for( int i = 0; i < s.length( ); i++ )
        {
            temp = s.charAt( i );
            if(isDigit(temp))
                charCount++;
        }
        return charCount;
    }


    private static Integer numSpecialChar(String s){
        int charCount = 0;
        char temp;
        for( int i = 0; i < s.length( ); i++ )
        {
            temp = s.charAt( i );
            if(!isAlphabetic(temp) && !isDigit(temp))
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

}
