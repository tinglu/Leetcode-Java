package MockP5;

import java.util.HashMap;
import java.util.Map;


/*
 *
 *
 * TODO: review later
 *
 *
 * 1056. Confusing Number
 * https://leetcode.com/problems/confusing-number/
 *
 * */
public class ConfusingNumber {

    public boolean confusingNumber(int N) {
        Map<Integer, Integer> strobos = new HashMap<>();
        strobos.put(0, 0);
        strobos.put(1, 1);
        strobos.put(8, 8);
        strobos.put(6, 9);
        strobos.put(9, 6);

        int tmp = N;
        int upperbound = Integer.MAX_VALUE / 10;
        int newNum = 0;

        while (tmp != 0) {
            int remainder = tmp % 10;

            if (!strobos.containsKey(remainder)) return false; // must be an invalid digit!

            if (newNum > upperbound) return false; // too big

            newNum = newNum * 10 + strobos.get(remainder);

            tmp = tmp / 10;
        }

        return newNum != N;
    }

    public static void main(String[] args) {
        ConfusingNumber sol = new ConfusingNumber();

        System.out.println("T: " + sol.confusingNumber(6));
        System.out.println("T: " + sol.confusingNumber(89));
        System.out.println("T: " + sol.confusingNumber(910));
        System.out.println("T: " + sol.confusingNumber(981));
        System.out.println("T: " + sol.confusingNumber(8699));
        System.out.println("T: " + sol.confusingNumber(19681));

        System.out.println("F: " + sol.confusingNumber(11));
        System.out.println("F: " + sol.confusingNumber(0));
        System.out.println("F: " + sol.confusingNumber(150));
        System.out.println("F: " + sol.confusingNumber(25));

        ///
//        System.out.println(sol.confusingNumber(1));
//        System.out.println(sol.confusingNumber(2));
//        System.out.println(sol.confusingNumber(3));
//        System.out.println(sol.confusingNumber(4));
//        System.out.println(sol.confusingNumber(5));
//        System.out.println(sol.confusingNumber(6));
//        System.out.println(sol.confusingNumber(7));
//        System.out.println(sol.confusingNumber(8));
//        System.out.println(sol.confusingNumber(9));
//        System.out.println(sol.confusingNumber(10));
//        System.out.println(sol.confusingNumber(100));
//        System.out.println(sol.confusingNumber(23));
//        System.out.println(sol.confusingNumber(44));
//        System.out.println(sol.confusingNumber(98));
//        System.out.println(sol.confusingNumber(96));
    }
}
