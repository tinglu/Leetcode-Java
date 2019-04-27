package _207;

import java.util.*;

// TODO: review later
// TOPOLOGICAL SORT
public class CourseSchedule {

    class Digraph {
        private final int V;
        private int E;
        private List<List<Integer>> adj;

        Digraph(int V) {
            this.V = V;
            this.E = 0;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int[] edge) {
            adj.get(edge[0]).add(edge[1]);
            E++;
        }

        public List<Integer> adj(int v) {
            return adj.get(v);
        }
    }


    boolean[] marked;
    int[] edgeTo;
    Stack<Integer> cycle;
    boolean[] onStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        edgeTo = new int[numCourses];
//        cycle = new Stack<>(); // !!!!! SHOULDN'T HAVE THIS LINE!!!
        onStack = new boolean[numCourses];

        Digraph digraph = new Digraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            digraph.addEdge(prerequisites[i]);
        }

        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) dfs(digraph, v);
        }

        System.out.println(cycle);
        return !hasCycle();
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
        CourseSchedule sol = new CourseSchedule();
        int num = 5;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 2}};
        System.out.println(sol.canFinish(num, prerequisites));
    }
}
