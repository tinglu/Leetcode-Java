package GreedyAlgorithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class AppleStock {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit

// xxx incorrect
//        if (stockPrices.length < 2) {
//            throw new IllegalArgumentException("cannot sell");
//        }
//
//        int buyAt = 0;
//        int sellAt = stockPrices.length - 1;
//        int max = stockPrices[sellAt] - stockPrices[buyAt];
//
//        for (int i = 1; i < stockPrices.length - 1; i++) {
//            if (stockPrices[i] <= stockPrices[i - 1]) {
//                buyAt = i;
//            } else {
//                sellAt = i;
//            }
//            max = Math.max(max, stockPrices[sellAt] - stockPrices[buyAt]);
//        }
//
//        return max;

        // O(n) time and O(1) space
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("cannot sell");
        }
        int minPrice = stockPrices[0];
        int potentialProfit = stockPrices[1] - stockPrices[0];
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            potentialProfit = Math.max(currentPrice - minPrice, potentialProfit);

            minPrice = Math.min(currentPrice, minPrice);
        }
        return potentialProfit;
    }


    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[]{1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[]{7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[]{9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[]{5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[]{});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AppleStock.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}