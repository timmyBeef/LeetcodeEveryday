package leetcode.bit.kt

fun hammingWeight(n:Int):Int {
    if (n == 0) return 0

    var res = 0
    var num = n
    for(i in 0 until 32) {
        res += num and 1
        num = num shr 1
    }
    return res
}