package _976;

import java.util.Arrays;

class Solution {
//    public int largestPerimeter(int[] A) {
//        if (A.length < 3) return -1;
//        Arrays.sort(A);
//
//        int[] l1 = Arrays.copyOfRange(A, 0, A.length - 2);
//        int[] l2 = Arrays.copyOfRange(A, 1, A.length - 1);
//        int[] l3 = Arrays.copyOfRange(A, 2, A.length);
//
//        int maxPerimeter = 0;
//        int tmpPerimeter;
//
//        for (int i = A.length - 3; i >= 0; i--) {
//            if (l1[i] + l2[i] > l3[i]) {
//                tmpPerimeter = l1[i] + l2[i] + l3[i];
//                if (tmpPerimeter > maxPerimeter) {
//                    maxPerimeter = tmpPerimeter;
//                }
//            }
//        }
//
//        return maxPerimeter;
//    }

    // No need to maintain three arrays
    public int largestPerimeter(int[] A) {
        if (A.length < 3) return -1;
        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i+1] > A[i+2]) {
               return A[i] + A[i+1] + A[i+2];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {3,2,3,4};
        System.out.println(solution.largestPerimeter(A));

        System.out.println(Math.ceil(3/(float) 2));
    }
}