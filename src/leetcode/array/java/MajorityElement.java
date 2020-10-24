package leetcode.array.java;

/*
    time complexity: O(n),
    space complexity: O(1)

    moore voting algo:

    抵銷"不同"的數字做 count 加減,
    count == 0 時紀錄結果 res
    最後會回傳 res 結果

    [3, 2, 3] => 3 , 2 抵銷, 結果是 2
    [2,2,1,1,1,2,2] => 2 1, 2 1, 2 1,抵銷, 結果是 2
*/
class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res != num) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}

