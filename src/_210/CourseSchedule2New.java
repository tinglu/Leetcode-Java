package _210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule2New {
    private boolean isPossible;
    private List<Integer> order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses]; // !!! use int array to represent visited status
        isPossible = true;
        order = new ArrayList<>();

        List<List<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependencies.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];
            dependencies.get(prereq[0]).add(prereq[1]); // prereq[0] dependent on prereq[1]
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(dependencies, i, visited);
            }
        }

        int[] result;
        if (isPossible) {
            result = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
                result[i] = order.get(i);
            }
        } else {
            result = new int[0];
        }

        return result;
    }

    private void dfs(List<List<Integer>> dependencies, int currCourse, int[] visited) {
        if (!isPossible) return;

        visited[currCourse] = 1; // mark as in process

        List<Integer> prereqs = dependencies.get(currCourse);

        for (int pre : prereqs) {
            if (visited[pre] == 1) {
                /*
                 * currCourse's this prereq is in the same visiting process - so cycle here !!!
                 * */
                isPossible = false;
            } else if (visited[pre] == 0) {
                /*
                 * currCourse's this prereq is not visited yet
                 * */
                dfs(dependencies, pre, visited);
            }
        }

        visited[currCourse] = 2; // mark as done visiting
        order.add(currCourse);
    }

    public static void main(String[] args) {
        CourseSchedule2New sol = new CourseSchedule2New();
        System.out.println(Arrays.toString(sol.findOrder(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 2}})));
        System.out.println(Arrays.toString(sol.findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(sol.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
