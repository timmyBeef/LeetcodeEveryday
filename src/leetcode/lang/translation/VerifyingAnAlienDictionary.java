package leetcode.lang.translation;

//https://leetcode.com/problems/verifying-an-alien-dictionary/

/*

    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    Output: false

    Alien has their dictionary order, to check the words[] seq is sorted or not

    so first build the dictionary: int[] map = new int[26];

    for loop compare words[i], words[i+1]...(use a compare method)

    compare method:
    int cmp = map[s.charAt(i) - 'a'] - map[t.charAt(i) - 'a'];
    cmp != 0 return cmp

    when one word is the prefix of the other, compare their sizes.
    other case:  cmp = 0, return m-n (length)

 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        // The reason for - 'A', is that it "shifts" the ascii/unicode value
        // so that A - Z have values 0 - 25.
        // And are thus more suitable as an array index.
        // 'A' - 'A' == 0
        // 'B' - 'A' == 1
        // 'C' - 'A' == 2
        // 建立字典(存著順序)
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        } // construct mapping to the give order.

        for (int i = 0; i < words.length-1; i++) { // Verify the ajacent words order.

            // compare i, i+1
            // > 0 代表不照順序(大->小), return false
            if (compare(words[i], words[i+1], map) > 0) {
                return false;
            }
        }
        return true;
    }

    // 判斷是否照外星人字典的順序, 所以數字一定是 小到大, 這裡是回傳 前-後 的數字
    private int compare(String s, String t, int[] map) { // compare the 2 words char by char.
        int m = s.length();
        int n = t.length();
        for (int i = 0; i < m && i < n; i++) {
            int cmp = map[s.charAt(i) - 'a'] - map[t.charAt(i) - 'a']; // compare according to the given order.
            if (cmp != 0) {
                // <= 0, 照順序(小->大, 小-大 <= 0)
                // > 0 , 不照順序(大->小, 大-小 > 0)
                return cmp;
            } // if not equal, return the comparison result.
        }

        /*
            Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
            Output: false
            cmp 若都 0, 代表前面字母都一樣, 這時候比較長度 前長度-後長度, 有照順序應該是..["app","apple"]
        */
        return m - n; // when one word is the prefix of the other, compare their sizes.
    }

    public static void main(String args[]) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        System.out.println("is alien word? " + new VerifyingAnAlienDictionary().isAlienSorted(words, order));

//        for (int i = 0; i < order.length(); i++) {
//            System.out.println("order.charAt(i):" + map[i]);
//        }
    }
}
