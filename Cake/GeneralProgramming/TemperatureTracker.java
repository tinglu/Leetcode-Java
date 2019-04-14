package GeneralProgramming;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemperatureTracker {

    static class TempTracker {

        // fill in the TempTracker class methods below

        // !!! O(1) time for each method, and O(1)O(1) space related to input!

        // For mean
        int count = 0;
        int total = 0;
        double mean;

        // For min/max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // For mode
        int[] temperatureOccurrances = new int[111]; // 0-110
        int mode = -1;
        int maxOccurrance = 0;

        // records a new temperature
        public void insert(int temperature) {
            total += temperature;
            count +=1;
            mean = (double) total / count;

            min = Math.min(temperature, min);
            max = Math.max(temperature, max);

            temperatureOccurrances[temperature] += 1;
            if (temperatureOccurrances[temperature] > maxOccurrance) {
                maxOccurrance = temperatureOccurrances[temperature];
                mode = temperature;
            }
        }

        // returns the highest temp we've seen so far
        public int getMax() {
            return max;
        }

        // returns the lowest temp we've seen so far
        public int getMin() {
            return min;
        }

        // returns the mean of all temps we've seen so far
        public double getMean() {
            return mean;
        }

        // return a mode of all temps we've seen so far
        public int getMode() {
            return mode;
        }
    }


    // tests

    @Test
    public void temperatureTrackerTest() {
        final double precision = 1e-6;

        final TempTracker t = new TempTracker();

        t.insert(50);
        assertEquals("step 1: max:", 50, t.getMax());
        assertEquals("step 1: min:", 50, t.getMin());
        assertEquals("step 1: mean:", 50.0, t.getMean(), precision);
        assertEquals("step 3: mode:", 50, t.getMode());

        t.insert(80);
        assertEquals("step 2: max:", 80, t.getMax());
        assertEquals("step 2: min:", 50, t.getMin());
        assertEquals("step 2: mean:", 65.0, t.getMean(), precision);
        assertTrue("step 2: mode:", t.getMode() == 50 || t.getMode() == 80);

        t.insert(80);
        assertEquals("step 3: max:", 80, t.getMax());
        assertEquals("step 3: min:", 50, t.getMin());
        assertEquals("step 3: mean:", 70.0, t.getMean(), precision);
        assertEquals("step 3: mode:", 80, t.getMode());

        t.insert(30);
        assertEquals("step 4: max:", 80, t.getMax());
        assertEquals("step 4: min:", 30, t.getMin());
        assertEquals("step 4: mean:", 60.0, t.getMean(), precision);
        assertEquals("step 4: mode:", 80, t.getMode());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TemperatureTracker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}