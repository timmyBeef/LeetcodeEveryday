package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        // dfs to mark first island to 2
        // then bfs to find second island (value is 1)
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];

        boolean markFirstIslandOver = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !markFirstIslandOver) {
                    dfs(grid, i, j, visited);
                    markFirstIslandOver = true;
                }

                if (markFirstIslandOver && grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int cell[] = queue.poll();
                int i = cell[0];
                int j = cell[1];

                for (int dir[] : DIRECTIONS) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n)
                        continue; // cant put visited[][] here, grid[x][y] == 2 visited

                    if (grid[x][y] == 2) { // it must be visited
                        return level;

                    }
                    if (!visited[x][y]) { // zero case
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, boolean visited[][]) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return; // only mark with value is 1

        grid[i][j] = 2;
        visited[i][j] = true;
        for (int dir[] : DIRECTIONS) {
            dfs(grid, i + dir[0], j + dir[1], visited);
        }
    }


    public static void main(String[] args) {
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{0, 1}, {1, 0}}));
    }
}
