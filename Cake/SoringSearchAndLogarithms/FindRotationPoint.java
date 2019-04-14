package SoringSearchAndLogarithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class FindRotationPoint {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

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