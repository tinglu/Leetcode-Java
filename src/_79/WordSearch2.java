package _79;

// TODO: review later
public class WordSearch2 {

    char[][] board;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        if (word.length() < 1) return false;

        this.board = board;
        rows = board.length;
        if (rows < 1) return false;
        cols = board[0].length;
        if (cols < 1) return false;

        boolean[][] visited = new boolean[rows][cols]; // visited flags should be passed in as argument
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, word, 0, visited)) return true;
                }

            }
        }
        return false;
    }

    private boolean dfs(int row, int col, String word, int wIdx, boolean[][] visited) {
        // Found whole word
        if (wIdx == word.length()) return true;

        // Return earlier by put invalid conditions on top
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] != word.charAt(wIdx))
            return false;

        visited[row][col] = true;
        boolean exist = dfs(row - 1, col, word, wIdx + 1, visited)
                || dfs(row + 1, col, word, wIdx + 1, visited)
                || dfs(row, col - 1, word, wIdx + 1, visited)
                || dfs(row, col + 1, word, wIdx + 1, visited);
        visited[row][col] = false; // !!!!!!! VERY IMPORTANT!!!!!
        return exist;
    }

    public static void main(String args[]) {
        WordSearch2 sol = new WordSearch2();

//        System.out.println("=================");
//        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(sol.exist(board1, "ABCCED"));
//        System.out.println(sol.exist(board1, ""));
//
//        System.out.println("=================");
//        char[][] board2 = {{}};
//        System.out.println(sol.exist(board2, "ABCCED"));
//
//        System.out.println("=================");
//        char[][] board3 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        System.out.println(sol.exist(board3, "AAB"));

        char[][] board4 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(sol.exist(board4, "ABCESEEEFS"));
    }
}
