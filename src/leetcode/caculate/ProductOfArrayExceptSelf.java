package leetcode.caculate;



import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/
/*
Input:  [1,2,3,4]
Output: [24,12,8,6] => [1*2*3, 0*2*3, 0*1*3, 0*1*2]

[a1*a2*a3, a0*a2*a3, a0*a1*a3, a0*a1*a2]
目標：變成2陣列 相乘
=>
[1, a0, a0a1, a0a1a2]
[a1a2a3, a2a3, a3 , 1]


res[0] = 1;
for (int i = 1; i < n; i++) { // from start
    res[i] = res[i - 1] * nums[i - 1];
}
[1, a0, a0a1, a0a1a2]


int right = 1;
for (int i = n - 1; i >= 0; i--) { // from end
    res[i] *= right;
    right *= nums[i];
}

[a1a2a3, a2a3, a3  , 1]

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity?
(The output array does not count as extra space for the purpose of space complexity analysis.)

Time complexity : O(N) where N represents the number of elements in the input array.
We use one iteration to construct the array LL, one to update the array answeranswer.

Space complexity : O(1) since don't use any additional array for our computations.
The problem statement mentions that using the answeranswer array doesn't add to
the space complexity.

*/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        /*
        res[0] = 1;
        res1 = res0*nums0 = 1*nums0
        res2 = res1*nums1 = 1*nums0*nums1
        res3 = res2*nums2 = 1*nums0*nums1*nums2
        */
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        /*
                res[3] *= right;
                right *= nums[3];

                res[2] *= right;
                right *= nums[2];

                res[1] *= right;
                right *= nums[1];
         */

        // 從後面來
        // res[3] = res[3] * 1
        // right = 1 * nums[3] = nums[3]

        // res[2] = res[2] * nums[3]
        // right = nums[3] * nums[2]

        // res[1] = res[1] * nums[3] * nums[2]
        // right = nums[3] * nums[2] * num[1]

        // res[0] = res[0] * nums[3] * nums[2] * num[1]
        // right = nums[3] * nums[2] * num[1]* num[0]
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;  // ori* 下面陣列
            right *= nums[i]; // right: [a1a2a3, a2a3, a3  , 1]
        }
        return res;
    }


    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(input)));
    }
}