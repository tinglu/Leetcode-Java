import java.util.Stack;

public class TreeStack {

    static void inOrderTraversal(Node node, Stack<Integer> stack) {
        if (node == null) return;

        Node left = node.left;
        Node right = node.right;
        if (left != null) {
            inOrderTraversal(left, stack);
        }

        stack.push(node.v);

        if (right != null) {
            inOrderTraversal(right, stack);
        }
    }

    public static void main(String args[]) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3, node1, node2);
        Node node = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));

        Stack<Integer> stack = new Stack<>();
        node.printInOrder();
        System.out.println("");

        inOrderTraversal(node, stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

class Node {
    int v;
    Node left = null;
    Node right = null;

    Node(int v) {
        this.v = v;
    }

    Node(int v, Node left, Node right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }

    void printInOrder() {
        //Node left = node.left;
        //Node right = node.right;
        if (left != null) {
            left.printInOrder();
        }

        System.out.print("," + v + ", ");

        if (right != null) {
            right.printInOrder();
        }
    }
}

