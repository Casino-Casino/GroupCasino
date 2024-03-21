package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * All players of a game should abide by `CasinoPlayerInterface`.
 * All players must have reference to the `ArcadeAccount` used to log into the `Arcade` system.
 * All players are capable of `play`ing a game.
 */
public interface CasinoPlayerInterface {/**
 * Joins the specified game.
 * @param game the game to join
 * @return true if the player successfully joins the game, false otherwise
 */
boolean joinGame(String game);

    /**
     * Leaves the specified game.
     * @param game the game to leave
     * @return true if the player successfully leaves the game, false otherwise
     */
    boolean leaveGame(String game);

    /**
     * Plays the specified game.
     * @param game the game to play
     * @return true if the player successfully plays the game, false otherwise
     */
    boolean play(String game);

    /**
     * Gets the name of the player.
     * @param player the player whose name to get
     * @return the name of the player
     */
    String getName(Object player);

    /**
     * Gets the score of the player.
     * @return the score of the player
     */
    int getScore();

    /**
     * Sets the name of the player.
     * @param name the name to set for the player
     */
    void setName(String name);

    /**
     * Plays again for the specified player.
     * @param player the player to play again
     * @return a message indicating if the player is playing again
     */
    String playAgain(Object player);
}
