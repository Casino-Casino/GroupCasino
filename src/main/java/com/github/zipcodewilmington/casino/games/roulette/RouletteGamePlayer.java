package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoPlayerInterface;
import com.github.zipcodewilmington.casino.GamblingPlayerInterface;

import java.util.Scanner;

public class RouletteGamePlayer extends CasinoAccount implements CasinoPlayerInterface, GamblingPlayerInterface {

    private final Scanner scanner;

    public RouletteGamePlayer(String name, double balance) {
        super("", "", name, "", null, balance);
        this.scanner = new Scanner(System.in);
    }

    public double placeBet() {
        System.out.println(getFirstName() + ", enter your bet amount:");
        return scanner.nextDouble();
    }

    public String chooseBetType() {
        System.out.println(getFirstName() + ", choose your bet type (number/color):");
        return scanner.next().trim().toLowerCase();
    }

    public int chooseNumber() {
        System.out.println(getFirstName() + ", choose a number between 0 and 36:");
        return scanner.nextInt();
    }

    public String chooseColor() {
        System.out.println(getFirstName() + ", choose a color (red/black):");
        return scanner.next().trim().toLowerCase();
    }

    public boolean checkBet(RouletteGamePocket result, String betType, double totalBet, int betValue) {
        if (betType.equals("number")) {
            return betValue == result.getNumber();
        } else {
            return betValue == -1 && betType.equals(result.getColor());
        }
    }

    public void collectWinnings(double totalBet, boolean win) {
        if (win) {
            double winnings = totalBet * 12; // Payout 12 times the bet for number
            if (getBalance() >= winnings) {
                depositFunds(winnings);
                System.out.println(getFirstName() + ", you win " + winnings + "!");
            } else {
                System.out.println(getFirstName() + ", you don't have enough balance to cover the winnings.");
            }
        } else {
            System.out.println(getFirstName() + ", you lost " + totalBet + ".");
            withdrawFunds(totalBet);
        }
    }

    private void withdrawFunds(double totalBet) {
        depositFunds(-totalBet);
    }

    @Override
    public boolean joinGame(String game) {
        return false;
    }

    @Override
    public boolean leaveGame(String game) {
        return false;
    }

    @Override
    public boolean play(String game) {
        return false;
    }

    @Override
    public String getName(Object player) {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String playAgain(Object player) {
        return null;
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
