package _978;

// TODO
class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        return helper(A, 2);
    }

    private int helper(int[] A, int k) {
        System.out.println("\nk: " + k);
        if (A.length == 2) return A[0] == A[1] ? 1 : 2;
        if (A.length <= 2) return A.length;

        if (k >= A.length) return 0;

        int prevDiff = A[k - 1] - A[k - 2];

        int count = 2;
        int max = count;

        for (int i = k; i < A.length; i++) {
            int currDiff = A[i] - A[i-1];
            System.out.println("\nA[i]:" + A[i]);
            System.out.println("curr:" + A[i-1]);
            System.out.println("prevDiff:" + prevDiff);
            System.out.println("currDiff:" + currDiff);
            System.out.println("count:" + count);

            int mul = currDiff * prevDiff;
            if (mul < 0) {
                prevDiff = currDiff;
                count++;
            } else if (mul > 0) {
                max = Math.max(max, count);
                max = Math.max(max, helper(A, i + 1));
                break;
            } else {
                max = Math.max(max, count);
                max = Math.max(max, helper(A, i + 2));
                break;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray sol = new LongestTurbulentSubarray();
        int[] A = {2,2,2};
//        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
//        int[] A = {8, 8, 9, 10, 6, 8, 2, 4, 2, 2, 10, 6, 6, 10, 10, 2, 3, 5, 1, 2, 10, 4, 2, 0, 9, 4, 9, 3, 0, 6, 3,
//                2, 3, 10, 10, 6, 4, 6, 4, 4, 2, 5, 1, 4, 1, 1, 9, 8, 9, 5, 3, 5, 5, 4, 5, 5, 6, 5, 3, 3, 7, 2, 0, 10,
//                9, 7, 7, 3, 5, 1, 0, 9, 6, 3, 1, 3, 4, 4, 3, 6, 3, 2, 1, 4, 10, 2, 3, 4, 4, 3, 6, 7, 6, 2, 1, 7, 0, 6, 8, 10};
        System.out.println("sol: " + sol.maxTurbulenceSize(A));
    }
}