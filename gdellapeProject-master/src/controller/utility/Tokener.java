package controller.utility;

import java.util.UUID;

public class Tokener {

    public Tokener(){
        String token = null;
    }

    public static String generateGenericToken(){
        String token = UUID.randomUUID().toString();
        token = token.replace("-", "");
        return token;
    }

    public static String generateResetToken(String id, String tipologia){
        String token = UUID.randomUUID().toString();
        token = id + token.replace("-", "") + tipologia;
        return token;
    }
}
