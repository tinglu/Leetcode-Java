package _1027;

// TODO: Can I do in DP?
public class LongestArithmeticSequence {

    public int longestArithSeqLength(int[] A) {
        if (A.length < 2) return 0;

        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {

            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, helper(i, j, A));
            }
        }

        return max;
    }

    private int helper(int i, int j, int[] A) {
        int diff = A[j] - A[i];

        int prev = A[j];
        int count = 2;

        for (int k = j + 1; k < A.length; k++) {
            if (A[k] - prev == diff) {
                count += 1;
                prev = A[k];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence sol = new LongestArithmeticSequence();
        int[] A = {3, 6, 9, 12};
        System.out.println(sol.longestArithSeqLength(A));

        int[] B = {9, 4, 7, 2, 10};
        System.out.println(sol.longestArithSeqLength(B));

        int[] C = {20, 1, 15, 3, 10, 5, 8};
        System.out.println(sol.longestArithSeqLength(C));
    }
}
