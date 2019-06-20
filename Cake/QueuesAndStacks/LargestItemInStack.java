package QueuesAndStacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.NoSuchElementException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;


/*
 * TODO: review later - good strategy by maintaining a maxes stack!
 *
 * O(1) time for push(), pop(), and getMax().
 *
 * O(m) additional space, where m is the number of operations performed on the stack.
 *
 * */
public class LargestItemInStack {

    // fill in the definitions for push(), pop(), and getMax()


    public static class MaxStack {
//        // Not O(1) time for heap!!!
//        private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
//        private Stack<Integer> stack = new Stack<>();
//
//        public void push(int item) {
//            stack.push(item);
//            queue.add(item);
//        }
//
//        public int pop() {
//            if (stack.isEmpty()) throw new NoSuchElementException("empty stack");
//            int pop = stack.pop();
//            queue.remove(pop);
//            return pop;
//        }
//
//        public int getMax() {
//            if (queue.isEmpty()) throw new NoSuchElementException("empty stack");
//            return queue.peek();
//        }

        // O(1) time if using map to store max values!!!
        private Stack<Integer> maxes = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        public void push(int item) {
            stack.push(item);
            if (maxes.isEmpty() || item >= maxes.peek()) { // !!! >= is important!!!
                maxes.add(item);
            }
        }

        public int pop() {
            if (stack.isEmpty()) throw new NoSuchElementException("empty stack");
            int pop = stack.pop();
            if (maxes.peek() == pop) {
                maxes.pop();
            }
            return pop;
        }

        public int getMax() {
            if (maxes.isEmpty()) throw new NoSuchElementException("empty stack");
            return maxes.peek();
        }
    }


    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LargestItemInStack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}