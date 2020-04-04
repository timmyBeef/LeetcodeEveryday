package leetcode.backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) return true;

                            board[i][j] = '.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 因為沒有用 set
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            char rowVal = board[row][i];
            if (rowVal != '.' && rowVal == c) return false;

            char colVal = board[i][col];
            if (colVal != '.' && colVal == c) return false;

            char boxVal = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3];
            if (boxVal != '.' && boxVal == c) return false;
        }
        return true;
    }


    public void solveSudoku2(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int d) {
        if (d == 81) return true; //terminator

        int i = d / 9; // row index
        int j = d % 9; // col index

        if (board[i][j] != '.') {

            return dfs(board, d + 1); // prefill number skip 已經被佔了, 跑下一層
        }

        // 其他是 . , 就要做 validate...
        boolean[] flag = new boolean[10];
        validate(board, i, j, flag);

        for (char c = '1'; c <= '9'; c++) { // validate通過後, 嘗試填入1~9
            if (flag[c]) {
                board[i][j] = c;
                if (dfs(board, d + 1)) return true; //繼續dfs
            }
        }
        board[i][j] = '.'; //if can not solve, in the wrong path, change back to '.' and out

        return false;
    }

    // 用 row, col 判斷, i j
    // flag 用來存1~9是否有重複的
    private void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);

        for (int k = 0; k < 9; k++) {

            if (board[i][k] != '.') flag[board[i][k] - '0'] = false;
            if (board[k][j] != '.') flag[board[k][j] - '0'] = false;

            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;

            if (board[r][c] != '.') flag[board[r][c] - '0'] = false;
        }
    }
}
