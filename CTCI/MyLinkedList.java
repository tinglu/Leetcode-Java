public class MyLinkedList {
    //    class Node {
    //        int data;
    //        Node next;
    //
    //        public Node(int data, Node next) {
    //            this.data = data;
    //            this.next = next;
    //        }
    //    }

    //    CTCI
    class Node {
        int data;
        Node next = null;

        public Node(int d) {
            data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node curr = this;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
        }
    }


    public Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node newList = reverseList(head.next);

        Node t1 = head.next;
        t1.next = head;
        head.next = null;
        return newList;
    }

    void printMyLinkedList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void test() {
//        Node n3 = new Node(3, null);
//        Node n2 = new Node(2, n3);
//        Node n1 = new Node(1, n2);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        n2.next = n3;
        Node n1 = new Node(1);
        n1.next = n2;
//        Node newHead = reverseList(n1);
//        printMyLinkedList(newHead);
        Node n4 = new Node(4);
        n4.next = n1;
        Node n5 = new Node(1);
        n5.next = n4;
        printMyLinkedList(n5);

        System.out.println("===");
//        Node newHead = deleteNode(n5, 1);
        Node newHead = removeDup(n5);
        printMyLinkedList(newHead);
    }


    //
    Node deleteNode(Node head, int d) {
        Node n = head; // VERY IMPORTANT!!

        if (head.data == d) {
            head =  head.next;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            }
            n = n.next;
        }
        return head;
    }

    //    2.1
    private Node removeDup(Node head) {
        Node n = head;
        while (n.next != null) {
            deleteNode(n.next, n.data);
            n = n.next;
        }
        return head;
    }


    public static void main(String args[]) {
        MyLinkedList ml = new MyLinkedList();
        ml.test();
    }
}
