package leetcode.graph;

/*

Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.

Input:
11110
11010
11000
00000

Output: 1

Input:
11000
11000
00100
00011

Output: 3


 USE DFS (why, use to visit node, and mark visited,
 so in the later we will not count it as an island again)
 https://leetcode.com/problems/number-of-islands/solution/

     step1: define the variable n: graph's height, m: width, count: the count of island

     step2: traveral all node, if hit 1, it means an island's start, count++
     then dfs the adjent node, if visited mark '0', use dfs to mark visited node

     condition limit: out of range && not island
     if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;

    use flood fill, use dfs to traverse all island, and mark vistied

    time complexity: O(n*m),
    space complexity: O(1), n is grid's height, m is grid's width

 */
public class NumberOfIslands {
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int n; // graph's height
    private int m; // width

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;

        m = grid[0].length;

        int count = 0; // the count of island

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') { // an island's start
                    dfs(grid, i, j); //run dfs, run through an island
                    count++; // count of island++
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;

        grid[i][j] = '0'; // mark visited

        for (int d[] : directions) {
            dfs(grid, i + d[0], j + d[1]); // toward different directions...
        }

    }

    public static void main(String args[]) {
        char[][] input = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new NumberOfIslands().numIslands(input));

        System.out.println("12345".substring(1));

    }
}
