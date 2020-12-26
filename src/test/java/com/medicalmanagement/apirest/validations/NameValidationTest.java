package com.medicalmanagement.apirest.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class NameValidationTest {

    @Autowired
    NameValidation nameValidation = new NameValidation();

    @Test
    public void NomeCorreto(){
        String correctName = "Marcelo Ferres";
        assertEquals(nameValidation.validate(correctName) , 1);
    }

    @Test
    public void umaLetra(){
        String name = "t";
        assertEquals(nameValidation.validate(name), 0);
    }

    @Test
    public void maxLetras(){
        /*String com no máximo 255 caracteres*/
        String name = "t".repeat(256);
        assertEquals(nameValidation.validate(name), 0);
    }

    @Test
    public void numeroNome(){
        String name = "R@afael T3xeira";
        assertEquals(nameValidation.validate(name), 0);
    }

}