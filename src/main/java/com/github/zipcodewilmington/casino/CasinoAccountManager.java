package com.github.zipcodewilmington.casino;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by leon on 7/21/2
 * 020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private List<CasinoAccount> accounts;

    public CasinoAccountManager(){
        this.accounts = new ArrayList<>();
    }
    public void registerAccount(CasinoAccount account) {
        accounts.add(account);
        System.out.println("Account registered successfully: "+account.getAccountId());
    }

    public List<CasinoAccount> getAccounts() {
        return accounts;
    }


    public Object findAccount(String userName, String password) {
        for (CasinoAccount account : accounts){
            if(account.getUserName().equals(userName)&&account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }
//    /**
//     * @param accountName     name of account to be returned
//     * @param accountPassword password of account to be returned
//     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
//     */
//    public CasinoAccount getAccount(String accountName, String accountPassword) {
//
//        return null;
//    }
//
//    /**
//     * logs & creates a new `ArcadeAccount`
//     *
//     * @param accountName     name of account to be created
//     * @param accountPassword password of account to be created
//     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
//     */
//    public CasinoAccount createAccount(String accountName, String accountPassword) {
//        return null;
//    }
//
//    /**
//     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
//     *
//     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
//     */
//    public void registerAccount(CasinoAccount casinoAccount) {
//
//    }


}
