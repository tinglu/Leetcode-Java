package MockS5;

import java.util.ArrayDeque;
import java.util.Deque;


/*
 *
 * TODO - review later - should use 2 stacks!!! easier to handle numbers and strings separately!!!
 *
 *
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> repetitions = new ArrayDeque<>();
        Deque<StringBuilder> resultStack = new ArrayDeque<>();

        resultStack.push(new StringBuilder());

        int multiplier = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                multiplier = multiplier * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                repetitions.push(multiplier);
                multiplier = 0; // reset

                resultStack.push(new StringBuilder()); // start a fresh sb
            } else if (c == ']') {
                // should form a group of string now

                StringBuilder pattern = resultStack.pop();
                StringBuilder repeated = new StringBuilder();
                int num = repetitions.pop();

                while (num > 0) {
                    repeated.append(pattern);
                    num--;
                }

                resultStack.push(resultStack.pop().append(repeated));
            } else {
                resultStack.push(resultStack.pop().append(c));
            }
        }

        return resultStack.pop().toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("3[a2[c]]"));
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
        System.out.println(sol.decodeString("ef"));
        System.out.println(sol.decodeString("2[a]xx2[b]"));
        System.out.println(sol.decodeString("100[leetcode]"));

//        int[] test = new int[10];
//        System.out.println(test[0]);
//        boolean[] test2 = new boolean[10];
//        System.out.println(test2[0]);
    }

}
