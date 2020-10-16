package leetcode.bit.kotlin

fun maxProduct(words: Array<String>): Int {
    var res = 0
    var bytes = IntArray(words.size)

    words.forEachIndexed { i, word ->
        var value = 0;
        word.forEachIndexed { j, c ->
            value = value or (1 shl (c - 'a'))
        }
        bytes[i] = value
    }

    for (i in 0 until words.size) {
        for (j in i until words.size) {
            if ((bytes[i] and bytes[j]) == 0) {
                res = Math.max(res, words[i].length * words[j].length)
            }
        }
    }
    return res
}