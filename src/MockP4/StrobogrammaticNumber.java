package MockP4;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 246. Strobogrammatic Number
 * https://leetcode.com/problems/strobogrammatic-number/
 *
 * */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int N = num.length();

        Map<Character, Character> strobos = new HashMap<>();
        strobos.put('0', '0');
        strobos.put('1', '1');
        strobos.put('8', '8');
        strobos.put('6', '9');
        strobos.put('9', '6');

        int i = 0;
        int j = N - 1;
        while (i <= j) {
            char left = num.charAt(i);
            char right = num.charAt(N - 1 - i);
//            System.out.println("left: " + left);
//            System.out.println("right: " + right);
            if (!(strobos.containsKey(left) && strobos.containsKey(right) && strobos.get(left) == right)) {
                return false;
            }

            if (i == j && !(left == '0' || left == '1' || left == '8')) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber sol = new StrobogrammaticNumber();

        System.out.println(sol.isStrobogrammatic("69")); // true
        System.out.println(sol.isStrobogrammatic("1")); // true
        System.out.println(sol.isStrobogrammatic("6")); // false
        System.out.println(sol.isStrobogrammatic("926")); // false
        System.out.println(sol.isStrobogrammatic("963")); // false
        System.out.println(sol.isStrobogrammatic("9129")); // false
    }
}
