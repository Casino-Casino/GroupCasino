package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;

public abstract class GamblingGame {

    private boolean isOver;
    private final List<Object> players;

    public GamblingGame() {
        this.isOver = false;
        this.players = new ArrayList<>();
    }

    /**
     * Places a bet for the specified player with the given amount.
     * @param player the player placing the bet
     * @param amount the amount to bet
     * @return the amount of the bet
     */
    public abstract double placeBet(Object player, double amount);

    /**
     * Collects the winnings for the specified player with the given amount.
     * @param player the player collecting the winnings
     * @param amount the amount to collect
     * @return a message indicating the result of collecting winnings
     */
    public abstract String collectWinnings(Object player, double amount);

    /**
     * Checks if the game is over.
     * @return true if the game is over, false otherwise
     */
    public boolean isOver() {
        return isOver;
    }

    /**
     * Sets the game over status.
     * @param over true if the game is over, false otherwise
     */
    protected void setOver(boolean over) {
        isOver = over;
    }

    /**
     * Gets the list of players participating in the game.
     * @return the list of players
     */
    protected List<Object> getPlayers() {
        return players;
    }

    /**
     * Adds a player to the game.
     * @param player the player to add
     */
    public void addPlayer(Object player) {
        players.add(player);
    }

    /**
     * Removes a player from the game.
     * @param player the player to remove
     */
    public void removePlayer(Object player) {
        players.remove(player);
    }
}
