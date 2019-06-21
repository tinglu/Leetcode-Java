package Mock7;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
 *
 * TODO: review later - priority queue is used for negative quality
 * - keep updating the amount of quality to be paid (the lower the better)
 *
 * 857. Minimum Cost to Hire K Workers
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 *
 * */
public class MinWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = wage.length;

        if (N < K) return -1;

        Worker[] workers = new Worker[N];

        for (int i = 0; i < N; i++) {
            Worker worker = new Worker(quality[i], wage[i]);
            workers[i] = worker;
        }
        Arrays.sort(workers);

        double result = Double.MAX_VALUE;

        /*
         * MinHeap with negative quality - so a MaxHeap indeed!!!
         * */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        /*
         * keep updating the amount of quality to be paid (the lower the better)
         * */
        int totalQualityToPay = 0;

        for (Worker worker : workers) {
            pq.offer(-worker.quality);

            totalQualityToPay += worker.quality;

            /*
             * pq.poll() gets the largest quality added so far;
             * because it's negative - so whenever the size > K, the just added quality is subtracted from
             * totalQualityToPay
             * */
            if (pq.size() > K) {
                totalQualityToPay += pq.poll();
            }
            if (pq.size() == K) {
                result = Math.min(result, totalQualityToPay * worker.wagePerQuality); // keep updating
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinWorkers sol = new MinWorkers();

        System.out.println(sol.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
    }
}

class Worker implements Comparable<Worker> {
    double wagePerQuality;
    int quality;

    public Worker(int quality, int wage) {
        wagePerQuality = wage * 1.0 / quality;
        this.quality = quality;
    }

    public int compareTo(Worker w2) {
        return Double.compare(this.wagePerQuality, w2.wagePerQuality);
    }
}
