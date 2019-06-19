package TreesAndGraphs;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.*;

class Neighbour {
    String name;
    List<String> route;

    Neighbour(String n, List<String> r) {
        name = n;
        r.add(n);
        route = r;
    }
}

// !!!!!!!!!!!TODO: review later
/*
 *
 *
 * the complexity of the breadth-first search is O(N+M).
 * the total time complexity of our backtracking step is O(N).
 *
 * Putting these together, the time complexity of our entire algorithm is O(N+M)O(N+M).
 *
 *
 * overall space complexity is O(N).
 *
 * */
public class MeshMessage {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users

        if (!graph.containsKey(startNode) || !graph.containsKey(endNode))
            throw new IllegalArgumentException("Invalid start or end node");

        Map<String, String> howArriveHere = new HashMap<>();
        howArriveHere.put(startNode, null); // start point; also avoid going back to the start


        /*
         *
         * This is DFS actually!!!!!
         *
         * */
//        if (bfs(graph, startNode, endNode, howArriveHere)) {
//            return buildPath(howArriveHere, startNode, endNode);
//        }



        /*
         *
         * Write proper BFS using queue!!!!!
         *
         *
         * ONLY BFS GUARANTEES TO GET SHORTEST PATH!
         *
         * */
        Queue<String> toVisit = new ArrayDeque<>();
        toVisit.add(startNode);

        while (!toVisit.isEmpty()) {
            String curr = toVisit.poll();

            if (curr.equals(endNode)) {
                return buildPath(howArriveHere, startNode, endNode);
            }

            for (String next : graph.get(curr)) {
                if (!howArriveHere.containsKey(next)) {
                    howArriveHere.put(next, curr);
                    toVisit.add(next);
                }
            }
        }

        return null;
    }

    private static String[] buildPath(Map<String, String> howArriveHere, String startNode, String endNode) {
        List<String> path = new ArrayList<>();
        String currNode = endNode;

        while (!currNode.equals(startNode)) {
            path.add(currNode);
            currNode = howArriveHere.get(currNode);
        }

        path.add(startNode);
        Collections.reverse(path);
        return path.toArray(new String[path.size()]);
    }

    /*
     *
     * This is DFS actually!!!!!
     *
     * */
//    private static boolean bfs(Map<String, String[]> graph, String startNode, String endNode,
//                               Map<String, String> howArriveHere) {
//
//        if (startNode.equals(endNode)) return true;
//
//        if (graph.get(startNode) == null) return false;
//
//        for (String next : graph.get(startNode)) {
//            if (!howArriveHere.containsKey(next)) {
//                howArriveHere.put(next, startNode);
//                if (bfs(graph, next, endNode, howArriveHere)) return true;
//            }
//        }
//        return false;
//    }


    // tests

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
    }

    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() {
            {
                put("a", new String[]{"b", "c", "d"});
                put("b", new String[]{"a", "d"});
                put("c", new String[]{"a", "e"});
                put("d", new String[]{"a", "b"});
                put("e", new String[]{"c"});
                put("f", new String[]{"g"});
                put("g", new String[]{"f"});
            }
        };
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MeshMessage.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}