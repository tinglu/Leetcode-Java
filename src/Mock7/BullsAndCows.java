package Mock7;

import java.util.HashMap;
import java.util.Map;


/*
 *
 * TODO: review later - just need 1 pass
 *
 * 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * */
public class BullsAndCows {

    /*
     *
     * My original answer - correct but not fast enough
     *
     * */
    public String getHint1(String secret, String guess) {
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
            }
        }
//        System.out.println(secretMap);
//        System.out.println(guessMap);
        for (Map.Entry<Character, Integer> kv : guessMap.entrySet()) {
            cows += Math.min(kv.getValue(), secretMap.getOrDefault(kv.getKey(), 0));
        }
        return bulls + "A" + cows + "B";
    }


    /*
     *
     * 1 Pass!
     *
     * */
    public String getHint(String secret, String guess) {
        int[] counts = new int[10]; // we are dealing with digits 0 to 9 so length is 10

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {

                if (counts[s - '0'] < 0) cows++; // guess has more characters than secret
                if (counts[g - '0'] > 0) cows++; // guess found same character from secret

                counts[s - '0']++;
                counts[g - '0']--; // pairs of secret - guess 抵消
            }
        }

        return bulls + "A" + cows + "B";
    }


    public static void main(String[] args) {
        BullsAndCows sol = new BullsAndCows();
        System.out.println(sol.getHint("1807", "7810"));
        System.out.println(sol.getHint("1123", "0111"));
    }
}
