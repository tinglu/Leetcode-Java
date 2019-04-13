package _252;

import java.util.Arrays;
import java.util.Comparator;

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

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length < 1) return true;

        Arrays.sort(intervals, Comparator.comparingInt((Interval o) -> o.end));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }

        return true;
    }
}
