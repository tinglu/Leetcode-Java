package MockS3;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * TODO: review later
 *
 * 809. Expressive Words
 * https://leetcode.com/problems/expressive-words/
 *
 * */
public class ExpressiveWords {

    /*
     *
     * Wrong!
     *
     * */
    public int expressiveWords1(String S, String[] words) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = letterCounts.getOrDefault(c, 0);
            letterCounts.put(c, count + 1);
        }
        System.out.println(letterCounts);

        int result = words.length;

        for (String word : words) {
            System.out.println();
            System.out.println(word);
//            System.out.println(letterCounts);
            Map<Character, Integer> counts = new HashMap<>(letterCounts);

            boolean valid = true;

            for (char c : word.toCharArray()) {
                if (!counts.containsKey(c) || counts.get(c) < 1) { // word has new character or has more number of char
//                    System.out.println("xx " + word);
                    result -= 1;
                    valid = false;
                    break;
                } else {
                    counts.put(c, counts.get(c) - 1);
                }
            }

            if (valid) {
                for (Map.Entry<Character, Integer> count : counts.entrySet()) {
                    if (count.getValue() == 1 && letterCounts.get(count.getKey()) < 3) {
//                        System.out.println("-- " + word);
                        result -= 1;
                    }
                }
            }

            System.out.println(counts);
        }
        return result < 0 ? 0 : result;
    }


    /*
     *
     * 2 POINTER!
     *
     * */
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (stretchy(S, word)) ans += 1;
        }
        return ans;
    }

    private boolean stretchy(String S, String word) {
        int lenS = S.length();
        int lenW = word.length();

        int j = 0;

        for (int i = 0; i < lenS; i++) {
            if (j < lenW && word.charAt(j) == S.charAt(i)) j++;
                // last occurrence or in the middle
            else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2)
                    || i > 0 && i < lenS - 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i + 1)) ;
            else
                return false;
        }
        return j == lenW;
    }

    public static void main(String[] args) {
        ExpressiveWords sol = new ExpressiveWords();

//        System.out.println(sol.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(sol.expressiveWords(
                "vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy",
                new String[]{"vvpeezttkkuggbbfywwbbccddkkspdpzhbbmmyy", "vvppeeztkkugbfywwbccddkksspdppzhhbmyy",
                        "vppezzttkkugbffyywbccddksspddpzhhbmy", "vvppezztkugbffyywwbbccddkssppddpzzhhbbmmy",
                        "vvppezttkuggbfyywwbbcddkspdppzhhbmy", "vppeezzttkkuugbfyywwbbccdkkssppdpzzhbbmy",
                        "vpeezztkkugbbffyywwbbccddkksppdpzzhhbbmmy", "vppeeztkkuuggbffywbbccddkksppdppzhhbmyy",
                        "vpeeztkkuggbfyywbbccdksppdpzhbmy", "vpeezztkkugbffywwbbccdkkssppddppzzhhbbmmy",
                        "vvpeztkkugbbfyywbcdkssppddpzzhhbbmyy", "vpezztkugbbffyywwbcddksppddpzzhbbmy",
                        "vvpeezztkkugbbffywwbccdkkspddpzzhbmmyy", "vvpeezzttkkuuggbbffyywbbccdkspdppzhhbmy",
                        "vvppeezztkkuggbbfywbcdkspdpzhhbmyy", "vvppeezzttkkuugbffyywwbbccddkkspddpzzhbmyy",
                        "vppezztkuuggbffywwbcdksspdppzhhbmyy", "vvppeezzttkuuggbffywbccddkksspddppzzhhbmmy",
                        "vvppezzttkuggbffywbbccdkspddppzzhhbmy", "vvpezzttkuugbbfywwbccdkssppdpzhbbmmy",
                        "vvpeezzttkuugbbffyywbccdksppddppzhhbmyy", "vpeezzttkkuggbbffywbccddksppddpzhhbbmy",
                        "vvpezttkuuggbffywwbbccddkspdppzhhbmmyy", "vppeezzttkkuugbffywbccddksppddpzhhbmmyy",
                        "vvpezttkkuugbbfywbccdkspddppzzhbbmmy", "vppezzttkkuugbbffywwbcddkssppddpzhhbmmy",
                        "vppezzttkugbfywbbcdksppddppzzhhbmyy", "vppeeztkuggbbffywbbccdkkspddppzzhbbmmy",
                        "vvpeeztkuuggbbfywbcdkksspddppzhhbbmmyy", "vpezttkkuuggbbffyywwbbcdksspddppzhhbmy",
                        "vpeezzttkkuuggbffywwbccdkksspddppzzhbmyy", "vpezttkkuugbffyywbccdksspddppzhbbmmyy",
                        "vvppezztkugbbffyywbbccdkksppdppzhbmyy", "vvpeezttkuggbbfyywwbbcddkksppdpzzhbbmyy",
                        "vvpeztkuuggbffyywbbccdkksspddppzzhbbmy", "vppeezzttkugbbffyywbccddksppdppzzhbmmyy",
                        "vppeezttkkuugbbfywwbccddkksspdpzhhbmmy", "vpeezzttkugbbffywbbccdkksspddppzhbbmyy",
                        "vpeezttkkuugbbfywbbccddksppddppzzhhbmmy", "vpeezztkuuggbbffywwbbccddksspddpzzhhbbmmyy",
                        "vppeezttkkuggbbffyywwbccdksspdpzzhbmy", "vpezzttkkuugbbfyywbbcdksspdppzzhbbmyy",
                        "vvppezttkkuggbbfyywbbccdkksspddpzhbbmyy", "vvpezzttkuggbbffyywbbcdkksppdpzzhbmmyy",
                        "vvpeztkugbfywwbccddkkspddpzhhbbmyy", "vvppezttkuugbbfyywwbcddkksspdppzhhbbmy",
                        "vvpeeztkkuuggbbfywwbcdkspddpzzhhbmmy", "vvpeezttkugbffywbbccdkkssppddppzhhbbmyy",
                        "vpeztkuuggbbfyywwbcddksppddpzhbbmy", "vppeztkuggbbfyywbcdksspdppzzhhbmy",
                        "vppeezttkkugbbffyywbccddkksppdpzhhbmy", "vvppeeztkugbfyywbcdkksppdppzhbmyy",
                        "vpezttkuugbbffywbcdksppddpzzhhbbmmy", "vppezzttkuugbfyywbcddkksspdpzhbbmmy",
                        "vppezzttkkuggbffywbbcdksspdpzzhhbbmmyy", "vpezzttkuggbfyywbbccdksspdpzhhbbmmy",
                        "vvppezttkkugbffyywbcdkssppdpzzhbmy", "vvpeezttkkuuggbbfyywbbccdkspdppzhhbmy",
                        "vpeezttkkuugbfywbccddkksppddpzzhhbmmy", "vvppezttkuuggbbffywbbccdkksppdpzzhhbbmmy",
                        "vvppeeztkuggbbffyywbccdksspddppzzhbmmyy", "vvppeezztkuggbfywwbccddkkspddpzhbbmy",
                        "vpezttkuuggbfyywwbcdkkspdpzhhbbmmyy", "vppezzttkuggbffywbbcdkkssppddppzhhbmyy",
                        "vppeztkuuggbffyywbccdkkspdppzzhhbmmyy", "vppeezztkuuggbfywbccddkksspddppzhhbbmyy",
                        "vvppeztkuugbfywwbccdkkspddppzzhhbmmy", "vvpezztkuugbbffyywwbbccddksppdpzhbbmmyy",
                        "vvpezzttkkuuggbffyywwbbcdkspdpzhbmmyy", "vvppeztkkuuggbbfyywbbccdksppdppzzhbmmyy",
                        "vvppezztkuggbffyywwbcddkkssppdpzhbmmyy", "vvpezzttkkuggbbffywwbcddkksspdpzzhhbbmmy",
                        "vpezztkkuuggbfyywwbccddkssppdppzhhbbmmy", "vvppezztkuugbffywwbccdkkspdppzhhbmmy",
                        "vpeztkugbfyywwbcdkksspdppzzhbmmy", "vvpeezzttkkugbbfywwbcdkkspdpzzhhbmmy",
                        "vpezzttkuuggbbfywbccdkspddppzzhhbbmmy", "vppeztkkuugbffyywwbbcddksspddppzhbbmyy",
                        "vpeztkkuggbffyywbbccddkssppdppzhbmyy", "vvppeezztkuggbffyywwbcddkksppdppzhbmyy",
                        "vpeezztkugbfyywbbccdkkspdppzhbmmyy", "vvppeezttkugbfywwbcddkkssppdppzhbmmyy",
                        "vpeeztkuggbffywwbbccddksspdppzzhhbmmy", "vvppeeztkuugbfywbcddkssppddppzzhhbbmyy",
                        "vpezzttkuggbbffyywwbbccdkssppddppzhbbmy", "vpezttkugbfywbbcddkksspddppzhbbmy",
                        "vpeezzttkkuggbbffyywwbccddkspddppzhbmyy", "vppeezzttkugbffywbccdkkspddpzhhbbmyy",
                        "vpezzttkuggbbfyywbbccdkksspddpzzhhbmmy", "vvppezttkugbfywwbbcdkksspddpzzhhbbmyy",
                        "vppezztkkuggbffyywbcddkkssppddpzzhhbbmmy", "vppeztkkuggbfywwbccdkksppdppzhhbmmy",
                        "vvpeezzttkugbffyywwbbcddkssppddpzzhbmmy", "vvpezztkkuuggbfyywbccdkksspddpzhhbbmyy",
                        "vpezttkuuggbffywbbccdksppdpzhbmmyy", "vvpezzttkuggbbfywbccddksspdpzzhhbmmy",
                        "vvpeezzttkkugbbfywwbcdkksppddpzhbmy", "vppeezttkkuugbbfyywwbcddkkspdpzhhbbmmyy",
                        "vvppeeztkkuugbbfyywwbbcddkksspdppzhbbmyy", "vvpeezzttkkuugbfywwbbcddkspdpzzhbbmyy"}));
//        System.out.println(sol.expressiveWords("vvkkkejjjjjj", new String[]{"vkeej", "vvkejj"}));
    }
}
