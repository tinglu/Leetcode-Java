package _17;


import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    private String[] digitMapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> tmpStrings = new LinkedList<>();

        int N = digits.length();
        if (N < 1) return tmpStrings;

        tmpStrings.add("");

        for (int i = 0; i < N; i++) { // appending i-th digit character to existing prefixes (prefix has length i)
            String letters = digitMapping[digits.charAt(i) - '0'];

            while (!tmpStrings.isEmpty() && tmpStrings.peek().length() == i) {
                /*
                 * append to the prefixes that are in the same length of thecurrent digit index
                 * */
                String prefix = tmpStrings.poll();

                for (char c : letters.toCharArray()) {
                    tmpStrings.add(prefix + c);
                }
            }
        }

        return tmpStrings;
    }

}

//public class LetterCombinationsOfAPhoneNumber {
//    Map<String, String[]> digitToLetter = new HashMap<>();
//
//    public List<String> letterCombinations(String digits) {
//        digitToLetter.put("2", new String[]{"a", "b", "c"});
//        digitToLetter.put("3", new String[]{"d", "e", "f"});
//        digitToLetter.put("4", new String[]{"g", "h", "i"});
//        digitToLetter.put("5", new String[]{"j", "k", "l"});
//        digitToLetter.put("6", new String[]{"m", "n", "o"});
//        digitToLetter.put("7", new String[]{"p", "q", "r", "s"});
//        digitToLetter.put("8", new String[]{"t", "u", "v"});
//        digitToLetter.put("9", new String[]{"w", "x", "y", "z"});
//
//        return helper(digits);
//    }
//
//
//    private List<String> helper(String digits) {
//        List<String> result = new ArrayList<>();
//
//        if (digits.length() < 1) return result;
//
//        String digit = digits.substring(0, 1);
//        String[] letters = digitToLetter.get(digit);
//        if (letters == null) return result;
//
//        for (String currLetter : letters) {
//            List<String> subresult = helper(digits.substring(1));
//
//            if (subresult.size() < 1) {
//                result.add(currLetter);
//            } else {
//                for (String followingLetters : subresult) {
//                    result.add(currLetter + followingLetters);
//                }
//            }
//        }
//
//        return result;
//    }
//}
