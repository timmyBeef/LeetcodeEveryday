package leetcode.bit.kt

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var res = 0;
        nums.forEach() {
            res = res xor it
        }
        return res
    }
}