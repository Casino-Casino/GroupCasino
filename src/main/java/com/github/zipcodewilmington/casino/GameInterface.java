package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGamePlayer;

public interface GameInterface {

    /**
     * Starts the game.
     * @return true if the game started successfully, false otherwise
     */
    boolean startGame();

    /**
     * Ends the game.
     * @return true if the game ended successfully, false otherwise
     */
    boolean endGame();

    /**
     * Resets the game to its initial state.
     * @return true if the game was successfully reset, false otherwise
     */
    boolean reset();

    /**
     * Determines if the player has won the game.
     * @return true if the player has won, false otherwise
     */
    boolean playerWin();

    /**
     * Determines if the player has lost the game.
     * @return true if the player has lost, false otherwise
     */
    boolean playerLose();

    /**
     * Allows players to take turns in the game.
     * @param player The player taking their turn
     */


}

