package _138;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

// TODO: review in future
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> nodesMap = new HashMap<>();

        Node newHead = new Node(head.val, null, null);
        nodesMap.put(head, newHead);

        Node orgNode = head;
        Node newNode = newHead;

        while (orgNode != null) {

            Node next = orgNode.next;
            Node random = orgNode.random;
            int val = orgNode.val;


            Node newNext;
            if (nodesMap.containsKey(next)) {
                newNext = nodesMap.get(next);
            } else {
                newNext = next == null ? null : new Node(next.val, null, null);
                nodesMap.put(next, newNext);
            }

            Node newRandom;
            if (nodesMap.containsKey(random)) {
                newRandom = nodesMap.get(random);
            } else {
                newRandom = random == null ? null : new Node(random.val, null, null);
                nodesMap.put(random, newRandom);
            }

            newNode.next = newNext;
            newNode.random = newRandom;

            orgNode = orgNode.next;
            newNode = newNode.next;
        }


        return newHead;
    }

//    private void helper(Node orgNode, Map<Node, Node> nodesMap, Node newNode) {
//
//        if (orgNode != null) {
//
//            if (nodesMap.containsKey(orgNode)) {
//                newNode = nodesMap.get(orgNode);
//            } else {
//
//                Node next = orgNode.next;
//                Node random = orgNode.random;
//                int val = orgNode.val;
//
//                System.out.println();
//                System.out.println("org: " + orgNode.val);
//                if (next != null) System.out.println("next: " + next.val);
//                if (random != null) System.out.println("random: " + random.val);
//
//                Node newNext;
//                if (nodesMap.containsKey(next)) {
//                    System.out.print("containsKey(next)");
//                    newNext = nodesMap.get(next);
//                } else {
//                    newNext = next == null ? null : new Node(next.val, next.next, next.random);
//                    nodesMap.put(next, newNext);
//                }
//
//                Node newRandom;
//                if (nodesMap.containsKey(random)) {
//                    System.out.print("containsKey(random)");
//                    newRandom = nodesMap.get(random);
//                } else {
//                    newRandom = random == null ? null : new Node(random.val, random.next, random.random);
//                    nodesMap.put(random, newRandom);
//                }
//
//                newNode = new Node(val, newNext, newRandom);
//                nodesMap.put(orgNode, newNode);
//            }
//
//            newNode.next = new Node();
//            helper(orgNode.next, nodesMap, newNode.next);
//        }
//    }
}
