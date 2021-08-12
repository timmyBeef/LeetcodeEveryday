package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
    317. Shortest Distance from All Buildings
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/317.-shortest-distance-from-all-buildings

    time: O(m*n*BFS) = O(m^2*n^2)
    space: O(m*n)
 */
public class ShortestDistanceFromAllBuildings {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int dist[][] = new int[m][n];
        int nums[][] = new int[m][n];

        int buildingNums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // node 1 do BFS
                    buildingNums++;
                    bfs(grid, i, j, dist, nums);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (buildingNums == nums[i][j] && grid[i][j] == 0 && dist[i][j] != 0) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int cell[] = queue.poll();
                for (int dir[] : DIRECTIONS) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                        dist[x][y] += distance;
                        nums[x][y]++;
                    }
                }
            }
        }
    }
}
