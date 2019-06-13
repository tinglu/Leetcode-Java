package _21;

import Common.ListNode;

// TODO
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode left; // = l1;
        ListNode right; // = l2;
        ListNode head; // = l1.val < l2.val ? l1 : l2;
        ListNode curr;

        if (l1.val < l2.val) {
            head = l1;
            left = l1.next;
            right = l2;
        } else {
            head = l2;
            left = l1;
            right = l2.next;
        }

        curr = head;

        while (left != null || right != null) {
            if (left == null) {
                curr.next = right;
                return head;
            }

            if (right == null) {
                curr.next = left;
                return head;
            }

            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }


        return head;
    }
}
