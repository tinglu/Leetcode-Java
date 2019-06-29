package MockP3;

import java.util.ArrayList;
import java.util.List;

public class MissingRangesInSortedArray {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        long next = lower;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) continue;

            if (nums[i] == next) {
                next += 1;
                continue;
            }

            long to = (long) nums[i] - 1;
            result.add(getRange(next, (long) to));

            next = (long) nums[i]+ 1;
        }

        if (next <= upper) {
            result.add(getRange(next, (long) upper));
        }

        return result;
    }

    private String getRange(long down, long up) {
        return up == down ? String.valueOf(up) : String.format("%d->%d", down, up);
    }

    public static void main(String[] args) {
        MissingRangesInSortedArray sol = new MissingRangesInSortedArray();
        int[] nums = {2147483647};
        List<String> result = sol.findMissingRanges(nums, 0, 2147483647);
        for (String s : result) {
            System.out.println(s); // ["0->2147483646"]
        }

        int[] nums1 = {-1};
        result = sol.findMissingRanges(nums1, -2, -1);
        for (String s : result) {
            System.out.println(s); // -2
        }

        int[] nums2 = {};
        result = sol.findMissingRanges(nums2, 1, 1);
        for (String s : result) {
            System.out.println(s); // 1
        }

        int[] nums3 = {-1};
        result = sol.findMissingRanges(nums3, -1, 0);
        for (String s : result) {
            System.out.println(s); // 0
        }
    }
}
