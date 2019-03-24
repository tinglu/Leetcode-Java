package _328;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode buildList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next.next;
            head.next = next;
            return next;
        }
        return null;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode nextOdd = head;
        ListNode nextEven = head.next;
        ListNode evenHead = head.next;

        while (nextOdd != null || nextEven != null) {
            nextOdd = buildList(nextOdd);
            nextEven = buildList(nextEven);
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = evenHead;
        return head;
    }

    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        oddEvenList(n1);
//        buildList(n2);

        printList(n1);

    }

    private void printList(ListNode n1) {
        ListNode node = n1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        sol.test();
    }
}