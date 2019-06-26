package _161;

/*
 *
 * TODO: review later
 *
 *
 * 161. One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/
 *
 * */
public class OneEditDistance {
    /*
     *
     * Approach 1: Simpler way
     *
     * */
    public boolean isOneEditDistance(String s, String t) {
        int sourceLen = s.length();
        int targetLen = t.length();

        if (sourceLen > targetLen) return isOneEditDistance(t, s);

        for (int i = 0; i < sourceLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sourceLen == targetLen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        // all characters are the same, then must has 1 length difference
        return targetLen - sourceLen == 1;
    }

    /*
     *
     * Approach 2
     *
     * */
//    public boolean isOneEditDistance(String s, String t) {
//        if (s == null && t == null) return true;
//        if (s == null || t == null) return false;
//
//        int sourceLen = s.length();
//        int targetLen = t.length();
//
//        if (sourceLen == targetLen) {
//            // one change
//            return isOneChange(s, t);
//        }
//
//        if (sourceLen - targetLen == 1) {
//            // one removal from source
//            return isOneRemoval(s, t);
//        }
//
//        if (targetLen - sourceLen == 1) {
//            // one removal from target
//            // one removal from source
//            return isOneRemoval(t, s);
//        }
//
//        return false; // length diff > 1
//    }
//
//    private boolean isOneChange(String s, String t) {
//        boolean flag = false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != t.charAt(i)) {
//                if (flag) {
//                    return false;
//                } else {
//                    flag = true;
//                }
//            }
//        }
//        return flag; // the two strings could be the same!!!
//    }
//
//    private boolean isOneRemoval(String longerString, String shorterString) {
//        boolean flag = false;
//        int i = 0, j = 0;
//
//        while (i < longerString.length() && j < shorterString.length()) {
//            if (longerString.charAt(i) != shorterString.charAt(j)) {
//                if (flag) {
//                    return false; // has removed once already
//                } else {
//                    i++;
//                    flag = true;
//                }
//            } else {
//                i++;
//                j++;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        OneEditDistance sol = new OneEditDistance();
        System.out.println(sol.isOneEditDistance("ab", "acd"));
    }
}
