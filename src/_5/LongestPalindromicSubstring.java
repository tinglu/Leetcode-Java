package _5;

public class LongestPalindromicSubstring {

    // TODO: this is brute force. Try use Dynamic Programming... or Expand Around Center...
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                String tmp = s.substring(i, j + 1);
                if (isPalindrom(tmp)) {
                    if (tmp.length() > max) {
                        max = tmp.length();
                        result = tmp;
                        if (i == 0 && (j == s.length() - 1)) return result; // Add this line to avoid TLE error!
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrom(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome("babad"));
        System.out.println(sol.longestPalindrome("cbbd"));
        System.out.println(sol.longestPalindrome("g"));
        System.out.println(sol.longestPalindrome(""));
    }
}
