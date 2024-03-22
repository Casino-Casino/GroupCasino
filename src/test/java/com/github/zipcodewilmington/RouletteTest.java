//package com.github.zipcodewilmington;
//
//import com.github.zipcodewilmington.casino.games.roulette.Result;
//import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
//import com.github.zipcodewilmington.casino.games.roulette.RouletteGamePocket;
//import com.github.zipcodewilmington.casino.games.roulette.RouletteGameWheel;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class RouletteTest {
//    /******************************RouletteGame**********************************************/
//
//
//    @Test
//    public void spinWheelTest(){
//        RouletteGame rg = new RouletteGame();
//        Result result = rg.spinWheel();
//
//        Assert.assertNotNull(result.getPocket());
//
//    }
//    /******************************RouletteWheel**********************************************/
//
//    @Test
//    public void testSpin(){
//        RouletteGameWheel wheel = new RouletteGameWheel();
//        RouletteGamePocket pocket = wheel.spin();
//
//        Assert.assertNotNull(pocket);
//
//    }
//
//    /******************************RoulettePocket**********************************************/
//
//
//    @Test
//    public void getNumberForPocketTest(){
//        RouletteGamePocket pocket = new RouletteGamePocket(5, "red");
//
//        Assert.assertEquals(5,pocket.getNumber());
//
//    }
//
//    @Test
//    public void getColorForPocketTest(){
//        RouletteGamePocket pocket = new RouletteGamePocket(5,"red");
//
//        Assert.assertEquals("red",pocket.getColor());
//    }
//
//    /******************************RouletteResult**********************************************/
//
//    @Test
//    public void getPocketTest(){
//        RouletteGamePocket pocket = new RouletteGamePocket(5,"red");
//        Result result = new Result(pocket);
//
//        Assert.assertEquals(pocket, result.getPocket());
//    }
//
//
//    /******************************GamblingGameAbstract**********************************************/
//    @Test
//    public void placeBetTest(){
//
//    }
//
//    @Test
//    public void collectWinningsTest(){
//
//    }
//    /******************************CasinoPlayerInterface**********************************************/
//    @Test
//    public void joinGameTest(){
//
//    }
//
//    @Test
//    public void leaveGameTest(){
//
//    }
//
//    @Test
//    public void playTheGameTest(){
//
//    }
//
//    @Test
//    public void getNameOfPlayerTest(){
//
//    }
//
//    @Test
//    public void getScoreOfGameTest(){
//
//    }
//
//    @Test
//    public void setNameOfPlayerTest(){
//
//    }
//
//    @Test
//    public void playGameAgainTest(){
//
//    }
//
//    /******************************GameInterface**********************************************/
//    @Test
//    public void startGameTest(){
//
//    }
//    @Test
//    public void endGameTest(){
//
//    }
//    @Test
//    public void resetTest(){
//
//    }
//    @Test
//    public void playerWinTest(){
//
//    }
//    @Test
//    public void playerLoseTest(){
//
//    }
//    @Test
//    public void takeTurnsTest(){
//
//    }
//
//
//    /******************************GamblingPlayerInterface**********************************************/
//
//    @Test
//    public void placeBet2Test(){
//
//    }
//    @Test
//    public void playerBalanceTest(){
//
//    }
//    @Test
//    public void addToBalanceTest(){
//
//    }
//    @Test
//    public void sufficientFundsTest(){
//
//    }
//    @Test
//    public void playerSelectionTest(){
//
//    }
//    @Test
//    public void subtractFromBalanceTest(){
//
//    }
//
//
//}
