package _350;

import java.util.*;

public class IntersectionOfTwoArrays2 {
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map1 = new HashMap<>();
//        for (int num : nums1) {
//            int count = map1.getOrDefault(num, 0);
//            map1.put(num, count + 1);
//        }
//
//        Map<Integer, Integer> map2 = new HashMap<>();
//        for (int num : nums2) {
//            int count = map2.getOrDefault(num, 0);
//            map2.put(num, count + 1);
//        }
//
//        List<Integer> result = map1.size() < map2.size() ? helper(map1, map2) : helper(map2, map1);
//        int[] arr = new int[result.size()];
//        int i = 0;
//        for (int num : result) {
//            arr[i] = num;
//            i++;
//        }
//        return arr;
//    }
//
//    private List<Integer> helper(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
//        List<Integer> result = new LinkedList<>();
//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            int key = entry.getKey();
//            int count = Math.min(entry.getValue(), map2.getOrDefault(key, 0));
//            while (count > 0) {
//                result.add(key);
//                count--;
//            }
//        }
//        return result;
//    }


    // Slightly better solution learned from discussion forum
    // Fewer loops
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            int count = map1.getOrDefault(num, 0);
            map1.put(num, count + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) { // !!! map1.get(num) > 0 check is very important
                result.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            arr[i] = num;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays2 sol = new IntersectionOfTwoArrays2();
        int[] A = {4, 9, 5};
        int[] B = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(sol.intersect(A, B)));
    }
}
