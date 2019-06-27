package _243;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) xs.add(i);
            if (words[i].equals(word2)) ys.add(i);
        }
        int min = Integer.MAX_VALUE;
        for (int x : xs) {
            for (int y : ys) {
                min = Math.min(Math.abs(x - y), min);
            }
        }
        return min;
    }
}
