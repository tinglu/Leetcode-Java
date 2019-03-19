package _334;

class Solution {
//    Doesn't work properly
//    public boolean increasingTriplet(int[] nums) {
//        if (nums.length < 3) return false;
//        int min = nums[0], max = nums[nums.length - 1];
//        int i = 1, j = nums.length - 2;
//        while (i <= j) {
//            if (nums[i] > min && nums[i] < max || nums[j] > min && nums[j] < max) return true;
//            if (nums[i] < min) {
//                min = nums[i];
//                if (nums[j] > min && nums[j] < max) return true;
//            }
//            if (nums[j] > max) {
//                max = nums[j];
//                if (nums[i] > min && nums[i] < max) return true;
//            }
//            if (nums[i] < nums[j] && nums[i] <= min) {
//                i++;
//
//            } else if (nums[i] >= nums[j] && nums[j] >= max) {
//                j--;
//            }
//        }
//        return false;
//    }

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        }

        return false;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

//        int[] nums = {2, 1, 5, 0, 4, 6};
//        int[] nums = {2, 4, -2, -3};
//        int[] nums = {5, 1, 5, 5, 2, 5, 4};
//        int[] nums = {5, 1, 5, 5, 2};
//        int[] nums = {1, 1, 1, 1, 1, 1};
//        int[] nums = {0, -2, -3, -1, 0};
//        int[] nums = {};
//        int[] nums = {1, 2, 3, 1, 2, 1};
        int[] nums = {1, 2, -10, -8, -7};
        System.out.println(solution.increasingTriplet(nums));
    }
}