package QueuesAndStacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/*
 *
 * TODO: review later - good strategy by starting from the openingParenIndex and maintaining a count of open left parens
 *
 * */
public class FindClosingParenthesis {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis

        /*
         *
         * Not O(1) time!!!
         * */
//        Stack<Integer> leftParens = new Stack<>();
//        char[] chars = sentence.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '(') {
//                leftParens.push(i);
//            } else if (chars[i] == ')') {
//                if (leftParens.peek() == openingParenIndex) {
//                    return i;
//                } else {
//                    leftParens.pop();
//                }
//            }
//        }
//
//        throw new IllegalArgumentException("no matching left paren");


        /*
         *
         * O(N) time - where N is the size of string
         * O(1) space
         *
         * */
        int openNestedLeftParens = 0;

        /*
         * Start from the next char after the openingParenIndex!!!
         * */
        for (int i = openingParenIndex + 1; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                openNestedLeftParens += 1; // 1 more open left paren
            } else {
                if (openNestedLeftParens == 0) {
                    return i; // found this left paren's matching right paren
                } else {
                    openNestedLeftParens -= 1; // close one left paren
                }
            }
        }
        throw new IllegalArgumentException("no matching right paren");
    }


    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindClosingParenthesis.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}