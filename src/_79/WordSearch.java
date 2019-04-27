package _79;

import java.util.Arrays;

// TODO: wrong
class WordSearch {
    char[][] board;
    int rows;
    int cols;
    int firstLetterRow;
    int firstLetterCol;

    private boolean findFirstLetterPos(char letter) {
        System.out.println("================== findFirstLetterPos ==================");
        for (int r = firstLetterRow; r < rows; r++) {
            int cStart;
            if (r == firstLetterRow) {
                cStart = firstLetterCol;
            } else {
                cStart = 0;
            }
            for (int c = cStart; c < cols; c++) {
                if (board[r][c] == letter) {
                    firstLetterRow = r;
                    firstLetterCol = c;
                    System.out.println("...");
                    System.out.println("firstLetterRow " + firstLetterRow + " firstLetterCol " + firstLetterCol);
                    return true;
                }
            }
        }
        System.out.println("??");
        return false;
    }

    private void nextFirstLetterPos() {
        firstLetterCol = firstLetterCol + 1 < cols ? firstLetterCol + 1 : 0;
        firstLetterRow = firstLetterCol == 0 ? firstLetterRow + 1 : firstLetterRow;
        System.out.println("nextFirstLetterPos called");
        System.out.println("firstLetterRow " + firstLetterRow + " firstLetterCol " + firstLetterCol);
    }


    private void fillVisisted(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        if (letters.length == 0) return false;

        this.board = board;
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        fillVisisted(visited);

        firstLetterRow = 0;
        firstLetterCol = 0;


        while (findFirstLetterPos(letters[0])) {
            int row = firstLetterRow;
            int col = firstLetterCol;
            visited[firstLetterRow][firstLetterCol] = true;

            if (letters.length > 1) {
                int found = 1; // first letter already found
                System.out.println(">>>>");
                for (int i = 1; i < letters.length; i++) {
                    System.out.println(letters[i]);
                    System.out.println("row " + row + " col " + col);

                    if (board[row][col] == letters[i] && !visited[row][col]) {
                        visited[row][col] = true;
                        found += 1;
                        System.out.println("row " + row + " col " + col);
                    } else if (col + 1 < cols && board[row][col + 1] == letters[i] && !visited[row][col + 1]) {
                        visited[row][col + 1] = true;
                        col += 1;
                        found += 1;
                        System.out.println("row " + row + " col " + col);
                    } else if (col - 1 >= 0 && board[row][col - 1] == letters[i] && !visited[row][col - 1]) {
                        visited[row][col - 1] = true;
                        col -= 1;
                        found += 1;
                        System.out.println("row " + row + " col " + col);
                    } else if (row + 1 < rows && board[row + 1][col] == letters[i] && !visited[row + 1][col]) {
                        visited[row + 1][col] = true;
                        row += 1;
                        found += 1;
                        System.out.println("row " + row + " col " + col);
                    } else if (row - 1 >= 0 && board[row - 1][col] == letters[i] && !visited[row - 1][col]) {
                        visited[row - 1][col] = true;
                        row -= 1;
                        found += 1;
                        System.out.println("row " + row + " col " + col);
                    } else {
                        System.out.println("??????");
                        fillVisisted(visited);
                        nextFirstLetterPos();
                    }
                }
                System.out.println("Found: " + found);
                if (found == letters.length) return true;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        WordSearch sol = new WordSearch();
//        char c = 'h';
//        System.out.println(c == 'h');
//        System.out.println("=================");
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(sol.exist(board, "ABCCED"));
//        System.out.println(sol.exist(board, ""));
//
//        System.out.println("=================");
//        char[][] board2 = {{}};
//        System.out.println(sol.exist(board2, "ABCCED"));

        char[][] board3 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(sol.exist(board3, "AAB"));

    }
}