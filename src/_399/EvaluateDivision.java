package _399;

import java.util.*;

public class EvaluateDivision {

    // Not right - shouldn't use two graphs!
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Map<String, Map<String, Double>> graphForward = new HashMap<>();
//        Map<String, Map<String, Double>> graphReverse = new HashMap<>();
//
//        // Build graph - a map of map
//        int i = 0;
//        for (List<String> nodes : equations) {
//            String from = nodes.get(0);
//            String to = nodes.get(1);
//            double val = values[i];
//
//            Map<String, Double> adjFrom = graphForward.getOrDefault(from, new HashMap<>());
//            adjFrom.put(to, val);
//            graphForward.put(from, adjFrom);
//
//            Map<String, Double> adjTo = graphReverse.getOrDefault(to, new HashMap<>());
//            adjTo.put(from, 1 / val);
//            graphReverse.put(to, adjTo);
//
//            i++;
//        }
//
//        List<Double> list = new LinkedList<>();
//        for (List<String> nodes : queries) {
//            double result1 = dfs(graphForward, nodes.get(0), nodes.get(1));
//            double result2 = dfs(graphReverse, nodes.get(0), nodes.get(1));
//            list.add(Math.max(result1, result2));
//        }
//        double[] result = new double[list.size()];
//        int j = 0;
//        for (double d : list) {
//            result[j] = d;
//            j++;
//        }
//        return result;
//    }
//
//    private double dfs(Map<String, Map<String, Double>> graph, String from, String to) {
//        Map<String, Double> adj = graph.get(from);
//
//        if (adj == null) { // node not exists
//            return -1.0;
//        }
//
//        if (from.equals(to)) return 1.0;
//
//        double result = -1.0;
//        for (Map.Entry<String, Double> entry : adj.entrySet()) {
//            String neigh = entry.getKey();
//            double val = entry.getValue();
//            if (to.equals(neigh)) { // found path
//                return val;
//            }
//            result = val * dfs(graph, neigh, to);
//            if (result < 0) return -1.0;
//        }
//        return result;
//    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        Map<String, Boolean> visited = new HashMap<>();

        // Build graph - a map of map
        int i = 0;
        for (List<String> nodes : equations) {
            String from = nodes.get(0);
            String to = nodes.get(1);
            double val = values[i];

            visited.putIfAbsent(from, false);
            visited.putIfAbsent(to, false);

            Map<String, Double> adjFrom = graph.getOrDefault(from, new HashMap<>());
            adjFrom.put(to, val);
            graph.put(from, adjFrom);

            Map<String, Double> adjTo = graph.getOrDefault(to, new HashMap<>());
            adjTo.put(from, 1 / val);
            graph.put(to, adjTo);

            i++;
        }

        List<Double> list = new LinkedList<>();
        for (List<String> nodes : queries) {
            for (String key : visited.keySet()) {
                visited.put(key, false);
            }
            list.add(dfs(graph, nodes.get(0), nodes.get(1), visited));
        }
        double[] result = new double[list.size()];
        int j = 0;
        for (double d : list) {
            result[j] = d;
            j++;
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Map<String, Boolean> visited) {
//        System.out.println("\nvisited: " + visited);
//        System.out.println("form: " + from);
//        System.out.println("to: " + to);
        Map<String, Double> adj = graph.get(from);

        visited.put(from, true);

        if (adj == null) { // node not exists
            return -1.0;
        }

        if (from.equals(to)) {
            return 1.0;
        }

        double result = -1.0;
        List<Double> results = new ArrayList<>(); // !!! IMPORTANT LINE - SHOULD GET ALL POSSIBLE RESULTS AND GET THE
        // LARGEST ONE
        for (Map.Entry<String, Double> entry : adj.entrySet()) {
            String neigh = entry.getKey();
            double val = entry.getValue();

            if (!visited.get(neigh)) {
                double tmp = dfs(graph, neigh, to, visited);
                results.add(val * tmp);
            }
        }
        visited.put(from, false);
        for (double r : results) {
            result = Math.max(result, r);
        }
        return result < 0 ? -1.0 : result; // !!! IMPORTANT LINE
    }

    public static void main(String[] args) {
        EvaluateDivision sol = new EvaluateDivision();

//        List<List<String>> equations = new ArrayList<>();
//        equations.add(Arrays.asList("a", "b"));
//        equations.add(Arrays.asList("b", "c"));
//        equations.add(Arrays.asList("a", "e"));
//
//        double[] values = {2.0, 3.0, 5.0};
//        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("b", "a"));
//        queries.add(Arrays.asList("a", "e"));
//        queries.add(Arrays.asList("a", "a"));
//        queries.add(Arrays.asList("x", "x"));
//        queries.add(Arrays.asList("b", "e"));
//
//        double[] result = sol.calcEquation(equations, values, queries);
//        System.out.println(Arrays.toString(result));


        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));

        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x2", "x4"));

        double[] result = sol.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
