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