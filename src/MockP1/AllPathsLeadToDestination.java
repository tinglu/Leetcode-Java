package MockP1;

import java.util.*;

// TODO: REVIEW LATER

/*
* first submission stackoverflow
* */
public class AllPathsLeadToDestination {
//    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
//        if (edges.length < n - 1) return false; // at least n-1 edges to reach from source to destination
//
//        Map<Integer, Set<Integer>> edgeMaps = new HashMap<>();
//        for (int i = 0; i < edges.length; i++) {
//            Set<Integer> neigh = edgeMaps.getOrDefault(edges[i][0], new HashSet<>());
//            neigh.add(edges[i][1]);
//            edgeMaps.put(edges[i][0], neigh);
//        }
//
//        // destination infinite loop
//        if (edgeMaps.containsKey(destination)) return false;
//
//        Set<Integer> visited = new HashSet<>();
//
//        visited.add(source);
////        if (!edgeMaps.containsKey(source)) return false; // cannot go out from source
//
////        Set<Integer> neigh = edgeMaps.get(source);
////        for (Integer next : neigh) {
////            visited.add(next);
////            if (!helper(next, visited, edgeMaps, destination)) return false;
////            visited.remove(next);
////        }
////        return true;
//        /*
//        *
//        *
//        * Call DFS directly!!!
//        *
//        *
//        * */
//        return helper(source, destination, visited, edgeMaps);
//    }
//
//    private boolean helper(int source, int destination, Set<Integer> visited, Map<Integer, Set<Integer>> edgeMaps) {
//        if (!edgeMaps.containsKey(source)) return source == destination;
//
//        Set<Integer> neigh = edgeMaps.get(source);
//        for (Integer next : neigh) {
//            if (visited.contains(next)) return false;
//            visited.add(next);
//            if (!helper(next, destination, visited, edgeMaps)) return false;
//            visited.remove(next);
//        }
//        return true;
//    }


    /*
     * Use List<Integer>[] to build the di-graph
     *
     *
     * FASTER THAN HASHMAP!
     * */
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (edges.length < n - 1) return false; // at least n-1 edges to reach from source to destination

        List<Integer>[] edgeMaps = new List[n];
        for (int[] edge : edges) {
            if (edgeMaps[edge[0]] == null) {
                edgeMaps[edge[0]] = new ArrayList<>();
            }
            edgeMaps[edge[0]].add(edge[1]);
        }

        // destination infinite loop
//        if (edgeMaps.containsKey(destination)) return false;

        Set<Integer> visited = new HashSet<>();

        visited.add(source);

        /*
         *
         *
         * Call DFS directly!!!
         *
         *
         * */
        return dfs(source, destination, visited, edgeMaps);
    }

    private boolean dfs(int source, int destination, Set<Integer> visited, List<Integer>[] edgeMaps) {
        List<Integer> neigh = edgeMaps[source];

        if (neigh == null) return source == destination;

        for (Integer next : neigh) {
            if (visited.contains(next)) return false;
            visited.add(next);
            if (!dfs(next, destination, visited, edgeMaps)) return false;
            visited.remove(next);
        }
        return true;
    }

    public static void main(String[] args) {
        AllPathsLeadToDestination sol = new AllPathsLeadToDestination();

        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(sol.leadsToDestination(3, edges, 0, 2));

        int[][] edges2 = {{0, 1}, {0, 3}, {1, 2}, {2, 1}};
        System.out.println(sol.leadsToDestination(4, edges2, 0, 3));

        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(sol.leadsToDestination(4, edges3, 0, 3));


        int[][] edges4 = {{0, 1}, {1, 1}, {1, 2}};
        System.out.println(sol.leadsToDestination(3, edges4, 0, 2));

        int[][] edges5 = {{0, 1}, {1, 1}};
        System.out.println(sol.leadsToDestination(2, edges5, 0, 1));


        int[][] edges6 = {};
        System.out.println(sol.leadsToDestination(1, edges6, 0, 0));
    }
}
