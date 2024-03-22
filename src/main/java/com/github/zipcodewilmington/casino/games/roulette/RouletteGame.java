package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouletteGame {
    private final RouletteGameWheel wheel;
    private final List<RouletteGamePlayer> players;

    public RouletteGame() {
        this.wheel = new RouletteGameWheel();
        this.players = new ArrayList<>();
    }

    public void addPlayer(RouletteGamePlayer player) {
        players.add(player);
    }

    public void startGame(List<CasinoAccount> casinoAccountList) {
        for (CasinoAccount account : casinoAccountList) {
            RouletteGamePlayer newPlayer = new RouletteGamePlayer(account.getFirstName(), account.getBalance());
            addPlayer(newPlayer);
        }

        Iterator<RouletteGamePlayer> iterator = players.iterator();
        while (iterator.hasNext()) {
            RouletteGamePlayer player = iterator.next();
            double initialBalance = player.getBalance(); // Store initial balance

            // Place bet and play game
            double totalBet = 0;
            int betValue = -1;
            String betType = "";
            double betAmount = player.placeBet();
            String choice = player.chooseBetType();
            if (choice.equals("number")) {
                betValue = player.chooseNumber();
            } else if (choice.equals("color")) {
                betType = player.chooseColor();
            }
            totalBet += betAmount;

            RouletteGamePocket result = wheel.spin();
            System.out.println("Result: " + result.getNumber() + " " + result.getColor());

            boolean win = player.checkBet(result, betType, totalBet, betValue);
            player.collectWinnings(totalBet, win);

            // Update player's balance based on game outcome
            double balanceChange = player.getBalanceChange();
            player.addToBalance(balanceChange); // Add balance change to player's balance

            // Remove player if balance is zero or negative
            if (player.getBalance() <= 0) {
                System.out.println(player.getFirstName() + ", you are out of money. Removing from the game.");
                iterator.remove(); // Safely remove the player from the list
                // Deduct initial balance from the CasinoAccount balance
                CasinoAccountManager.getInstance().findAccount(player.getUserName()).withdraw(initialBalance);
            }
        }
    }


}
