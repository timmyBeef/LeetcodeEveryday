package leetcode.array.kotlin

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var res = 0
    var left = 0
    var zeroIdx = -1
    for (i in nums.indices) {
        if (nums[i] == 0) {
            left = zeroIdx + 1
            zeroIdx = i
        }
        res = Math.max(res, i - left + 1)
    }
    return res
}