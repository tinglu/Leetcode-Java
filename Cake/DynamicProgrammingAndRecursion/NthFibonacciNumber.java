package DynamicProgrammingAndRecursion;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/*
 *
 * O(n) time and O(1) space.
 *
 *
 * */
public class NthFibonacciNumber {

    public static int fib(int n) {

        // compute the nth Fibonacci number

        // (1) Recursive way
//        Map<Integer, Integer> memo = new HashMap<>();
//
//        if (n < 0) throw new IllegalArgumentException("negative number!");
//        else if (n == 0 || n == 1) return n;
//
//        if (memo.containsKey(n)) return memo.get(n);
//
//        int result = fib(n-2) + fib(n-1);
//        memo.put(n, result);
//
//        return result;

        // (2) Iterative way
        if (n < 0) throw new IllegalArgumentException("negative number!");
        else if (n == 0 || n == 1) return n;
        int start = 2;
        int result = 0;
        int prev1 = 0;
        int prev2 = 1;
        while (start <= n) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
            start++;
        }
        return result;
    }


    // tests

    @Test
    public void zerothFibonacciTest() {
        final int actual = fib(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstFibonacciTest() {
        final int actual = fib(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondFibonacciTest() {
        final int actual = fib(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdFibonacciTest() {
        final int actual = fib(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthFibonacciTest() {
        final int actual = fib(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthFibonacciTest() {
        final int actual = fib(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void negativeFibonacciTest() {
        fib(-1);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NthFibonacciNumber.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}