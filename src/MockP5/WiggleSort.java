package MockP5;

/*
 *
 * 280. Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort/
 *
 * TODO - review later - Just need to swap pair-wise !!!! - OR can do in One Pass swap
 *
 * */
public class WiggleSort {

    /*
     *
     * One-pass Swap
     *
     * */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]
                    || i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
//        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /*
     *
     * My original solution - TOO SLOW!
     *
     * */
    public void wiggleSort1(int[] nums) {

        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int smallest = nums[i];
            int p = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < smallest) {
                    p = j;
                    smallest = nums[j];
                }
            }
            if (p > i) {
                nums[p] = nums[i];
                nums[i] = smallest;
            }
        }

//        System.out.println(Arrays.toString(nums));

        int from = (N % 2 == 0 ? N / 2 : N / 2 + 1);
        int step = 0;

        while (from < N) {
            int toBeMoved = nums[from];
            int dest = step * 2 + 1;
            for (int i = from; i >= dest + 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[dest] = toBeMoved;
            step++;
            from++;
        }

//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        WiggleSort sol = new WiggleSort();

        sol.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
