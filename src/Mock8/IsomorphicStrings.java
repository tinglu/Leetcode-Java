package Mock8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/*
 *
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * */
public class IsomorphicStrings {
    /*
     *
     * My solution - slow
     *
     * */
    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> usedMappings = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
//            System.out.println("c1: " + c1 + " c2: " + c2);
            if (!map.containsKey(c1)) {
                if (usedMappings.contains(c2)) return false;
                map.put(c1, c2);
                usedMappings.add(c2);
            }
            if (map.get(c1) != c2) return false;
        }
        return true;
    }


    /*
     *
     * Another approach - using array
     *
     * */
    public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[512]; // ASCII has 256 characters

        /*
         *
         * If char is new, then the two index always have same value 0;
         * Otherwise, their value would be updated already - and should be the same
         *
         * */
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] != arr[t.charAt(i) + 256]) return false;
            arr[s.charAt(i)] = i + 1; // to distinguish default value 0
            arr[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings sol = new IsomorphicStrings();
//        System.out.println(sol.isIsomorphic("egg", "add"));
//        System.out.println(sol.isIsomorphic("foo", "bar"));
//        System.out.println(sol.isIsomorphic("paper", "title"));
        System.out.println(sol.isIsomorphic("ab", "aa"));
    }
}
