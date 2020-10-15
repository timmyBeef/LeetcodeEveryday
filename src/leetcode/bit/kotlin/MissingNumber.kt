package leetcode.bit.kotlin

fun missingNumber(nums: IntArray): Int {
    var res = nums.size
    nums.forEachIndexed { index, v ->
        res = res.xor(index.xor(v))
    }
    return res
}