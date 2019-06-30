package _279;

import java.util.Arrays;

class Solution {
//    public int numSquares(int n) {
//        Map<Integer, Integer> sumMin = new HashMap<>();
//        return steps(n, sumMin);
//    }
//
//    private int steps(int sum, Map<Integer, Integer> sumMin) {
//        if (sum == 0) return 0;
//        if (sumMin.containsKey(sum)) return sumMin.get(sum);
//
//        int largestSqrt = (int) Math.sqrt(sum);
//        int min = Integer.MAX_VALUE;
//        for (int j = largestSqrt; j >= 1; j--) {
//            int square = j * j;
//            int remaining = sum - square;
//            int tmp;
//            tmp = 1 + steps(remaining, sumMin);
//            min = tmp < min ? tmp : min;
//        }
//        sumMin.put(sum, min);
//        System.out.println(sumMin);
//        return min;
//    }
//
//    public static void main(String args[]) {
//        Solution sol = new Solution();
//        sol.numSquares(48);
//    }

    /*
     *
     *
     * TODO: review later
     *  https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
     *
     * */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int j = 1; // !!!
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }

        return dp[n];
    }
}
