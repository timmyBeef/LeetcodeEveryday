package leetcode.divideandconquer;

/*
    time complexity: O(n), space complexity: O(1)
*/
class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;

        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else if (num != majority) {
                count--;
            } else {
                count++;
            }
        }
        return majority;
    }
}

