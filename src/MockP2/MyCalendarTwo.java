package MockP2;

// NOT QUITE RIGHT...
//public class MyCalendarTwo {
//    Map<Integer, Integer> count;
//
//    public MyCalendarTwo() {
//        count = new HashMap<>();
//    }
//
//    public boolean book(int start, int end) {
//        for (int i = start; i < end; i++) {
//            int cnt = count.getOrDefault(i, 0);
//            if (cnt == 2) return false;
//            count.put(i, cnt + 1);
//        }
//        return true;
//    }
//
////    ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
////    [[],[26,35],[26,32],[25,32],[18,26],[40,45],[19,26],[48,50],[1,6],[46,50],[11,18]]
////    [null,true,true,false,true,true,false,true,true,true,true]
////    [null,true,true,false,true,true,true,true,true,true,true]
//}


import java.util.ArrayList;
import java.util.List;

// TODO: Review Later

// 731. My Calendar II
// Time Complexity: O(N^2), where NN is the number of events booked. For each new event, we process every previous
//  event to decide whether the new event can be booked.
// Space Complexity: O(N), the size of the calendar.
class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarTwo() {
        calendar = new ArrayList();
        overlaps = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv : overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv : calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
