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
        assertEquals( 1, nameValidation.validate(correctName));
    }

    @Test
    public void umaLetra(){
        String name = "t";
        assertEquals( 0, nameValidation.validate(name));
    }

    @Test
    public void maxLetras(){
        /*String com no máximo 255 caracteres*/
        String name = "t".repeat(256);
        assertEquals( 0, nameValidation.validate(name));
    }

    @Test
    public void numeroNome(){
        String name = "R@afael T3xeira";
        assertEquals( 0, nameValidation.validate(name));
    }

}