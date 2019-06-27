package _56;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervalsNew {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        ArrayDeque<int[]> merged = new ArrayDeque<>();

        Comparator<int[]> comparator = (int[] o1, int[] o2) -> {
            return o1[0] - o2[0];
        };
        Arrays.sort(intervals, comparator);

        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (!merged.isEmpty()) {
                int[] prev = merged.peekLast();
                int[] curr = intervals[i];
//                System.out.println("prev: " + Arrays.toString(prev) + " curr: " + Arrays.toString(curr));
                if (prev[1] >= curr[0]) {
//                    merged.removeLast();
//                    merged.add(new int[]{prev[0], Math.max(prev[1], curr[1])});
                    /*
                     * remove then add new int[] is too slow!!!
                     * update the last interval in stack directly
                     * */
                    prev[1] = Math.max(prev[1], curr[1]);
                } else {
                    merged.add(curr);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervalsNew sol = new MergeIntervalsNew();

        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        int[][] result = sol.merge(intervals);
        System.out.println();
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }
    }
}
