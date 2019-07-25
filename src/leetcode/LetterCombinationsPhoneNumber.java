package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/

USE Backtracking

time: O(3^N*4^M), 2~8, 有3種字母, 9有4種字母
space:O(3^N*4^M), since one has to keep O(3^N*4^M) solutions.
 */

public class LetterCombinationsPhoneNumber {
    HashMap<String, String> phoMap = new HashMap<>();
    List<String> output = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        phoMap.put("2", "abc");
        phoMap.put("3", "def");
        phoMap.put("4", "ghi");
        phoMap.put("5", "jkl");
        phoMap.put("6", "mno");
        phoMap.put("7", "pqrs");
        phoMap.put("8", "tuv");
        phoMap.put("9", "wxyz");

        if(digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private void backtrack(String combination, String digits) {
        if(digits.length() == 0) {
            output.add(combination);
        } else {
            String firstDigit = digits.substring(0,1);
            String letters = phoMap.get(firstDigit);

            for(int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                backtrack(combination+letter, digits.substring(1));
            }
        }
    }
}
