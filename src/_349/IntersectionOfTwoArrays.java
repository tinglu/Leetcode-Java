package _349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        int[] arr = new int[result.size()];
        Iterator iter = result.iterator();
        int i = 0;
        while (iter.hasNext()) {
            arr[i] = (int) iter.next();
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 2};
        System.out.println(Arrays.toString(sol.intersection(A, B)));
    }
}
