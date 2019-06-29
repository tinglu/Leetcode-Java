package _332;

import java.util.*;


/*
 *
 * TODO: Review this!
 *
 * */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));

        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                // System.out.println();
                // System.out.print(stack.peek() + "  ");
                stack.push(targets.get(stack.peek()).poll());
                // System.out.println(stack);
            }

            String s = stack.pop();
            System.out.println(s);
            route.add(0, s);
        }
        return route;
    }

    public static void main(String[] args) {
        ReconstructItinerary sol = new ReconstructItinerary();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
        tickets.add(new ArrayList<>(Arrays.asList("LHR", "SFO")));

        List<String> result = sol.findItinerary(tickets);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
