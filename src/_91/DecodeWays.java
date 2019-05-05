package _91;

// XXX TLE!
//public class DecodeWays {
//    int count;
//
//    public int numDecodings(String s) {
//        count = 0;
//        helper(s);
//        return count;
//    }
//
//
//    private void helper(String s) {
//        if (s.length() < 1) {
//            count += 1;
//            return;
//        }
//
//        int firstDigit = Integer.valueOf(s.substring(0, 1));
//        if (firstDigit == 0) return;
//        if (firstDigit >= 1 && firstDigit <= 9) helper(s.substring(1));
//
//        if (s.length() >= 2) {
//            int firstTwoDigits = Integer.valueOf(s.substring(0, 2));
//            if (firstTwoDigits >= 10 && firstTwoDigits <= 26) helper(s.substring(2));
//        }
//    }
//}

// TODO: review later
public class DecodeWays {

    public int numDecodings(String s) {
        int N = s.length();
        if (N == 0) return 0;

        int[] memo = new int[N + 1];
        memo[N] = 1;
        memo[N - 1] = s.charAt(N - 1) == '0' ? 0 : 1;

        for (int i = N - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                memo[i] = (Integer.valueOf(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }
}