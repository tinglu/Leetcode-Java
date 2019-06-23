package Mock9;

import Common.UnionFind;

import java.util.*;

/*
 *
 * TODO: review later - UnionFind is faster than DFS
 *
 * */
public class SimilarSentence2 {
    /*
     *
     * Approach1: DFS
     *
     * Time Complexity: O(NP), where N is the maximum length of words1 and words2, and P is the length of pairs. Each
     *  of N searches could search the entire graph.
     *
     * Space Complexity: O(P), the size of pairs.
     *
     * */
    public boolean areSentencesSimilarTwo1(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            Set<String> sim1 = graph.getOrDefault(w1, new HashSet<>());
            Set<String> sim2 = graph.getOrDefault(w2, new HashSet<>());
            sim1.add(w2);
            sim2.add(w1);
            graph.put(w1, sim1);
            graph.put(w2, sim2);
        }

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            Set<String> visited = new HashSet<>();
            if (!reachable(w1, w2, graph, visited)) return false;
        }

        return true;
    }

    private boolean reachable(String from, String to, Map<String, Set<String>> graph, Set<String> visited) {
        if (from.equals(to)) return true;

        if (!graph.containsKey(from)) return false;

        visited.add(from);
        Set<String> neighbours = graph.get(from);
        for (String next : neighbours) {
            if (!visited.contains(next)) {
                if (reachable(next, to, graph, visited)) return true;
            }
        }

        visited.remove(from);
        return false;
    }


    /*
     *
     * Approach2: UnionFind
     *
     *
     * Time Complexity: O(NlogP+P), where N is the maximum length of words1 and words2, and P is the length of pairs.
     * If we used union-by-rank, this complexity improves to O(N * α(P)+P) ≈ O(N+P), where α is the Inverse-Ackermann
     *  function.
     *
     * Space Complexity: O(P)O(P), the size of pairs.
     *
     * */
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        int count = 0;
        Map<String, Integer> idx = new HashMap<>();

        UnionFind uf = new UnionFind(pairs.size() * 2);
        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);
            if (!idx.containsKey(w1)) {
                idx.put(w1, count);
                count++;
            }
            if (!idx.containsKey(w2)) {
                idx.put(w2, count);
                count++;
            }
            uf.union(idx.get(w1), idx.get(w2));
        }

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (!w1.equals(w2)) {
                if (!idx.containsKey(w1) || !idx.containsKey(w2)
                        || uf.find(idx.get(w1)) != uf.find(idx.get(w2)))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SimilarSentence2 sol = new SimilarSentence2();

//        String[] words1 = new String[]{"great", "acting", "skills"};
//        String[] words2 = new String[]{"fine", "drama", "talent"};
//        List<List<String>> pairs = new ArrayList<>();
//        pairs.add(new ArrayList<>(Arrays.asList("great", "fine")));
//        pairs.add(new ArrayList<>(Arrays.asList("fine", "good")));
//        pairs.add(new ArrayList<>(Arrays.asList("acting", "drama")));
//        pairs.add(new ArrayList<>(Arrays.asList("skills", "talent")));
//        System.out.println(sol.areSentencesSimilarTwo(words1, words2, pairs));

        String[] words1 = new String[]{"great", "acting", "skills"};
        String[] words2 = new String[]{"fine", "painting", "talent"};
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList("great", "fine")));
        pairs.add(new ArrayList<>(Arrays.asList("drama", "acting")));
        pairs.add(new ArrayList<>(Arrays.asList("skills", "talent")));
        System.out.println(sol.areSentencesSimilarTwo(words1, words2, pairs));

    }
}
