package _516;


/*
 *
 * Dynamic programming
 *
 * */
public class LongestPalindromicSubsequence {


    // WRONG!
//    public int longestPalindromeSubseq(String s) {
//        int result = 0;
//
//        int len = s.length();
//        if (len == 0) return 0;
//        if (len == 1) return 1;
//
//        int left = 0;
//        int right = len - 1;
//
//        while (left < right) {
//
//            for (int j = right; j > left; j--) {
//                if (s.charAt(j) == s.charAt(left)) {
//                    result += 2;
//                    right = j - 1;
//                    break;
//                }
//            }
//
//            left++;
//        }
//
//        if (left <= right) result += 1; // has some characters left in-between the palindromic letter
//        return result;
//    }


    private int helper(int from, int to, String s, int[][] memo) {
        if (memo[from][to] != 0) return memo[from][to];

        if (from == to) return 1;
        if (from > to) return 0;

        if (s.charAt(from) == s.charAt(to)) {
            memo[from][to] = helper(from + 1, to - 1, s, memo) + 2;
        } else {
            memo[from][to] = Math.max(helper(from, to - 1, s, memo), helper(from + 1, to, s, memo));
        }

        return memo[from][to];
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();

        int[][] memo = new int[len][len];
        return helper(0, len - 1, s, memo);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
        System.out.println(sol.longestPalindromeSubseq("cbbd"));
        System.out.println(sol.longestPalindromeSubseq("a"));
        System.out.println(sol.longestPalindromeSubseq("ab"));
        System.out.println(sol.longestPalindromeSubseq("aabaaba"));
    }
}
