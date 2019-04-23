package _26;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray1 {

    // Very slow
//    public int removeDuplicates(int[] nums) {
//        Set<Integer> existed = new HashSet<>();
//        int i = 0;
//        int dupsIdx = nums.length - 1;
//        while (i < dupsIdx + 1) {
//            System.out.println("i: " + i);
//            if (existed.contains(nums[i])) {
//                // scoot over the rest of the numbers 1 position closer
//                int tmp = nums[i];
//                for (int j = i; j < dupsIdx; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                nums[dupsIdx] = tmp;
//                dupsIdx -= 1;
//            } else {
//                existed.add(nums[i]);
//                i++;
//            }
//        }
//
//        System.out.println("dup: " + dupsIdx);
//        return dupsIdx + 1;
//    }

    // !!! The array is already sorted!!!
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j< nums.length; j++){
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray1 sol = new RemoveDuplicatesFromSortedArray1();

        int[] A = {1, 1, 2};
        System.out.println(sol.removeDuplicates(A));
        System.out.println(Arrays.toString(A));

        int[] B = {1, 1};
        System.out.println(sol.removeDuplicates(B));
        System.out.println(Arrays.toString(B));
    }
}
