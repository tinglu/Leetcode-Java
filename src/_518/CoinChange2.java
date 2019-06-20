package _518;

// TODO: review later
/*
 *
 * 518. Coin Change 2 (Unique ways to make change)
 * https://leetcode.com/problems/coin-change-2/
 *
 * */
public class CoinChange2 {
    public int change1(int amount, int[] coins) {
        /*
         * coins.length + 1 because start from 0 type of coins
         * amount + 1 because start form 0 dollar then build up to the amount - so the array has 1 extra length
         * */
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1; // 1 way to get 0 dollar using no coin

        for (int i = 1; i <= coins.length; i++) { // i start from 1!!!

            dp[i][0] = 1; // Initialisation --> for 0 dollar, always 1 way regardless which coin to use

            for (int j = 1; j <= amount; j++) {
                /*
                 * coins[i-1] for the i-th coin (index start from 0!)
                 * */
                dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] >= 0 ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    /*
     *
     * Use 1 dimension array
     * */
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1; // 1 way to get 0 dollar using no coin

        for (int coin : coins) {

            /*
             * j start from coin ---> means use coin types until this coin
             * */
            for (int j = coin; j <= amount; j++) {

                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 sol = new CoinChange2();
        System.out.println(sol.change(5, new int[]{1, 2, 5}));
    }
}
