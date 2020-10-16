package leetcode.bit.java;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int wLen = words.length;

        int[] bytes = new int[wLen]; // 因為 int = 4byte = 32bits, 所以可以存 26 個字母
        int res = 0;

        for (int i = 0; i < wLen; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= (1 << (words[i].charAt(j) - 'a')); // 把每個單詞的字做佔位
            }
            bytes[i] = val; // 存起來
        }

        for (int i = 0; i < wLen; i++) {
            for (int j = i + 1; j < wLen; j++) {
                if ((bytes[i] & bytes[j]) == 0) { // 一個跟一個做 or 比較, 0 代表佔位不重複，也就是完全不同的字母
                    res = Math.max(res, words[i].length()*words[j].length()); //計算最長長度
                }
            }
        }
        return res;
    }
}
