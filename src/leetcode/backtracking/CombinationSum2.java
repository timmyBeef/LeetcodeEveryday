package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


Given a collection of candidate numbers (candidates) and a target number (target),
find all "unique" combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used "once" in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]


Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

 */

public class CombinationSum2 {
//    public List<List<Integer>> combinationSum2(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, target, 0);
//        return list;
//
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
//        if(remain < 0) return;
//        else if(remain == 0) list.add(new ArrayList<>(tempList));
//        else{
//            for(int i = start; i < nums.length; i++){
//                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, remain - nums[i], i + 1);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }


    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if(remain < 0) return;
        else if (remain == 0){
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1]) i++; //如果往下走的時候(i > start, 即index是start還要跑的).., 下一數字依樣時, pass
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remain - nums[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 5, 4, 6};
        System.out.println(new CombinationSum2().combinationSum2(nums, 6));
    }
}
