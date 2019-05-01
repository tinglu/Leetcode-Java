package _106;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeByInorderPostorder {
    Map<Integer, Integer> postNumToIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length < 1) return null;
        if (inorder.length != postorder.length) return null;

        postNumToIdx = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postNumToIdx.put(postorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inorderLeft, int inorderRight,
                            int[] postorder, int postorderLeft, int postorderRight) {
        if (postorderRight < postorderLeft) return null;

        int rootVal = postorder[postorderRight];
        TreeNode root = new TreeNode(rootVal);

        int pos;
        for (pos = inorderLeft; pos <= inorderRight; pos++) {
            if (inorder[pos] == rootVal) {
                break;
            }
        }

        int leftItemCount = pos - inorderLeft;
        root.left = helper(inorder, inorderLeft, pos - 1, postorder, postorderLeft, postorderLeft + leftItemCount - 1);
        int rightItemCount = inorderRight - pos;
        root.right = helper(inorder, pos + 1, inorderRight, postorder, postorderRight - rightItemCount,
                postorderRight - 1);

        return root;
    }
}
