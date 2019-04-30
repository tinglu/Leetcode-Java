package _285;

import Common.TreeNode;

public class InorderSuccessorInBST {
    // Recursion: Don't understand this solution
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) return null;
//
//        if (root.val <= p.val) {
//            return inorderSuccessor(root.right, p);
//        } else {
//            TreeNode left = inorderSuccessor(root.left, p);
//            return left == null ? root : left;
//        }
//    }

    // Iterative way
    // TODO: review later
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;

        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }

//    XXX Wrong!
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
////        if (root == null || p == null) return null;
////        if (root.val == p.val && root.right != null) return root.right;
////
////        if (root.left != null && root.left.val == p.val) return root;
////        if (root.val > p.val) return inorderSuccessor(root.left, p);
////
////        if (root.val < p.val) return inorderSuccessor(root.right, p);
////
////        return null;
//        return helper(root, p, root);
//    }
//
//    private TreeNode helper(TreeNode root, TreeNode p, TreeNode max) {
//        if (root == null || p == null) return null;
//        if (root.val == p.val && root.right != null) return root.right;
//
//        if (root.left != null && root.left.val == p.val) return root;
//        if (root.val > p.val) return helper(root.left, p, root);
//
//        if (root.right != null && root.right.val == p.val) return max;
//        if (root.val < p.val) return helper(root.right, p, null);
//
//        return null;
//    }
}
