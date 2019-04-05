package _74;

public class Search2DMatrix1 {
//    My naive iterate  O(m+n)
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length <= 0) return false;
//        if (matrix[0].length <= 0) return false;
//        int r;
//        for (r = 0; r < matrix.length; r++) {
//            if (matrix[r][0] > target)
//                break;
//        }
//        int targetRow = r == 0 ? 0 : r - 1;
//        int[] row = matrix[targetRow];
//        for (int c = 0; c < row.length; c++) {
//            if (row[c] == target) return true;
//        }
//        return false;
//    }

    //    Use divide and mod to calc row and column O(log(m*n))
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0) return false;
        if (matrix[0].length <= 0) return false;
        int r = matrix.length;
        int c = matrix[0].length;

        int i = 0;
        int j = r * c - 1;

        int mid;
        int curr;
        while (i != j) {
            mid = (i + j) / 2;

            curr = matrix[mid / c][mid % c];
            System.out.println("mid: " + mid);
            System.out.println("mid / c: " + mid / c);
            System.out.println("mid % c: " + mid % c);
            System.out.println("curr: " + curr);
            if (curr == target) return true;
            if (curr < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return matrix[j / c][j % c] == target;
    }

    public static void main(String[] args) {
        Search2DMatrix1 sol = new Search2DMatrix1();
        int[][] A = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(sol.searchMatrix(A, 3));
    }
}
