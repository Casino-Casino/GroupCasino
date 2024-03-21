package com.github.zipcodewilmington.casino.games.HeadsOrTails;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayerInterface;

public class HeadsOrTailsPlayer implements GamblingPlayerInterface {

    public CasinoAccount account;
    public HeadsOrTailsPlayer(CasinoAccount account){
        this.account = account;
    }


    @Override
    public String placeBet(double amount) {
        return null;
    }

    @Override
    public double playerBalance() {
        return 0;
    }

    @Override
    public double addToBalance(double amount) {
        return 0;
    }

    @Override
    public String sufficientFunds(double amount) {
        return null;
    }

    @Override
    public String playerSelection() {
        return null;
    }
}
