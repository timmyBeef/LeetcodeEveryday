package leetcode.array.java;
/*
    245
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/hashtable/245.-shortest-word-distance-iii

    time: O(n)
    space: O(1)
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int a = -1;
        int b = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                a = i;
            }
            if (wordsDict[i].equals(word2)) { // 243 + only add this
                if (word1.equals(word2)) { // 243 + only add this
                    a = b;
                }
                b = i;
            }
            if (a != -1 && b != -1) {
                min = Math.min(min, Math.abs(a - b));
            }
        }
        return min;
    }

}
