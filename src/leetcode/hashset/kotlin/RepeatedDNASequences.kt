package leetcode.hashset.kotlin


fun findRepeatedDnaSequences(s: String): List<String> {
    var seen = mutableSetOf<String>()
    var repeated = mutableSetOf<String>()

    for (i in 0 until (s.length - 9)) {
        var dna = s.substring(i, i+10)
        if (!seen.add(dna)) {
            repeated.add(dna)
        }
    }
    return repeated.toList()
}