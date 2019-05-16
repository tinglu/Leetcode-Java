//package _76;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class MinimumWindowSubstring {
//    public String minWindow(String s, String t) {
//        Map<Character, Integer> targets = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            int count = targets.getOrDefault(c, 0);
//            targets.put(c, count + 1);
//        }
//        int N = targets.size();
//        Set<Character> group = new HashSet<>();
//        for (char curr : s.toCharArray()) {
//            if (group.size() ==)
//
//                if (targets.contains(curr)) {
//                    group.add(curr);
//                }
//        }
//    }
//}
