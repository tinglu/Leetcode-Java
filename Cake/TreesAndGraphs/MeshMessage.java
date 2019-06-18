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

// !!!!!!!!!!!TODO Finish this!!!!!!!!!!!!!
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

        if (!graph.containsKey(startNode)) return null;


        Queue<Neighbour> connections = new ArrayDeque<>();
        for (String s : graph.get(startNode)) {
            List<String> route = new LinkedList<>();
            route.add(startNode);
            Neighbour neighbour = new Neighbour(s, route);
            connections.add(neighbour);
        }

        Set<String> visited = new HashSet<>();
        visited.add(startNode);
//        System.out.println("Visited: " + visited);


//        helper(graph, connections, route, endNode, visited);

        while (!connections.isEmpty()) {
            Neighbour next = connections.remove();

//            System.out.println("\nVisited: " + visited);
//            System.out.println("next: " + next.name);
            if (!visited.contains(next.name)) {
                if (next.name.equals(endNode)) {
                    String[] r = next.route.toArray(new String[next.route.size()]);
//                    System.out.println(Arrays.toString(r));
                    return r;
                } else {
                    if (graph.containsKey(next.name)) {
                        for (String s : graph.get(next.name)) {
                            if (!visited.contains(s)) {
//                                System.out.println("next.name: " + next.name);
//                                System.out.println("route: " + Arrays.toString(next.route.toArray(new String[next
//                                .route.size()])));
                                Neighbour neighbour = new Neighbour(s, next.route);
                                connections.add(neighbour);
                            }

                        }
                    } else {
                        throw new IllegalArgumentException("not find this person");
                    }
                }

                visited.add(next.name);
            }

        }

        return null;
    }

//    private static void helper(Map<String, String[]> graph, Queue<String> connections, List<String> route,
//                               String endNode, Set<String> visited) {
//        while (!connections.isEmpty()) {
//            String next = connections.poll();
//            if (!visited.contains(next)) {
//                route.add(next);
//                if (next.equals(endNode)) {
//                    break;
//                } else {
//                    if (graph.containsKey(next)) {
//                        Collections.addAll(connections, graph.get(next));
//                        visited.add(next);
//                        helper(graph, connections, route, endNode, visited);
//                    }
//                }
//            } else {
//                helper(graph, connections, route, endNode, visited);
//            }
//
//        }
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