package _264;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int[] numbers = new int[n];
        numbers[0] = 1;

        // the n-th ugly number is at the index of n-1
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(numbers[i2] * 2, numbers[i3] * 3), numbers[i5] * 5);
            numbers[i] = min;
            if (min == numbers[i2] * 2) i2++;
            if (min == numbers[i3] * 3) i3++;
            if (min == numbers[i5] * 5) i5++;
        }

        return numbers[n - 1];
    }
}
