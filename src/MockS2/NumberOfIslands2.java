package MockS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 *
 * https://leetcode.com/problems/number-of-islands-ii/
 * 305. Number of Islands II
 *
 * Not quite right!
 *
 *
 * TODO!!!!!: finish this later using UnionFind!!!!!
 *
 * */
public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();

        int[][] grid = new int[m][n];

        for (int i = 0; i < positions.length; i++) {
            int r = positions[i][0];
            int c = positions[i][1];

            grid[r][c] = 1;

            int connected = 0;
            connected += connectedIslands(r, c - 1, m, n, grid);
            connected += connectedIslands(r, c + 1, m, n, grid);
            connected += connectedIslands(r - 1, c, m, n, grid);
            connected += connectedIslands(r + 1, c, m, n, grid);
//            System.out.println("connected: " + connected);

            if (connected == 0) {
                if (result.size() == 0) {
                    result.add(1);
                } else {
                    result.add(result.get(result.size() - 1) + 1);
                }
            } else if (connected == 1) {
                result.add(result.get(result.size() - 1));
            } else {
                if (result.size() > 0) {
                    int updated = result.get(result.size() - 1) - connected + 1;
                    if (updated > 0) {
                        result.add(updated);
                    } else {
                        result.add(1);
                    }
                }
            }
        }
        return result;
    }

    private int connectedIslands(int r, int c, int rows, int cols, int[][] grid) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return 0;
        return 1;
    }

    public static void main(String[] args) {
        NumberOfIslands2 sol = new NumberOfIslands2();

        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        List<Integer> result = sol.numIslands2(3, 3, positions);
        System.out.println(Arrays.toString(result.toArray()));

        int[][] positions2 = {{0, 0}, {1, 1}, {0, 1}};
        List<Integer> result2 = sol.numIslands2(2, 2, positions2);
        System.out.println(Arrays.toString(result2.toArray()));


        int[][] positions3 = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        List<Integer> result3 = sol.numIslands2(3, 3, positions3);
        System.out.println(Arrays.toString(result3.toArray()));
    }
}
