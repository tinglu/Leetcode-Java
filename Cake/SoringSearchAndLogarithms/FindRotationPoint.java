package SoringSearchAndLogarithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/*
 *
 * Each time we go through the while loop, we cut our range of indices in half, just like binary search. So we have O
 * (lgn) loop iterations.
 *
 *
 * Some languages—like German, Russian, and Dutch—can have arbitrarily long words, so we might want to factor the
 * length of the words into our runtime. We could say the length of the words is l, each string comparison takes
 * O(l) time, and the whole algorithm takes O(l * lgn) time.
 *
 *
 *
 * We use O(1) space to store the first word and the floor and ceiling indices.
 * */
public class FindRotationPoint {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            /*
            *
            * Just need to compare with the first word!!!!!!!!!
            *
            * */
            if (words[mid].compareTo(words[0]) < 0) {
                // go left
                end = mid;
            } else {
                // go right
                start = mid;
            }
            if (start + 1 == end) {
                break; // !!!!!!!!!
            }
        }

        /*
        *
        *
        * return the end!!!!
        *
        * */
        return end;
    }


    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[]{"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[]{"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[]{"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindRotationPoint.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}