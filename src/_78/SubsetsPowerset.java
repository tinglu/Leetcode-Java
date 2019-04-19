package _78;

import java.util.ArrayList;
import java.util.List;

public class SubsetsPowerset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) return result;

        List<Integer> first = new ArrayList<>();
        result.add(first);

        List<List<Integer>> newResult = new ArrayList<>(result);

        for (int num : nums) {
            for (List<Integer> sublist : result) {
                List<Integer> tmp = new ArrayList<>(sublist);
                sublist.add(num);
                newResult.add(tmp);
            }
            result = new ArrayList<>(newResult);
        }
        return result;
    }

//    public List<List<Integer>> helper(int num, List<List<Integer>> result) {
//        for (List<Integer> sublist : result) {
//            List<Integer> tmp = new ArrayList<>(sublist);
//            sublist.add(num);
//            result.add(tmp);
//        }
//
//        return result;
//    }

//    public void helper(int[] nums, List<List<Integer>> result) {
//        if (nums.length < 1) return;
//
//        for (List<Integer> sublist : result) {
//            sublist.add(nums[0]);
//        }
//        helper(nums);
//    }


    public static void main(String[] args) {
        SubsetsPowerset sol = new SubsetsPowerset();

        int[] A = {1, 2, 3};
        List<List<Integer>> result = sol.subsets(A);
        for (List<Integer> sublist : result) {
            for (int i : sublist) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
