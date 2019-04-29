package _729;

// (1) Brute Force - Time O(N^2), Space O(N)
//public class MyCalendar {
//    List<int[]> calendars;
//
//    public MyCalendar() {
//        calendars = new ArrayList<>();
//    }
//
//    public boolean book(int start, int end) {
//        for (int[] cal : calendars) {
//            if (cal[0] < end && start < cal[1]) {
//                return false;
//            }
//        }
//        calendars.add(new int[]{start, end});
//        return true;
//    }
//}

import java.util.TreeMap;

// (1) Balanced Tree (using Java TreeMap)
// - Time O(N * log N), where NN is the number of events booked. For each new event, we search that the event is
//      legal in O(\log N)O(logN) time, then insert it in O(1)O(1) time
// - Space O(N)
public class MyCalendar {
    TreeMap<Integer, Integer> calendars;

    public MyCalendar() {
        calendars = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendars.floorKey(start);

        Integer next = calendars.ceilingKey(start);
        if ((prev == null || calendars.get(prev) <= start)
                && (next == null || end <= next)) { // NOT end <= calendars.get(next)!!!!
            calendars.put(start, end);
            return true;
        }
        return false;
    }
}