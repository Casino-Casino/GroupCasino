package com.github.zipcodewilmington.casino.games.Trivia;

import com.github.zipcodewilmington.casino.CasinoAccount;

import java.util.List;

public class TriviaGame {

    public String initialReport() {
        return "WELCOME TO TRIVIA, YOU'LL BE ASKED A TOTAL OF 10 QUESTIONS BASED ON DIFFERENT CATEGORIES." +
                " READY? LET'S START!";
    }
    public String finalReport() {
        return "Congratulations You are a top score winner! Thanks for playing Trivia!";

    public static boolean startGame(List<CasinoAccount> casinoAccountList) {
        return true;

    }
}
