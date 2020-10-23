package leetcode.array.kotlin


fun maxArea(height: IntArray): Int {
    var res = 0
    var l = 0
    var r = height.size - 1
    while (l < r) {
        var minHeight = if (height[l] < height[r]) height[l++] else height[r--]
        res = Math.max(res, minHeight * (r - l + 1))
    }
    return res
}