package _139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

//    WRONG!
//    private boolean helper(int from, String s, Set<String> dict, int[][] isWord) {
//        if (from == s.length()) return false;
//
//        for (int to = s.length() - 1; to >= from; to--) {
////            System.out.println("from: " + from + " to: " + to);
//            if (isWord[from][to] == 1 && to == s.length() - 1) return true; // find matches until the end
//            if (isWord[from][to] == 0) { // 0 means this range is not checked yet
//                String sub = s.substring(from, to + 1);
//                if (dict.contains(sub)) {
//                    isWord[from][to] = 1;
//                    if (to == s.length() - 1) return true;
//                    return helper(to + 1, s, dict, isWord);
//                } else {
//                    isWord[from][to] = -1; // hard code -1 to indicate this range has been checked and is not a word
//                }
//            }
//        }
//        return helper(from + 1, s, dict, isWord);
//    }
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int N = s.length();
//
//        Set<String> dict = new HashSet<>(wordDict);
//
//        int[][] isWord = new int[N][N];
//
//        return helper(0, s, dict, isWord);
//    }


    /*
     *
     *
     * Time complexity : O(n^2). Two loops are their to fill dp array.
     *
     *
     * Space complexity : O(n). Length of p array is n+1.
     *
     *
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();

        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[N + 1];
        dp[0] = true; // !!!!! IMPORTANT - empty string is true

        for (int i = 1; i <= N; i++) { // i -> substring length
            for (int j = 0; j < i; j++) { // j -> index of partition in range from 0 to i
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(sol.wordBreak("a", Arrays.asList("a")));
        System.out.println(sol.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
        System.out.println(sol.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }
}
