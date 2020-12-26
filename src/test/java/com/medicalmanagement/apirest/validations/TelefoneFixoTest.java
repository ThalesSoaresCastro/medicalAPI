package com.medicalmanagement.apirest.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneFixoTest {

    @Autowired
    TelefoneFixo telefoneFixo = new TelefoneFixo();

    @Test
    public void testeCorreto(){
        String tel = "(11)3921-1223";
        assertEquals(1, telefoneFixo.validate(tel));
    }

    @Test
    public void qtediferente(){
        String tel = "(11)391-1223";
        assertEquals(0, telefoneFixo.validate(tel));
    }

    @Test
    public void simboloLetra(){
        String tel = "(11)@e91-1223";
        assertEquals(0, telefoneFixo.validate(tel));
    }



}