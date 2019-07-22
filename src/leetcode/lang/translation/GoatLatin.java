package leetcode.lang.translation;


import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/goat-latin/
/*
        If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
        For example, the word 'apple' becomes 'applema'.

         If a word begins with a consonant (i.e. not a vowel), remove the first letter
        and append it to the end, then add "ma".
        For example, the word "goat" becomes "oatgma".

        Add one letter 'a' to the end of each word per its word index in the sentence,
        starting with 1.
        For example, the first word gets "a" added to the end, the second word gets "aa"
        added to the end and so on.

Time Complexity:
O(N^2), where NN is the length of S.
This represents the complexity of rotating the word and adding extra "a" characters.

Space Complexity: O(N^2), the space added to the answer by adding extra "a" characters.


*/
public class GoatLatin {

    public String toGoatLatin(String S) {


        Set<Character> vowel = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        int t = 0;
        StringBuilder ans = new StringBuilder();
        for (String word : S.split(" ")) { //!!
            char first = word.charAt(0);
            if (vowel.contains(first)) {
                ans.append(word);
            } else {
                ans.append(word.substring(1)); // from index 1 to end substring
                ans.append(word.substring(0, 1)); // the first word
            }
            ans.append("ma");
            for (int i = 0; i <= t; i++) { //!!
                ans.append("a");
            }
            ans.append(" "); //!!
            t++;
        }
        ans.deleteCharAt(ans.length()-1); //!!
        return ans.toString();

    }

    public static void main(String[] args) {
        String input = "I speak Goat Latin";
        System.out.println(new GoatLatin().toGoatLatin(input));
    }
}