package _647;

// TODO


public class PalindromicSubstrings {

    /*
     *
     * This approach takes more than O(N^2) complexity
     *
     * */
//    public boolean isPalindrome(String s, int from, int to) {
//        while (from < to) {
//            if (s.charAt(from) == s.charAt(to)) {
//                from++;
//                to--;
//            } else {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//    public int countSubstrings(String s) {
//        int len = s.length();
//        int result = 0;
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (isPalindrome(s, i, j)) {
//                    result += 1;
//                }
//            }
//        }
//        return result;
//    }


    /*
     *
     * O(N^2) time - expand from centre
     * O(1) space
     *
     * */
    public int countSubstrings(String s) {
        int N = s.length();
        int result = 0;
        for (int center = 0; center < 2 * N - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                /*
                 *
                 * !!!!!! while is very important!! need to expand!!!
                 *
                 * */
                result += 1;
                left--;
                right++;
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
