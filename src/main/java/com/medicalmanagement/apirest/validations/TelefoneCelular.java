package com.medicalmanagement.apirest.validations;

import java.util.regex.Pattern;

public class TelefoneCelular {
    public int validate(String tel) {

        String regValidate = "^[-()0-9]*$";
        Pattern p = Pattern.compile(regValidate);

        if (tel.length() != 14)
            return 0;

        if (!p.matcher(tel).matches())
            return 0;
        return 1;
    }
}
