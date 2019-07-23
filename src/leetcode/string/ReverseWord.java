package leetcode.string;
// https://leetcode.com/problems/reverse-words-in-a-string/
/*
    append condition: left == 0 || s.charAt(left-1) == ' '
 */
public class ReverseWord {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();

        int right = s.length();
        for(int left = s.length()-1; left >= 0; left--) { // from right to run
            if(s.charAt(left) == ' ') { // left == '' , it means a new word to do, so set new right
                right = left;
            } else if (left == 0 || s.charAt(left-1) == ' ') { //last positon || found a word could ouput
                if(reversed.length() != 0) {
                    reversed.append(" ");
                }
                reversed.append(s.substring(left, right));
            }
        }
        return reversed.toString();
    }

    // inplaceReverseWords, reverse all string, then reverse word!
    public void inplaceReverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') { // 到尾巴了 || 遇到空白 取 i~j, 取完 i = j+1
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }
    private void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "timmy is good";

        System.out.println("reverse:" + String.valueOf(new ReverseWord().reverseWords(str)));

        char[] charAry = str.toCharArray();
        new ReverseWord().inplaceReverseWords(charAry);

        for(char a: charAry) {
            System.out.print(a);
        }
    }

}