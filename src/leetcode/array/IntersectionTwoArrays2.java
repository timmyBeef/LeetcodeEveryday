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
                map.put(num, map.getOrDefault(num, 0)-1);

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
