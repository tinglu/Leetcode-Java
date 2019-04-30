package _1008;

import Common.TreeNode;

public class ConstructBST {
    //    Faster solution
    int i = 0;

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

//    Mine
//    public TreeNode bstFromPreorder(int[] preorder) {
//        Stack<TreeNode> nodes = new Stack<>();
//
//        if (preorder.length == 0) return null;
//
//        int prevVal = preorder[0];
//        TreeNode rootNode = new TreeNode(prevVal);
//        nodes.push(rootNode);
//
//        if (preorder.length > 1) {
//            for (int i = 1; i < preorder.length; i++) {
//                TreeNode currNode = new TreeNode(preorder[i]);
//
//                if (preorder[i] < prevVal) {
//                    nodes.peek().left = currNode;
//                } else {
//                    TreeNode parent = nodes.peek();
//                    while (!nodes.empty() && preorder[i] > nodes.peek().val) {
//                        parent = nodes.pop();
//                    }
//                    parent.right = currNode;
//                }
//                nodes.push(currNode);
//
//                prevVal = preorder[i];
//            }
//        }
//        return rootNode;
//    }
}
