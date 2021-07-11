package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
    542. 01 Matrix
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/542.-01-matrix

    time: O(mn)
    space: O(mn)
 */
public class ZeroOneMatrix {
    class Solution {
        private static final int DIRECTIONS[][] = {{0,1}, {1, 0}, {0, -1}, {-1,0}};

        public int[][] updateMatrix(int[][] mat) {
            // BFS from 0 to find 1, record dist in res, run all queue level++
            int m = mat.length, n = mat[0].length;
            int[][] res = new int[m][n];

            boolean vistited[][] = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j}); // 00 01 02 10 12
                        vistited[i][j] = true;
                    }
                }
            }
            int dist = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int q = 0; q < size; q++) {
                    int cell[] = queue.poll();
                    int i = cell[0];
                    int j = cell[1];
                    if (mat[i][j] == 1) {
                        res[i][j] = dist;
                    }
                    for (int dir[] : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >=0 && y < n && !vistited[x][y]) {
                            queue.offer(new int[]{x, y});
                            vistited[x][y] = true;
                        }
                    }
                }
                dist++;
            }
            return res;
        }
    }

    class Solution2 {
        private static final int DIRECTIONS[][] = {{0,1}, {1, 0}, {0, -1}, {-1,0}};

        public int[][] updateMatrix(int[][] mat) {
            // BFS from 0 to find 1, put 0 into queue, 1 mark MAX, so when meet MAX, if new node (MAX) > prenode+1
            // update new node = prenode+1
            int m = mat.length, n = mat[0].length;

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j}); // 00 01 02 10 12
                    } else {
                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int q = 0; q < size; q++) {
                    int cell[] = queue.poll();
                    int i = cell[0];
                    int j = cell[1];
                    for (int dir[] : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >=0 && y < n && mat[x][y] > mat[i][j] + 1) {
                            queue.offer(new int[]{x, y});
                            mat[x][y] = mat[i][j] + 1;
                        }
                    }
                }
            }
            return mat;
        }
    }
}
