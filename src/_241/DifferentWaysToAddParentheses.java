package _241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: review later
public class DifferentWaysToAddParentheses {

    //    Map<String, Integer> memo = new HashMap<>();

    // Remember history for the whole input that is not only length of 3
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input)) return memo.get(input);

        if (input.equals("")) return null;

        List<Integer> result = new ArrayList<>();

        int N = input.length();

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftPart = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(input.substring(i + 1));

                for (int l : leftPart) {
                    for (int r : rightPart) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        // Base case
        if (result.size() == 0) { // no operator
            result.add(Integer.parseInt(input));
        }

        memo.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses sol = new DifferentWaysToAddParentheses();
        System.out.println(sol.diffWaysToCompute("2-1-1"));
        System.out.println(sol.diffWaysToCompute("2*3-4*5"));
        System.out.println(sol.diffWaysToCompute(""));
    }

//    Initial submission without memoization
//    public List<Integer> diffWaysToCompute(String input) {
//        List<Integer> result = new ArrayList<>();
//        if (input.equals("")) return result;
//
//        int N = input.length();
//
//        for (int i = 0; i < N; i++) {
//            char c = input.charAt(i);
//            if (c == '+' || c == '-' || c == '*') {
//                List<Integer> leftPart = diffWaysToCompute(input.substring(0, i));
//                List<Integer> rightPart = diffWaysToCompute(input.substring(i + 1));
//
//                for (int l : leftPart) {
//                    for (int r : rightPart) {
//                        switch (c) {
//                            case '+':
//                                result.add(l + r);
//                                break;
//                            case '-':
//                                result.add(l - r);
//                                break;
//                            case '*':
//                                result.add(l * r);
//                                break;
//                            default:
//                                break;
//                        }
//                    }
//                }
//            }
//        }
//        if (result.size() == 0) { // no operator
//            result.add(Integer.parseInt(input));
//        }
//        return result;
//    }
}
