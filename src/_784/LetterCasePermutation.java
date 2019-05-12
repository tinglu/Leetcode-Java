package _784;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    // TODO: Review later - could use accumulator
    public List<String> letterCasePermutation(String S) {
        return helper(S, 0);
    }

    private List<String> helper(String S, int i) {
        List<String> subresult = new ArrayList<>();
        if (i == S.length()) return subresult;

        List<String> following = helper(S, i + 1);

        String s = S.substring(i, i + 1);
        if (Character.isDigit(S.charAt(i))) {
            if (following.isEmpty()) {
                subresult.add(s);
            } else {
                for (String follow : following) {
                    subresult.add(s + follow);
                }
            }
        } else {
            String lower = s.toLowerCase();
            String upper = s.toUpperCase();

            if (following.isEmpty()) {
                subresult.add(lower);
                subresult.add(upper);
            } else {
                for (String follow : following) {
                    subresult.add(lower + follow);
                    subresult.add(upper + follow);
                }
            }
        }
        return subresult;
    }

    public static void main(String[] args) {
        LetterCasePermutation sol = new LetterCasePermutation();
        System.out.println(sol.letterCasePermutation("a1b2"));
        System.out.println(sol.letterCasePermutation("3z4"));
        System.out.println(sol.letterCasePermutation("12345"));
    }
}
