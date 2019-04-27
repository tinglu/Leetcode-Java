package _210;

import _207.Digraph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

// TODO: review later
public class CourseSchedule2 {
    boolean[] marked;
    int[] edgeTo;
    Stack<Integer> cycle;
    boolean[] onStack;
    Stack<Integer> reversePostOrder;
    Queue<Integer> pre;
    Queue<Integer> post;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        edgeTo = new int[numCourses];
        onStack = new boolean[numCourses];

        // Build graph
        Digraph digraph = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            digraph.addEdge(prerequisites[i]);
        }

        // Verify if has cycle
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) dfs(digraph, v);
        }

        // Ordering
        if (hasCycle()) return new int[0];

        reversePostOrder = new Stack<>();
        pre = new ArrayDeque<>();
        post = new ArrayDeque<>();
        marked = new boolean[numCourses]; // RESET MARKED FOR ORDERING!!!
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) dfsOrder(digraph, v);
        }
        int[] result = new int[numCourses];
//        int i = 0;
//        System.out.println("numCourses： " + numCourses);
//        System.out.println("reversePostOrder: " + reversePostOrder);
//        System.out.println("reversePostOrder: " + Arrays.toString(reversePostOrder.toArray()));
//        System.out.println("pre: " + pre);
//        System.out.println("post: " + post);
//        while (!reversePostOrder.isEmpty() && i < numCourses) {
//            result[i] = reversePostOrder.pop();
//            i++;
//        }

        Object[] ord = reversePostOrder.toArray();
        for (int i = 0; i< numCourses; i++) {
            result[i] = (int) ord[i];
        }
        return result;
    }


    private void dfsOrder(Digraph digraph, int v) {
        pre.add(v);
        marked[v] = true;

        for (int w : digraph.adj(v)) {
            if (!marked[w]) dfsOrder(digraph, w);
        }
        post.add(v);
        reversePostOrder.push(v);
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                System.out.println("v: " + v);
                System.out.println("w: " + w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    System.out.println("x: " + x);
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public static void main(String[] args) {
        CourseSchedule2 sol = new CourseSchedule2();
        int num = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(sol.findOrder(num, prerequisites)));

        num = 2;
        int[][] prerequisites2 = {{0,1},{1,0}};
        System.out.println(Arrays.toString(sol.findOrder(num, prerequisites2)));
    }
}
