package _340;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int N = s.length();

        if (N == 0 || k == 0) {
            return 0;
        }

        int max = -1;


        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < N) { // expanding right
            /*
             * TODO: reivew later - watch out here - store the rightmost index of this char !!!
             * */
            window.put(s.charAt(right), right);

            if (window.size() == k + 1) {
                /*
                 * Just added a new distinct letter
                 * */
                // shrink left by deleting the leftmost character
                int leftmostCh = Collections.min(window.values());
                window.remove(s.charAt(leftmostCh));

                left = leftmostCh + 1;
            }

            /*
             * TODO: reivew later - watch out here - check max every time rather than only checking inside if block !!!
             * */
            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringAtMostKDistinctCharacters sol = new LongestSubstringAtMostKDistinctCharacters();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(sol.lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(sol.lengthOfLongestSubstringKDistinct("a", 2));
    }
}
