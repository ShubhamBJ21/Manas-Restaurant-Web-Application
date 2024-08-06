package com.shubham.validation;

import java.util.regex.Pattern;

public class AdminLoginValidationImp implements AdminLoginValidation {

    private String result;

    @Override
    public String adminLoginValidation1(String username, String password) {

        try {
        	username = username.trim();
            password = password.trim();

            int userLength = username.length();
            int passLength = password.length();

            // Define regex patterns
            
            Pattern hasUpperCase = Pattern.compile("[A-Z]");
            Pattern hasLowerCase = Pattern.compile("[a-z]");
            Pattern hasDigit = Pattern.compile("[0-9]");
            Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]");
            Pattern hasSpace = Pattern.compile("\\s");

            if (userLength < 3 || userLength > 16) {
                result = "ERROR IN ADMIN USERNAME";
            } 
            else if (passLength < 5 
                    || !hasUpperCase.matcher(password).find()
                    || !hasLowerCase.matcher(password).find()
                    || !hasDigit.matcher(password).find()
                    || !hasSpecialChar.matcher(password).find()
                    || hasSpace.matcher(password).find() 
            	    || passLength > 20)
            {
                result = "ERROR IN ADMIN PASSWORD";
            } 
            else {
                result = "VALID";
            }
        }catch(Exception e){
        	e.addSuppressed(e);
        	result = "SOMETHING WENT IN VALIDATION";
        }

        return result;
    }
}
