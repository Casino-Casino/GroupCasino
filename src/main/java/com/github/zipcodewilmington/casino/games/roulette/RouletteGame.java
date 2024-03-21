package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import java.util.ArrayList;
import java.util.List;

public class RouletteGame implements GameInterface {

    private final RouletteGameWheel wheel;
    private final List<RouletteGamePlayer> players;

    public RouletteGame() {
        this.wheel = new RouletteGameWheel();
        this.players = new ArrayList<>();
    }

    public void addPlayer(RouletteGamePlayer player) {
        players.add(player);
    }

    public void removePlayer(RouletteGamePlayer player) {
        players.remove(player);
    }

    @Override
    public boolean startGame() {
        List<CasinoAccount> casinoAccountList = new ArrayList<>();
        for (RouletteGamePlayer player : players) {
            casinoAccountList.add(new CasinoAccount(player.getFirstName(), "",
                    player.getFirstName(), "", null, player.getBalance()));
        }
        startGame(casinoAccountList);
        return true;
    }

    @Override
    public boolean endGame() {
        return players.isEmpty();
    }

    @Override
    public boolean reset() {
        players.clear();
        return true;
    }

    @Override
    public boolean playerWin() {
        return false; // Not implemented yet
    }

    @Override
    public boolean playerLose() {
        return false; // Not implemented yet
    }

    public void startGame(List<CasinoAccount> casinoAccountList) {
        for (CasinoAccount account : casinoAccountList) {
            RouletteGamePlayer newPlayer = new RouletteGamePlayer(account.getFirstName(), account.getBalance());
            addPlayer(newPlayer);
        }

        while (!endGame()) {
            int totalBet = 0;
            int betValue = -1;
            String betType = "";
            for (RouletteGamePlayer player : players) {
                double betAmount = player.placeBet();
                String choice = player.chooseBetType();
                if (choice.equals("number")) {
                    betValue = player.chooseNumber();
                } else if (choice.equals("color")) {
                    betType = player.chooseColor();
                }
                totalBet += betAmount;
            }

            RouletteGamePocket result = wheel.spin();
            System.out.println("Result: " + result.getNumber() + " " + result.getColor());

            for (RouletteGamePlayer player : players) {
                boolean win = player.checkBet(result, betType, totalBet, betValue);
                player.collectWinnings(totalBet, win);
            }
        }
    }
}
