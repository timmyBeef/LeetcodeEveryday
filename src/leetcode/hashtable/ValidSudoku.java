package leetcode.hashtable;
/*
    int aNum = aIdx >= 0 ? (a.charAt(aIdx) - '0') : 0;
    (a.charAt(aIdx) - '0')=> cast char to int
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int [] vset = new int [9]; // use array to save bit int
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(('9' - '0'));
    }
}
