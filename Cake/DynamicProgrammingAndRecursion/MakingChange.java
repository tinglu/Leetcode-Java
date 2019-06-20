package DynamicProgrammingAndRecursion;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

// TODO
/*
 *
 * Review:
 * (1) 322. Coin Change (minimum coins to make change)
 * https://leetcode.com/problems/coin-change/
 * Using DP: BOTTOM-UP
 *
 *
 * (2)
 * 518. Coin Change 2 (Unique ways to make change)
 * https://leetcode.com/problems/coin-change-2/
 *
 * */
public class MakingChange {


    /*
     *
     * Bottom-up!
     *
     * */
    public static int changePossibilities(int amount, int[] denominations) {
        int[] dp = new int[amount + 1];

        dp[0] = 1; // 1 way to get 0 dollar using no coin

        for (int coin : denominations) {

            System.out.println("\nBefore: " + Arrays.toString(dp));
            /*
             * j start from coin ---> means use coin types until this coin
             * */
            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
            System.out.println("After: " + Arrays.toString(dp));
        }
        return dp[amount];
    }


//    private static Map<String, Integer> memo = new HashMap<>();
//
//    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
//        return topDown(amount, denominations, 0);
//    }
//
//    /*
//     *
//     * TopDown WITH memoization
//     * */
//    private static int topDown(int amountLeft, int[] denominations, int idx) {
//
//        String key = amountLeft + ", " + idx;
//        if (memo.containsKey(key)) return memo.get(key);
//
//        /*
//         * Base case:
//         * Just have exact change
//         * */
//        if (amountLeft == 0) return 1;
//        /*
//         * Not enough change
//         * */
//        if (amountLeft < 0) return 0;
//
//        /*
//         * !!!! important: no more coins to try!!!
//         * */
//        if (idx == denominations.length) return 0;
//
//        int currentCoin = denominations[idx];
//        int possibilities = 0;
//        while (amountLeft >= 0) {
//            possibilities += topDown(amountLeft, denominations, idx + 1);
//            amountLeft -= currentCoin;
//        }
//        memo.put(key, possibilities);
//        return possibilities;
//    }


    // tests

    @Test
    public void sampleInputTest() {
        final int actual = changePossibilities(4, new int[]{1, 2, 3});
        final int expected = 4;
        assertEquals(expected, actual);
    }

//    @Test
//    public void oneWayToMakeZeroCentsTest() {
//        final int actual = changePossibilities(0, new int[]{1, 2});
//        final int expected = 1;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void noWaysIfNoCoinsTest() {
//        final int actual = changePossibilities(1, new int[]{});
//        final int expected = 0;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void bigCoinValueTest() {
//        final int actual = changePossibilities(5, new int[]{25, 50});
//        final int expected = 0;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void bigTargetAmountTest() {
//        final int actual = changePossibilities(50, new int[]{5, 10});
//        final int expected = 6;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void changeForOneDollarTest() {
//        final int actual = changePossibilities(100, new int[]{1, 5, 10, 25, 50});
//        final int expected = 292;
//        assertEquals(expected, actual);
//    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MakingChange.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}