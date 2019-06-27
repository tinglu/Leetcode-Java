package _684;

import java.util.Arrays;

/*
 *
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/
 *
 * */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1); // +1 because there're at least 1 redundant edge!!!

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!uf.shouldUnion(x, y)) return edge;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();

        int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        System.out.println(Arrays.toString(sol.findRedundantConnection(edges)));

        int[][] edges2 = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        System.out.println(Arrays.toString(sol.findRedundantConnection(edges2)));
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        rank = new int[N];
    }

    /*
     * find root
     * */
    public int find(int a) {
        int root = parent[a];
        if (root != a) {
            parent[a] = find(root);
            return parent[a];
        }
        return root;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rank[rootX] > rank[rootY]) {
            // move y to x
            parent[y] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            // move x to y
            parent[x] = rootY;
        } else {
            parent[y] = rootX;
            count--; // component decrease by 1
        }
    }

    public boolean shouldUnion(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        System.out.println("x: " + x + " y: " + y + " rootX: " + rootX + " rootY: " + rootY);
        if (rootX == rootY) {
            return false;
        } else {
            if (rank[rootX] > rank[rootY]) {
                // move y to x
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                // move x to y
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                count--; // component decrease by 1
            }
            return true;
        }
    }

    public int getCount() {
        return count;
    }
}
