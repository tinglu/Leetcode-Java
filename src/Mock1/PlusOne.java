package Mock1;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int sum = digits[i] + 1;
                digits[i] = sum % 10;
                carry = sum / 10 > 0;
            } else {
                if (carry) {
                    int sum = digits[i] + 1;
                    digits[i] = sum % 10;
                    carry = sum / 10 > 0;
                }
            }
        }
        if (carry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            Arrays.copyOfRange(digits, 1, result.length - 1);
            return result;
        } else {
            return digits;
        }
    }
}
