package leetcode;

public class AddBinary {
    public String addBinary(String a, String b)
    {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int sum = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || sum == 1)
        {

            // Comput sum of last
            // digits and carry
            //Because string.charAt(i) returns char. But puz is int[].
            //So string.charAt(i) - '0'converts it to an integer.

            sum += ((i >= 0)? a.charAt(i) - '0': 0) + ((j >= 0)? b.charAt(j) - '0': 0);
            //sum += ;

            // If current digit sum is
            // 1 or 3, add 1 to result
            // use (char)(sum % 2 + '0') 跟 sum % 2 速度差很多
            result = (char)(sum % 2 + '0') + result;

            // Compute carry
            sum = sum/2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(String.valueOf(new AddBinary().addBinary(a, b)));

        System.out.println(' ' - '0');

    }
}
