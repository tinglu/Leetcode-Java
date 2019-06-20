package DynamicProgrammingAndRecursion;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RecursiveStringPermutation {

//    public static Set<String> getPermutations(String inputString) {
//        Set<String> letters = new HashSet<>();
//        for (int i = 0; i < inputString.length(); i++) {
//            letters.add(inputString.substring(i, i + 1));
//        }
//        return helper(letters, 0);
//    }
//
//    private static Set<String> helper(Set<String> letters, int from) {
//        if (letters.size() == 0) return new HashSet<>();
//
//        Set<String> permutations = new HashSet<>();
//
////        Set<String> substrings = helper(inputString, from + 1);
//
//        Iterator<String> iter = letters.iterator();
//        while(iter.hasNext()) {
//
//        }
//
//        for (int i = from; i < inputString.length(); i++) {
//            if (substrings.isEmpty()) {
//                permutations.add(inputString.substring(i, i + 1));
//            } else {
//                for (String sub : substrings) {
//                    permutations.add(inputString.substring(i, i + 1) + sub);
//                }
//            }
//        }
//        return permutations;
//    }


    /*
     *
     * !!!!! TODO: finish this using interview cake's solution
     *
     * a permutation of the current word is adding the char into each position among characters
     *
     * */
//    public static Set<String> getPermutations(String inputString) {
//        char[] letters = inputString.toCharArray();
//
//
//    }

    /*
     *
     * Below is my solution - correct!
     *
     * But interview cake's solution is cleaner
     *
     * */
    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        return helper(new HashSet<>(Arrays.asList("")), inputString);
    }

    private static Set<String> helper(Set<String> accu, String inputString) {
        if (inputString.length() == 0) return accu;

        String curr = inputString.substring(0, 1);
        if (accu.isEmpty()) {
            accu.add(curr);
            return helper(accu, inputString.substring(1));
        }

        Set<String> accu2 = new HashSet<>();
        for (String str : accu) {
            for (int i = 1; i <= str.length() + 1; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, i - 1));
                sb.append(curr);
                sb.append(str.substring(i - 1));
                accu2.add(sb.toString());
            }
        }
        return helper(accu2, inputString.substring(1));
    }

    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RecursiveStringPermutation.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}