package leetcode.string;

public class MaximumConseChar {
    /*
        連續相同字元最多的長度
        aabbcccd
        ans: c, 最常字元的第一個index: 4

        OUTPUT 最常字元的第一個index
     */

    //參考 https://www.geeksforgeeks.org/maximum-consecutive-repeating-character-string/
    //做了點修改

    // function to find out the maximum repeating
    // character in given string
    //O(N^2), O(1)
    static int maxRepeating(String str) {
        int len = str.length();
        int count = 0;

        // Find the maximum repeating character
        // starting from str[i]
        char res = str.charAt(0);
        int index = 0;
        for (int i = 0; i < len; i++) {
            int cur_count = 1;
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) != str.charAt(j))
                    break;
                cur_count++;
            }

            // Update result if required
            if (cur_count > count) {
                count = cur_count;
                index = i;
            }
        }
        return index;
    }

    //O(N), O(1)
    static int maxRepeatingOn(String str) {
        int n = str.length();
        int maxCount = 0;
        int res = 0;
        int curCount = 1;
        int keepIndex = 0;

        // Traverse string except last character
        for (int i = 0; i < n; i++) {
            // If current character matches with next
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) { //有相同時
                if (curCount == 1) { //初次進入某連續char時, 要記錄起始的index
                    keepIndex = i;
                }
                curCount++; //連續數++

            // 如果目前連續數 最大時, 要更新結果, 其他就放棄 回歸1
            // (if required) and reset count
            } else {
                if (curCount > maxCount) {
                    maxCount = curCount;
                    res = keepIndex;
                }
                curCount = 1;
            }
        }
        return res;
    }

    // Driver code
    public static void main(String args[]) {

        String str = "aabbcccd";
        System.out.println(maxRepeating(str));
        System.out.println(maxRepeatingOn(str));

    }
}