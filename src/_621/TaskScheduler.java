package _621;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A'] += 1;
        }

        Queue<Integer> heap = new PriorityQueue<>((Integer o1, Integer o2) -> o2 - o1);

        for (int count : counts) {
            if (count > 0) { // don't care about the task name - only care about its count
                heap.add(count);
            }
        }

//        Iterator<Integer> iterator = heap.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        int total = 0;

        while (!heap.isEmpty()) {

            int i = 0;
            List<Integer> tmp = new LinkedList<>();
            while (i <= n) {
                if (!heap.isEmpty()) {
                    if (heap.peek() > 1) {
                        tmp.add(heap.poll() - 1);
                    } else {
                        heap.poll();
                    }
                }
                total += 1;
                if (heap.isEmpty() && tmp.size() == 0) break;
                i++;
            }
            heap.addAll(tmp);
        }

        return total;
    }

    public static void main(String[] args) {
        TaskScheduler sol = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(sol.leastInterval(tasks, 2));
    }
}
