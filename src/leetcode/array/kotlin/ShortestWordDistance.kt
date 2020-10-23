package leetcode.array.kotlin

fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
    var x = -1;
    var y = -1;
    var res = words.size
    for (i in words.indices) {
        if (word1 == words[i]) {
            x = i
        } else if (word2 == words[i]) {
            y = i
        }
        if (x != -1 && y != -1) {
            res = Math.min(res, Math.abs(x - y))
        }
    }
    return res
}