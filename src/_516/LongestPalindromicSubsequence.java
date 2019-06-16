package _516;


// TODO
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


    public int longestPalindromeSubseq(String s) {
        int result = 0;

        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;

        int left = 0;
        int right = len - 1;

        while (left < right) {

            for (int j = right; j > left; j--) {
                if (s.charAt(j) == s.charAt(left)) {
                    result += 2;
                    right = j - 1;
                    break;
                }
            }

            left++;
        }

        if (left <= right) result += 1; // has some characters left in-between the palindromic letter
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
        System.out.println(sol.longestPalindromeSubseq("cbbd"));
        System.out.println(sol.longestPalindromeSubseq("a"));
        System.out.println(sol.longestPalindromeSubseq("ab"));
    }
}
