package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CasinoAccountManagerTest {
    @Test
    public void testRegisterAccount(){
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount account = new CasinoAccount("userName","password","John",
                "Doe", new Date(90, 0,1), 1000.0);

        casinoAccountManager.registerAccount(account);
        Assert.assertEquals(1,casinoAccountManager.getAccounts().size());

    }

    @Test
    public void testFindAccount() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount account = new CasinoAccount("userName","password","John",
                "Doe", new Date(90, 0,1), 1000.0);
        casinoAccountManager.registerAccount(account);

        Assert.assertNotNull(casinoAccountManager.findAccount("userName","password"));
    }

    @Test
    public void testFindNonExistentAccount() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        Assert.assertNull(casinoAccountManager.findAccount("nonexistent","password"));
    }


}
