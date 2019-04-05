package _240;


public class Search2DMatrix2 {
    //    My simple way: Locate row ranges then iterate these rows and locate target in each row
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length <= 0) return false;
//        if (matrix[0].length <= 0) return false;
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        int top = 0;
//        int bottom = rows - 1;
//        int mid;
//        while (top != bottom) {
//            mid = (top + bottom) / 2;
//            if (matrix[mid][0] == target) return true;
//
//            if (matrix[mid][0] > target) {
//                bottom = mid;
//            } else {
//                top = mid + 1;
//            }
//        }
//        int rowBottom = matrix[bottom][0] <= target ? bottom : bottom - 1;
//
//        top = 0;
//        bottom = rowBottom;
//        while (top != bottom) {
//            mid = (top + bottom) / 2;
//            if (matrix[mid][cols - 1] == target) return true;
//
//            if (matrix[mid][cols - 1] > target) {
//                bottom = mid;
//            } else {
//                top = mid + 1;
//            }
//        }
//
//        int rowTop = matrix[bottom][cols - 1] >= target ? bottom : bottom + 1;
//
////        System.out.println("bottom: " + bottom);
////        System.out.println("rowTop: " + rowTop);
////        System.out.println("rowBottom: " + rowBottom);
//
//        int left, right;
//
//        for (int i = rowTop; i <= rowBottom; i++) {
//            left = 0;
//            right = cols - 1;
//            while (left != right) {
//                mid = (left + right) / 2;
//                if (matrix[i][mid] == target) return true;
//                if (matrix[i][mid] < target) {
//                    left = mid + 1;
//                } else {
//                    right = mid;
//                }
//            }
//
////            System.out.println("right: " + right);
//            if (matrix[i][right] == target) return true;
//        }
//        return false;
//    }

    //    Start from top right
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                row += 1;
            } else {
                col -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix2 sol = new Search2DMatrix2();
        int[][] A = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(sol.searchMatrix(A, 5));
        System.out.println(sol.searchMatrix(A, 20));
        int[][] B = {{-5}};
        System.out.println(sol.searchMatrix(B, -5));
    }
}
