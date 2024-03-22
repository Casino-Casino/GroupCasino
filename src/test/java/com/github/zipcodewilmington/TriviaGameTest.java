package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Trivia.TriviaGame;
import static org.junit.Assert.*;

import com.github.zipcodewilmington.casino.games.Trivia.TriviaGamePlayer;
import org.junit.Test;

public class TriviaGameTest {

    @Test
    public void testInitialReport(){
        String expected = "WELCOME TO TRIVIA, YOU'LL BE ASKED A TOTAL OF 10 QUESTIONS BASED ON DIFFERENT CATEGORIES." +
                " READY? LET'S START!";
        TriviaGame tg = new TriviaGame();

        String actual = tg.initialReport();

        assertEquals(expected, actual);
    }

    @Test
    public void finalReport(){
        String expected = "Congratulations! Thanks for playing Trivia!";
        TriviaGame tg = new TriviaGame();
        String actual = tg.finalReport();
        assertEquals(expected, actual);
    }

}
