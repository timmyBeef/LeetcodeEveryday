package leetcode.bit.kotlin

fun reverseBits(n:Int):Int {
    var res = 0
    var num = n
    for (i in 1..32) {
        res = res shl 1
        if ((num and 1) == 1) res++
        num = num shr 1
    }
    return res;
}