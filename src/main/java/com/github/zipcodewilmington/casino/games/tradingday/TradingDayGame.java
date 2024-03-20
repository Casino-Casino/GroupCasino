package com.github.zipcodewilmington.casino.games.tradingday;
import java.util.Random;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.CasinoPlayerInterface;


public class TradingDayGame {

    void add(CasinoPlayerInterface player) {

    }
    void remove(CasinoPlayerInterface player) {

    }

    void run() {

    }
//Variables: stonk, portfolio, stonkValue, 10-bagger
// Methods: chooseStonk(), portfolioValue(stonkValue,inputWager), valueChange(), stonkValue()

    //  [-10,-8,-6,-4,-2, 2, 4, 6, 8, 10] initial stonkValues (to be multiplied by 1++)
    //     [1, 2, 3, 4, 5, 6, 7, 8, 9,10] index (Player chooses index number)
    // [-10,-16,-18,-16,-10,12,28,48,72,100] stonkValues if exclusively based on index multiplier
    // stonks will continually be randomized each time player chooses stonk (investments)
    public static void trainingDay(String[] args) {
        Random stonkValue = new Random(); //random object
        int[] stonks = {-10, -8, -6, -4, -2, 4, 6, 8, 10}; //index values
        //int size = stonks.length; //array length
        System.out.println("Welcome trader!! The market is open and there's money to be made." + "\n");
        System.out.println("How much are you willing to invest with us today??");
        System.out.println();
        System.out.println();

        //inputWager()
        //portfolio = inputWager();

        System.out.println();
        System.out.println("Wonderful! Now what are you waiting for?! Start making some money!");
        System.out.println();
        System.out.println("Enter a number between 1 - 10.");
        for(int i =1; i < stonks.length; i++){ //increment array length starting at 1
            stonks[i] = stonkValue.nextInt() * i; //randomize stonks multiplied by incremented index
            Scanner stonkSelection = new Scanner(System.in); //Player chooses stonk index number
            int investment = stonkSelection.nextInt(); // Investment displays the selected stonk
            System.out.println("Wow, you've done your research! That stonk is valued at " +stonkValue);
            System.out.println();
            // portfolioValue = portfolio + stonkValue;
            System.out.println();
            System.out.println();
            //System.out.println("Your stonk portfolio is now valued at: " + "$"+ portfolioValue);
        }
    }

}
//On 10th count, stonkValue is multiplied by 2 (Ex. if stonkValue is 100, multiply by 2)
//int[] stonks = new int[] { -10, -8, -6, -4, -2, 2, 4, 6, 8, 10};


//stonkValue = stonk * i++
//portfolioValue = inputWager + stonkValue

import com.github.zipcodewilmington.casino.PlayerInterface;

public class TradingDayGame {
//Variables: stonk, portfolio, stonkValue, 10-bagger
// Methods: chooseStonk(), portfolioValue(stonkValue,inputWager), valueChange(), stonkValue()

     //  [-10,-8,-6,-4,-2, 2, 4, 6, 8, 10] initial stonkValues (to be multiplied by 1++)
     //     [1, 2, 3, 4, 5, 6, 7, 8, 9,10] index (Player chooses index number)
     // [-10,-16,-18,-16,-10,12,28,48,72,100] stonkValues if exclusively based on index multiplier
     // stonks will continually be randomized each time player chooses stonk (investments)
     public static void trainingDay(String[] args) {
          Random stonkValue = new Random(); //random object
          int[] stonks = {-10, -8, -6, -4, -2, 4, 6, 8, 10}; //index values
          //int size = stonks.length; //array length
          System.out.println("Welcome trader!! The market is open and there's money to be made." + "\n");
          System.out.println("How much are you willing to invest with us today??");
          System.out.println();
          System.out.println();

     //inputWager()
          //portfolio = inputWager();

          System.out.println();
          System.out.println("Wonderful! Now what are you waiting for?! Start making some money!");
          System.out.println();
          System.out.println("Enter a number between 1 - 10.");
          for(int i =1; i < stonks.length; i++){ //increment array length starting at 1
               stonks[i] = stonkValue.nextInt() * i; //randomize stonks multiplied by incremented index
               Scanner stonkSelection = new Scanner(System.in); //Player chooses stonk index number
               int investment = stonkSelection.nextInt(); // Investment displays the selected stonk
          System.out.println("Wow, you've done your research! That stonk is valued at " +stonkValue);
          System.out.println();
              // portfolioValue = portfolio + stonkValue;
          System.out.println();
          System.out.println();
          //System.out.println("Your stonk portfolio is now valued at: " + "$"+ portfolioValue);
          }
     }

}
    //On 10th count, stonkValue is multiplied by 2 (Ex. if stonkValue is 100, multiply by 2)
    //int[] stonks = new int[] { -10, -8, -6, -4, -2, 2, 4, 6, 8, 10};


    //stonkValue = stonk * i++
    //portfolioValue = inputWager + stonkValue

















