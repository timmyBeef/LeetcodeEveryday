package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            if(nums[i] >= lower && nums[i] <= upper && i != nums.length - 1) {


                int diff = nums[i + 1] - nums[i];
                if (diff > 1) {
                    if (diff == 2) {
                        list.add(String.valueOf(nums[i] + 1));
                    } else {
                        list.add(String.valueOf(nums[i] + 1) + "->" + String.valueOf(nums[i + 1] - 1));
                    }
                }
            } else {
                break;
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(new MissingRanges().findMissingRanges(nums, 0, 100));


    }
}
