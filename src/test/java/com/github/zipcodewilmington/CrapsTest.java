package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Craps.CrapsGameDice;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

/////       DICE TESTS      /////
    @Test
    public void crapsGameDiceConstructorTest(){
        int die1 = 0;
        int die2 = 0;

        Object actual = new CrapsGameDice(die1, die2);

        Assert.assertTrue(actual instanceof CrapsGameDice);
    }

    @Test
    public void diceRollTest(){
        int die1 = 2;
        int die2 = 4;
        
    }



}
