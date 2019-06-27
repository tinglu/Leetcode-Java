package _244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    private Map<String, List<Integer>> wordIndices;

    public WordDistance(String[] words) {
        wordIndices = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> indices = wordIndices.getOrDefault(word, new ArrayList<>());
            indices.add(i);
            wordIndices.put(word, indices);
        }
    }

    public int shortest(String word1, String word2) {
        if (!wordIndices.containsKey(word1)) return -1;
        if (!wordIndices.containsKey(word2)) return -1;

        List<Integer> ids1 = wordIndices.get(word1);
        List<Integer> ids2 = wordIndices.get(word2);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < ids1.size() && j < ids2.size()) {
            int w1 = ids1.get(i);
            int w2 = ids2.get(j);
            min = Math.min(min, Math.abs(w1 - w2));

            if (w1 < w2) {
                i++;
            } else if (w1 > w2) {
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        WordDistance obj = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(obj.shortest("coding", "practice"));
        System.out.println(obj.shortest("makes", "coding"));
    }
}