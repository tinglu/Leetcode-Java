package _973;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class KClosestPoints {
    //    Very naive way
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0) return new int[K][];

        if (K >= points.length) return points;

        Map<Integer, List<int[]>> distToPoint = new HashMap<>();

        List<int[]> sameDistPoints;
        for (int[] p : points) {
            if (p.length < 2) return new int[K][];

            int dist = p[0] * p[0] + p[1] * p[1];
            sameDistPoints = distToPoint.getOrDefault(dist, new ArrayList<>());
            sameDistPoints.add(p);
            distToPoint.put(dist, sameDistPoints);
        }

        int[] dists = new int[distToPoint.size()];
        int k = 0;
        Set<Integer> keys = distToPoint.keySet();
        for (int d : keys) {
            dists[k++] = d;
        }
        Arrays.sort(dists);

        int[][] results = new int[K][2];
        k = 0;
        while (K > 0) {
            sameDistPoints = distToPoint.get(dists[k]);
            int size = sameDistPoints.size();
            int i = 0;
            while (i < size && K > 0) {
                results[k] = sameDistPoints.get(i);
                k++;
                K--;
                i++;
            }
        }
        return results;
    }

    void printSet(Set<int[]> results) {
        for (int[] p : results) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }

    void printArray(int[][] A) {
        for (int[] p : A) {
            System.out.print(String.format("[%d,%d]", p[0], p[1]));
        }
        System.out.println("");
    }


    public static void main(String args[]) {
        KClosestPoints sol = new KClosestPoints();
//        int[][] A = {{0, 1}, {1, 0}};
//        for (int[] p : sol.kClosest(A, 2)) {
//            System.out.println(p[0] + ", " + p[1]);
//        }

        int[][] A = {{1, 2}, {2, 3}};
        for (int[] p : sol.kClosest(A, 3)) {
            System.out.println(p[0] + ", " + p[1]);
        }

    }
}
