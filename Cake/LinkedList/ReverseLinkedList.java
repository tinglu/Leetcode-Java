package LinkedList;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/*
 *
 * TODO: review later
 *
 * */
public class ReverseLinkedList {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    /*
     *
     * TODO: review this later using O(1) space!!!!!
     *
     * O(n) time and O(1) space
     *
     * */
    public static LinkedListNode reverse1(LinkedListNode headOfList) {

        // reverse the linked list !!!in place!!!
        LinkedListNode prevNode = null;
        LinkedListNode currNode = headOfList;
        LinkedListNode nextNode; // nextNode is read in while loop!!!

        // until we have 'fallen off' the end of the list
        while (currNode != null) {

            // Read new nextNode before changing old nextNode's next pointer!!!
            nextNode = currNode.next;

            // Update currentNode's next pointer to prevNode!!
            currNode.next = prevNode;

            // Move forward prevNode and currNode!!
            prevNode = currNode;
            currNode = nextNode;
        }

        // prevNode is the new head
        return prevNode;
    }


    /*
     *
     * Recursion way
     * */
    public static LinkedListNode reverse(LinkedListNode headOfList) {

        if (headOfList == null) return null;

        LinkedListNode next = headOfList.next;
        if (next == null) return headOfList;

        LinkedListNode newHead = reverse(next);
        headOfList.next = null;
        next.next = headOfList;
        return newHead;
    }


    // tests

    @Test
    public void shortLinkedListTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2});
        final LinkedListNode result = reverse(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void longLinkedListTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[]{1, 2, 3, 4, 5, 6});
        final LinkedListNode result = reverse(nodes[0]);
        assertTrue(isListReversed(result, nodes));
    }

    @Test
    public void oneElementLinkedListTest() {
        final LinkedListNode node = new LinkedListNode(1);
        final LinkedListNode result = reverse(node);
        assertSame(node, result);
    }

    @Test
    public void emptyLinkedListTest() {
        final LinkedListNode result = reverse(null);
        assertNull(result);
    }

    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    private static boolean isListReversed(LinkedListNode list, LinkedListNode[] originalNodes) {
        int i = originalNodes.length - 1;
        while (list != null && i >= 0) {
            if (originalNodes[i] != list) {
                return false;
            }
            list = list.next;
            i--;
        }
        return list == null && i == -1;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseLinkedList.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}