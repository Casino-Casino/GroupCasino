package com.github.zipcodewilmington.casino.games.Hi_Lo;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;

import java.util.Date;
import java.util.Scanner;

public class HiLoPlayer extends CasinoAccount implements GameInterface {
    private final Scanner scanner;

    public HiLoPlayer(String name) {
        super("", "", name, "", null, 0);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean startGame() {
        return false;
    }

    @Override
    public boolean endGame() {
        return false;
    }

    @Override
    public boolean reset() {
        return false;
    }

    @Override
    public boolean playerWin() {
        return false;
    }

    @Override
    public boolean playerLose() {
        return false;
    }
}