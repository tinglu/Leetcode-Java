package MockO6;

import java.util.*;


/*
*
* TODO !!!!! - finish this!!!
*
* */
public class AutocompleteSystem {
    private Trie trie = new Trie();
    private TrieNode currentNode;
    private String prefix = "";

//    Map<String, Integer> sentenceCounts = new HashMap<>();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            String str = sentences[i];
            int count = times[i];
            trie.addSentence(str, count);
        }
        currentNode = trie.rootNode;
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();

        /*
         * Operation: input('#')
         * Output: []
         * Explanation:
         * The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And
         * the following input will be counted as a new search.
         * */
        if (c == '#') {
            trie.addSentence(prefix, 1);
            prefix = "";
            currentNode = trie.rootNode;
            return result;
        }

        prefix += c;

        if (currentNode == null) return result;

        currentNode = trie.findCharacter(c, currentNode);
        if (currentNode == null) return result;


        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ?
                        a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        pq.addAll(currentNode.counts.entrySet());

        int num = 3;
        while (num > 0 && !pq.isEmpty()) {
            Map.Entry<String, Integer> obj = pq.poll();
            result.add(obj.getKey());
            num--;
        }
        return result;
    }

    public static void main(String[] args) {
        AutocompleteSystem sol = new AutocompleteSystem(
                new String[]{"i love you", "island", "ironman", "i love leetcode"},
                new int[]{5, 3, 2, 2});
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
    }
}

class HotSentence implements Comparable<HotSentence> {
    String sentence;
    int count;

    HotSentence(String sentence, int count) {
        this.sentence = sentence;
        this.count = count;
    }

    @Override
    public int compareTo(HotSentence o) {
        if (this.count != o.count) return o.count - this.count;

        int len1 = this.sentence.length();
        int len2 = o.sentence.length();


        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (this.sentence.charAt(i) != o.sentence.charAt(i)) {
                return this.sentence.charAt(i) - o.sentence.charAt(i);
            }
        }

        return len2 - len1;
    }
}

class TrieNode {
    public Map<Character, TrieNode> children;
    public Map<String, Integer> counts;

    TrieNode() {
        children = new HashMap<>();
        counts = new HashMap<>();
    }

    public boolean hasChild(char ch) {
        return children.containsKey(ch);
    }

    public void addChild(char ch) {
        children.put(ch, new TrieNode());
    }

    public void addCount(char ch, String str, int count) {
        counts.put(str, counts.getOrDefault(str, 0) + count);
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    public TrieNode rootNode;
    private static final Character END_WORD_MARKER = '#';


    public Trie() {
        rootNode = new TrieNode();
    }

    public void addSentence(String str, int count) {
        TrieNode currentNode = rootNode;

        for (char ch : str.toCharArray()) {
            if (!currentNode.hasChild(ch)) {
                // this is a new word
                currentNode.addChild(ch);
            }
            currentNode.addCount(ch, str, count);
            currentNode = currentNode.getChild(ch);
        }

        if (!currentNode.hasChild(END_WORD_MARKER)) {
            // this is a new word
            currentNode.addChild(END_WORD_MARKER);
            currentNode.addCount(END_WORD_MARKER, str, count);
        }
    }

    public TrieNode findCharacter(char ch, TrieNode currentNode) {
        if (currentNode.hasChild(ch)) return currentNode.getChild(ch);
        return null;
    }
}