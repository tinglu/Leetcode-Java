package BitManipulation;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;


/*
 *
 * TODO: review later
 *
 * We XOR all the integers in the array.
 * We start with a variable uniqueDeliveryId set to 0.
 * Every time we XOR with a new ID, it will change the bits.
 * When we XOR with the same ID again, it will cancel out the earlier change.
 *
 * O(n) time, and O(1)O(1) space.
 *
 * */
public class BreakfastStolenDrone {

    public static int findUniqueDeliveryId(int[] deliveryIds) {

        // find the one unique ID in the array

//        if (deliveryIds.length < 1) return -1;
//        if (deliveryIds.length == 1) return deliveryIds[0];
//        if (deliveryIds.length == 2) {
//            if (deliveryIds[0] == deliveryIds[1]) return -1;
//            else return deliveryIds[1];
//        }
//
//        Arrays.sort(deliveryIds);
//
//        for (int i = 1; i <= deliveryIds.length - 2; i++) {
//            if ((deliveryIds[i] ^ deliveryIds[i - 1]) > 0 && (deliveryIds[i] ^ deliveryIds[i + 1]) == 0) {
//                return deliveryIds[i - 1];
//            }
//
//            if ((deliveryIds[i] ^ deliveryIds[i - 1]) == 0 && (deliveryIds[i] ^ deliveryIds[i + 1]) > 0) {
//                return deliveryIds[i + 1];
//            }
//
//            if ((deliveryIds[i] ^ deliveryIds[i - 1]) > 0 && (deliveryIds[i] ^ deliveryIds[i + 1]) > 0) {
//                return deliveryIds[i];
//            }
//        }
//
//        return -1;


        // O(n) time, and O(1) space!!!
        int uniqueDeliveryId = 0;
        for (int id : deliveryIds) {
            uniqueDeliveryId ^= id;
        }
        return uniqueDeliveryId;
    }


    // tests

    @Test
    public void oneDroneTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[]{1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesFirstTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[]{1, 2, 2});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesLastTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[]{3, 3, 2, 2, 1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdInTheMiddleTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[]{3, 2, 1, 2, 3});
        assertEquals(expected, actual);
    }

    @Test
    public void manyDronesTest() {
        final int expected = 8;
        final int actual = findUniqueDeliveryId(new int[]{2, 5, 4, 8, 6, 3, 1, 4, 2, 3, 6, 5, 1});
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BreakfastStolenDrone.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}