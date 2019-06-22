package CombinatoricsProbabilityOtherMath;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/*
 * O(n) time. We can sum all the numbers 1..n1..n in O(1) time using the fancy formula, but it still takes O(n) time
 * to sum all the numbers in our input array.
 *
 * O(1) additional space—the only additional space we use is for numbers to hold the sums with and without the
 * repeated value.
 *
 * */
public class NumberAppearTwice {

    public static int findRepeat(int[] numbers) {

        // find the number that appears twice
        if (numbers.length < 2) throw new IllegalArgumentException("No dupes with 1 or less number");

        int N = numbers.length - 1; // !!!!! MUST minus 1!!! because one number is duplicated!
        int totalShouldBe = (1 + N) * N / 2;

        int totalActual = 0;
        for (int num : numbers) {
            totalActual += num;
        }

        return totalActual - totalShouldBe;
    }


    // tests

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {4, 1, 3, 4, 2};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {1, 5, 9, 7, 2, 6, 3, 8, 2, 4};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NumberAppearTwice.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}