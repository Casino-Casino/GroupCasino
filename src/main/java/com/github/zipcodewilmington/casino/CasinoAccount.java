package com.github.zipcodewilmington.casino;

import java.util.Date;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private int accountId;
    private int lastAccountId = 0;
    private double balance;
    private String firstName;
    private String lastname;
    private Date birthDate;
    private String password;
    private String userName;




    public CasinoAccount(String userName, String password, String firstName, String lastName, Date birthDate, double initialBalance) {
        this.accountId = ++lastAccountId;
        this.firstName = firstName;
        this.lastname = lastName;
        this.birthDate = birthDate;
        this.balance = initialBalance;
        this.userName = userName;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getLastAccountId() {
        return lastAccountId;
    }

    public void setLastAccountId(int lastAccountId) {
        this.lastAccountId = lastAccountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public void depositFunds(double amount){
        balance += amount;
    }
}


