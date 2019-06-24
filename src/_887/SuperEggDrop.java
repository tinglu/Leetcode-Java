package _887;

import java.util.HashMap;
import java.util.Map;


public class SuperEggDrop {

    /*
     *
     *
     * TODO: review later - DP + binary search
     *
     * K: eggs
     * N: floors
     *
     *
     * Time Complexity: O(K * NlogN).
     *
     * Space Complexity: O(K * N).
     *
     * */
    Map<Integer, Integer> dp = new HashMap<>();

    public int superEggDrop1(int K, int N) {
        int key = N * 100 + K;

        if (!dp.containsKey(key)) {
            int ans = 0;
            if (N == 0) {
                ans = 0;
            } else if (K == 1) {
                ans = N; // worst steps if having 1 egg and N floors - has to try every step from bottom
            } else {
                int lo = 1;
                int hi = N;

                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int d1 = superEggDrop(K - 1, x - 1); // egg breaks
                    int d2 = superEggDrop(K, N - x); // egg not break

                    if (d1 < d2) {
                        lo = x;
                    } else if (d1 > d2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }
                ans = 1 + Math.min(
                        Math.max(superEggDrop(K - 1, lo - 1), superEggDrop(K, N - lo)),
                        Math.max(superEggDrop(K - 1, hi - 1), superEggDrop(K, N - hi)));
            }
            dp.put(key, ans);
        }

        return dp.get(key);
    }

    /*
     *
     * TODO: review later - another approach by thinking how many floors I can go with M moves and K eggs!!!
     *
     * */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
//            System.out.println("---> m=" + m);
            m++;
//            System.out.println("     m=" + m);

            for (int i = 1; i <= K; i++) {
                /*
                 *
                 * dp[m - 1][i - 1] is the floor below
                 * +1 is for the current floor
                 * dp[m - 1][i] + 1 is the floor above
                 *
                 * */
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        SuperEggDrop sol = new SuperEggDrop();
        System.out.println(sol.superEggDrop(1, 2)); // 2
        System.out.println(sol.superEggDrop(2, 6)); // 3
        System.out.println(sol.superEggDrop(3, 14)); // 4
    }
}
