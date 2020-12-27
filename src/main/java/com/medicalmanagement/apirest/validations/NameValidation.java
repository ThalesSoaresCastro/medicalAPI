package com.medicalmanagement.apirest.validations;

import java.util.regex.Pattern;

public class NameValidation {
    public int validate(String name) {

        //String regValidationName = "/^[a-záàâãéèêíïóôõöúçñ ]+$/i";

        //Regex verifica se existe apenas letras e espaços na string.
        //String regValidationName="^[ a-zA-Z á]*$";
        String regValidationName="^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]+$";

        Pattern p = Pattern.compile(regValidationName);

        if (name.length() < 2)
            return 0;

        if (name.length() > 255)
            return 0;

        if (!(p.matcher(name).matches()))
            return 0;

        return 1;
    }
}
