package com.github.zipcodewilmington.casino;

public interface GamblingPlayerInterface {

    /**
     * Places a bet with the specified amount.
     * @param amount the amount to bet
     * @return a message indicating if the bet was successful or not
     */
    String placeBet(double amount);

    /**
     * Retrieves the balance of the player.
     * @return the balance of the player
     */
    double playerBalance();

    /**
     * Adds the specified amount to the player's balance.
     * @param amount the amount to add to the balance
     * @return the updated balance of the player
     */
    double addToBalance(double amount);

    /**
     * Checks if the player has sufficient funds to make a bet with the specified amount.
     * @param amount the amount to check if the player has sufficient funds for
     * @return a message indicating if the player has sufficient funds or not
     */
    String sufficientFunds(double amount);

    /**
     * Allows the player to make a selection.
     * @return the player's selection
     */
    String playerSelection();
}
