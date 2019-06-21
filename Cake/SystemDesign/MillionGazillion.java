package SystemDesign;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MillionGazillion {

    // implement a trie and use it to efficiently store string

    static class TrieNode {
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }

        public boolean hasChildNode(char letter) {
            return children.containsKey(letter);
        }

        public TrieNode getChildNode(char letter) {
            return children.get(letter);
        }

        public void addChildNode(char letter) {
            children.put(letter, new TrieNode());
        }
    }


    static class Trie {
        private TrieNode rootNode;
        
        private static final char END_OF_WORD_MARKER = '\0';

        public Trie() {
            this.rootNode = new TrieNode();
        }

        public boolean addWord(String word) {
            TrieNode currentNode = this.rootNode;

            boolean isNewWord = false;

            for (char c : word.toCharArray()) {
                if (!currentNode.hasChildNode(c)) {
                    // should add this as new word
                    isNewWord = true;
                    currentNode.addChildNode(c);
                }

                currentNode = currentNode.getChildNode(c);
            }
            
            if (!currentNode.hasChildNode(END_OF_WORD_MARKER)) {
                // then this is a new word
                isNewWord = true;
                currentNode.addChildNode(END_OF_WORD_MARKER);
            }

            return isNewWord;
        }
    }






    // tests

    @Test
    public void trieTest() {
        final Trie trie = new Trie();

        boolean result = trie.addWord("catch");
        assertTrue(result);

        result = trie.addWord("cakes");
        assertTrue(result);

        result = trie.addWord("cake");
        assertTrue(result);

        result = trie.addWord("cake");
        assertFalse(result);

        result = trie.addWord("caked");
        assertTrue(result);

        result = trie.addWord("catch");
        assertFalse(result);

        result = trie.addWord("");
        assertTrue(result);

        result = trie.addWord("");
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MillionGazillion.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}