package leetcode.topology;

import java.util.LinkedList;
import java.util.Queue;
/*
    207
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/topology/207.-course-schedule

    time: O(V+E)
    space: O(n)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topology order
        int indegree[] = new int[numCourses];
        int res = numCourses;
        for (int pair[] : prerequisites) { // why indegree, find indegree == 0 start to finish, that's the solution
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // add indegree == 0 as start point
            }
        }

        // [4,3] => graph: 3-4. => indegree => 3: 0, 4: 1
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int pair[] : prerequisites) {
                if (pre == pair[1]) { // when pair[1](prerequisites) match the start point
                    indegree[pair[0]]--; // do --
                    if (indegree[pair[0]] == 0) { // pair[0]'s indegree == 0, means pair[0] can be a new start point
                        queue.offer(pair[0]); // add start point
                    }
                }
            }
        }
        return res == 0; // means we finish all courses
    }
}
