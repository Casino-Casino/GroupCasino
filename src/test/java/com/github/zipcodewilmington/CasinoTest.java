package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CasinoTest {
    @Test
    public void testCreateAccount(){
        Casino casino = new Casino();
        casino.createAccount();
        Assert.assertEquals(1,casino.getCasinoAccountList().size());
    }

    @Test
    public void testLoginValidAccount(){
        Casino casino = new Casino();
        casino.createAccount();
        Assert.assertTrue(casino.login("John","zipcode"));
    }

    @Test
    public void testLoginInvalidAccount(){
        Casino casino = new Casino();
        Assert.assertFalse(casino.login("nonexistent","password"));
    }
}
