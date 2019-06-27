package _322;

import java.util.Arrays;

// TODO: review later
/*
 *
 * 322. Coin Change (minimum coins to make change)
 * https://leetcode.com/problems/coin-change/
 *
 *
 * DP: BOTTOM-UP
 *
 *
 * Time complexity : O(S*n). On each step the algorithm finds the next F(i) in nn iterations, where 1 < i < S.
 * Therefore in total the iterations are S*n.
 *
 * Space complexity : O(S). We use extra space for the memoization table.
 *
 * */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1]; // [amount + 1] !!!!

        /*
         *
         * IMPORTANT: pre-set the max number to (amount + 1), which is impossible because the max number of coins
         * needed is the "amount" N using $1 coins.
         * */
        int max = amount + 1; // So when calling Math.min() --> it always choose the correct smaller number
        Arrays.fill(memo, max);


        /*
         *
         * Start with 0
         *
         * !!!!! this line MUST BE AFTER Arrays.fill(memo, max); !!!!
         *
         * */
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c = 0; c < coins.length; c++) {
                if (coins[c] <= i) {
                    memo[i] = Math.min(memo[i], memo[i - coins[c]] + 1);
                }
            }
        }

        return memo[amount] > amount ? -1 : memo[amount]; // if memo[amount] > amount, then it means no suitable coins
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 5));
    }
}
