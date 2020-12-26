package com.medicalmanagement.apirest.validations;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CrmValidation {
    public int validate(String crm) {

        String regDigits = "^[0-9]*$";
        String regState = "^[/a-zA-z]*$";

        Pattern pD = Pattern.compile(regDigits);
        Pattern pS = Pattern.compile(regState);

        if(crm.length() > 13){
            return 0;
        }

        if(crm.length() < 4){
            return 0;
        }

        String[] arr = crm.split("/");

        if( !(pD.matcher(arr[0]).matches()) || !(pS.matcher(arr[1])).matches())
            return 0;

        return 1;
    }
}
