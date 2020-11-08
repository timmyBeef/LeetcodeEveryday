package leetcode.array.java;
/*
    leetcode 41

    like bucket sort idea,

    idx and value will like this
idx: 0,1,2,3
    [1,2,3,4] => [idx-1, idx-1, idx-1,idx-1]

    so
    do "while" poitive num & in nums range & nums[nums[i]-1] != nums[i]
    do swap,

    for ex:
    Input: nums = [3,4,-1,1]
    Output: 2

    i = 0, should put 3 to index (3-1), so 3 and -1 do swap
    => -1, 4, 3, 1
    => i = 1, meet while condition, so 4 and 1 do swap
    => -1, 1, 3, 4
    => i = 1, meet while condition, so 1 and -1 do swap
    => 1,-1,3,4,
    => i = 2, i = 3 do nothing

    => then in another loop, check idx + 1 != nums[idx],
    => find -1 should be idx+1 = 2
    => so the result = 2


    time: O(n)
    space: O(1)
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1; // max positive num is 1

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
