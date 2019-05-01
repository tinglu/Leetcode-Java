package HashingAndHashTables;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Read carefully!!!
//
//"But 'ivicc' isn't a palindrome!"
//        If you had this thought, read the question again carefully. We're asking if any permutation of the string
//        is a palindrome. Spend some extra time ensuring you fully understand the question before starting. Jumping
//        in with a flawed understanding of the problem doesn't look good in an interview.
public class PermutationIsPalindrome {

    public static boolean hasPalindromePermutation(String theString) {

//        Map<Character, Integer> charCount = new HashMap<>();
//        for (char c : theString.toCharArray()) {
//            int n = charCount.getOrDefault(c, 0);
//            charCount.put(c, n + 1);
//        }
//
//        int odds = 0;
//
//        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
//            if (entry.getValue() % 2 == 1) odds += 1;
//            if (odds > 1) return false;
//        }
//
//        return true;

//        Map is not necessary; we only care if there's odd number of characters
        Set<Character> set = new HashSet<>();
        for (char c : theString.toCharArray()) {
            if (set.contains(c)) set.remove(c); // this get rid of an even pair of the character
            else set.add(c); // this character is always remains in odd number
        }

        return set.size() <= 1;
    }


    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PermutationIsPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}