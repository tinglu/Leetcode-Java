package _347;

import java.util.*;

class Solution {
    private class IntegerCount {
        private int id;
        private int count;

        public IntegerCount(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }


    Comparator<IntegerCount> countComparator = new Comparator<IntegerCount>() {
        @Override
        public int compare(IntegerCount o1, IntegerCount o2) {
            return (int) (o2.count - o1.count);
        }
    };


    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int n : nums) {
            if (!counts.containsKey(n)) counts.put(n, 0);
            counts.put(n, counts.get(n) + 1);
        }
        System.out.println(counts);

        List<Integer> topK = new ArrayList<>();

//        build max heap
        PriorityQueue<IntegerCount> pQueue = new PriorityQueue<IntegerCount>(countComparator);
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            IntegerCount ic = new IntegerCount(entry.getKey(), entry.getValue());
            pQueue.add(ic);
        }

        while (k > 0) {
            topK.add(pQueue.poll().id);
            k--;
        }
        return topK;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(solution.topKFrequent(nums, 2));
    }
}