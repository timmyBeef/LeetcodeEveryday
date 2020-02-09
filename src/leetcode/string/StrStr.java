package leetcode.string;

import java.util.Arrays;

/*
    28. Implement strStr()
    https://leetcode.com/problems/implement-strstr/

    O(nm) runtime, O(1) space – Brute force:

There are known efficient algorithms such as Rabin-Karp algorithm, KMP algorithm,
or the Boyer-Moore algorithm. Since these algorithms are usually studied in an advanced algorithms class,
it is sufficient to solve it using the most direct method in an interview – The brute force method.

The brute force method is straightforward to implement.
We scan the needle with the haystack from its first position
and start matching all subsequent letters one by one.
If one of the letters does not match, we start over again with the next position in the haystack.
Assume that n = length of haystack and m = length of needle, then the runtime complexity is O(nm).


Have you considered these scenarios?


1. needle or haystack is empty. If needle is empty, always return 0. If haystack is empty,
then there will always be no match (return –1) unless needle is also empty which 0 is returned.

2. needle’s length is greater than haystack’s length. Should always return –1.

3. needle is located at the end of haystack. For example, “aaaba” and “ba”. Catch
possible off-by-one errors.

4. needle occur multiple times in haystack. For example, “mississippi” and “issi”.
It should return index 2 as the first match of “issi”.

5. Imagine two very long strings of equal lengths = n, haystack = “aaa...aa” and needle = “aaa...ab”.
You should not do more than n character comparisons, or else your code will get Time Limit Exceeded in OJ.

 // If at this point we have navigated through the entire length of needle,
 // we have found a solution, haystack[i].
 if (j == needle.length()) return i;

 // This happens when we run out of elements in haystack, but there are still elements in needle.
 if (i + j == haystack.length()) return -1;

 // We stop comparing after needle[j], so i will be incremented and cycle repeats itself.
 if (needle.charAt(j) != haystack.charAt(i + j)) break;

 */
public class StrStr {

    // 3ms easy solution
    public int strStrSimple(String haystack, String needle) {
        for (int i = 0; ; i++) { // The length of haystack
            for (int j = 0; ; j++) { // The length of needle
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    //1ms but use inbuild method
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char[] target = haystack.toCharArray();
        for (int i = 0; i < target.length - needle.length() + 1; i++) { // 因為超過needle len的, 後面不夠長度, 根本不用跑
            char[] temp = Arrays.copyOfRange(target, i, i + needle.length());
            String str = new String(temp);
            if (str.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "TESTTTT";
        String needle = "ES";

        System.out.println("index:" + String.valueOf(new StrStr().strStr(haystack, needle)));

    }
}
