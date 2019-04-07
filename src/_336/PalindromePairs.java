package _336;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> tmp;
        String s1, s2;
        String str;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                tmp = new ArrayList<>();

                s1 = words[i];
                s2 = words[j];

                str = s1 + s2;
//                System.out.println(isPalindrome(str.toCharArray()));
                if (isPalindrome(str.toCharArray()) && i != j) {
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }

                tmp = new ArrayList<>();
                str = s2 + s1;
//                System.out.println(isPalindrome(str.toCharArray()));
                if (isPalindrome(str.toCharArray()) && i != j) {
                    tmp.add(j);
                    tmp.add(i);
                    result.add(tmp);
                }


            }
        }
        List<List<Integer>> resultList = new ArrayList<>();

        for (List<Integer> list : result) {
            resultList.add(list);
        }
        return resultList;
    }

    private boolean isSameCharacters(String s1, String s2) {
        Set<Character> set1 = stringToSet(s1);
        Set<Character> set2 = stringToSet(s2);
        return set1.equals(set2) && set1.size() == 1;
    }

    private Set<Character> stringToSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private boolean isPalindrome(char[] chars) {
//        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs sol = new PalindromePairs();
        String[] A = {"abcd", "dcba", "lls", "s", "sssll"};
//        String[] A = {"a", "b", "c", "ab", "ac", "aa"};
        List<List<Integer>> result = sol.palindromePairs(A);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            for (int n : list) {
                System.out.print(n + ",");
            }
            System.out.println("");
        }
    }
}
