package leetcode.lang.translation;

//https://leetcode.com/problems/integer-to-english-words/

// 3 digits, one comma, to seperate "Thousand", "Million", "Billion"

// so 1231234567 => 1.231.234.567 => 1 billion 231 million 234 thousand 567


// then use helper to convert the remain three num digits
// 0
// <20
// <100
// else

/*
Time complexity : O(N). Intuitively the output is proportional to
the number N of digits in the input.

Space complexity : O(1) since the output is just a string.
 */
public class IntegerToEnglishWords {

    public static final String LESS_THAN_20[] = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public static final String TENS[] = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};

    public static final String THOUSANDS[] = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String words = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) { // 若不做 可能會多一個空的 "Thousand", "Million", "Billion"
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            i++;
            num /= 1000;
        }

        return words.trim();
    }


    public String helper(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        }
        if (num < 100) {
            return TENS[num / 10] + " " + this.helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + this.helper(num % 100);
        }
    }

    public static void main(String args[]) {
        System.out.println(new IntegerToEnglishWords().numberToWords(1231234567));

        System.out.println(new IntegerToEnglishWords().numberToWords(1231234567));

    }
}
