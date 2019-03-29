package _969;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int maxIdx = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int j = A.length - 1;
        List<Integer> result = new ArrayList<>();

        while (j >= 0) {
//            System.out.println("j: " + j);
//            System.out.println("max: " + max);
            for (int i = 0; i <= j; i++) {
                if (A[i] > max) {
                    max = A[i];
                    maxIdx = i;
                }
            }
            if (maxIdx < j) {
                flipList(A, maxIdx + 1);
                result.add(maxIdx + 1);
                flipList(A, j + 1);
                result.add(j + 1);
            }
            max = Integer.MIN_VALUE;
            j--;

        }
        return result;
    }

    private void flipList(int[] A, int k) {
        int mid = k / 2;

        for (int i = 0; i < mid; i++) {
            Integer tmp = A[i];
            int opposite = k - 1 - i;
            A[i] = A[opposite];
            A[opposite] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {2,1,3};
        List<Integer> result = sol.pancakeSort(A);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}