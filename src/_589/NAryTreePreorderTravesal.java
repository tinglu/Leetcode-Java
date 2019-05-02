package _589;

import Common.Node;

import java.util.*;

public class NAryTreePreorderTravesal {

    // Use iteration
//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Queue<Node> nodes = new ArrayDeque<>();
//        nodes.add(root);
//        while(!nodes.isEmpty()) {
//            Node node = nodes.poll();
//            result.add(node.val);
//            if (node.children != null && !node.children.isEmpty()) {
//                for (Node child : node.children) {
//                    result.addAll(preorder(child));
//                }
//            }
//        }
//        return result;
//    }

    // Avoid recursion
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.pollLast();
            result.add(node.val);

            if (node.children != null && !node.children.isEmpty()) {
                Collections.reverse(node.children);
                nodes.addAll(node.children);
            }
        }
        return result;
    }
}
