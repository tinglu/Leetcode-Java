package _76;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int N = s.length();

        if (N == 0 || t.length() == 0) {
            return "";
        }

        int minPos = -1;
        int minLeft = 0;
        int minRight = 0;

        Map<Character, Integer> targetLetters = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = targetLetters.getOrDefault(t.charAt(i), 0);
            targetLetters.put(t.charAt(i), count + 1);
        }

        int required = targetLetters.size();

        Map<Character, Integer> window = new HashMap<>();
        int formed = 0;

        int left = 0;
        int right = 0;

        while (right < N) {
            char ch = s.charAt(right);

            // continue expanding right
            int count = window.getOrDefault(ch, 0);
            // System.out.println(window);
            window.put(ch, count + 1);

            if (targetLetters.containsKey(ch) && targetLetters.get(ch).intValue() == window.get(ch).intValue()) {
                formed++; // window a required char with correct occurrence
            }

            // can start shrinking from left while still in a valid window
            while (left <= right && formed == required) {
                ch = s.charAt(left);

                if (minPos == -1 || right - left + 1 < minPos) {
                    minPos = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                window.put(ch, window.get(ch) - 1);

                if (targetLetters.containsKey(ch) && targetLetters.get(ch) > window.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minPos == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();

        System.out.println(sol.minWindow("a", "a"));
        System.out.println(sol.minWindow("a", "aa"));
    }

}
