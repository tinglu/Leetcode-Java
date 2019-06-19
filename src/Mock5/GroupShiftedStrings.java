package Mock5;

import java.util.*;

public class GroupShiftedStrings {

    /*
     *
     * Cannot use set - should keep all same strings!
     *
     * */
//    public List<List<String>> groupStrings(String[] strings) {
//        Map<Integer, Set<String>> stringByLength = new HashMap<>();
//        for (String str : strings) {
//            int len = str.length();
//            Set<String> stringInGroup = stringByLength.getOrDefault(len, new HashSet<>());
//            stringInGroup.add(str);
//            stringByLength.put(len, stringInGroup);
//        }
//
//        List<List<String>> result = new ArrayList<>();
//
//        for (Map.Entry<Integer, Set<String>> entry : stringByLength.entrySet()) {
//            Set<String> stringSameLength = entry.getValue();
//            int len = entry.getKey();
//
//            while (!stringSameLength.isEmpty()) { // loop over strings with same length (could be in diff groups)
//                List<String> subGroup = new ArrayList<>();
//                String first = stringSameLength.iterator().next();
//                subGroup.add(first);
//                stringSameLength.remove(first);
//
//                Iterator<String> iter = stringSameLength.iterator();
//
//                while (iter.hasNext()) {
//                    String curr = iter.next();
//
//                    int diff = curr.charAt(0) - first.charAt(0);
//                    diff = diff < 0 ? diff + 26 : diff;
////                    System.out.println("first: " + first + " diff: " + diff);
////                    System.out.println("curr.charAt(0): " + curr.charAt(0));
//
//                    boolean sameShift = true;
//                    for (int k = 1; k < len; k++) {
//                        int d = curr.charAt(k) - first.charAt(k);
//                        d = d < 0 ? d + 26 : d;
//                        if (d != diff) {
//                            sameShift = false;
//                            break;
//                        }
//                    }
//                    if (sameShift) {
//                        subGroup.add(curr);
////                        stringSameLength.remove(curr);
//                        iter.remove();
//                    }
//                }
//                result.add(subGroup);
//            }
//        }
//
//        return result;
//    }


    /*
     *
     * https://leetcode.com/problems/group-shifted-strings/
     * 249. Group Shifted Strings
     *
     * My solution is correct...
     *
     * TODO!!!: but redo this using diff as keys (similar to 49. Group Anagrams?)
     *
     *
     * */
    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<String>> stringByLength = new HashMap<>();
        for (String str : strings) {
            int len = str.length();
            List<String> stringInGroup = stringByLength.getOrDefault(len, new ArrayList<>());
            stringInGroup.add(str);
            stringByLength.put(len, stringInGroup);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : stringByLength.entrySet()) {
            List<String> stringSameLength = entry.getValue();
            int len = entry.getKey();

            while (!stringSameLength.isEmpty()) { // loop over strings with same length (could be in diff groups)
                List<String> subGroup = new ArrayList<>();
                String first = stringSameLength.get(0);
                subGroup.add(first);
                stringSameLength.remove(first);

                Iterator<String> iter = stringSameLength.iterator();

                while (iter.hasNext()) {
                    String curr = iter.next();

                    int diff = curr.charAt(0) - first.charAt(0);
                    diff = diff < 0 ? diff + 26 : diff;

                    boolean sameShift = true;
                    for (int k = 1; k < len; k++) {
                        int d = curr.charAt(k) - first.charAt(k);
                        d = d < 0 ? d + 26 : d;
                        if (d != diff) {
                            sameShift = false;
                            break;
                        }
                    }
                    if (sameShift) {
                        subGroup.add(curr);
                        iter.remove();
                    }
                }
                result.add(subGroup);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        GroupShiftedStrings sol = new GroupShiftedStrings();

        List<List<String>> result = sol.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        for (List<String> group : result) {
            System.out.println(Arrays.toString(group.toArray()));
        }

        result = sol.groupStrings(new String[]{"a", "a"});
        for (List<String> group : result) {
            System.out.println(Arrays.toString(group.toArray()));
        }
    }
}
