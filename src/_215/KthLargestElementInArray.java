package _215;

import java.util.*;

/*
* - Heap: O(Nlogk) time complexity
* - QuickSelect: O(N) time complexity & O(N^2) in the worst case
*
* TODO: Implement QuickSelect in future
* */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//        for (int i : nums) {
//            set.add(i);
//        }

        Comparator<Integer> comparator = (Integer o1, Integer o2) -> o2 - o1;

        PriorityQueue<Integer> heap = new PriorityQueue<>(comparator);
        for (int i : nums) {
            heap.add(i);
        }


//        System.out.println(heap);

//        while (!heap.isEmpty()) {
//            System.out.println(heap.poll());
//        }

        int result = Integer.MIN_VALUE;
        while (k > 0 && heap.peek() != null) {
//            System.out.println("k: " + k);
            result = heap.poll();
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        KthLargestElementInArray sol = new KthLargestElementInArray();
        int[] A = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(sol.findKthLargest(A, 4));
        int[] B = {3, 2, 1, 5, 6, 4};
        System.out.println(sol.findKthLargest(B, 2));
    }
}
