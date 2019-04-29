package Mock2;

import java.util.HashSet;
import java.util.Set;

// 939. Minimum Area Rectangle
//Time Complexity: O(N^2), where N is the length of points.
// Space Complexity: O(N).
public class MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }
        int minArea = Integer.MAX_VALUE; // !!! ASKING FOR MIN AREA!!!! LOOK CAREFULLY AT QUESTIONS!!!

        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

//            System.out.println(String.format("x1: %d, y1: %d", x1, y1));
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] != x1 && points[j][1] != y1) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
//                    System.out.println(String.format("x2: %d, y2: %d", x2, y2));

                    if (pointSet.contains(x1 + "," + y2) && pointSet.contains(x2 + "," + y1)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        MinAreaRectangle sol = new MinAreaRectangle();
//        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        System.out.println(sol.minAreaRect(points));
    }
}
