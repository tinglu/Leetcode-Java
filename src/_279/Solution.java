package _279;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSquares(int n) {
        Map<Integer, Integer> sumMin = new HashMap<>();
        return steps(n, sumMin);
    }

    private int steps(int sum, Map<Integer, Integer> sumMin) {
        if (sum == 0) return 0;
        if (sumMin.containsKey(sum)) return sumMin.get(sum);

        int largestSqrt = (int) Math.sqrt(sum);
        int min = Integer.MAX_VALUE;
        for (int j = largestSqrt; j >= 1; j--) {
            int square = j * j;
            int remaining = sum - square;
            int tmp;
            tmp = 1 + steps(remaining, sumMin);
            min = tmp < min ? tmp : min;
        }
        sumMin.put(sum, min);
        System.out.println(sumMin);
        return min;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        sol.numSquares(48);
    }
}
