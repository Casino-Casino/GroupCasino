package com.github.zipcodewilmington.casino.games.Hi_Lo;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;
import java.util.Scanner;

public class HiLoCardGame {
    private final Casino casino; // Reference to the Casino
    private IOConsole console;

    // Constructor now accepts a Casino object
    public HiLoCardGame(Casino casino) {
        this.casino = casino;
        this.console = new IOConsole();
    }

    public void gameRules() {
        System.out.println("The player will guess if the next card's \n" +
                "value will be higher or lower than the face-up card. Your score will be tallied. \n" +
                "A tie will result as a loss.");
    }

    public void startGame(List<CasinoAccount> casinoAccountList) {
        Scanner scanner = new Scanner(System.in);
        gameRules();

        int gamesPlayed = 0;
        int sumOfScores = 0;
        double averageScore;
        String playAgain;

        do {
            int scoreThisGame = play(scanner);
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            do {
                System.out.print("Play again? (yes/no): ");
                playAgain = scanner.next().trim().toLowerCase();
                if (!playAgain.equals("yes") && !playAgain.equals("no")) {
                    System.out.println("Please answer 'yes' or 'no'.");
                }
            } while (!playAgain.equals("yes") && !playAgain.equals("no"));

            if (playAgain.equals("no")) {
                break; // Exit the loop if player does not want to play again
            }
        } while (true);

        averageScore = ((double) sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("You played " + gamesPlayed + " games.");
        System.out.printf("Your average score was %1.3f.\n", averageScore);

        // Since the scanner is created here, close it before leaving the method
        scanner.close();

        // Call playGames from the Casino class to return to the main menu
        if (this.casino != null) {
            this.casino.playGames();
        }
    }

    public int play(Scanner scanner) {
        Deck deck = new Deck();
        Card currentCard, nextCard;
        int correctGuesses = 0;
        char guess;

        deck.shuffle();
        currentCard = deck.dealCard();
        System.out.println("The first card is the " + currentCard);

        while (true) {
            System.out.print("Will the next card be higher (H) or lower (L)? ");
            do {
                guess = scanner.next().toUpperCase().charAt(0);
                if (guess != 'H' && guess != 'L') {
                    System.out.print("Please respond with H or L: ");
                }
            } while (guess != 'H' && guess != 'L');

            nextCard = deck.dealCard();
            System.out.println("The next card is " + nextCard);

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties. Sorry!");
                break; // The game ends in a tie
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (guess == 'H') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break; // Wrong guess ends the game
                }
            } else { // nextCard.getValue() < currentCard.getValue()
                if (guess == 'L') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break; // Wrong guess ends the game
                }
            }
            currentCard = nextCard;
            System.out.println();
            System.out.println("The card is " + currentCard);
        }

        System.out.println();
        System.out.println("The game is over.");
        System.out.println("You made " + correctGuesses + " correct predictions.");
        System.out.println();

        return correctGuesses;
    }
}
