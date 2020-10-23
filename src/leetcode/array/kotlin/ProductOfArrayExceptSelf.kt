package leetcode.array.kotlin

fun productExceptSelf(nums: IntArray): IntArray {
    var res = IntArray(nums.size)
    res[0] = 1
    // 1, a0, a0a1, a0a1a2
    for (i in 1 until nums.size) {
        res[i] = res[i-1]*nums[i-1]
    }
    // a1a2a3,a2a3,a3,1
    var right = 1
    for (i in nums.size-1 downTo 0) {
        res[i] *= right
        right *= nums[i]
    }
    return res
}