package MockP1;

import java.util.Arrays;

// SEE 66. Plus One
public class PlusOne {
    // Modified after the mock!
    public int[] plusOne(int[] digits) {
        boolean carry;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            carry = sum / 10 > 0;
            if (!carry) return digits; // !!! CAN RETURN EARLY!
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        Arrays.copyOfRange(digits, 1, result.length - 1);
        return result;
    }
}
