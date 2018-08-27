package controller.utility;

import dao.exception.DaoException;
import dao.implementation.AdminDaoImp;
import dao.implementation.AziendaDaoImp;
import dao.implementation.TirocinanteDaoImp;
import model.Admin;
import model.Azienda;
import model.Tirocinante;
import model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utility {
    public static Boolean isEmail(String mail){

        String email = "vivek.mitra@gmail.com";
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if(mat.matches()){

            return true;
        }else{

           return false;
        }
    }




    }




