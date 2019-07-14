package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/

// inplace 關鍵 : 2 個指標
// lastNonZeroFoundAt 用來指 0 的index, 因為 0 的時候, lastNonZeroFoundAt 不動
// cur 目前位置, cur 會一直動誒所以當 cur !=0 時, 做 swap , lastNonZeroFoundAt(0的位置) 和 cur
// swap 完, lastNonZeroFoundAt++, 所以 lastNonZeroFoundAt 一直指到0 (因為swap了)
// 如此一直把 0 swap 到最後面！
//
public class MoveZeroes {
    void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt, cur);
                lastNonZeroFoundAt++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {

        int nums[] = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);

        System.out.println(Arrays.toString(nums));

    }
}
