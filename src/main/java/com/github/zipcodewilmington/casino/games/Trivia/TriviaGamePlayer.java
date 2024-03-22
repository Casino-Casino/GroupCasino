package com.github.zipcodewilmington.casino.games.Trivia;

import java.util.Scanner;

public class TriviaGamePlayer {

    public static String getAnswer;
    public static Scanner scanner = new Scanner(System.in);
    // Call getAnswer when we want them to input an answer
    public static String playerAnswer(){
        return getAnswer = scanner.nextLine();
    }
}
