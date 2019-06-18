package Mock4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


// TODO: review later

public class CampusBikes {

    /*
     * Start finding solutions for each worker - instead of finding worker for each bike!?
     *
     * Wrong answer - didn't pass all tests
     * */
//    public int[] assignBikes(int[][] workers, int[][] bikes) {
//        int M = bikes.length;
//        int N = workers.length;
//
//        Map<Integer, HashMap<Integer, Integer>> bikeLocToId = new HashMap<>();
//        for (int i = 0; i < M; i++) {
//            int x = bikes[i][0];
//            int y = bikes[i][1];
//            HashMap<Integer, Integer> bikeOnX = bikeLocToId.getOrDefault(x, new HashMap<>());
//            bikeOnX.put(y, i);
//            bikeLocToId.put(x, bikeOnX);
//        }
//        System.out.println(bikeLocToId);
//
//        int[] result = new int[N];
//        int assigned = 0;
//
//        for (int w = 0; w < N; w++) {
//            int i = workers[w][0];
//            int j = workers[w][1];
//
//            int bikeId = findClosestBike(i, j, bikeLocToId);
//            System.out.println("i: " + i + "; j: " + j + "; bikeId: " + bikeId + "; w: " + w);
//            if (bikeId != Integer.MAX_VALUE) {
//                result[w] = bikeId;
//                assigned += 1;
//            }
//            if (assigned == N) break;
//        }
//        return result;
//    }
//
//    private int findClosestBike(int x, int y, Map<Integer, HashMap<Integer, Integer>> bikeLocToId) {
//        int smallestBikeId = Integer.MAX_VALUE;
//        int bikeX = Integer.MAX_VALUE;
//        int bikeY = Integer.MAX_VALUE;
//        int k = 1;
//        while (k <= 1000 && smallestBikeId == Integer.MAX_VALUE) {
//
//            /*
//             * Distance = 1
//             * */
//            if (bikeLocToId.containsKey(x) && bikeLocToId.get(x).containsKey(y + k)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x).get(y + k));
//                int newId = bikeLocToId.get(x).get(y + k);
//                if (newId < smallestBikeId) {
//                    smallestBikeId = newId;
//                    bikeX = x;
//                    bikeY = y + k;
//                }
//            }
//            if (bikeLocToId.containsKey(x) && bikeLocToId.get(x).containsKey(y - k)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x).get(y - k));
//                int newId = bikeLocToId.get(x).get(y - k);
//                if (newId < smallestBikeId) {
//                    smallestBikeId = newId;
//                    bikeX = x;
//                    bikeY = y - k;
//                }
//            }
//            if (bikeLocToId.containsKey(x - k) && bikeLocToId.get(x - k).containsKey(y)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x - k).get(y));
//                int newId = bikeLocToId.get(x - k).get(y);
//                if (newId < smallestBikeId) {
//                    smallestBikeId = newId;
//                    bikeX = x - k;
//                    bikeY = y;
//                }
//            }
//            if (bikeLocToId.containsKey(x + k) && bikeLocToId.get(x + k).containsKey(y)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x + k).get(y));
//                int newId = bikeLocToId.get(x + k).get(y);
//                if (newId < smallestBikeId) {
//                    smallestBikeId = newId;
//                    bikeX = x + k;
//                    bikeY = y;
//                }
//            }
//
//            /*
//             * Distance = even number --> find diagonal points
//             * */
//            if (k % 2 == 0) {
//                if (bikeLocToId.containsKey(x - k / 2) && bikeLocToId.get(x - k / 2).containsKey(y - k / 2)) {
//                    int newId = bikeLocToId.get(x - k / 2).get(y - k / 2);
//                    if (newId < smallestBikeId) {
//                        smallestBikeId = newId;
//                        bikeX = x - k / 2;
//                        bikeY = y - k / 2;
//                    }
//                }
//                if (bikeLocToId.containsKey(x - k / 2) && bikeLocToId.get(x - k / 2).containsKey(y + k / 2)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x - k/2).get(y + k/2));
//                    int newId = bikeLocToId.get(x - k / 2).get(y + k / 2);
//                    if (newId < smallestBikeId) {
//                        smallestBikeId = newId;
//                        bikeX = x - k / 2;
//                        bikeY = y + k / 2;
//                    }
//                }
//                if (bikeLocToId.containsKey(x + k / 2) && bikeLocToId.get(x + k / 2).containsKey(y - k / 2)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x + k/2).get(y - k/2));
//                    int newId = bikeLocToId.get(x + k / 2).get(y - k / 2);
//                    if (newId < smallestBikeId) {
//                        smallestBikeId = newId;
//                        bikeX = x + k / 2;
//                        bikeY = y - k / 2;
//                    }
//                }
//                if (bikeLocToId.containsKey(x + k / 2) && bikeLocToId.get(x + k / 2).containsKey(y + k / 2)) {
////                smallestBikeId = Math.min(smallestBikeId, workerLocToID.get(x + k/2).get(y + k/2));
//                    int newId = bikeLocToId.get(x + k / 2).get(y + k / 2);
//                    if (newId < smallestBikeId) {
//                        smallestBikeId = newId;
//                        bikeX = x + k / 2;
//                        bikeY = y + k / 2;
//                    }
//                }
//            }
//
//            k++;
//        }
//
//        System.out.println("smallestBikeId: " + smallestBikeId + " bikeX: " + bikeX + "; bikeY: " + bikeY);
//
//        if (bikeLocToId.containsKey(bikeX)) bikeLocToId.get(bikeX).remove(bikeY);
//        return smallestBikeId;
//    }


    /*
     *
     * Use priority queue
     *
     * */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int M = bikes.length;
        int N = workers.length;


        /*
        *
        * a[dist, workerIdx, bikeIdx] !!!!
        *
        * */
        PriorityQueue<int[]> workerBikeDist = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int w = 0; w < N; w++) {
            int[] worker = workers[w];

            for (int b = 0; b < M; b++) {
                int[] bike = bikes[b];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                workerBikeDist.add(new int[]{dist, w, b});
            }
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);

        Set<Integer> assignedBikes = new HashSet<>();
        while (assignedBikes.size() < N) {
            int[] pair = workerBikeDist.poll();
            if (pair != null && result[pair[1]] == -1 && !assignedBikes.contains(pair[2])) {
                // worker is not assigned yet
                result[pair[1]] = pair[2];
                assignedBikes.add(pair[2]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CampusBikes sol = new CampusBikes();

//        int[][] workers = {{0, 0}, {2, 1}};
//        int[][] bikes = {{1, 2}, {3, 3}};
//        int[] result = sol.assignBikes(workers, bikes);
//        System.out.println(Arrays.toString(result));

        int[][] workers2 = {{0, 0}, {1, 1}, {2, 0}};
        int[][] bikes2 = {{1, 0}, {2, 2}, {2, 1}};
        int[] result2 = sol.assignBikes(workers2, bikes2);
        System.out.println(Arrays.toString(result2));

//        [[240,446],[745,948],[345,136],[341,68],[990,165],[165,580],[133,454],[113,527]]
//[[696,140],[95,393],[935,185],[767,205],[387,767],[214,960],[804,710],[956,307]]
    }
}
