package ProblemSet._681;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        String[] components = time.split(":");

        int orgHour = Integer.parseInt(components[0]);
        int orgMinute = Integer.parseInt(components[1]);
        int orgTime = timeInMinutes(orgHour, orgMinute);

        Set<Integer> digits = new HashSet<>();
        digits.add(Integer.parseInt(components[0].substring(0, 1)));
        digits.add(Integer.parseInt(components[0].substring(1, 2)));
        digits.add(Integer.parseInt(components[1].substring(0, 1)));
        digits.add(Integer.parseInt(components[1].substring(1, 2)));

        if (digits.size() == 1) return time;

//        MyPrint.printSetOfInt(digits);

        List<Integer> hours = getNumber(digits, 23);
        List<Integer> minutes = getNumber(digits, 59);

//        MyPrint.printListOfInt(hours);
//        MyPrint.printListOfInt(minutes);

        int aday = 24 * 60;
        int minDiff = Integer.MAX_VALUE;
        int minHour = orgHour;
        int minMinute = orgTime;
        int tmpTime;
        int diff;
        for (int hour : hours) {
            for (int minute : minutes) {
                tmpTime = timeInMinutes(hour, minute);
                if (tmpTime < orgTime) tmpTime += aday;
                diff = tmpTime - orgTime;
                if (diff != 0 && diff < minDiff) {
                    minDiff = diff;
                    minHour = hour;
                    minMinute = minute;
                }
                System.out.println(String.format("%d:%d - %d minutes - %d diff -- %d minHour - %d minMinute - %d " +
                        "minDiff", hour, minute, tmpTime, diff, minHour, minMinute, minDiff));
            }
        }

        String hs = minHour < 10 ? "0" + minHour : String.valueOf(minHour);
        String ms = minMinute < 10 ? "0" + minMinute : String.valueOf(minMinute);
        return String.format("%s:%s", hs, ms);
    }

    private List<Integer> getNumber(Set<Integer> digits, int hi) {
        List<Integer> results = new ArrayList<>();
        int r;
        for (int i : digits) {
            for (int j : digits) {
                r = i * 10 + j;
                if (r >= 0 && r <= hi) {
                    results.add(r);
                }
            }
        }
        return results;
    }

    private int timeInMinutes(int hour, int minute) {
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        NextClosestTime sol = new NextClosestTime();
//        System.out.println(sol.nextClosestTime("19:34"));
//        System.out.println(sol.nextClosestTime("23:59"));
//        System.out.println(sol.nextClosestTime("19:34"));
//        System.out.println(sol.nextClosestTime("01:32"));
        System.out.println(sol.nextClosestTime("11:11"));
    }
}
