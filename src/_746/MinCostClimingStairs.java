package _746;

// TODO: Review later
public class MinCostClimingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;

        if (N < 2) return 0;

        int[] memo = new int[N];
//        memo[0] = 0;
//        memo[1] = Math.min(cost[0], cost[1]);
        memo[0] = cost[0];
        memo[1] = cost[1]; // we can start on the second stair

        for (int i = 2; i < N; i++) {
            memo[i] = Math.min(memo[i - 1] + cost[i], memo[i - 2] + cost[i]);
        }
        return Math.min(memo[N - 1], memo[N - 2]);
    }

    public static void main(String[] args) {
        MinCostClimingStairs sol = new MinCostClimingStairs();
        int[] cost = {10, 15, 20};
        System.out.println(sol.minCostClimbingStairs(cost));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(sol.minCostClimbingStairs(cost2));
    }
}
