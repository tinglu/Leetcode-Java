package _303;

public class RangeSumQueryImmutable {

    int[] sum;

    // O(N) time pre-computation
    // O(N) space
    public RangeSumQueryImmutable(int[] nums) {
        int N = nums.length;
        sum = new int[N];

        if (N > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < N; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    // O(1) time per query
    public int sumRange(int i, int j) {
        if (i < 0 || j < 0 || i > j) return Integer.MAX_VALUE;
        if (i == 0) return sum[j];
        return sum[j] - sum[i-1];
    }
}
