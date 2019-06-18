package SoringSearchAndLogarithms;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class FindADuplicateSpaceEdition {

    public static int findRepeat(int[] theArray) {

        // find a number that appears more than once

        // (1) O(N) SPACE!
//        if (theArray.length < 1) {
//            throw new IllegalArgumentException("empty array");
//        }
//        Set<Integer> seen = new HashSet<>();
//        int result = theArray[0];
//        for (int i : theArray) {
//            if (seen.contains(i)) {
//                result = i;
//                break;
//            } else {
//                seen.add(i);
//            }
//        }
//
//        return result;

        // (2) O(n*log n) time - but still O(n) space if we need to store the sorted array
//        Arrays.sort(theArray);
//        if (theArray.length < 1) {
//            throw new IllegalArgumentException("empty array");
//        }
//        for (int i = 1; i < theArray.length; i++) {
//            if (theArray[i] == theArray[i - 1]) {
//                return theArray[i];
//            }
//        }
//
//        throw new IllegalArgumentException("No duplicates");


        // !!!!!!!!TODO!!!!!!!!!: review later (3) NEED TO OPTIMISE SPACE!!!
        /*
        *
        * O(1) space and O(nlgn) time.
        *
        * */
        int floor = 1; // !!!!!!! Floor should start from 1 because integers range is 1..n
        int ceiling = theArray.length - 1;

        while (floor < ceiling) {
            int mid = floor + (ceiling - floor) / 2;
            int lowerRangeFloor = floor;
            int lowerRangeCeiling = mid;
            int upperRangeFloor = mid + 1;
            int upperRangeCeiling = ceiling;

            int itemsInLowerRange = 0;

            for (int item : theArray) {
                if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
                    itemsInLowerRange += 1;
                }
            }

            int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {
                // some item is duplicated in lowerRange
                floor = lowerRangeFloor;
                ceiling = lowerRangeCeiling;
            } else {
                floor = upperRangeFloor;
                ceiling = upperRangeCeiling;
            }
        }
        return floor;
    }


    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindADuplicateSpaceEdition.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}