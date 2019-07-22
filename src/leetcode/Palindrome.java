package leetcode;

/*
use two pointer, left = 0, right = len-1

while(left < right ) {
    while(left < right && not letter or digits) , pass these char

    compare char with lower case
}
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public static void main(String[] args) {
        String text = "A man, a plan, a canal: Panama";
        System.out.println("Is this pala:" + String.valueOf(new Palindrome().isPalindrome(text)));

    }
}
