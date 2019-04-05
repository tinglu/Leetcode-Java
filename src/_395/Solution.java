package _395;

import java.util.*;

//395. Longest Substring with At Least K Repeating Characters

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O
// (N)-Two-Pointer-Solution
class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int max = 0, i, j, idx, unique, noLessThanK;
        int[] counts = new int[26];

        for (int u = 1; u <= 26; u++) {
            Arrays.fill(counts, 0);
            unique = 0;
            noLessThanK = 0;
            i = 0;
            j = 0;
            while (j < str.length) {
                if (unique <= u) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0) unique++;
                    counts[idx]++;
                    if (counts[idx] == k) noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k) noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0) unique--;
                    i++;
                }
                if (unique == u && unique == noLessThanK) {
                    max = Math.max(j - i, max);
                }

            }
        }
        return max;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("a", 1) == 1);
        System.out.println(solution.longestSubstring("ababacb", 3) == 0);
        System.out.println(solution.longestSubstring("aabcabb", 3) == 0);
        System.out.println(solution.longestSubstring("bbaaacbd", 3) == 3);
        System.out.println(solution.longestSubstring("aaabb", 3) == 3);
    }
}

// Wrong...
//class Solution {
//    public int longestSubstring(String s, int k) {
//        Map<Character, Integer> stringCount = new HashMap<>();
//        char[] chars = s.toCharArray();
//        int[] charCount = new int[chars.length];
//
//        char c;
//        for (int i = 0; i < chars.length; i++) {
//            c = chars[i];
//            if (!stringCount.containsKey(c)) stringCount.put(c, 1);
//            else stringCount.put(c, stringCount.get(c) + 1);
//
//            charCount[i] = stringCount.get(c);
//        }
//
////        System.out.println(stringCount);
////        System.out.println(Arrays.toString(charCount));
//
//        Set<Character> charsInCurrentSubstring = new HashSet<>();
//        int currentMax = 0;
//        int tmpMax = 0;
//        int foundFirst = 0;
//
//        for (int i = chars.length - 1; i >= 0; i--) {
//            c = chars[i];
////            System.out.println("----");
////            System.out.println(c);
//            if (charCount[i] < k) {
//                // reach a character that repeats less than k at this index
//
//                if (!charsInCurrentSubstring.contains(c)) {
//                    // should start over
//
////                    System.out.println("before start over " + tmpMax);
////                    System.out.println("tmpMax: " + tmpMax);
////                    System.out.println("currentMax: " + currentMax);
//
//                    if (tmpMax > currentMax && foundFirst == charsInCurrentSubstring.size()) currentMax = tmpMax;
//
//                    tmpMax = 0;
////                    System.out.println("< k and not contain ");
////                    System.out.println("tmpMax: " + tmpMax);
////                    System.out.println("currentMax: " + currentMax);
//
//                    charsInCurrentSubstring.clear();
//                } else {
//                    // in a consecutive substring counting cycle
//
//                    tmpMax += 1;
//                    if (charCount[i] == 1) {
//                        foundFirst += 1;
//
////                        System.out.println("found first ");
//                    }
//                    if (tmpMax > currentMax && foundFirst == charsInCurrentSubstring.size()) currentMax = tmpMax;
//
////                    System.out.println("tmpMax: " + tmpMax);
////                    System.out.println("currentMax: " + currentMax);
//                }
//            } else {
//                if (charsInCurrentSubstring.isEmpty()) {
//                    tmpMax = 0; // start over from here
//                }
//                charsInCurrentSubstring.add(c);
//                tmpMax += 1;
//
//                if (i == 0 && tmpMax > currentMax) currentMax = tmpMax;
//
////                System.out.println("tmpMax: " + tmpMax);
////                System.out.println("currentMax: " + currentMax);
//            }
//
////            System.out.println(Arrays.toString(charsInCurrentSubstring.toArray()));
//        }
//        return currentMax;
//    }
//
//    public static void main(String args[]) {
//        Solution solution = new Solution();
//        System.out.println(solution.longestSubstring("a", 1) == 1);
//        System.out.println(solution.longestSubstring("ababacb", 3) == 0);
//        System.out.println(solution.longestSubstring("aabcabb", 3) == 0);
//        System.out.println(solution.longestSubstring("bbaaacbd", 3) == 3);
//        System.out.println(solution.longestSubstring("aaabb", 3) == 3);
//    }
//}
