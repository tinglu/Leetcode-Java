package _91;

import java.util.Arrays;

/*
 *
 * TODO: review later - should use MEMOIZATION!!!
 *
 * */
public class DecodeWaysNew {
    /*
     *
     * XXXXXXXXX TLE
     * Time O(2^N)
     *
     *
     * */
//    int count;
//
//    public int numDecodings(String s) {
//        count = 0;
//        validDecode(s, 0);
//        return count;
//    }
//
//
//    private void validDecode(String s, int from) {
//        if (from == s.length()) count++;
//
//        if (from < s.length()) { // 1 character decoding
//            int d1 = s.charAt(from) - '0';
//            if (d1 >= 1 && d1 <= 9) {
//                validDecode(s, from + 1);
//            }
//        }
//        if (from < s.length() - 1) { // 2 characters decoding
//            int d2 = Integer.parseInt(s.substring(from, from + 2));
//            if (d2 >= 10 && d2 <= 26) {
//                validDecode(s, from + 2);
//            }
//        }
//    }


    public int numDecodings(String s) {
        int[] prevAns = new int[s.length()];
        Arrays.fill(prevAns, -1);
        return validDecode(s, 0, prevAns);
    }


    private int validDecode(String s, int decodePointer, int[] prevAns) {
        if (decodePointer == s.length()) return 1;

        if (prevAns[decodePointer] > -1) {
            return prevAns[decodePointer];
        }

        int decodeWaysFromHere = 0;

        if (decodePointer < s.length()) { // 1 character decoding
            int d1 = s.charAt(decodePointer) - '0';
            if (d1 >= 1 && d1 <= 9) {
                decodeWaysFromHere += validDecode(s, decodePointer + 1, prevAns);
            }
        }
        if (decodePointer < s.length() - 1) { // 2 characters decoding
            int d2 = Integer.parseInt(s.substring(decodePointer, decodePointer + 2));
            if (d2 >= 10 && d2 <= 26) {
                decodeWaysFromHere += validDecode(s, decodePointer + 2, prevAns);
            }
        }

        // !!! CACHE THE SUBPROBLEM HERE !!!
        prevAns[decodePointer] = decodeWaysFromHere;
        return decodeWaysFromHere;
    }

    public static void main(String[] args) {
        DecodeWaysNew sol = new DecodeWaysNew();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
    }
}
