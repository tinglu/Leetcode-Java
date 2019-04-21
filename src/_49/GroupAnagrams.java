package _49;

import java.util.*;


public class GroupAnagrams {
    //    TODO: review later
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1) return new ArrayList<>();

        Map<String, List<String>> ans = new HashMap<>();

        for (String currString : strs) {
            char[] currChars = currString.toCharArray();
            Arrays.sort(currChars);

            String key = String.valueOf(currChars);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(currString);
        }
        return new ArrayList<>(ans.values());
    }


// !!! Anagram -- needs to check not only contain same CHARACTERS but also SAME NUMBER OF EACH CHARACTER!
// XXX TIME OUT
//    public List<List<String>> groupAnagrams(String[] strs) {
//        boolean[] checked = new boolean[strs.length];
//
//        List<List<String>> result = new ArrayList<>();
//
//        List<String> tmp;
//
//        for (int i = 0; i < strs.length; i++) {
//            tmp = new ArrayList<>();
//
//            if (!checked[i]) {
//                checked[i] = true;
//
//                String currString = strs[i];
//
//                tmp.add(currString);
//
////                Set<Character> currSet = new HashSet<>();
////                for (char c : currString.toCharArray()) {
////                    currSet.add(c);
////                }
//                char[] currChars = currString.toCharArray();
//                Arrays.sort(currChars);
//                String currString2 = new String(currChars);
//
//                for (int j = i + 1; j < strs.length; j++) {
//                    if (!checked[j]) {
//                        String tmpString = strs[j];
//
//                        char[] tmpChars = tmpString.toCharArray();
//                        Arrays.sort(tmpChars);
//                        String tmpString2 = new String(tmpChars);
//
//                        if (tmpString2.equals(currString2)) {
//                            tmp.add(tmpString);
//                            checked[j] = true;
//                        }
//
////                        if (tmpString.length() == currString.length()) {
////                            Set<Character> tmpSet = new HashSet<>();
////                            for (char c : tmpString.toCharArray()) {
////                                tmpSet.add(c);
////                            }
////
////                            if (currSet.size() == tmpSet.size() && currSet.equals(tmpSet)) {
////                                tmp.add(tmpString);
////                                checked[j] = true;
////                            }
////                        }
//                    }
//                }
//
//                if (tmp.size() > 0) result.add(tmp);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();

        String[] A = {"eat", "tea", "tan", "ate", "nat", "bat"};
        sol.printResult(sol.groupAnagrams(A));

        String[] B = {"tea", "", "eat", "", "tea", ""};
        sol.printResult(sol.groupAnagrams(B));

        String[] C = {"hos", "boo", "nay", "deb", "wow", "bop", "bob"};
        sol.printResult(sol.groupAnagrams(C));
    }

    private void printResult(List<List<String>> result) {
        System.out.println("--------");
        for (List<String> sub : result) {
            for (String s : sub) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }
}
