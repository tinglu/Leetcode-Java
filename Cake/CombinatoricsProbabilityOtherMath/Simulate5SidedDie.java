package CombinatoricsProbabilityOtherMath;

import java.util.Random;

/*
 *
 * Worst-case O(∞) time (we might keep re-rolling forever) and O(1) space.
 *
 * */
class Simulate5SidedDie {

    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    public static int rand5() {

        // implement rand5() using rand7()

        int result = 7;

        while (result > 5) {
            result = rand7();
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", rand5());
        }
        System.out.println();
    }
}