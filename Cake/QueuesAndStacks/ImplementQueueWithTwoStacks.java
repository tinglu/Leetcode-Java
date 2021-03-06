package QueuesAndStacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


/*
 *
 * TODO: review later - good strategy by only moving inStack to outStack when there's no item to pop in outStack!
 *
 *
 * Each enqueue is clearly O(1) time,
 * and so is each dequeue when outStack has items.
 *
 * Dequeue on an empty outStack is order of the number of items in inStack at that moment, which can vary significantly.
 *
 * So let's look at the worst case for a single item, which is the case where it is enqueued and then later dequeued.
 * In this case, the item enters inStack (costing 1 push), then later moves to outStack (costing 1 pop and 1 push),
 * then later comes off outStack to get returned (costing 1 pop).
 * Each of these 4 pushes and pops is O(1) time. So our total cost per item is O(1). Our m enqueue and
 * dequeue operations put m or fewer items into the system, giving a total runtime of O(m).
 *
 * */
public class ImplementQueueWithTwoStacks {

    // fill in the definitions for enqueue() and dequeue()


    public static class QueueTwoStacks {

        private Deque<Integer> inStack = new ArrayDeque<>();
        private Deque<Integer> outStack = new ArrayDeque<>();

//        public void enqueue(int item) {
//            if (outStack.isEmpty()) {
//                inStack.push(item);
//            } else {
//                while (!outStack.isEmpty()) {
//                    inStack.push(outStack.pop());
//                }
//                inStack.push(item);
//            }
//        }
//
//        public int dequeue() {
//            if (inStack.isEmpty()) {
//                if (outStack.isEmpty()) {
//                    throw new IllegalArgumentException("No item to poll");
//                }
//            }
//            while (!inStack.isEmpty()) {
//                outStack.push(inStack.pop());
//            }
//            return outStack.pop();
//        }

        // !!! Enqueue can do better - no need to put outStack back!!!
        public void enqueue(int item) {
            inStack.push(item);
        }

        public int dequeue() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }

                if (outStack.isEmpty()) {
                    throw new NoSuchElementException("No item to poll");
                }
            }

            return outStack.pop();
        }
    }


    // tests

    @Test
    public void basicQueueOperationsTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals("dequeue #1", 1, q.dequeue());
        assertEquals("dequeue #2", 2, q.dequeue());
        q.enqueue(4);
        assertEquals("dequeue #3", 3, q.dequeue());
        assertEquals("dequeue #4", 4, q.dequeue());
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromNewQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.dequeue();
    }

    @Test(expected = Exception.class)
    public void exceptionWhenDequeueFromEmptyQueueTest() {
        final QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ImplementQueueWithTwoStacks.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}