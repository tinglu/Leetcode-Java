package TreesAndGraphs;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.fail;

public class GraphColouring {

    public static class GraphNode {

        private String label;
        private Set<GraphNode> neighbors;
        private Optional<String> color;

        public GraphNode(String label) {
            this.label = label;
            neighbors = new HashSet<GraphNode>();
            color = Optional.empty();
        }

        public String getLabel() {
            return label;
        }

        public Set<GraphNode> getNeighbors() {
            return Collections.unmodifiableSet(neighbors);
        }

        public void addNeighbor(GraphNode neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasColor() {
            return color.isPresent();
        }

        public String getColor() {
            return color.get();
        }

        public void setColor(String color) {
            this.color = Optional.ofNullable(color);
        }
    }


    /*
     * !!!!!!!!!!!TODO: read the time complexity analysis again
     *
     *
     * O(N+M) time where N is the number of nodes and M is the number of edges.
     *
     * The runtime might not look linear because we have outer and inner loops. The trick is to look at each step and
     * think of things in terms of the total number of edges (M) wherever we can:
     *
     * We check if each node appears in its own hash set of neighbors.
     * Checking if something is in a hash set is O(1), so doing it for all N nodes is O(N).
     *
     * When we get the illegal (used) colors for each node, we iterate through that node's neighbors. So in total, we
     * cross each of the graphs M edges twice: once for the node on either end of each edge. O(2*M) --> O(M) time.
     *
     * When we assign a color to each node, we're careful to stop checking colors as soon as we find one that works.
     * In the worst case, we'll have to check one more color than the total number of neighbors. Again, each edge in
     * the graph adds two neighbors — one for the node on either end—so there are 2*M neighbors. So, in total, we'll
     * have to try O(N(1 + k)) -> 1 is for extra color if all neigbours are assigned colors --> O(N + N*k) --> O(N + M)
     * colors.
     *
     * Putting all the steps together, our complexity is O(N + 2M + N+M) --> O(N+M).
     *
     *
     * The only thing we're storing is the illegalColors hash set. In the worst case, all the neighbors of a node
     * with the maximum degree (D) have different colors, so our hash set takes up O(D) space.
     *
     *
     * */
    public static void colorGraph(GraphNode[] graph, String[] colors) {

        // create a valid coloring for the graph

        if (graph.length < 1) return;

        Set<String> usedColors;

        for (GraphNode currNode : graph) {

            Set<GraphNode> neighbours = currNode.neighbors;

            if (!currNode.hasColor()) {

                usedColors = new HashSet<>();

                for (GraphNode neigh : neighbours) {
                    if (neigh.equals(currNode)) throw new IllegalArgumentException("GraphNode cannot be neighbour of " +
                            "itself");

                    if (neigh.hasColor()) {
                        usedColors.add(neigh.getColor());
                    }
                }

                for (String color : colors) {
                    if (!usedColors.contains(color)) {
                        currNode.setColor(color);
                        break;
                    }
                }
            }
        }
    }


    // tests

    @Test
    public void lineGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeC.addNeighbor(nodeB);
        nodeC.addNeighbor(nodeD);
        nodeD.addNeighbor(nodeC);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void separateGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeD);
        nodeD.addNeighbor(nodeC);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void triangleGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeC.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeB);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test
    public void envelopeGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        final GraphNode nodeB = new GraphNode("B");
        final GraphNode nodeC = new GraphNode("C");
        final GraphNode nodeD = new GraphNode("D");
        final GraphNode nodeE = new GraphNode("E");
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeA);
        nodeC.addNeighbor(nodeB);
        nodeC.addNeighbor(nodeD);
        nodeC.addNeighbor(nodeE);
        nodeD.addNeighbor(nodeB);
        nodeD.addNeighbor(nodeC);
        nodeD.addNeighbor(nodeE);
        nodeE.addNeighbor(nodeB);
        nodeE.addNeighbor(nodeC);
        nodeE.addNeighbor(nodeD);
        final GraphNode[] graph = new GraphNode[]{nodeA, nodeB, nodeC, nodeD, nodeE};
        colorGraph(graph, getColors());
        validateGraphColoring(graph);
    }

    @Test(expected = Exception.class)
    public void loopGraphTest() {
        final GraphNode nodeA = new GraphNode("A");
        nodeA.addNeighbor(nodeA);
        final GraphNode[] graph = new GraphNode[]{nodeA};
        colorGraph(graph, getColors());
    }

    private static String[] getColors() {
        return new String[]{"red", "green", "blue", "orange", "yellow", "white"};
    }

    private static void validateGraphColoring(GraphNode[] graph) {

        for (final GraphNode node : graph) {
            if (!node.hasColor()) {
                fail(String.format("Found non-colored node %s", node.getLabel()));
            }
        }

        int maxDegree = 0;
        final Set<String> usedColors = new HashSet<>();

        for (final GraphNode node : graph) {
            final Set<GraphNode> neighbors = node.getNeighbors();
            maxDegree = Math.max(maxDegree, neighbors.size());
            usedColors.add(node.getColor());
        }

        final int allowedColorCount = maxDegree + 1;

        if (usedColors.size() > allowedColorCount) {
            fail(String.format("Too many colors: %d allowed, but %d actually used",
                    allowedColorCount, usedColors.size()));
        }

        for (final GraphNode node : graph) {
            final Set<GraphNode> neighbors = node.getNeighbors();
            for (final GraphNode neighbor : neighbors) {
                if (neighbor.getColor().equals(node.getColor())) {
                    fail(String.format("Neighbor nodes %s and %s have the same color %s",
                            node.getLabel(), neighbor.getLabel(), node.getColor()));
                }
            }
        }
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(GraphColouring.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}