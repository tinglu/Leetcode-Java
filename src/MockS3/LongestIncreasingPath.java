package MockS3;

/*
 * TODO: review later
 *
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * */
public class LongestIncreasingPath {

    /*
     *
     * Naive DFS - correct but TLE!!!
     *
     * Time complexity: O(2^(m+n)).
     * The search is repeated for each valid increasing path. In the worst case we can have O(2^(m+n)) calls.
     *
     * I used the optimization that uses a set to prevent the repeat visit in one DFS search.
     * This optimization will reduce the time complexity for each DFS to O(mn) and the total algorithm to O(m^2n^2).
     *
     *
     * Space complexity: O(mn). For each DFS we need O(h) space used by the system stack, where hh is the maximum
     * depth of the recursion. In the worst case, O(h)=O(mn).
     *
     * */
//    public int longestIncreasingPath(int[][] matrix) {
//        int rows = matrix.length;
//        if (rows <= 0) return 0;
//        int cols = matrix[0].length;
//        if (cols <= 0) return 0;
//
//        int max = 0;
//        boolean[][] visited = new boolean[rows][cols];
//
//        // asc
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                max = Math.max(max, helper(matrix, rows, cols, r, c, 0, matrix[r][c] - 1, visited));
//            }
//        }
//
//        return max;
//    }
//
//    private int helper(int[][] matrix, int rows, int cols, int r, int c, int count, int prev, boolean[][] visited) {
//        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] <= prev) {
//            return count;
//        }
//
//        visited[r][c] = true;
//
//        int curr = matrix[r][c];
//        int max = 0;
//        max = Math.max(max, helper(matrix, rows, cols, r, c - 1, count + 1, curr, visited));
//        max = Math.max(max, helper(matrix, rows, cols, r, c + 1, count + 1, curr, visited));
//        max = Math.max(max, helper(matrix, rows, cols, r - 1, c, count + 1, curr, visited));
//        max = Math.max(max, helper(matrix, rows, cols, r + 1, c, count + 1, curr, visited));
//
//        visited[r][c] = false;
////        System.out.println("\nChecking [" + r + "][" + c + "] = " + max);
//        return max;
//    }


    /*
     *
     * DFS + Memoization
     *
     *
     * Time complexity : O(mn). Each vertex/cell will be calculated once and only once, and each edge will be visited
     *  once and only once. The total time complexity is then O(V+E). VV is the total number of vertices and E is the
     *  total number of edges. In our problem, O(V) = O(mn), O(E) = O(4V) = O(mn).
     *
     * Space complexity : O(mn). The cache dominates the space complexity.
     *
     * */
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // !!! for convenience

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows <= 0) return 0;
        int cols = matrix[0].length;
        if (cols <= 0) return 0;

        int max = 0;

        int[][] memo = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                max = Math.max(max, dfs(matrix, rows, cols, r, c, memo));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int rows, int cols, int r, int c, int[][] memo) {
        // r and c are the current row and col

        if (memo[r][c] != 0) return memo[r][c];

        for (int[] dir : dirs) {

            // x and y, are the next row and col
            int x = r + dir[0];
            int y = c + dir[1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[r][c]) {
                memo[r][c] = Math.max(memo[r][c], dfs(matrix, rows, cols, x, y, memo));
            }
        }
        /*
         * TODO: review later - memo[r][c] needs to be ++ because the current value is for the adjacent cells !!!
         *  should add cell[r][c] itself
         * */
        return ++memo[r][c];
    }

    public static void main(String[] args) {
        LongestIncreasingPath sol = new LongestIncreasingPath();

        int[][] nums = {{
                9, 9, 4
        }, {
                6, 6, 8
        }, {
                2, 1, 1
        }};
        System.out.println(sol.longestIncreasingPath(nums));

        int[][] nums2 = {{
                3, 4, 5
        }, {
                3, 2, 6
        }, {
                2, 2, 1
        }};
        System.out.println(sol.longestIncreasingPath(nums2));
    }
}
