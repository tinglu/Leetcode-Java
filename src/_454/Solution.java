package _454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    //    Time out problem!!
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//
////        System.out.println(Arrays.toString(A));
////        System.out.println(Arrays.toString(B));
////        System.out.println(Arrays.toString(C));
////        System.out.println(Arrays.toString(D));
//
//        int count = 0;
//        if (A.length == 0) return count;
//
//        int[] sum1 = new int[A.length * B.length];
//        int[] sum2 = new int[C.length * D.length];
//        int sum;
//
//        System.out.println(sum1.length);
//        int idx = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                // System.out.println(i + " - " + j + " ---- " + idx);
//                sum1[idx] = A[i] + B[j];
//                idx++;
//            }
//        }
//
//        idx = 0;
//        for (int k = 0; k < C.length; k++) {
//            for (int l = 0; l < D.length; l++) {
//                sum2[idx] = C[k] + D[l];
////                System.out.println("C[" + k + "] + D[" + l + "] = sum2[" + (k + l) + "] = " + C[k] +
////                        " + " + D[l] + " = " + sum2[k + l]);
//                idx++;
//            }
//        }
//
////        System.out.println(Arrays.toString(sum1));
////        System.out.println(Arrays.toString(sum2));
//
//        for (int m = 0; m < sum1.length; m++) {
//            for (int n = 0; n < sum2.length; n++) {
//                sum = sum1[m] + sum2[n];
//                if (sum == 0) count++;
//            }
//        }
//
//        return count;
//    }


    // Save complement of sum of A and B to map so no need to do the third N^2 loop
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count = 0;
        if (A.length == 0) return count;

        Map<Integer, Integer> compAB = new HashMap<>();

        int sum;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                // System.out.println(i + " - " + j + " ---- " + idx);
                sum = 0 - A[i] - B[j];
                if (!compAB.containsKey(sum)) compAB.put(sum, 1);
                else compAB.put(sum, compAB.get(sum) + 1);
            }
        }

        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                sum = C[k] + D[l];
                count += compAB.getOrDefault(sum, 0);
            }
        }

        return count;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(solution.fourSumCount(A, B, C, D));
    }
}