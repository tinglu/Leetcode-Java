package _1026;

import Common.TreeNode;

// TODO: could rewrite to make it faster
public class MaxDiffBtwNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        int max = 0;
        if (root.left != null) {
            max = Math.max(max, helper(root.left, root.val));
            max = Math.max(max, maxAncestorDiff(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, helper(root.right, root.val));
            max = Math.max(max, maxAncestorDiff(root.right));

        }
        return max;
    }


    public int helper(TreeNode node, int currVal) {
        int max = 0;
        max = Math.max(max, Math.abs(currVal - node.val));

        if (node.left != null) {
            max = Math.max(max, helper(node.left, currVal));
        }
        if (node.right != null) {
            max = Math.max(max, helper(node.right, currVal));
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDiffBtwNodeAndAncestor sol = new MaxDiffBtwNodeAndAncestor();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        System.out.println(sol.maxAncestorDiff(node1));
    }
}
