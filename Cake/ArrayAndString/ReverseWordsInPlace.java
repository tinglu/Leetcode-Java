package ArrayAndString;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;


/*
 * Solve a simpler version of the problem (in this case, reversing the characters instead of the words), and see if
 * that gets us closer to a solution for the original problem.
 *
 *
 * */
public class ReverseWordsInPlace {

    public static void reverseWords(char[] message) {

        // decode the message by reversing the words
        reverseChars(message, 0, message.length - 1);
        int from = 0;
//        for (int i = 0; i < message.length; i++) {
//            if (message[i] == ' ') {
//                reverseChars(message, from, i - 1);
//                from = i + 1;
//            }
//            if (i == message.length - 1) {
//                reverseChars(message, from, i);
//            }
//        }

        // Simpler way!
        // i == message.length means the last word needs a reverse too
        for (int i = 0; i <= message.length; i++) {
            if (i == message.length || message[i] == ' ') { // !!! i == message.length should be the first condition
                reverseChars(message, from, i - 1);
                from = i + 1;
            }
        }
    }

    private static void reverseChars(char[] chars, int from, int to) {
        while (from < to) {
            char tmp = chars[from];
            chars[from] = chars[to];
            chars[to] = tmp;
            from++;
            to--;
        }

    }


    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseWordsInPlace.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}