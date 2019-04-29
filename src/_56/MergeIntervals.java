package _56;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };

        intervals.sort(comparator);

        List<Interval> intervalList = new ArrayList<>();
        int from = intervals.get(0).start;
        int to = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (item.start > to) {
                Interval tmp = new Interval(from, to);
                intervalList.add(tmp);
                from = item.start;
            }
            to = item.end > to ? item.end : to;
        }
        // add the last interval chunk
        Interval tmp = new Interval(from, to);
        intervalList.add(tmp);
        return intervalList;
    }
}
