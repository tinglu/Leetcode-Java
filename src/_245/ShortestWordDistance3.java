package _245;

public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int w1 = words.length;
        int w2 = -words.length; // TODO: review here - negative w2 makes the first Math.abs(w1 - w2) very large!

        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    w2 = w1;
                }
                w1 = i;
            } else if (words[i].equals(word2)) {
                w2 = i;
            }
            min = Math.min(min, Math.abs(w1 - w2));
        }

        return min;
    }

    public static void main(String[] args) {
        ShortestWordDistance3 obj = new ShortestWordDistance3();
        System.out.println(obj.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));
        System.out.println(obj.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "makes"));
    }
}
