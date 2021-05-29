package leetcode.array.java;

/*
243
https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/hashtable/243.-shortest-word-distance

Given a list of words and two words word1 and word2,
return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

find min, so we should initial result to : int res = words.length;

time: O(n)
space: O(1)
 */
public class ShortestWordDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int x = -1;
        int y = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                x = i;
            } else if (word2.equals(words[i])) {
                y = i;
            }
            if (x != -1 && y != -1) {
                res = Math.min(res, Math.abs(x - y));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(words, word1, word2) == 3 ? "pass" : "not pass");

        word1 = "makes";
        word2 = "coding";
        System.out.println(shortestDistance(words, word1, word2) == 1 ? "pass" : "not pass");

    }
}

