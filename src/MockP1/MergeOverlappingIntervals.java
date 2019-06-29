package MockP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 56. Merge Intervals
public class MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Arrays.sort(intervals, comparator);

        List<int[]> intervalList = new ArrayList<>();
        int from = intervals[0][0];
        int to = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] item = intervals[i];
            if (item[0] > to) {
                int[] tmp = {from, to};
                intervalList.add(tmp);
                from = item[0];
            }
            to = item[1] > to ? item[1] : to;
        }
        // add the last interval chunk
        int[] tmp = {from, to};
        intervalList.add(tmp);

        int[][] result = new int[intervalList.size()][];
        for (int i = 0; i < intervalList.size(); i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
