package _19;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveLastKthFromLinkedList {

//    XX not quite right!
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (n == 0) return head;
//
//        ListNode prev = head;
//        if (head.next != null) {
//            ListNode toRemove = head.next;
//            int total = 1;
//            int c = 1;
//            ListNode curr = head.next;
//            while (curr != null) {
//                System.out.println("\ncurr: " + curr.val);
//
//                total++;
//                c++;
//
//                if (c > n && toRemove.next != null) {
//                    prev = toRemove;
//                    toRemove = toRemove.next;
//                    c = 1;
//                }
//
//                System.out.println("after  - c: " + c + " -> " + "prev: " + prev.val + " - toRemove: " + toRemove
// .val);
//                curr = curr.next;
//            }
//
//            System.out.println("total: " + total);
//            if (total == n) head = toRemove;
//            else prev.next = toRemove == null ? null : toRemove.next;
//        } else {
//            if (n > 0) {
//                return null;
//            }
//        }
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    private void test() {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        ListNode head = removeNthFromEnd(n1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RemoveLastKthFromLinkedList sol = new RemoveLastKthFromLinkedList();
        sol.test();
    }
}
