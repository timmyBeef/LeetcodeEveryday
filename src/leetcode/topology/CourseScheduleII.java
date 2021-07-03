package leetcode.topology;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    210
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/topology/210.-course-schedule-ii
    time: O(V+E)
    space: O(n)
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        int res[] = new int[numCourses];

        for (int p[] : prerequisites) {
            indegree[p[0]]++;
        }
        System.out.println(Arrays.toString(indegree));

        int k = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
                System.out.println("indegree == 0");
            }
        }
        System.out.println(Arrays.toString(res));

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int p[] : prerequisites) {
                if (pre == p[1]) {
                    indegree[p[0]]--;
                    if (indegree[p[0]] == 0) {
                        queue.offer(p[0]);
                        res[k++] = p[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }

    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2, new int[][]{{0,1},{1,0}});
    }
}
