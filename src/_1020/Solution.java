package _1020;

import java.util.Arrays;

public class Solution {
//    public int numEnclaves(int[][] A) {
//        int cols = A.length;
//        int rows = A[0].length;
//        boolean[][] visited = new boolean[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            Arrays.fill(visited[i], false);
//        }
//
//        int count = 0;
//        int result = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                count = 0;
//                if (A[i][j] == 1) {
//                    visited[i][j] = true;
//                    dfs(A, visited, i, j, 0);
//                    if (count > result) result = count;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private void dfs(int[][] A, boolean[][] visited, int row, int col, int count) {
//        int cols = A.length;
//        int rows = A[0].length;
//        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
////            count = 0;
//        } else {
//            if (row - 1 > 0 && A[row - 1][col] == 1 && !visited[row - 1][col]) {
//                visited[row - 1][col] = true;
//                dfs(A, visited, row - 1, col, count += 1);
//            }
//            if (row + 1 < rows - 1 && A[row + 1][col] == 1 && !visited[row + 1][col]) {
//                visited[row + 1][col] = true;
//                dfs(A, visited, row + 1, col, count += 1);
//            }
//            if (col - 1 > 0 && A[row][col - 1] == 1 && !visited[row][col - 1]) {
//                visited[row][col - 1] = true;
//                dfs(A, visited, row, col - 1, count += 1);
//            }
//            if (col + 1 < cols - 1 && A[row][col + 1] == 1 && !visited[row][col + 1]) {
//                visited[row][col + 1] = true;
//                dfs(A, visited, row, col + 1, count += 1);
//            }
//
//        }
//    }


    public int numEnclaves(int[][] A) {
        int cols = A[0].length;
        int rows = A.length;
        boolean[][] visited;

        int count = 0;
        int totalOne = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    totalOne += 1;
                    visited = new boolean[rows][cols];
                    if (dfs(A, i, j, visited)) count += 1;
                }
            }
        }

        return totalOne - count;
    }


    private boolean dfs(int[][] A, int row, int col, boolean[][] visited) {
        if (row < 0 || row > A.length - 1 || col < 0 || col > A[0].length) return false;
        if (A[row][col] == 0) return false;
        if (row == 0 || col == 0 || row == A.length - 1 || col == A[0].length - 1) return true;
        if (visited[row][col]) return false;
        visited[row][col] = true;
        return dfs(A, row - 1, col, visited) || dfs(A, row + 1, col, visited) || dfs(A, row, col - 1, visited) || dfs(A,
                row, col + 1, visited);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(sol.numEnclaves(A));
    }
}