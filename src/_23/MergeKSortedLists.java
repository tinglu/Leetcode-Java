package _23;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// Merge by Divide and Conquer
// Time complexity: O(N * lg K)
public class MergeKSortedLists {

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length < 1) return null;
//        int mid = lists.length / 2;
//        if (mid == 0) {
//            return lists[0];
//        }
//        return helper(mergeKLists(Arrays.copyOfRange(lists, 0, mid)), mergeKLists(Arrays.copyOfRange(lists, mid,
//        lists.length)));
//    }

    // Same method, but don't have to copy lists in every partition
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int from, int to) {
        if (from == to) return lists[from];
        if (from > to) return null;
        int mid = (from + to) / 2;
        return helper(partition(lists, from, mid), partition(lists, mid + 1, to));
    }

    private ListNode helper(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode head;
        if (node1.val < node2.val) {
            head = node1;
            node1 = node1.next;
        } else {
            head = node2;
            node2 = node2.next;
        }
        ListNode curr = head;

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                curr.next = node2;
                return head;
            }
            if (node2 == null) {
                curr.next = node1;
                return head;
            }
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        node4.next = node5;

        ListNode[] lists = {node1, node4};
//        ListNode result = sol.helper(node1, node4);
        ListNode result = sol.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
