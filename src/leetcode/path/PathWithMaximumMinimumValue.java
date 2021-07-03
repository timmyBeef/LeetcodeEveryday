package leetcode.path;

import java.util.PriorityQueue;

/*
    1102. Path With Maximum Minimum Value

    time: O(m*n * log(m*n))
    space: O(m*n) // visited matrix

    use Dijkstra's algo
 */
public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] grid) {
        if (grid == null || grid.length > 0 && grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int maxScore = grid[0][0];

        int dir[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            int cell[] = pq.poll();
            int score = cell[0];
            int row = cell[1];
            int col = cell[2];
            maxScore = Math.min(maxScore, score);
            if (row == m - 1 && col == n - 1) {
                return maxScore;
            }
            for (int d[] : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    pq.offer(new int[]{grid[newRow][newCol], newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return maxScore;
    }

}
