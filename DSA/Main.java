import java.util.*;

public class Main {

    static <T> void printList(List<T> ls) {
        for (T el : ls) {
            System.out.print(String.valueOf(el));
            System.out.print(", ");
        }
        System.out.println();
    }


    List<Vertex> dfs(Graph g) {
        List<Vertex> result = new ArrayList<>();
        for (Map.Entry<Vertex, List<Vertex>> edge : g.edges.entrySet()) {
            Vertex vertex = edge.getKey();
            if (!vertex.visited) {
                result.add(vertex);
                vertex.visited = true;

                List<Vertex> connectedVertices = edge.getValue();
                _dfs(g, connectedVertices, result);
            }
        }
        return result;
    }

    void _dfs(Graph g, List<Vertex> connectedVertices, List<Vertex> result) {
        for (Vertex currVertex : connectedVertices) {
            if (!currVertex.visited) {
                result.add(currVertex);
                currVertex.visited = true;

                List<Vertex> nextConnection = g.edges.get(currVertex);
                if (nextConnection != null) {
                    _dfs(g, nextConnection, result);
                }
            }
        }
    }


    void testGraph() {
        List<Vertex> vs = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            Vertex vt = new Vertex(i);
            vs.add(vt);
        }
        Graph g = new Graph(vs);
        Edge e = new Edge(new Vertex(1), new Vertex(2));
        g.addEdge(e);
        e = new Edge(new Vertex(2), new Vertex(4));
        g.addEdge(e);
        e = new Edge(new Vertex(2), new Vertex(5));
        g.addEdge(e);
        e = new Edge(new Vertex(3), new Vertex(4));
        g.addEdge(e);
        g.printGraph();

        System.out.println("dfs:");
        List<Vertex> result = dfs(g);
        printList(result);
    }

    public static void main(String[] args) {

//        char v1[] = {'c'};
//        v1 = new char[]{8};
//
//        String s1 = "a";
//        System.out.println(s1.hashCode());
//        s1 = "b";
//        System.out.println(s1.hashCode());
//
//        char[] v2 = {'c'};


//        int[] xs = {100, 76, 0, 2, 3, 5, 6, 4, 123};
//        System.out.println(Arrays.toString(MergeSort.mergeSort(xs)));
//
//
//        List<Integer> ls = new ArrayList<>();
//        for (int x : xs) {
//            ls.add(x);
//        }
//        List<Integer> sorted = QuickSort.quickSort(ls);
//        for (int i : sorted) {
//            System.out.print(String.valueOf(i));
//            System.out.print(", ");
//        }
//        System.out.println();
//
//
//        System.out.println(Arrays.toString(BubbleSort.bubbleSort(xs)));


        LinkedList<Integer> ls = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            ls.add(i);
        }
        List<Integer> ls2 = new LinkedList<>();
        while (ls.size() > 0) {
            int last = ls.removeLast();
            ls2.add(last);
        }
        printList(ls2);


        Main main = new Main();
        main.testGraph();

    }


    class Vertex {
        int vt;
        boolean visited;

        Vertex(int v) {
            this.vt = v;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return vt == vertex.vt;
        }

        @Override
        public int hashCode() {
            return vt;
        }

        public String toString() {
            return String.valueOf(vt);
        }
    }

    class Edge {
        Vertex from;
        Vertex to;

        Edge(Vertex f, Vertex t) {
            this.from = f;
            this.to = t;
        }
    }

    class Graph {
        Map<Vertex, List<Vertex>> edges = new HashMap<>();

        Graph(List<Vertex> vs) {
            for (Vertex v : vs) {
                edges.put(v, new ArrayList<>());
            }
        }

        void addEdge(Edge e) {
            List<Vertex> ve = edges.get(e.from);
            if (ve == null) {
                edges.put(e.from, new ArrayList<>());
            }
            ve.add(e.to);

        }

        void printGraph() {
            for (Map.Entry<Vertex, List<Vertex>> e : edges.entrySet()) {
                System.out.println("key: " + e.getKey().vt);
                printList(e.getValue());
            }
        }
    }

}
