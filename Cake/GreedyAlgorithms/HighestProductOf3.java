package GreedyAlgorithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;


/*
 *
 * O(n) time and O(1) additional space.
 *
 * */
public class HighestProductOf3 {

    // TODO: my strategy is different from the solution
    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers
        if (intArray.length < 3) throw new IllegalArgumentException("array contains fewer than 3 items");

        int left = Integer.MIN_VALUE;
        int mid = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        int smallerNeg = 0;
        int smallestNeg = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > right) {
                left = mid;
                mid = right;
                right = intArray[i];
            } else if (intArray[i] > mid) {
                left = mid;
                mid = intArray[i];
            } else if (intArray[i] > left) {
                left = intArray[i];
            }

            if (intArray[i] < 0) {
                if (intArray[i] < smallestNeg) {
                    smallerNeg = smallestNeg;
                    smallestNeg = intArray[i];
                } else if (intArray[i] < smallerNeg) {
                    smallerNeg = intArray[i];
                }
            }
        }

        int result = left * mid * right;
        if (smallerNeg < 0 && smallestNeg < 0) {
            result = Math.max(smallerNeg * smallestNeg * right, result);
        }
        return result;
    }


    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[]{1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[]{6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[]{-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[]{-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[]{-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[]{});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[]{1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[]{1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HighestProductOf3.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}