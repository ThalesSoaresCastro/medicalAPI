package com.medicalmanagement.apirest.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AddressValidationTest {

    @Autowired
    AddressValidation addressValidation = new AddressValidation();

    @Test
    public void ruaCorrect(){
        String rua = "Pimenteiras Nogueira";
        assertEquals( 1, addressValidation.ruaValidate(rua));
    }

    @Test
    public void ruaIncorrect(){
        String rua = "P1m3nt3ir@s";
        assertEquals( 0, addressValidation.ruaValidate(rua));
    }

    @Test
    public void ruaTamMin(){
        String rua = "P";
        assertEquals( 0, addressValidation.ruaValidate(rua));
    }

    @Test
    public void ruaTamMax(){
        String rua = "P".repeat(256);
        assertEquals( 0, addressValidation.ruaValidate(rua));
    }

    @Test
    public void bairroCorrect(){
        String bairro = "Parque das Flores";
        assertEquals(1, addressValidation.bairroValidate(bairro));
    }

    @Test
    public void bairroinCorrect(){
        String bairro = "P@rqu3 d@s Fl0r35";
        assertEquals(0, addressValidation.bairroValidate(bairro));
    }

    @Test
    public void bairroTamMin(){
        String bairro = "P";
        assertEquals(0, addressValidation.bairroValidate(bairro));
    }

    @Test
    public void bairroTamMax(){
        String bairro = "P".repeat(256);
        assertEquals(0, addressValidation.bairroValidate(bairro));
    }

    @Test
    public void cidadeCorrect(){
        String cidade = "São Paulo";
        assertEquals(1, addressValidation.cidadeValidate(cidade));
    }

    @Test
    public void cidadeIncorrect(){
        String cidade = "S@o P@ul0";
        assertEquals(0, addressValidation.cidadeValidate(cidade));
    }

    @Test
    public void cidadeTamMin(){
        String cidade = "S";
        assertEquals(0, addressValidation.cidadeValidate(cidade));
    }

    @Test
    public void cidadeTamMax(){
        String cidade = "S".repeat(256);
        assertEquals(0, addressValidation.cidadeValidate(cidade));
    }


    @Test
    public void estadoCorrect(){
        String estado = "Rio Grande do Sul";
        assertEquals(1, addressValidation.estadoValidate(estado));
    }

    @Test
    public void estadoIncorrect(){
        String estado = "Ri0 Gr@and3 do Sul";
        assertEquals(0, addressValidation.estadoValidate(estado));
    }

    @Test
    public void estadoTamMin(){
        String estado = "S";
        assertEquals(0, addressValidation.estadoValidate(estado));
    }

    @Test
    public void estadoTamMax(){
        String estado = "S".repeat(256);
        assertEquals(0, addressValidation.estadoValidate(estado));
    }

    @Test
    public void paisCorrect(){
        String pais = "Inglaterra";
        assertEquals(1, addressValidation.paisValidate(pais));
    }

    @Test
    public void paisIncorrect(){
        String pais = "Ingl@t3rr@";
        assertEquals(0, addressValidation.paisValidate(pais));
    }

    @Test
    public void paisTamMin(){
        String pais = "I";
        assertEquals(0, addressValidation.paisValidate(pais));
    }

    @Test
    public void paisTamMax(){
        String pais = "I".repeat(256);
        assertEquals(0, addressValidation.paisValidate(pais));
    }

    @Test
    public void cepCorrect(){
        String cep = "12234-750";
        assertEquals(1, addressValidation.cepValidate(cep));
    }

    @Test
    public void cepIncorrect(){
        String cep = "l2344-7s0";
        assertEquals(0, addressValidation.cepValidate(cep));
    }

    @Test
    public void cepTamMin(){
        String cep = "1";
        assertEquals(0, addressValidation.cepValidate(cep));
    }

    @Test
    public void cepTamMax(){
        String cep = "1".repeat(256);
        assertEquals(0, addressValidation.cepValidate(cep));
    }

    @Test
    public void numeroCorrect(){
        long numero = 1223;
        assertEquals(1, addressValidation.numeroValidate(numero));
    }

    @Test
    public void numeroTamMin(){
        long numero = 0;
        assertEquals(0, addressValidation.numeroValidate(numero));
    }

    @Test
    public void numeroTamMax(){
        long numero =(long) Math.pow(20, 30);
        assertEquals(0, addressValidation.numeroValidate(numero));
    }
}