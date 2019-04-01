package _447;

import java.util.HashMap;
import java.util.Map;

public class Boomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    // calc distance from i to j
                    int dist = dist(points[i], points[j]);
                    distanceMap.put(dist, distanceMap.getOrDefault(dist, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }

            distanceMap.clear();
        }

        return res;
    }

    private int dist(int[] posA, int[] posB) {
        return (posA[0] - posB[0]) * (posA[0] - posB[0]) + (posA[1] - posB[1]) * (posA[1] - posB[1]);
    }

    public static void main(String args[]) {
        Boomerangs boo = new Boomerangs();
//        int[][] A = {{0, 0}, {1, 0}, {2, 0}};
        int[][] A = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(boo.numberOfBoomerangs(A));
    }
}
