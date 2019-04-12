package ArrayAndString;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SingleRiffleShuffle {

//    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
//
//        // check if the shuffled deck is a single riffle of the halves
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//        Stack<Integer> deck = new Stack<>();
//        for (int i : half1) {
//            stack1.push(i);
//        }
//        for (int i : half2) {
//            stack2.push(i);
//        }
//        for (int i : shuffledDeck) {
//            deck.push(i);
//        }
//        return helper(stack1, stack2, deck);
//    }
//
//    private static boolean helper(Stack<Integer> half1, Stack<Integer> half2, Stack<Integer> deck) {
//        if (half1.empty() && half2.empty() && deck.empty()) {
//            return true;
//        } else {
//            if (!half1.empty() && half1.peek().equals(deck.peek())) {
//                half1.pop();
//                deck.pop();
//                return helper(half1, half2, deck);
//            }
//            if (!half2.empty() && half2.peek().equals(deck.peek())) {
//                half2.pop();
//                deck.pop();
//                return helper(half1, half2, deck);
//            }
//            return false;
//        }
//    }

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // CAN START FROM LEFT
        int i = 0;
        int j = 0;

        for (int num : shuffledDeck) {
            if (i < half1.length && half1[i] == num) {
                i++;
            } else if (j < half2.length && half2[j] == num) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }


    // tests

    @Test
    public void bothHalvesAreTheSameLengthTest() {
        final int[] half1 = {1, 4, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 4, 5, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void halvesAreDifferentLengthsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void oneHalfIsEmptyTest() {
        final int[] half1 = {};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {2, 3, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void shuffledDeckIsMissingCardsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void shuffledDeckHasExtraCards() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 5, 6, 8};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SingleRiffleShuffle.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}