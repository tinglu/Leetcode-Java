package _616;

import java.util.*;

public class AddBoldClassInStringNew {
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                intervals.add(new Interval(index, index + str.length()));
                System.out.println("\nindex: " + index);
                index += 1;
                index = s.indexOf(str, index); // Keep looking for same word in the source string !!!
                System.out.println("index: " + index);
            }
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            prev = interval.end;
        }
        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }
        return sb.toString();
    }

    class Interval {
        int start, end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        AddBoldClassInStringNew sol = new AddBoldClassInStringNew();

        String[] dict = {"abc", "123"};
        System.out.println(sol.addBoldTag("abcxyz123", dict));


    }
}
