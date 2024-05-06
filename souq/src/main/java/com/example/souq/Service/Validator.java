package com.example.souq.Service;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isvalidEmail(String emailAddress){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return  Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean isvalidNumber(String number) {
        String regexPattern = "[0-9]+";
        return Pattern.compile(regexPattern)
                .matcher(number)
                .matches();
    }

    public static boolean isvalidWord(String word){
        String regexPattern = "[A-Za-z]+";
        return  Pattern.compile(regexPattern)
                .matcher(word)
                .matches();
    }

}
