package _931;

// TODO: Review Later
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        if (N < 1) return Integer.MAX_VALUE;
        if (N != A[0].length) return Integer.MAX_VALUE;

        int[][] best = new int[N][N];

        for (int i = 0; i < N; i++) { // fill in the first row
            best[0][i] = A[0][i];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // compare col on top it
                int min = best[r - 1][c];
                // has left col
                if (c - 1 >= 0) min = Math.min(min, best[r - 1][c - 1]);
                // has right col
                if (c + 1 < N) min = Math.min(min, best[r - 1][c + 1]);
                best[r][c] = min + A[r][c];
            }
        }
//        for (int[] arr : best) {
//            System.out.println(Arrays.toString(arr));
//        }

        int ans = Integer.MAX_VALUE;
        for (int num : best[N - 1]) { // pick the smallest in the last row (because the last row contains all the sums)
            ans = Math.min(ans, num);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum sol = new MinimumFallingPathSum();
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sol.minFallingPathSum(A));
    }
}
