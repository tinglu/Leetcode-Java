package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Random;


/*
 *
 * O(n) time and O(1) space.
 *
 * */
public class InPlaceShuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    // My solution
    public static void shuffle(int[] theArray) {

        // shuffle the input in place

        if (theArray.length < 2) throw new IllegalArgumentException("need at least two items to shuffle");

        for (int i = 1; i < theArray.length; i++) {
            int j = getRandom(i, theArray.length - 1);
            if (i != j) {
                int tmp = theArray[i - 1];
                theArray[i - 1] = theArray[j];
                theArray[j] = tmp;
            } else {
                System.out.println("! " + i);
            }
        }
    }

    // Interview Cake's solution
    public static void shuffle2(int[] theArray) {

        // if it's 1 or 0 items, just return
        if (theArray.length <= 1) {
            return;
        }

        // walk through from beginning to end
        for (int indexWeAreChoosingFor = 0;
             indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {
//            System.out.println("indexWeAreChoosingFor: " + indexWeAreChoosingFor);

            // choose a random not-yet-placed item to place there
            // (could also be the item currently in that spot)
            // must be an item AFTER the current item, because the stuff
            // before has all already been placed
            int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);
//            System.out.println("randomChoiceIndex: " + randomChoiceIndex);

            // place our random choice in the spot by swapping
            if (randomChoiceIndex != indexWeAreChoosingFor) {
                int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
                theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
                theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
            } else {
                System.out.println("? " + randomChoiceIndex);
            }
        }
    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array:  %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));


        final int[] shuffled2 = Arrays.copyOf(initial, initial.length);
        shuffle2(shuffled2);
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled2));
    }
}