package MockO6;

import java.util.*;

public class SimilarSentence {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            Set<String> sim1 = map.getOrDefault(w1, new HashSet<>());
            Set<String> sim2 = map.getOrDefault(w2, new HashSet<>());
            sim1.add(w2);
            sim2.add(w1);
            map.put(w1, sim1);
            map.put(w2, sim2);
        }

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (!w1.equals(w2)) {
                if (!(map.containsKey(w1) && map.get(w1).contains(w2)
                        || map.containsKey(w2) && map.get(w2).contains(w1))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SimilarSentence sol = new SimilarSentence();

    }
}
