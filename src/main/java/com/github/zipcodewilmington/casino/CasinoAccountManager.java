package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;

public class CasinoAccountManager {
    private List<CasinoAccount> accounts;
    private static CasinoAccountManager instance;

    public CasinoAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void registerAccount(CasinoAccount account) {
        accounts.add(account);
        System.out.println("Account registered successfully: " + account.getAccountId());
    }

    public CasinoAccount findAccount(String userName, String password) {
        for (CasinoAccount account : accounts) {
            if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public CasinoAccount findAccount(String userName) {
        for (CasinoAccount account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }

    public static CasinoAccountManager getInstance() {
        if (instance == null) {
            instance = new CasinoAccountManager();
        }
        return instance;
    }
}
