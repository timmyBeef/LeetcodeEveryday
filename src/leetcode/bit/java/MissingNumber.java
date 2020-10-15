package leetcode.bit.java;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // n+1 length array, but it has n distinct numbers
        int res = nums.length; // 所以初始值設為最後的長度
        for (int i = 0; i < nums.length; i++) {
            res ^= (i^nums[i]); // 一個一個去 xor, 會得到遺失的數字
        }
        return res;
    }
}
