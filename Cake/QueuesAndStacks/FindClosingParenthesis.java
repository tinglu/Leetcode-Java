package QueuesAndStacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class FindClosingParenthesis {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
        Stack<Integer> leftParens = new Stack<>();
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftParens.push(i);
            } else if (chars[i] == ')'){
                if (leftParens.peek() == openingParenIndex) {
                    return i;
                } else {
                    leftParens.pop();
                }
            }
        }

        throw new IllegalArgumentException("no matching left paren");
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