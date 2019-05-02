package _590;

import Common.Node;

import java.util.*;

public class NAryTreePostOrderTraversal {
    // XXX Wrong
//    public List<Integer> postorder(Node root) {
//        List<Integer> result = new LinkedList<>();
//        if (root == null) return result;
//
//        Queue<Node> traversing = new ArrayDeque<>();
//        Map<Node, Boolean> visited = new HashMap<>();
//
//        traversing.add(root);
//        visited.put(root, false);
//
//        while (!traversing.isEmpty()) {
//
//            Node curr = traversing.poll();
//
//            if (!visited.containsKey(curr) || !visited.get(curr)) {
//                result.add(curr.val);
//                visited.putIfAbsent(curr, true);
//            }
//
//            if (curr.children != null || !curr.children.isEmpty()) {
//                Collections.reverse(curr.children);
//                for (Node child : curr.children) {
//                    if (!visited.containsKey(child) || !visited.get(child)) {
//                        result.add(child.val);
//                        visited.putIfAbsent(child, true);
//                        traversing.add(child);
//                    }
//                }
//            }
//        }
//        Collections.reverse(result);
//        return result;
//    }


    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<Node> traversing = new Stack<>();

        traversing.add(root);

        while (!traversing.isEmpty()) {
            Node curr = traversing.pop();

            result.addFirst(curr.val);

            if (curr.children != null || !curr.children.isEmpty()) {
                for (Node child : curr.children) {
                    traversing.add(child);
                }
            }
        }
        return result;
    }
}
