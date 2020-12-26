package com.medicalmanagement.apirest.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneCelularTest {

    @Autowired
    TelefoneCelular telefoneCelular = new TelefoneCelular();

    @Test
    public void testeCorreto(){
        String tel = "(11)99921-1223";
        assertEquals(1, telefoneCelular.validate(tel));
    }

    @Test
    public void qtediferente(){
        String tel = "(11)991-1223";
        assertEquals(0, telefoneCelular.validate(tel));
    }

    @Test
    public void simboloLetra(){
        String tel = "(11)@e991-1223";
        assertEquals(0, telefoneCelular.validate(tel));
    }



}