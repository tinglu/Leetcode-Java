package QueuesAndStacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 *
 * O(n) time (one iteration through the string)
 *
 * O(n) space (in the worst case, all of our characters are openers, so we push them all onto the stack).
 *
 * */
public class BracketValidator {

    public static boolean isValid(String code) {

        // determine if the input code is valid
        Stack<Character> openers = new Stack<>();
        char[] chars = code.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                openers.add(c);
            } else if (openers.isEmpty()) {
                return false;
            } else if (c == ')' && openers.peek() == '('
                    || c == ']' && openers.peek() == '['
                    || c == '}' && openers.peek() == '{') {
                openers.pop();
            } else {
                return false;
            }
        }

        return openers.isEmpty();
    }


    // tests

    @Test
    public void validShortCodeTest() {
        final boolean result = isValid("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = isValid("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = isValid("([][]}");
        assertFalse(result);
    }

    @Test
    public void interleavedOpenersAndClosersTest() {
        final boolean result = isValid("([)]");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = isValid("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = isValid("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = isValid("");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BracketValidator.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}