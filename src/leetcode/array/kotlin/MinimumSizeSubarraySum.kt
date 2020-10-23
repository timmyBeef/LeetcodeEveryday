package leetcode.array.kotlin

/*
    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2

    // sliding windows
    // for loop continue sum,
    // while left < i && sum >= s,
    // calate min distance
    // sum -= left
 */
fun minSubArrayLen(s: Int, nums: IntArray): Int {
    var sum = 0
    var left = 0
    var res = Int.MAX_VALUE
    nums.forEachIndexed { i, num ->
        sum += num
        while (sum >= s) {
            res = Math.min(res, i - left + 1)
            sum -= nums[left++]
        }
    }
    if (res == Int.MAX_VALUE) return 0 else return res
}