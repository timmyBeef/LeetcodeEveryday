package leetcode.caculate;

// https://leetcode.com/problems/add-binary/
/*
Input: a = "11", b = "1"
Output: "100"


Input: a = "1010", b = "1011"
Output: "10101"

use two pointer, all from the string end to caculate
and a carry

sum = carry

add:
if (i >= 0) sum += a.charAt(i--) - '0';
if (j >= 0) sum += b.charAt(j--) - '0';

sb append sum%2
carry = sum/2

if (carry != 0) sb.append(carry)
at last, return the reverse of sb

Time: O(max(m,n))
Space: O(1),
since the space we used for the StringBuilder is just the result,
so I guess it does not count as extra space.

 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;

        while(aIdx >= 0 || bIdx >= 0) { //!!!
            int sum = carry; //!!!

            int aNum = aIdx >= 0 ? (a.charAt(aIdx) - '0') : 0; //!!! 注意index
            int bNum = bIdx >= 0 ? (b.charAt(bIdx) - '0') : 0;

            sum +=  aNum + bNum;
            result.append(sum%2);
            carry = sum/2;
            aIdx--; //!!!
            bIdx--;
        }
        if (carry > 0) { //!!!
            result.append(carry);
        }

        return result.reverse().toString();

    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability string vs stringbuilder if you don't know why we use this instead of regular string

        //two pointers starting from the back, just think of adding two regular ints from you add from back
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }

        if (carry != 0) {
            sb.append(carry); //leftover carry, add it
        }
        return sb.reverse().toString(); // because we write to sb from begin, so it need reverse
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(String.valueOf(new AddBinary().addBinary(a, b)));

        System.out.println(' ' - '0');

    }
}
