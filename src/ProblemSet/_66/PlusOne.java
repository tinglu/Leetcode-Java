package ProblemSet._66;

import java.util.Arrays;

public class PlusOne {
//    public int[] plusOne(int[] digits) {
//        int i = digits.length - 1;
//        int sum;
//        do {
//            sum = digits[i] + 1;
//            digits[i] = sum % 10;
//            i--;
//        } while (sum > 9 && i >= 0);
//
//        int[] results;
//        if (sum > 9 && i == -1) {
//            results = new int[digits.length + 1];
//            results[0] = 1;
//            System.arraycopy(digits, 0, results, 1, digits.length);
//        } else {
//            results = digits;
//        }
//        return results;
//    }

    //    Could return early once find a sum is less than 10 in a digit position
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] results = new int[digits.length + 1];
        results[0] = 1;
        System.arraycopy(digits, 0, results, 1, digits.length);
        return results;
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        int[] A = {9,9,1};
        System.out.println(Arrays.toString(sol.plusOne(A)));
    }
}
