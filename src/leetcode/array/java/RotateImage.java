package leetcode.array.java;
/*
    先做主對角線 ＝> 在做垂直 => 就會成功, 其他組合也可以試試看

    1 2 3
    4 5 6
    7 8 9

    => 做主對角線 (以 1,5,9 為主軸, 左上右下半邊對換)
    1 4 7
    2 5 8
    3 6 9

    => 在做垂直 (以 4,5,6 為主軸, 左右對換)
    7 4 1
    8 5 2
    9 6 3

 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        // do diagonal exchange
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // do horizontal exchange
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
