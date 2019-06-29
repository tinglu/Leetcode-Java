package MockS5;

import java.util.TreeSet;

/*
 *
 * TODO !!! - review later - use TreeSet !!!
 *  
 * TODO !!! - can also use PriorityQueue with Intervals(leftPos, rightPos, dist) - ordered by dist then leftPos
 *  [MaxHeap]
 *
 * 855. Exam Room
 * https://leetcode.com/problems/exam-room/
 *
 * */
public class ExamRoom {
    /*
     *
     * Time Complexity: Each seat operation is O(P), (where P is the number of students sitting), as we iterate
     * through every student. Each leave operation is O(P) (logP in Java).
     *
     * Space Complexity: O(P), the space used to store the positions of each student sitting.
     *
     * */
    int size;
    TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.size = N;
        students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;

        if (students.size() > 0) { // otherwise can sit on the 1st seat

            int dist = students.first(); // the smallest pos can be chosen is the first number in treeset
            Integer prev = null;

            for (Integer curr : students) {
                if (prev != null) { // start comparison when at least two students
                    int d = (curr - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        student = prev + d;
                    }
                }
                prev = curr;
            }

            // when only 1 seat taken - consider the last seat
            if (size - 1 - students.last() > dist) {
                student = size - 1;
            }
        }

        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom obj = new ExamRoom(10);
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        obj.leave(4);
        System.out.println(obj.seat());
    }
}
