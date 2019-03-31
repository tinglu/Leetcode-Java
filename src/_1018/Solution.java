package _1018;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        if (A.length <= 0) return result;

        int X = 0;
        for (int i = 0; i < A.length; i++) {
            X = (2 * X + A[i]) % 5;
            if (X == 0) result.add(true);
            else result.add(false);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1,
                0, 1, 0, 0, 0, 1};
        System.out.println(sol.prefixesDivBy5(A));
    }
}