package _66;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int sum;
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
}
