package leetcode.hashmap;

/*
    1160. Find Words That Can Be Formed by Characters
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/hashtable/1160.-find-words-that-can-be-formed-by-characters

    time: O(n * k) , n : words array size, k : each word's length
    space: O(1)
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int map[] = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            if (isPossible(word, map)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean isPossible(String word, int map[]) {
        int cMap[] = new int[26];
        System.arraycopy(map, 0, cMap, 0, 26); // faster
        // or use
        // int cMap[] = map.clone(); // slower, but easier

        for (char c : word.toCharArray()) {
            cMap[c - 'a']--;
            if (cMap[c - 'a'] < 0) return false;
        }
        return true;
    }

}
