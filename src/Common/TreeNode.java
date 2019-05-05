package Common;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public List<Integer> inorderPrint() {
        List<Integer> result = new ArrayList<>();
        if (left != null) result.addAll(left.inorderPrint());
        result.add(val);
        if (right != null) result.addAll(right.inorderPrint());
        return result;
    }
}