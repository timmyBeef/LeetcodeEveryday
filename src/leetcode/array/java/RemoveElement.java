package leetcode.array.java;
/*
    27. Remove Element
    https://leetcode.com/problems/remove-element/

    雖然是說要 “remove", 但其實紀錄有多少非 target 的數字就好
    因為要回傳的是 length

    time: o(n), space: o(1)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int idx = 0;
        for (int num: nums) {
            if (num != val) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
