package _1003;

import java.util.Stack;

public class WordValidAfterSubstitutions {

    // TODO: Review later - could write shorter code by only check 'c' situation
    // https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/247626/JavaPythonC%2B%2B-Stack-Solution-O(N)
    public boolean isValid(String S) {

        char[] letters = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < letters.length; i++) {
            char curr = letters[i];
            switch (curr) {
                case 'a':
                    stack.add(curr);
                    break;
                case 'b':
                    if (i == letters.length - 1) return false;
                    if (letters[i + 1] == 'c' && !stack.empty() && stack.peek() == 'a') {
                        stack.pop();
                        i++;
                    } else {
                        stack.add(curr);
                    }
                    break;
                case 'c':
                    if (stack.empty() || stack.peek() != 'b') return false;
                    stack.pop();
                    if (stack.empty() || stack.peek() != 'a') return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
}
