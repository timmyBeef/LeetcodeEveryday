package leetcode.path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    1631. Path With Minimum Effort

    time: O(m*n * log(m*n))
    space: O(m*n) // efftor matrix

    use Dijkstra's algo
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(effort[i], Integer.MAX_VALUE);

        // PriorityQueue accept int[] : new_dist(effort), row, col
        // poll min by minimum new_dist(effort), so a -> a[0]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 4 direction search neighbors
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];

            if (dist > effort[row][col]) continue; // dist > effort, no update
            if (row == m - 1 && col == n - 1) return dist; // arrive last cell, complete and return result

            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) { // check boudary
                    // find new effort
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newDist < effort[newRow][newCol]) { // if new effor is smaller
                        effort[newRow][newCol] = newDist;
                        pq.offer(new int[]{newDist, newRow, newCol}); // add to pq to be the next candidate
                    }
                }
            }
        }
        return 0;
    }
}
