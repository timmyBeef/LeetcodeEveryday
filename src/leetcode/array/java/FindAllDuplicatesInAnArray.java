package leetcode.array.java;

/*
    time: O(n)
    space: O(1)

    due to question, 1 ≤ a[i] ≤ n (n = size of array), so the nums range are within index - 1
    idea is the num scanned, make this num negtive,
    if in next time, a num found it's already negtive, means duplicate!
 */
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        // [4,3,2,7,8,2,3,1]
        // [4,-3,-2,-7,8,2,-3,-1]
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index  = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
