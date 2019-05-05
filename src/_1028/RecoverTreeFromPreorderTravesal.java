package _1028;

import Common.TreeNode;

import java.util.*;

// TODO: not finished
public class RecoverTreeFromPreorderTravesal {
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() < 1) return null;

        TreeNode root = new TreeNode(Integer.valueOf(S.substring(0, 1)));

        Map<TreeNode, Integer> nodeIdx = new HashMap<>();

        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        nodeIdx.put(root, 0);

        String level = "-";

        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
//            System.out.println("level: " + level);

            for (int i = 1; i < S.length(); i++) {

                int dashEnds = i + level.length();

                if (dashEnds >= S.length()) break;

//                String prevLevel = level.substring(0, level.length() - 1);
//                int bound = S.indexOf(prevLevel, i);
//                bound = bound >= S.length() ? S.length() : bound;
//                System.out.println("bound: " + bound);

                if (!S.substring(i - 1, i).equals("-")
                        && S.substring(i, dashEnds).equals(level)
                        && !S.substring(dashEnds, dashEnds + 1).equals("-")) {

                    int nextDashStart = S.indexOf("-", dashEnds);
                    nextDashStart = nextDashStart < 0 ? S.length() : nextDashStart;

                    int val = Integer.valueOf(S.substring(dashEnds, nextDashStart));

                    TreeNode node = new TreeNode(val);

                    while (currentNode != null) {
                        TreeNode nextNode = ((ArrayDeque<TreeNode>) nodes).peekFirst();
                        if (nodeIdx.containsKey(nextNode) && nodeIdx.get(nextNode) < i) {
                            System.out.println("??nextNode: " + nextNode.val);
                            System.out.println("??nextNode idx: " + nodeIdx.get(nextNode));
                            System.out.println("??i: " + i);
                            currentNode = nodes.poll();
                        } else if (currentNode.left == null) {
                            currentNode.left = node;
                            break;
                        } else if (currentNode.right == null) {
                            currentNode.right = node;
                            break;
                        }
//                        else {
//                            currentNode = nodes.poll();
//                        }
                    }

                    nodes.add(node);
                    nodeIdx.put(node, dashEnds);
//                    System.out.println("node: " + node.val);

                }
            }

            level += "-";
        }
        return root;
    }

    public static void main(String[] args) {
        RecoverTreeFromPreorderTravesal sol = new RecoverTreeFromPreorderTravesal();

        TreeNode root = sol.recoverFromPreorder("1-2--3--4-5--6--7");
        List<Integer> S = root.inorderPrint();
        System.out.println("S: " + Arrays.toString(S.toArray()));

//        TreeNode root2 = sol.recoverFromPreorder("1-2--3---4-5--6---7");
//        S = root2.inorderPrint();
//        System.out.println("S: " + Arrays.toString(S.toArray()));
    }
}
