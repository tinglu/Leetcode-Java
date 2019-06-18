package DynamicProgrammingAndRecursion;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class SecondLargestInBinarySearchTree {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }


    /*
     *
     * My solution - this logic is not sound
     *
     * */
//    public static int findSecondLargest(BinaryTreeNode rootNode) {
//        if (rootNode == null || rootNode.left == null && rootNode.right == null)
//            throw new IllegalArgumentException("at least 2 nodes to get the second largest");
//
//        return helper(rootNode, rootNode.value);
//    }
//
//    private static int helper(BinaryTreeNode rootNode, int potential) {
//        if (rootNode.right != null) {
//            return helper(rootNode.right, rootNode.value);
//        }
//        if (rootNode.left != null) {
//            return rootNode.left.value;
//        }
//        return potential;
//    }


    /*
     * TODO - review interview cake solution below
     *
     * if the current node has a left subtree - then the second largest must be the first largest
     * node in the left subtree;
     * if the current node has a right subtree and the right node is the leaf - then the current node is the second
     * largest
     *
     *
     *
     * We're doing one walk down our BST, which means O(h) time, where hh is the height of the tree (again,
     * that's O(lgn) if the tree is balanced, O(n) otherwise). O(1) space.
     *
     *
     *
     * Here we used a "simplify, solve, and adapt" strategy.
     *
     *
     * */
    private static int findLargest1(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public static int findSecondLargest1(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null
                && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {

            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest1(current.left);
            }

            // case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }

    // !!!
    private static int findLargest(BinaryTreeNode node) {
        if (node == null) throw new IllegalArgumentException("must have at least 1 node");

        if (node.right != null) {
            return findLargest(node.right);
        }
        return node.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {

        // find the second largest item in the binary search tree

        if (rootNode == null || rootNode.right == null && rootNode.left == null) {
            throw new IllegalArgumentException("no second largest");
        }

        BinaryTreeNode current = rootNode;
        while (true) {
            if (current.left != null && current.right == null) {
                /*
                 *
                 *
                 * !!!!! if the current node has a left subtree - then the second largest must be the first largest
                 * node in the left subtree!!!!!!
                 *
                 *
                 * */
                return findLargest(current.left);
            }

            // current node only has a right leaf!!!
            if (current.right != null
                    && current.right.right == null
                    && current.right.left == null) {
                return current.value;
            }

            current = current.right;
        }
    }


    // tests

    @Test
    public void findSecondLargestTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftChildTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70).insertLeft(60);
        final int actual = findSecondLargest(root);
        final int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftSubtreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70).insertLeft(60);
        b.insertLeft(55).insertRight(58);
        b.insertRight(65);
        final int actual = findSecondLargest(root);
        final int expected = 65;
        assertEquals(expected, actual);
    }

    @Test
    public void secondLargestIsRootNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70);
        final int actual = findSecondLargest(root);
        final int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void descendingLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20);
        final int actual = findSecondLargest(root);
        final int expected = 40;
        assertEquals(expected, actual);
    }

    @Test
    public void ascendingLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertRight(60).insertRight(70).insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithTreeThatHasOneNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        findSecondLargest(root);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyTreeTest() {
        findSecondLargest(null);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SecondLargestInBinarySearchTree.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}