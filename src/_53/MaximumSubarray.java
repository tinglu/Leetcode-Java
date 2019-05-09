package _53;

public class MaximumSubarray {
    // Memory Limit Exceeded
//    public int maxSubArray(int[] nums) {
//        int N = nums.length;
//        int[][] memo = new int[N][N];
//
//        int max = Integer.MIN_VALUE;
//
//        for (int row = N - 1; row >= 0; row--) {
//            int curr = nums[row];
//
//            for (int col = row; col < N; col++) {
//                memo[row][col] = row == col ? curr : curr + memo[row + 1][col];
//                if (memo[row][col] > max) {
//                    max = memo[row][col];
//                }
//            }
//        }
//        return max;
//    }

    // To Slow
//    public int maxSubArray(int[] nums) {
//        int N = nums.length;
//        int[] memo = new int[N];
//
//        int max = Integer.MIN_VALUE;
//
//        for (int row = N - 1; row >= 0; row--) {
//            int curr = nums[row];
//
//            for (int col = row; col < N; col++) {
//                memo[col] = row == col ? curr : curr + memo[col];
//                if (memo[col] > max) {
//                    max = memo[col];
//                }
//            }
//        }
//        return max;
//    }


    //    TODO: Review later
    public int maxSubArray(int[] nums) {
        int N = nums.length;

        if (N < 1) return 0;

        int maxSofar = nums[0];
        int maxCurr = nums[0];

        for (int i = 1; i < N; i++) {
            maxCurr = Math.max(nums[i], maxCurr + nums[i]);
            maxSofar = Math.max(maxSofar, maxCurr);
        }
        return maxSofar;
    }


    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();

        int[] A = {-2, 4, 3, -8};
        System.out.println("Maximum contiguous sum is " + sol.maxSubArray(A));

    }
}
