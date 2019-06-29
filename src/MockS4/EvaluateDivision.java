package MockS4;

import java.util.*;


/*
*
* 399. Evaluate Division
* https://leetcode.com/problems/evaluate-division/
*
* */
public class EvaluateDivision {
    private Map<String, HashMap<String, Double>> orgEdges = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            Set<String> visited = new HashSet<>();

            if (!orgEdges.containsKey(to)) { // destination not exist
                result[i] = -1;
            } else {
                result[i] = traverseGraph(visited, from, to);
            }
        }
        return result;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);

            HashMap<String, Double> fromEdges = orgEdges.getOrDefault(from, new HashMap<>());
            fromEdges.put(to, values[i]);
            orgEdges.put(from, fromEdges);

            HashMap<String, Double> toEdges = orgEdges.getOrDefault(to, new HashMap<>());
            toEdges.put(from, 1 / values[i]);
            orgEdges.put(to, toEdges);
        }
    }

    private double traverseGraph(Set<String> visited, String from, String to) {

        if (!orgEdges.containsKey(from)) return -1.0; // query nodes not exist

        HashMap<String, Double> fromEdges = orgEdges.get(from);

        if (from.equals(to)) return 1.0;

        visited.add(from);

        double result = -1.0;
        for (Map.Entry<String, Double> next : fromEdges.entrySet()) {

            String node = next.getKey();
            double val = next.getValue();

            if (!visited.contains(node)) {
                double tmp = val * traverseGraph(visited, node, to);
                if (tmp > 0) return tmp;
            }
        }
        visited.remove(from);

        return result;
    }

    public static void main(String[] args) {
        EvaluateDivision sol = new EvaluateDivision();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));

        double[] result = sol.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
