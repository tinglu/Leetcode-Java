package _207;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private final int V;
    private int E;
    private List<List<Integer>> adj;

    public Digraph(int V) {
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
