package leetcode.array.java;

import java.util.Arrays;
/*
    time complexity: O(n), space complexity: O(1)

    it's really magic...
    1. reverse entire array
    2. reverse the partial array of 0 ~ k-1
    3. reverse the partial array of k ~ end
    4. it's the answer

    1,2,3,4,5,6,7 =>
    1)[7, 6, 5, 4, 3, 2, 1]
    2)[5, 6, 7, 4, 3, 2, 1]
    3)[5, 6, 7, 1, 2, 3, 4]
*/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }

    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();

        int case1[] = {1,2,3,4,5,6,7}; // 567 1234
        test.rotate(case1, 3);

        int case2[] = {-1,-100,3,99};
        test.rotate(case2, 2);

        System.out.println("pass: " + "[5, 6, 7, 1, 2, 3, 4]".equals(Arrays.toString(case1)));
        System.out.println("pass: " + "[3, 99, -1, -100]".equals(Arrays.toString(case2)));

    }

}


