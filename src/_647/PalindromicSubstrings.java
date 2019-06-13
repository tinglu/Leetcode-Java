package _647;

// TODO
public class PalindromicSubstrings {
    public boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) == s.charAt(to)) {
                from++;
                to--;
            } else {
                return false;
            }
        }

        return true;
    }


    public int countSubstrings(String s) {
        int len = s.length();
        int result = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j)) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstrings sol = new PalindromicSubstrings();
        System.out.println(sol.countSubstrings("tacocat"));
        System.out.println(sol.countSubstrings("tacoca"));
        System.out.println(sol.countSubstrings("mom"));
        System.out.println(sol.countSubstrings("aaa"));
    }
}
