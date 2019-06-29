package _76;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringNew {

    /*
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * */
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int count = 0;

        int S = s.length();
        int T = t.length();

        Map<Character, Integer> targets = new HashMap<>();
        for (int i = 0; i < T; i++) {
            targets.put(t.charAt(i), targets.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = targets.size();

        Map<Character, Integer> window = new HashMap<>();

        int min = -1; // TODO: watch out here - min == -1 means hasn't been updated anywhere - a valid min at least 0
        int minL = 0;
        int minR = 0;

        while (right < S) {
            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (targets.containsKey(ch) && window.get(ch).intValue() == targets.get(ch).intValue()) {
                count++;
            }

            // TODO: watch out here - left <= right (= is important!!!)
            while (left <= right && count == required) {
                // shrink from left
                ch = s.charAt(left);


                /*
                 * TODO: watch out here - check min inside while loop !!!
                 *  the current left is where the window is still valid!
                 * */
                int currMin = right - left + 1;
                if (min == -1 || currMin < min) { // TODO: watch out here - min == -1 means hasn't been updated anywhere
                    min = currMin;
                    minL = left;
                    minR = right;
                }

                window.put(ch, window.get(ch) - 1);

                if (targets.containsKey(ch) && window.get(ch) < targets.get(ch)) {
                    count--;
                }

                left++;
            }

            right++;
        }

        System.out.println("min: " + minR);
        System.out.println("minL: " + minL);
        System.out.println("minR: " + minR);
        // TODO: watch out here - min == -1 means hasn't been updated anywhere
        return min == -1 ? "" : s.substring(minL, minR + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstringNew sol = new MinimumWindowSubstringNew();

        System.out.println(sol.minWindow("a", "a"));
        System.out.println(sol.minWindow("a", "aa"));
    }
}
