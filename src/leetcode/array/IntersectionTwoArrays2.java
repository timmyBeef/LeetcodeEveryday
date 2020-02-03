package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

    use map to store the first one, value and counts

    to compare, if they are matched, add to result,
    update map count-1

    when 0, remove it from map, remove by map's key and value
    so the result wont repeat


https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions

 Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

1. What if the given array is already sorted? How would you optimize your algorithm?

(變跟之前的two pointers解法一樣, 只是不用set保持唯一（本題結果可以重複的）)
Classic two pointer iteration, i points to nums1 and j points to nums2.
Because a sorted array is in ascending order, so if nums1[i] > nums[j],
we need to increment j, and vice versa. Only when nums1[i] == nums[j],
we add it to the result array. Time Complexity O(max(N, M)).
Worst case, for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }.
We will always iterate the longest array.
The example code is below(I sorted it so it could go through OJ):

2. What if nums1's size is small compared to nums2's size? Which algorithm is better?

This one is a bit tricky. Let's say nums1 is K size.
Then we should do binary search for every element in nums1.
Each lookup is O(log N), and if we do K times, we have O(K log N).

If K this is small enough, O(K log N) < O(max(N, M)).
Otherwise, we have to use the previous two pointers method.

3. What if elements of nums2 are stored on disk,
and the memory is limited such that you cannot load all elements into the memory at once?

This one is open-ended. But Map-Reduce I believe is a good answer.

Store the two strings in distributed system(whether self designed or not),
then using MapReduce technique to solve the problem;

Map-Reduce implementaion:
https://ithelp.ithome.com.tw/articles/10191235
 */
public class IntersectionTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int num: nums2) {
            if (map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num)-1);

                // remove by map's key and value, so when 0, remove it
                // so the result wont reapeat
                map.remove(num, 0);

            }
        }
        int[] rs = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            rs[i++] = num;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};

        System.out.print(Arrays.toString(new IntersectionTwoArrays2().intersect(nums1, nums2)));

        System.out.print(Arrays.toString(new IntersectionTwoArrays2().intersect(nums3, nums4)));

    }
}
