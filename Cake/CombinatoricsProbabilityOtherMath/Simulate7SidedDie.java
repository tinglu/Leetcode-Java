package CombinatoricsProbabilityOtherMath;

import java.util.Random;

/*
 *
 * TODO: review later - our total number of possible outcomes must be divisible by 7
 *
 * Worst-case O(\infty)O(∞) time (we might keep re-rolling forever) and O(1)O(1) space.
 *
 * Since 5 is already prime, any number that can be expressed as 5^n (where n is a positive integer)
 * will have a prime factorization that is all 5s. For example, here are the prime factorizations for 5^2, 5^3, 5^4...
 * 7 is also prime, so if any power of 5 were divisible by 7, 7 would be in its prime factorization.
 * But 7 can't be in its prime factorization because its prime factorization is all 5s (and it has only one prime
 * factorization).
 * So no power of 5 is divisible by 7. BAM MATHPROOF.
 *
 *
 * */
class Simulate7SidedDie {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    /*
     *
     * First approach:
     *
     * */
    public static int rand7() {

        // implement rand7() using rand5()

        int[][] matrix = {{
                1, 2, 3, 4, 5
        }, {
                6, 7, 1, 2, 3
        }, {
                4, 5, 6, 7, 1
        }, {
                2, 3, 4, 5, 6
        }, {
                7, 1, 2, 3, 4
        }};

        int result = 0;

        while (true) {
            int r = rand5() - 1;
            int c = rand5() - 1;
            result = matrix[r][c];
            if (r == 4 && c > 0) continue;
            return result;
        }
    }

    /*
     * Second approach:
     *
     *
     * 25 isn't evenly divisible by 7, but 21 is. So when we get one of the last 4 possible outcomes, we throw it out
     *  and roll again.
     *
     * So we roll twice and translate the result into a unique outcomeNumber in the range 1..25. If the outcomeNumber is
     *  greater than 21, we throw it out and re-roll. If not, we mod by 7 (and add 1).
     *
     * */
    public static int rand7Other() {

        while (true) {

            // do our die rolls
            int roll1 = rand5();
            int roll2 = rand5();

            int outcomeNumber = (roll1 - 1) * 5 + (roll2 - 1) + 1; // +1 because number starts from 1 not 0!!!

            // if we hit an extraneous
            // outcome we just re-roll
            if (outcomeNumber > 21) continue;

            // our outcome was fine. return it!
            return outcomeNumber % 7 + 1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}