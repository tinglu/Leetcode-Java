package HashingAndHashTables;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

// TODO: review later

/*
 *
 * Runtime and memory cost are both O(n). This is the best we can do because we have to look at every character in
 * the input string and we have to return a hash map of every unique word. We optimized to only make one pass over
 * our input and have only one O(n) data structure.
 *
 * */
public class WordCloud {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {

            // count the frequency of each word
            List<String> words = splitWords(inputString);
//            for (String s : words) {
//                System.out.println(s);
//            }
            for (String word : words) {
                String capitalised = word.length() > 1 ? Character.toUpperCase(word.charAt(0)) + word.substring(1) :
                        Character.toString(Character.toUpperCase(word.charAt(0)));
                if (!wordsToCounts.containsKey(word) && wordsToCounts.containsKey(capitalised)) {
                    int count = wordsToCounts.get(capitalised);
                    wordsToCounts.remove(capitalised);
                    wordsToCounts.put(word, count + 1);
                } else {
                    int count = wordsToCounts.getOrDefault(word, 0);
                    wordsToCounts.put(word, count + 1);
                }
            }

        }

        private List<String> splitWords(String inputString) {
            List<String> words = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (char c : inputString.toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append(c);
                } else {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0) {
                words.add(sb.toString());
            }
            return words;
        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }


    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("like", 1);
                put("cake", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("and", 1);
                put("pound", 1);
                put("for", 2);
                put("dessert", 1);
                put("Chocolate", 1);
                put("dinner", 1);
                put("cake", 2);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("cake", 1);
                put("Strawberry", 1);
                put("short", 1);
                put("Yum", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("cake", 1);
                put("Dessert", 1);
                put("mille-feuille", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("mmm", 2);
                put("decisions", 2);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("Bakery", 1);
                put("Cakes", 1);
                put("Allie's", 1);
                put("Sasha's", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(WordCloud.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}