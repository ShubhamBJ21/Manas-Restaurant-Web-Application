package com.shubham.validation;

public class ServiceModuleValidationImp implements ServiceModuleValidation {

    @Override
    public String serviceModuleValidation(String iconname, String title, String description) {

        int iconnamelength = iconname.length();
        int titlelength = title.length();
        int descriptionlength = description.length();

        if (iconnamelength < 1 || iconnamelength > 15) {
            return "INVALID: ICON LENGTH IS NOT VALID";
        } else if (titlelength < 2 || titlelength > 15) {
            return "INVALID: TITLE LENGTH IS NOT VALID";
        } else if (descriptionlength < 10 || descriptionlength > 70) {
            return "INVALID: DESCRIPTION LENGTH MUST BE BETWEEN 10 TO 50 CHARACTERS";
        } else {
            return "VALID";
        }
    }
}
