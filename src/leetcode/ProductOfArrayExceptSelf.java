package leetcode;

// https://leetcode.com/problems/product-of-array-except-self/

/*
Input:  [1,2,3,4]
Output: [24,12,8,6] => [2*3*4, 1*3*4, 1*2*4, 1*2*3]
*/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        /*

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
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
