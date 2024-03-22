package com.github.zipcodewilmington.casino.games.coinflip;

import java.util.Random;

public class RNGCoin {

    public static void main(String[] args) {

    }
    private int rngRange;

    public int coinRNG() {
        Random random = new Random();
        return 1 + random.nextInt(2);
    }
}
