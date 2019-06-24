package MockO4;

/*
 * TODO: review later - Just need to compare with its top left cell
 *
 * 766. ToeplitzMatrix Matrix
 * https://leetcode.com/problems/toeplitz-matrix/
 *
 * */
public class ToeplitzMatrix {

    /*
     *
     * Wrong!
     *
     * */
//    public boolean isToeplitzMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        if (rows <= 0) return false;
//
//        int cols = matrix[0].length;
//        if (cols <= 0) return false;
//
//        int currRow = rows - 2;
//        while (currRow >= 0) {
//            int num = matrix[currRow][0];
//            for (int r = currRow + 1, c = 1; r < rows && c < cols; r++, c++) {
////                System.out.println("r: " + r + " c:" + c);
//                if (matrix[r][c] != num) return false;
//            }
//            currRow--;
//        }
//
//        if (cols > rows) {
////            System.out.println("?");
//            int currCol = cols - 2; // the second last on first row
//            while (currCol > 0) {
//                int num = matrix[0][currCol];
//                for (int r = 1, c = currCol + 1; r < rows && c < cols; r++, c++) {
////                    System.out.println("r: " + r + " c:" + c);
//                    if (matrix[r][c] != num) return false;
//                }
//                currCol--;
//            }
//        }
//
//        return true;
//    }


    /*
     *
     * Just need to compare with its top left cell
     *
     * */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows <= 0) return false;

        int cols = matrix[0].length;
        if (cols <= 0) return false;

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix sol = new ToeplitzMatrix();

        int[][] nums = {{
                1, 2, 3, 4
        }, {
                5, 1, 2, 3
        }, {
                9, 5, 1, 2
        }};
        System.out.println(sol.isToeplitzMatrix(nums));

        int[][] nums2 = {{
                1, 2
        }, {
                2, 2
        }};
        System.out.println(sol.isToeplitzMatrix(nums2));

        int[][] nums3 = {{
                11, 74, 0, 93
        }, {
                40, 11, 74, 7
        }};
        System.out.println(sol.isToeplitzMatrix(nums3));

        int[][] nums4 = {{
                11, 74
        }, {
                40, 12
        }, {
                40, 40
        }};
        System.out.println(sol.isToeplitzMatrix(nums4));
    }
}
