package com.github.zipcodewilmington.casino;

import java.util.Date;

public class CasinoAccount {
    private int accountId;
    private static int lastAccountId = 0;
    private double balance;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String password;
    private String userName;

    public CasinoAccount(String userName, String password, String firstName, String lastName, Date birthDate, double initialBalance) {
        this.accountId = ++lastAccountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.balance = initialBalance;
        this.userName = userName;
        this.password = password;
    }

    // Getters and setters
    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void depositFunds(double amount) {
        balance += amount;
    }
}
