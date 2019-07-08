package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/

// use two point i, j
// 先計算最後面的結果, 因為原題是排序過的 有正負的序列
// 所以兩個 poninter 用來比較頭尾,
// 如果abs 後, 頭大於尾 i ++
// 塞入index i 的此值的平方
// 如果尾比較大 j--
// 塞入index j 的此值的平方
// 如此計算出最後結果
public class SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0; int j = n - 1;
        for(int p = n - 1; p >= 0; p--) {
            if(Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i]*A[i];
                i++;
            } else {
                result[p] = A[j]*A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 3, 10};
        int[] result = new SquaresSortedArray().sortedSquares(a);
        Arrays.stream(result).forEach( r -> {
            System.out.print(r + ",");

        });


    }
}
