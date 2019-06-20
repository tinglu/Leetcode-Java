package Mock6;


import java.util.HashSet;
import java.util.Set;

/*
 *
 * TODO!!!!!!!!!!!!!!: review later - using UnionFind!!! (similar to island problem)
 *
 *
 * 947. Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 *
 * */
public class RemoveStones {

    /*
     * Wrong!
     * */
    public int removeStones1(int[][] stones) {
        int numOfStonesWithSharing = 0;

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];

            for (int[] other : stones) {
                int ro = other[0];
                int co = other[1];
                if (ro == row && co != col || co == col && ro != row) {
                    numOfStonesWithSharing += 1;
                    break;
                }
            }
        }

        return numOfStonesWithSharing < 1 ? 0 : numOfStonesWithSharing - 1;
    }


    /*
     *
     * Use UnionFind!
     *
     * */
    public int removeStones(int[][] stones) {
        int N = stones.length;
        UnionFind uf = new UnionFind(20000); // uniting rows and cols - so doubling up

        for (int[] stone : stones) {
            /*
             *
             * 1 <= stones.length <= 1000
             * 0 <= stones[i][j] < 10000
             *
             * */
            uf.union(stone[0], stone[1] + 10000);
        }


        Set<Integer> seen = new HashSet<>(); // counting islands
        for (int[] stone : stones) {
            seen.add(uf.find(stone[0]));
        }
//        System.out.println("N: " + N + " seen.size(): " + seen.size());
        return N - seen.size();
    }


    public static void main(String[] args) {
        RemoveStones sol = new RemoveStones();

        System.out.println(sol.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(sol.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        System.out.println(sol.removeStones(new int[][]{{0, 0}}));
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

}