package _927;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
//    https://leetcode.com/problems/three-equal-parts/

    /*
    * Fail 1:
    * */
//    public int[] threeEqualParts(int[] A) {
//        int[] result = {-1, -1};
//
//        A = removeLeadingZeros(A);
//        System.out.println(Arrays.toString(A));
//
//        int j;
//        int remaining;
//
//        for (int i = 0; i < A.length - 2; i++) {
//            remaining = A.length - i - 1;
//            j = remaining / 2 + 1 + i;
//            if (isSame(A, Arrays.copyOfRange(A, 0, i+1), i, j)) {
//                result[0] = i;
//                result[1] = j;
//                return result;
//            }
//            if (remaining % 2 != 0) {
//                j = (int) Math.ceil(remaining / (float) 2) + 1 + i;
//                if (isSame(A, Arrays.copyOfRange(A, 0, i+1), i, j)) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result;
//    }
//
//    public int[] removeLeadingZeros(int[] A) {
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] != 0) {
//                int[] newA = Arrays.copyOfRange(A, i, A.length);
//                return newA;
//            }
//        }
//        return A;
//    }
//
//    public int[] removeTrailingZeros(int[] A) {
//        for (int i = A.length - 1; i >= 0; i--) {
//            if (A[i] != 0) {
//                int[] newA = Arrays.copyOfRange(A, 0, i+1);
//                return newA;
//            }
//        }
//        return A;
//    }
//
//
//    public boolean isSame(int[] A, int[] firstPart, int i, int j) {
//        int[] secondPart = Arrays.copyOfRange(A,i+1, j);
//        secondPart = removeLeadingZeros(secondPart);
//        secondPart = removeTrailingZeros(secondPart);
//        int[] thirdPart = Arrays.copyOfRange(A, j, A.length);
//        thirdPart = removeLeadingZeros(thirdPart);
//        thirdPart = removeTrailingZeros(thirdPart);
//        System.out.println("");
//        System.out.println("i: " + i);
//        System.out.println("j: " + j);
//        System.out.println(Arrays.toString(firstPart));
//        System.out.println(Arrays.toString(secondPart));
//        System.out.println(Arrays.toString(thirdPart));
//        return Arrays.equals(firstPart, secondPart) && Arrays.equals(firstPart, thirdPart);
//    }


    /*
    * Fail 2: TODO
    * */
    public int[] threeEqualParts(int[] A) {
        int i = -1, j = -1;
        int[] result = {i, j};

        int[] firstPart, secondPart, thirdPart;
        int secondStart, thirdStart;
        int firstNoneZeroPos = firstNoneZeroPos(A);
        int totalLen = A.length;

        for (i = firstNoneZeroPos; i < totalLen - 2; i++) {
            firstPart = Arrays.copyOfRange(A, firstNoneZeroPos, i + 1);
//            result[0] = i;

            for (secondStart = i + 1; secondStart < totalLen - 1; secondStart++) {
                if (A[secondStart] != 0) {
                    j = secondStart + firstPart.length;
//                    result[1] = j;

                    secondPart = Arrays.copyOfRange(A, secondStart, j);

                    if (!Arrays.equals(firstPart, secondPart)) break;

                    for (thirdStart = j; thirdStart < totalLen; thirdStart++) {
                        if (A[thirdStart] != 0) {
                            thirdPart = Arrays.copyOfRange(A, thirdStart, totalLen);

                            if (Arrays.equals(firstPart, thirdPart)) {
                                result[0] = i;
                                result[1] = j;
                                return result;
                            }
                            break;
                        }
                    }

                    break;
                }
            }
        }
        System.out.println(i);
        System.out.println(j);
        return result;
    }

    public int firstNoneZeroPos(int[] A) {
        int i;
        for (i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                return i;
            }
        }
        return i;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] result;

        int[] inputs1 = {1, 0, 1, 0, 1};
        result = solution.threeEqualParts(inputs1);
        System.out.println(Arrays.toString(result));
        int[] expected1 = {0, 3};
        System.out.println(Arrays.equals(result, expected1));
        System.out.println();

        int[] inputs2 = {1, 1, 0, 0, 1};
        result = solution.threeEqualParts(inputs2);
        System.out.println(Arrays.toString(result));
        int[] expected2 = {0, 2};
        System.out.println(Arrays.equals(result, expected2));
        System.out.println();

        int[] inputs3 = {1, 0, 1, 1, 0};
        result = solution.threeEqualParts(inputs3);
        System.out.println(Arrays.toString(result));
        int[] expected3 = {-1, -1};
        System.out.println(Arrays.equals(result, expected3));
        System.out.println();

        int[] inputs4 = {0, 0, 1, 1, 0, 0, 1};
        result = solution.threeEqualParts(inputs4);
        System.out.println(Arrays.toString(result));
        int[] expected4 = {2, 4};
        System.out.println(Arrays.equals(result, expected4));
        System.out.println();

        int[] inputs5 = {0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1,
                1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0};
        result = solution.threeEqualParts(inputs5);
        System.out.println(Arrays.toString(result));
        int[] expected5 = {-1, -1};
        System.out.println(Arrays.equals(result, expected5));
        System.out.println();

        int[] inputs6 = {0, 1, 0, 1, 1};
        result = solution.threeEqualParts(inputs6);
        System.out.println(Arrays.toString(result));
        int[] expected6 = {1, 4};
        System.out.println(Arrays.equals(result, expected6));
        System.out.println();

        int[] inputs7 = {0, 0, 0, 0, 0};
        result = solution.threeEqualParts(inputs7);
        System.out.println(Arrays.toString(result));
        int[] expected7 = {0, 4};
        System.out.println(Arrays.equals(result, expected7));
        System.out.println();
    }
}