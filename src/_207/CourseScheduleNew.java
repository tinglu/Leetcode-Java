package _207;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * TODO: review later - simpler DFS TOPOLOGICAL SORT
 *
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * */
public class CourseScheduleNew {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        boolean[] visited = new boolean[numCourses];
        int[] visited = new int[numCourses]; // !!! use int array to represent visited status

        List<List<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependencies.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];
            dependencies.get(prereq[0]).add(prereq[1]); // prereq[0] dependent on prereq[1]
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(dependencies, i, visited)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> dependencies, int currCourse, int[] visited) {
        visited[currCourse] = 1; // mark as in process

        List<Integer> prereqs = dependencies.get(currCourse);

        for (int pre : prereqs) {
            /*
             * currCourse's this prereq is in the same visiting process - so cycle here !!!
             * */
            if (visited[pre] == 1) return false;
            /*
             * currCourse's this prereq is not visited yet
             * */
            if (visited[pre] == 0) {
                if (!dfs(dependencies, pre, visited)) return false;
            }
        }

        visited[currCourse] = 2; // mark as done visiting
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleNew sol = new CourseScheduleNew();
        int num = 5;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 2}};
        System.out.println(sol.canFinish(num, prerequisites));
    }
}
