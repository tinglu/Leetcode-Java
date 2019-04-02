package _1008;


import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConstructBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> nodes = new Stack<>();

        if (preorder.length == 0) return null;

        int prevVal = preorder[0];
        TreeNode rootNode = new TreeNode(prevVal);
        nodes.push(rootNode);

        if (preorder.length > 1) {
            for (int i = 1; i < preorder.length; i++) {
                TreeNode currNode = new TreeNode(preorder[i]);

                if (preorder[i] < prevVal) {
                    nodes.peek().left = currNode;
                } else {
                    TreeNode parent = nodes.peek();
                    while (!nodes.empty() && preorder[i] > nodes.peek().val) {
                        parent = nodes.pop();
                    }
                    parent.right = currNode;
                }
                nodes.push(currNode);

                prevVal = preorder[i];
            }
        }
        return rootNode;
    }
}
