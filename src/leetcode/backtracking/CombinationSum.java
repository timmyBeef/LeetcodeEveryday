package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/

https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(result, temp, nums, remain - nums[i], i); //這裡start是i, 因為可以重複使用
                temp.remove(temp.size()-1);
            }
        }

    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 5, 4, 6};
        System.out.println(new CombinationSum().combinationSum(nums, 6));
    }
}
