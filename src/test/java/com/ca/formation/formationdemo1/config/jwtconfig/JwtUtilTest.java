package com.ca.formation.formationdemo1.config.jwtconfig;

import com.ca.formation.formationdemo1.models.Utilisateur;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JwtUtilTest {
    JwtUtil jwtUtil = new JwtUtil();


    @Test
    public void testValidate() throws Exception {
        boolean result = jwtUtil.validate("token");
        Assert.assertEquals(false, result);
    }




}

