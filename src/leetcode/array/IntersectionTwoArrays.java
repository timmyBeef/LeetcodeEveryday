package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(e -> set.contains(e)).toArray();
    }

    //用兩個 SET 去做
    //Time complexity : O(n + m), where n and m are arrays' lengths.
    // O(n) time is used to convert nums1 into set,
    // O(m) time is used to convert nums2, and contains/in operations are
    // O(1) in the average case.
    //
    //Space complexity : O(m+n) in the worst case when all elements in the arrays are different.
    public int[] intersectionBySet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    // 用bs去找另個 int[] 有沒有這個值了
    public int[] intersectionByBinarySearch(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};

        System.out.print(Arrays.toString(new IntersectionTwoArrays().intersection(nums1, nums2)));

        System.out.print(Arrays.toString(new IntersectionTwoArrays().intersection(nums3, nums4)));

    }
}
