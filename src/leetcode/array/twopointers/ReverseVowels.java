package leetcode.array.twopointers;

import java.util.Arrays;
import java.util.List;
/*
    345. Reverse Vowels of a String
    https://leetcode.com/problems/reverse-vowels-of-a-string/

    O(n)
    O(1)
 */
public class ReverseVowels {

    // use == is faster than use list.contains ... or String.contains
    public String reverseVowels(String s) {
        char sArray[] = s.toCharArray();
        //List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        // String vowels = "aeiouAEIOU";  string also has contains method

        // boolean ascii[] = new boolean[128];
        // ascii['a'] = true;
        // ascii['e'] = true;
        // ascii['i'] = true;
        // ascii['o'] = true;
        // ascii['u'] = true;
        // ascii['A'] = true;
        // ascii['E'] = true;
        // ascii['I'] = true;
        // ascii['O'] = true;
        // ascii['U'] = true;

        int l = 0;
        int r = s.length() - 1;
        while (r >= l) {
            while (r >= l && isNotVowel(s.charAt(l))) {
                l++;
            }
            while (r >= l && isNotVowel(s.charAt(r))) {
                r--;
            }
            if (r >= l) {
                swap(sArray, l, r);
            } else {
                return String.valueOf(sArray);
            }
            l++;
            r--;
        }
        return String.valueOf(sArray);
    }

    private boolean isNotVowel(char c) {

        return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private void swap(char sArray[], int l, int r) {
        char temp = sArray[l];
        sArray[l] = sArray[r];
        sArray[r] = temp;
    }

    public String reverseVowelsMyOwn(String s) {
        char sArray[] = s.toCharArray();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int l = 0;
        int r = s.length() - 1;
        while (r >= l) {
            while (r >= l && !vowels.contains(s.charAt(l))) {
                l++;
            }
            while (r >= l && !vowels.contains(s.charAt(r))) {
                r--;
            }
            if (r >= l) {

                char temp = s.charAt(l);
                sArray[l] = s.charAt(r);
                sArray[r] = temp;
            } else {
                return String.valueOf(sArray);
            }
            l++;
            r--;
        }
        return String.valueOf(sArray);
    }

}
