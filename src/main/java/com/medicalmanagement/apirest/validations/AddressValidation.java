package com.medicalmanagement.apirest.validations;

import java.util.regex.Pattern;

public class AddressValidation {

    String regValidationString ="^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]+$";

    public int ruaValidate(String rua) {
        Pattern p = Pattern.compile(regValidationString);

        if(rua.length() < 2 || rua.length() >255)
            return 0;

        if (!p.matcher(rua).matches())
            return 0;

        return 1;
    }


    public int bairroValidate(String bairro) {
        Pattern p = Pattern.compile(regValidationString);

        if(bairro.length() < 2 || bairro.length() > 255)
            return 0;

        if(!p.matcher(bairro).matches())
            return 0;

        return 1;
    }

    public int cidadeValidate(String cidade) {
        Pattern p = Pattern.compile(regValidationString);

        if(cidade.length() < 2 || cidade.length() > 255)
            return 0;

        if (!p.matcher(cidade).matches())
            return 0;

        return 1;
    }

    public int estadoValidate(String estado) {
        Pattern p = Pattern.compile(regValidationString);

        if (estado.length() < 2 || estado.length() > 255)
            return 0;

        if (!p.matcher(estado).matches())
            return 0;

        return 1;
    }

    public int paisValidate(String pais) {
        Pattern p = Pattern.compile(regValidationString);

        if (pais.length() < 2 || pais.length() > 255)
            return 0;

        if (!p.matcher(pais).matches())
            return 0;

        return 1;
    }

    public int cepValidate(String cep) {
        String regValidate = "^[-0-9]*$";
        Pattern p = Pattern.compile(regValidate);

        if (cep.length() != 9)
            return 0;

        if (!p.matcher(cep).matches())
            return 0;

        return 1;

    }

    public int numeroValidate(long numero) {

        if (numero < 1 || numero > (500000))
            return 0;

        return 1;
    }
}
