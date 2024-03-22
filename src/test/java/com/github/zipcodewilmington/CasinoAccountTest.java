package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CasinoAccountTest {
    @Test
    public void casinoAccountConstructorTest(){
        String firstName = "Anthony";
        String lastName = "Pearson";
        Date birthDate = new Date("01/01/2000");
        String userName = "zip";
        String password = "ZipCode";

        CasinoAccount account = new CasinoAccount(userName,password,
                firstName,lastName,birthDate, 1000.0);
      
        Assert.assertTrue(account instanceof CasinoAccount);
    }


    @Test
    public void casinoAccountGetUserNameTest(){
        String userName = "Anthony";


        CasinoAccount account = new CasinoAccount(userName,"password",
                "firstName","lastName",new Date(90, 0, 1), 1000.0);
        String actualUserName = account.getUserName();

        Assert.assertEquals(userName, actualUserName);
    }

    @Test
    public void casinoAccountGetPasswordTest(){
        String password = "ZipCode";

        CasinoAccount account = new CasinoAccount("user",password,
                "firstName","lastName",new Date(90, 0, 1), 1000.0);
        String actualPassword = account.getPassword();

        Assert.assertEquals(password, actualPassword);
    }

    @Test
    public void casinoAccountGetFirstName(){
        String firstName = "Anthony";

        CasinoAccount account = new CasinoAccount("user","password",
                firstName,"lastName",new Date(90, 0, 1), 1000.0);
        String actual = account.getFirstName();
        Assert.assertTrue(actual.equals(firstName));
    }

    @Test
    public void casinoAccountGetLastName(){
        String lastName = "Pearson";

        CasinoAccount account = new CasinoAccount("user","password",
                "firstName",lastName,new Date(90, 0, 1), 1000.0);
        String actual = account.getLastname();
        Assert.assertTrue(actual.equals(lastName));
    }

    @Test
    public void casinoAccountGetBirthDate(){
        Date birthdate = new Date("01/01/2000");

        CasinoAccount account = new CasinoAccount("user","password",
                "firstName","lastName",birthdate, 1000.0);
        Date actual = account.getBirthDate();
        Assert.assertTrue(actual.equals(birthdate));
    }

    @Test
    public void testDepositFunds(){
        CasinoAccount account = new CasinoAccount("user","password",
                "firstName","lastName",new Date(90, 0, 1), 1000.0);
        account.depositFunds(500.0);
        Assert.assertEquals(1500.0,account.getBalance());
    }


}
