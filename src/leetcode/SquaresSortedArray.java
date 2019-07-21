package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/

/*

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

use two point
left = 0, right = n-1

use another array to store result

because the array is in ascending order, and has negative value

so use two point to get value, and do abs,

to compare the head and the tail value,

set larger result to new array, and move the pointer

Time Complexity: O(N), where NN is the length of A.

Space Complexity: O(N).

use two point i, j
先計算最後面的結果, 因為原題是排序過的 有正負的序列
所以兩個 poninter 用來比較頭尾,
輪流比較頭尾
如果abs 後, 頭大於尾 i ++
塞入index i 的此值的平方
如果尾比較大 j--
塞入index j 的此值的平方
如此計算出最後結果

 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        for(int p = n - 1; p >= 0; p--) {
            if(Math.abs(A[left]) > Math.abs(A[right])) {
                result[p] = A[left]*A[left];
                left++;
            } else {
                result[p] = A[right]*A[right];
                right--;
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
