package _378;

import java.util.Arrays;

/*
 *
 * TODO: review this discussion solution !!!
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/301357/Java-0ms-
 * (added-Python-and-C%2B%2B)%3A-Easy-to-understand-solutions-using-Heap-and-Binary-Search
 *
 * */



class Solution {

    private int[] merge(int[] xs, int[] ys) {
        int x = 0;
        int y = 0;
        int z = 0;
        int[] zs = new int[xs.length + ys.length];
        while (z < xs.length + ys.length) {
            if (x == xs.length) {
                zs[z] = ys[y];
                y++;
            } else if (y == ys.length) {
                zs[z] = xs[x];
                x++;
            } else if (xs[x] <= ys[y]) {
                zs[z] = xs[x];
                x++;
            } else {
                zs[z] = ys[y];
                y++;
            }
            z++;
        }
        return zs;
    }

    private int[] mergeMatrix(int[][] matrix) {
        int mid = matrix.length / 2;
        if (mid == 0) return matrix[0];
        return merge(mergeMatrix(Arrays.copyOfRange(matrix, 0, mid)),
                mergeMatrix(Arrays.copyOfRange(matrix, mid, matrix.length)));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] merged = mergeMatrix(matrix);
        System.out.println(Arrays.toString(merged));
        return merged[k - 1];
    }


//    Wrong!!!
//    private int getSmallestNext(int[][] matrix, int row, int col, boolean[][] visited, int k) {
//        int current = matrix[row][col];
//
//        System.out.println("========= " + matrix.length);
//        System.out.println("k: " + k);
//        System.out.println("current: " + current);
//        System.out.println("row: " + row);
//        System.out.println("col: " + col);
//
//        if (k == 1) return matrix[row][col];
//
//        int next = Integer.MAX_VALUE;
//        int nextRow = row, nextCol = col;
//        int nr, nc, val;
//
//        nr = row;
//        nc = col + 1;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // right
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        nr = row - 1;
//        nc = col;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // up
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        nr = row - 1;
//        nc = col + 1;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // up
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        nr = row + 1;
//        nc = col;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // down
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        nr = row + 1;
//        nc = col + 1;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // down
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        nr = row + 1;
//        nc = col - 1;
//        if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix.length && !visited[nr][nc]) { // down
//            val = matrix[nr][nc];
//            if (val <= next) {
//                System.out.println("val: " + val);
//                next = val;
//                nextRow = nr;
//                nextCol = nc;
//            }
//        }
//
//        System.out.println("nextRow: " + nextRow);
//        System.out.println("nextCol: " + nextCol);
//        visited[nextRow][nextCol] = true;
//        return getSmallestNext(matrix, nextRow, nextCol, visited, k - 1);
//    }
//
//    public int kthSmallest(int[][] matrix, int k) {
//
//        int n = matrix.length;
//        boolean[][] visited = new boolean[n][n];
//        for (boolean[] row : visited) {
//            Arrays.fill(row, false);
//        }
//
//        visited[0][0] = true;
//        return getSmallestNext(matrix, 0, 0, visited, k);
//    }

    public static void main(String args[]) {
        Solution obj = new Solution();

        int[][] matrix = {{1, 5, 9}, {2, 100, 1000}, {15, 100000, 200000}};

        System.out.println(obj.kthSmallest(matrix, 5));
    }
}