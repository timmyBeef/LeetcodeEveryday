package leetcode.bit.kt

fun findTheDifference(s: String, t: String): Char {
    var res = 0
    for (c in s + t) { // 都用數字來做
        res = res xor c.toInt()
    }
    return res.toChar()
}

