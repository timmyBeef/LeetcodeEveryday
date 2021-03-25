package hackerrank;

import java.util.List;

/*
    https://www.hackerrank.com/challenges/sherlock-and-array/problem

    Watson gives Sherlock an array of integers.
    His challenge is to find an element of the array such that
    the sum of all elements to the left is equal to the sum of all elements to the right.

    => find an element of the array such that =>
    this element's left sum = this element's right sum

    1. 求和 sum
    2. 計算 leftSum == sum - current - leftSum

        h
    0 0 2 0
    when index 2, 0 = (2 - 2 - 0) => YES
        h
    1 1 4 1 1
    when index 2, 2 = (8 - 4 - 2) => YES

    refer:
    https://gist.github.com/hxwang
 */
public class SherlockAndArray {

    static String balancedSums(List<Integer> arr) {

        // caculate total sum first
        int sum = arr.stream().mapToInt(i -> i).sum();

        int leftSum = 0; //left sum
        for (Integer current : arr) {

            // left == right ( total - current value - left sum)
            if (leftSum == sum - current - leftSum) {
                return "YES";
            }
            leftSum += current;
        }
        return "NO";
    }
}
