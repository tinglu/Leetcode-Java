package _438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: review later
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) return result;

        Map<Character, Integer> memo = new HashMap<>();
        for (char c : p.toCharArray()) {
            memo.put(c, memo.getOrDefault(c, 0) + 1);
        }

        int counter = memo.size(); // the number of distinct letter in target

        int begin = 0;
        int end = 0;

        while (end < s.length()) {
            char curr = s.charAt(end);
            if (memo.containsKey(curr)) {
                memo.put(curr, memo.get(curr) - 1);

                if (memo.get(curr) == 0) counter--; // found a matching letter in current position
            }
            end++;

            while (counter == 0) { // stop when find the first matching letter in the valid anagram
                char tmp = s.charAt(begin);
                if (memo.containsKey(tmp)) { // only if this tmp letter exists in memo, this letter is valid
                    memo.put(tmp, memo.get(tmp) + 1);
//                    System.out.println(memo);
                    if (memo.get(tmp) > 0) { // !!! IMPORTANT LINE because cases like {a=-1, b=0, c=0} could happen,
                        // when counter is not zero yet, but we've found more 'a' than number of 'a' in target, so
                        // number of 'a' could be negative
                        counter++; // found a matching letter in current position
                    }
                }

                if (end - begin == p.length()) result.add(begin); // begin to end forms a valid anagram
                begin++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInString sol = new FindAllAnagramsInString();
        System.out.println(sol.findAnagrams("cbaebabacd", "abc"));
    }
}
