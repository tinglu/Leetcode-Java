package _253;

import java.util.*;

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

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {

        Comparator<Interval> roomComparator = (Interval o1, Interval o2) -> {
            return o1.end - o2.end;
        };
        Queue<Interval> rooms = new PriorityQueue<>(roomComparator);

        Comparator<Interval> meetingComparator = (Interval o1, Interval o2) -> {
            return o1.start - o2.start;
        };
        Arrays.sort(intervals, meetingComparator);

        for (Interval interval : intervals) {
            if (rooms.isEmpty() || rooms.peek().end > interval.start) {
                rooms.add(interval);
            } else {
                rooms.poll();
                rooms.add(interval);
            }
        }

        return rooms.size();
    }

//    private boolean overlapped(Interval i1, Interval i2) {
//        return Math.min(i1.end, i2.end) > Math.max(i1.start, i2.start);
//    }
}
