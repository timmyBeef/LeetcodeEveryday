package leetcode;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        String result = "";
        int j = s.length();
        for(int i = 0; i < j; i++) {
            if((i+1) < j && s.charAt(i) == s.charAt(i+1)) {
                result = "";
            } else {
                result += s.charAt(i);
            }
        }
        System.out.println("result:" + result);
        return result.length();
    }

    // https://stackoverflow.com/questions/32878514/when-to-initialize-an-array-with-256
    // 使用一個 boolean array 來記錄哪幾個 char 出現過了,
    // here are 2^8 = 256 chars in an extended ASCII char set. 所以是 256 的大小
    // 有兩個指標, i 和 j, j 跑回圈把字對應的位置塞入true 到 array, 遇到已經有的字
    // 根據i的位置, 把 塞過的 更新成 沒塞過, 如此就可以慢慢調整 i 的位置 移到已經有的字的位置,
    // 依此類推, so 最大長度會是 j - i + 1 但要跟之前出現過的 max 相比
    public int method2(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                System.out.println("j:" + j + ", s.charAt(j):" + s.charAt(j));
                System.out.println("i:" + i + ", s.charAt(i):" + s.charAt(i));
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(String.valueOf(new LengthOfLongestSubstring().method2(s)));

    }
}
