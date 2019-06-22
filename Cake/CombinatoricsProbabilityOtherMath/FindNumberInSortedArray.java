package CombinatoricsProbabilityOtherMath;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 *
 * TODO: review later - pay attention to the update on left and right by +1 or -1
 *
 *
 * O(lgn) time and O(1)O(1) additional space
 *
 *
 * */
public class FindNumberInSortedArray {

    public static boolean contains(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
//            System.out.println(mid);

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < target) {
                // go right
                left = mid + 1; // !!!!!!!!!!!!!!!!!!!
            } else {
                // go left
                right = mid - 1; // !!!!!!!!!!!!!!!!!!!
            }
        }

        return false;


//        // we think of floorIndex and ceilingIndex as "walls" around
//        // the possible positions of our target, so by -1 below we mean
//        // to start our wall "to the left" of the 0th index
//        // (we *don't* mean "the last index")
//        int floorIndex = -1;
//        int ceilingIndex = nums.length;
//
//        // if there isn't at least 1 index between floor and ceiling,
//        // we've run out of guesses and the number must not be present
//        while (floorIndex + 1 < ceilingIndex) {
//
//            // find the index ~halfway between the floor and ceiling
//            // we use integer division, so we'll never get a "half index"
//            int distance = ceilingIndex - floorIndex;
//            int halfDistance = distance / 2;
//            int guessIndex = floorIndex + halfDistance;
//
//            int guessValue = nums[guessIndex];
//
//            if (guessValue == target) {
//                return true;
//            }
//
//            if (guessValue > target) {
//
//                // target is to the left, so move ceiling to the left
//                ceilingIndex = guessIndex;
//
//            } else {
//
//                // target is to the right, so move floor to the right
//                floorIndex = guessIndex;
//            }
//        }
//
//        return false;
    }


    // tests

    @Test
    public void emptyArrayTest() {
        final boolean result = contains(new int[]{}, 1);
        assertFalse(result);
    }

    @Test
    public void oneItemArrayNumberPresentTest() {
        final boolean result = contains(new int[]{1}, 1);
        assertTrue(result);
    }

    @Test
    public void oneItemArrayNumberAbsentTest() {
        final boolean result = contains(new int[]{1}, 2);
        assertFalse(result);
    }

    @Test
    public void smallArrayNumberPresentTest() {
        final boolean result = contains(new int[]{2, 4, 6}, 4);
        assertTrue(result);
    }

    @Test
    public void smallArrayNumberAbsentTest() {
        final boolean result = contains(new int[]{2, 4, 6}, 5);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberPresentTest() {
        final boolean result = contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberAbsentTest() {
        final boolean result = contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberFirstTest() {
        final boolean result = contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberLastTest() {
        final boolean result = contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindNumberInSortedArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}