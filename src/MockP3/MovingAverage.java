package MockP3;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> bucket;
    int size;
    int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        bucket = new ArrayDeque<>();
    }

    public double next(int val) {
        if (this.size < 1) throw new IllegalArgumentException("Illegal size");

        if (bucket.size() < this.size) {
            bucket.add(val);
            sum += val;
            return (double) sum / bucket.size();
        } else {
            int first = bucket.poll();
            sum -= first;
            bucket.add(val);
            sum += val;
            return (double) sum / this.size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */