package _3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithouRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            Set<Character> exists = new HashSet<>();

            for (int j = i; j < letters.length; j++) {

                if (exists.contains(letters[j])) {
                    max = Math.max(max, j - i);
                    break;
                } else {
                    if (j == letters.length - 1) {
//                        System.out.println("i: " + i + " " + letters[i] + " - j: " + j + " " + letters[j]);
                        max = Math.max(max, j - i + 1);
                    }
                    exists.add(letters[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithouRepeatingCharacters solution = new LongestSubstringWithouRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbc"));
    }
}
