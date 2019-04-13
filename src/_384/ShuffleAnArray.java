package _384;

import java.util.Arrays;
import java.util.Random;

// Brute force
//class ReverseStringInPlace {
//    private int[] array;
//    private int[] orgNums;
//    private Random random = new Random();
//
//
//    public ReverseStringInPlace(int[] nums) {
//        array = nums;
//        orgNums = array.clone();
//    }
//
//    /**
//     * Resets the array to its original configuration and return it.
//     */
//    public int[] reset() {
//        array = orgNums;
//        orgNums = orgNums.clone();
//        return array;
//    }
//
//    /**
//     * Returns a random shuffling of the array.
//     */
//    public int[] shuffle() {
//        List<Integer> aux = getArrayCopy(array);
//        for (int i = 0; i < array.length; i++) {
//            int j = random.nextInt(aux.size());
//            array[i] = aux.get(j);
//            aux.remove(j);
//        }
//        return array;
//    }
//
//    private List<Integer> getArrayCopy(int[] nums){
//        List<Integer> asList = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++){
//            asList.add(nums[i]);
//        }
//        return asList;
//    }
//
//    public static void main(String args[]) {
//        int[] nums = {1,2,3};
//        ReverseStringInPlace obj = new ReverseStringInPlace(nums);
//        int[] param_1 = obj.reset();
//        int[] param_2 = obj.shuffle();
//        System.out.println(Arrays.toString(param_1));
//        System.out.println(Arrays.toString(obj.shuffle()));
//        System.out.println(Arrays.toString(obj.shuffle()));
//        System.out.println(Arrays.toString(obj.shuffle()));
//    }
//}

// TODO: Fisher-Yates Algorithm ????
class ShuffleAnArray {
    private int[] array;
    private int[] orgNums;
    private Random random = new Random();


    public ShuffleAnArray(int[] nums) {
        array = nums;
        orgNums = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = orgNums;
        orgNums = orgNums.clone();
        return orgNums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public void swapAt(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String args[]) {
        int[] nums = {1,2,3};
        ShuffleAnArray obj = new ShuffleAnArray(nums);
        int[] param_1 = obj.reset();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}


// Wrong: not equally chosen
//
//class ReverseStringInPlace {
//    int[] orgNums;
//    Random random;
//
//
//    public ReverseStringInPlace(int[] nums) {
//        orgNums = nums;
//        random = new Random();
//    }
//
//    /**
//     * Resets the array to its original configuration and return it.
//     */
//    public int[] reset() {
//        return orgNums;
//    }
//
//    /**
//     * Returns a random shuffling of the array.
//     */
//    public int[] shuffle() {
//        int[] nums = orgNums;
//        for (int i = 0; i < nums.length; i++) {
//            int j = random.nextInt(nums.length);
//            swap(nums, i, j);
//        }
//        return nums;
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//
//
//    public static void main(String args[]) {
//        int[] nums = {1,2,3};
//        ReverseStringInPlace obj = new ReverseStringInPlace(nums);
//        int[] param_1 = obj.reset();
//        int[] param_2 = obj.shuffle();
//        System.out.println(Arrays.toString(param_1));
//        System.out.println(Arrays.toString(param_2));
//    }
//}

