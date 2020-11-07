package leetcode.array.kotlin

fun wiggleSort(nums: IntArray) {
    // odd high, even low
    for (i in 1 until nums.size) {
        if (i % 2 == 1 && nums[i] < nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
            val temp = nums[i]
            nums[i] = nums[i - 1]
            nums[i - 1] = temp
        }
    }
}
