package _80;

import java.util.Arrays;

// TODO: Review later
public class RemoveDupliatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            System.out.println("\n---- n: " + n);
            if (i < 2 || n > nums[i - 2]) {
                System.out.println("------ i: " + i);
                nums[i++] = n;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        RemoveDupliatesFromSortedArray2 sol = new RemoveDupliatesFromSortedArray2();

        int[] A = {1, 1, 1, 2, 2, 3};
        System.out.println(sol.removeDuplicates(A));
        System.out.println(Arrays.toString(A));

        int[] B = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(sol.removeDuplicates(B));
        System.out.println(Arrays.toString(B));
    }
}
