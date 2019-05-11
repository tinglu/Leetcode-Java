package _3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithouRepeatingCharacters {

    // Did in April 2019
//    public int lengthOfLongestSubstring(String s) {
//        int max = 0;
//        char[] letters = s.toCharArray();
//
//        for (int i = 0; i < letters.length; i++) {
//            Set<Character> exists = new HashSet<>();
//
//            for (int j = i; j < letters.length; j++) {
//
//                if (exists.contains(letters[j])) {
//                    max = Math.max(max, j - i);
//                    break;
//                } else {
//                    if (j == letters.length - 1) {
////                        System.out.println("i: " + i + " " + letters[i] + " - j: " + j + " " + letters[j]);
//                        max = Math.max(max, j - i + 1);
//                    }
//                    exists.add(letters[j]);
//                }
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        LongestSubstringWithouRepeatingCharacters solution = new LongestSubstringWithouRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbc"));
    }

    // Re-do in May 2019
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] letters = s.toCharArray();

        Map<Character, Integer> charToIdx = new HashMap<>();
        int start = 0;
        for (int i = start; i < letters.length; i++) {
            if (charToIdx.containsKey(letters[i])) {
                max = Math.max(max, i - start);

                // Get previous index of the duplicated letter
                int prevIdx = charToIdx.get(letters[i]);
                // Remove all letters before this dup letter and itself from the map
                for (int j = start; j <= prevIdx; j++) {
                    charToIdx.remove(letters[j]);
                }
                // Map this dup letter to the new index
                charToIdx.put(letters[i], i);
                start = prevIdx + 1;
            } else {
                charToIdx.put(letters[i], i);
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
}
