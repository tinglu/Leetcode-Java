package LinkedList;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 *
 * O(1) time and O(1)O(1) space.
 *
 * */
public class CycleInSinglyLinkedList {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode firstNode) {

        // check if the linked list contains a cycle
//        if (firstNode == null) return false;
//
//        LinkedListNode slow = firstNode;
//        LinkedListNode fast = firstNode.next;
//        while (fast != null) {
//            if (slow == fast) return true;
//            if (fast.next == null || fast.next.next == null) return false;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return false;

        // Another way - less code
        LinkedListNode slow = firstNode;
        LinkedListNode fast = firstNode;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }


    // tests

    @Test
    public void linkedListWithNoCycleTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        final boolean result = containsCycle(nodes[0]);
        assertFalse(result);
    }

    @Test
    public void cycleLoopsToBeginningTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4});
        nodes[3].next = nodes[0];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void cycleLoopsToMiddleTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4, 5});
        nodes[4].next = nodes[2];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void twoNodeCycleAtEndTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4, 5});
        nodes[4].next = nodes[3];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void emptyListTest() {
        final boolean result = containsCycle(null);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListNoCycleTest() {
        final LinkedListNode node = new LinkedListNode(1);
        final boolean result = containsCycle(node);
        assertFalse(result);
    }

    @Test
    public void oneElementLinkedListCycleTest() {
        final LinkedListNode node = new LinkedListNode(1);
        node.next = node;
        final boolean result = containsCycle(node);
        assertTrue(result);
    }

    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CycleInSinglyLinkedList.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}