package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.tradingday.TradingDayGame;
import org.junit.Assert;
import org.junit.Test;

public class TradingDayTest {
    private String getStonkName;
    private int getPortfolio;
    private int[] getStonk;

/*    +selectStonk(stonkName): String
+stonkValues(stonkValues): int
+valueChange(): int
+stonkSelection(): int
+portfolioValue(): int
+valueChange(): void
    stonks : stonk[]
    portfolio: Portfolio
    stonkSelection
+stonkName(): String
*/

   @Test
   public void tradingDayConstructorTest(){
       //Given
    String expectedStonkName = getStonkName;
    int[] stonk = new int[]{Integer.MAX_VALUE};
    int portfolio = Integer.MAX_VALUE;

       TradingDayTest tradingDayTest = new TradingDayTest();
        //When
       int[] actualStonk = tradingDayTest.getStonk;
       String actualStonkName =tradingDayTest.getStonkName;
       int actualPortfolio = tradingDayTest.getPortfolio;

        //Then
       Assert.assertEquals(getStonk, actualStonk);
       Assert.assertEquals(expectedStonkName,actualStonkName);
       Assert.assertEquals(getPortfolio, actualPortfolio);
   }

    @Test
    public void testSetStonkName(){
        TradingDayTest tradingDayTest = new TradingDayTest();
        String getStonkName = "";
        tradingDayTest.testSetStonkName();
        String actual = tradingDayTest.getStonkName;

        Assert.assertEquals("", actual);
    }

    @Test
    public void testSetPortfolio(){
        TradingDayTest tradingDayTest = new TradingDayTest();
        int expected = 1000;
        int setPortfolio = getPortfolio;

        tradingDayTest.testSetPortfolio();

        Assert.assertEquals(expected, setPortfolio);
    }
    @Test
    public void testSetStonk(){
        TradingDayTest tradingDayTest = new TradingDayTest();
        int[] expected = {-10, -8, -6, -4, -2, 2, 4, 6, 8 ,10};

        tradingDayTest.testSetStonk();
        
        Assert.assertEquals(expected, getStonk);
    }

    @Test
    public void portfolioValueTest(){
    TradingDayTest tradingDayTest = new TradingDayTest();
    }

    @Test
    public void valueChangeTest(){
        TradingDayTest tradingDayTest = new TradingDayTest();
    }
    @Test
    public void setGetStonkTest() {
        TradingDayTest tradingDayTest = new TradingDayTest();
    }
    @Test
    public void setPortfolioTest() {
        TradingDayTest tradingDayTest = new TradingDayTest();
    }
}
