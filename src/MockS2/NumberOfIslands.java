package MockS2;

/*
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
 *
 * TODO: review later
 *
 *
 * DFS approach:
 *
 * Time complexity : O(M×N) where M is the number of rows and NN is the number of columns.
 *
 * Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
 *
 *
 * */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;

        int rows = grid.length;
        if (rows < 1) return 0;

        int cols = grid[0].length;
        if (cols < 1) return 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {

                    /*
                     *
                     * if there is a start point with value 1 - then there is an island!!!!
                     *
                     * */
                    result += 1;

                    dfs(grid, r, c, rows, cols);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') return;

//        System.out.println();
//        for (char[] tmp : grid) {
//            System.out.println(Arrays.toString(tmp));
//        }

        grid[r][c] = '0';
        dfs(grid, r, c - 1, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r + 1, c, rows, cols);
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();

        char[][] grid = {{
                '1', '1', '1', '1', '0'
        }, {
                '1', '1', '0', '1', '0'
        }, {
                '1', '1', '0', '0', '0'
        }, {
                '0', '0', '0', '0', '0'
        }};
        System.out.println(sol.numIslands(grid));

        char[][] grid2 = {{
                '1', '1', '0'
        }, {
                '0', '1', '1'
        }, {
                '0', '1', '0'
        }};
        System.out.println(sol.numIslands(grid2));
    }
}
