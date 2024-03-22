package com.github.zipcodewilmington.casino.games.Trivia;
import com.github.zipcodewilmington.casino.CasinoPlayerInterface;
import com.github.zipcodewilmington.casino.GameInterface;

import java.util.Scanner;


public class TriviaGameQuestion implements GameInterface {
//my fields
    int counter = 0;
   public String incorrectAnswer = "Incorrect, next question";
   public String correctAnswer = "Correct! You get a point";
    int maxNumberTries;
    //scanner for user input
    Scanner scanner = new Scanner(System.in);
//
    public static void main(String[] args) {
        TriviaGameQuestion triviaGameQuestion = new TriviaGameQuestion();
        String evaluation = triviaGameQuestion.askQuestion();
        System.out.println("Evaluation:\n" + evaluation);
    }
    public String askQuestion() {
        TriviaGame tg = new TriviaGame();
        System.out.println(tg.initialReport());
        //my array of string we will be looping through
        System.out.println("🌈");
        String[] text = {"1)What color do you see in a rainbow? Red or black?", "2)What animal is a mammal? Bear or Spider?",
                "3)In Java, what is an array? A list of stored values or a true or false statement?", " 4)What animal has the bite " +
                "force of 2000 pounds? Lion or Hippopotamus?", "5)Where did french fries originate? Belgium or France?",
                "6)What color is snow? White or Translucent?", "7)Who invented the lightbulb? Thomas Edison or " +
                "Albert Einstein?", "8)What is the largest state in the U.S.A? Alaska or California?",
                "9)How many planets are in our solar system? Seven or eight?", "10)Who painted the Mona Lisa?" +
                " Leonardo Davinci or Pablo Picasso? "};
        String[] answers = {"Red", "Bear", "A list of stored values", "Hippopotamus", "Belgium", "Translucent",
                "Thomas Edison", "Alaska", "eight", "Leonardo Davinci"};
        for (int i = 0; i < text.length; i++) {
            //work here
            System.out.println(text[i]);
            String userInput = scanner.nextLine();

            if(userInput.equalsIgnoreCase(answers[i])){
                System.out.println(correctAnswer);
            }
            else {
                System.out.println(incorrectAnswer);
            }




            try {
                if (checkAnswer(userInput, answers[i])) {
                    counter++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
//            checkAnswer(userInput, answers[i]);
        }
        if (counter >= 9) { return tg.finalReport(); }
        else { return "game ended, score < 9"; }
    }

    public boolean checkAnswer(String input, String answer) {
        return input.equalsIgnoreCase(answer);
    }

















    @Override
    public void add(CasinoPlayerInterface player) {

    }

    @Override
    public void remove(CasinoPlayerInterface player) {

    }

    @Override
    public void run() {
        askQuestion();
    }
}
