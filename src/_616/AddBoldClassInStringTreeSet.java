package _616;

import java.util.*;

public class AddBoldClassInStringTreeSet {
    class Interval implements Comparable<Interval> {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return (this.start == o.start) ? this.end - o.end : this.start - o.start;
        }
    }

    private static final String PRE = "<b>";
    private static final String POST = "</b>";


    public String addBoldTag(String s, String[] dict) {
        Set<Interval> st = new TreeSet<>();
        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                Interval temp = new Interval(index, index + str.length());
                st.add(temp);
                index += 1;
                index = s.indexOf(str, index);
            }
        }
        if (st.size() <= 0) return s;



        List<Interval> intervals = merge(st);



        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start))
                    .append(PRE)
                    .append(s.substring(interval.start, interval.end))
                    .append(POST);
            prev = interval.end;
        }
        if (prev < s.length()) sb.append(s.substring(prev));
        return sb.toString();
    }

    public List<Interval> merge(Set<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() <= 0) return res;
        if (intervals.size() == 1) {
            res.add(intervals.iterator().next());
            return res;
        }

        Iterator<Interval> iter = intervals.iterator();
        Interval front = iter.next();
        int start = front.start;
        int end = front.end;

        while (iter.hasNext()) {
            Interval i = iter.next();
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
        AddBoldClassInStringTreeSet sol = new AddBoldClassInStringTreeSet();

        String[] dict = {"abc", "123"};
        System.out.println(sol.addBoldTag("abcxyz123", dict));
    }
}
