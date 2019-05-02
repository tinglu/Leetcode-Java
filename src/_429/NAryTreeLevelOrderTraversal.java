package _429;

import Common.Node;

import java.util.LinkedList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        List<Node> traversing = new LinkedList<>();
        List<Node> toTraverse = new LinkedList<>();
        traversing.add(root);

        List<Integer> levelList = new LinkedList<>();
        levelList.add(root.val);
        result.add(levelList);

        while(!traversing.isEmpty()){
            levelList = new LinkedList<>();
            for (Node currNode : traversing) {
                if (currNode.children != null && !currNode.children.isEmpty()) {
                    for (Node child : currNode.children) {
                        levelList.add(child.val);
                        toTraverse.add(child);
                    }
                }
            }
            if (!levelList.isEmpty()) result.add(levelList);
            traversing = toTraverse;
            toTraverse = new LinkedList<>();
        }
        return result;
    }
}
