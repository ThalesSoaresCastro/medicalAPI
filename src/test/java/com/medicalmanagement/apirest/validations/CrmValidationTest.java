package com.medicalmanagement.apirest.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CrmValidationTest {

    @Autowired
    CrmValidation crmValidation = new CrmValidation();

    @Test
    public void crmCorreto(){
        String crm = "0000000000/SP";
        assertEquals(1, crmValidation.validate(crm));
    }

    @Test
    public void crmMaxValue(){
        String crm = "000000000000/SP";
        assertEquals(0, crmValidation.validate(crm));
    }

    @Test
    public void crmMinValue(){
        String crm = "/SP";
        assertEquals(0, crmValidation.validate(crm));
    }

    @Test
    public void crmdigitsError(){
        String crm = "0".repeat(8)+"@"+"e"+"/SP";
        assertEquals(0, crmValidation.validate(crm));
    }

    @Test
    public void crmstatesError(){
        String crm = "0".repeat(10)+"/3@";
        assertEquals(0, crmValidation.validate(crm));
    }

}