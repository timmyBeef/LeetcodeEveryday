package leetcode.caculate;


/*
    https://leetcode.com/problems/divide-two-integers/

Given two integers dividend and divisor, divide two integers

without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.



    step1: to find the result is positive or negative

    step2: use long (include result) to make sure not overflow at the beginning, and abs number

    step3: Find the highest multiplication use shift, to make the process fast,
           if only use divisor to subtract dividend every time , it would be exceed time limit

    step4: multiplication = (divisor * 2^shifts) which is <= dividend

           and use divisor * 2^shifts to subtract the dividend every time , and update it until

           the highest multiplication <= dividend

           and we can get the quotient is every time 2^shifts accumalation

    step5: change the result negative symbol or not

    step6: check the result exceed the integer MAX_VALUE

    step7: return (int) result

    O(logN) divisor * 2^shifts to subtract the dividend every time, n is the original substraction time
    O(1)

「五的四次方」讀作
five to the power of four = five to the fourth power = five to the fourth

「七的五次方」讀作
seven to the power of five = seven to the fifth power = seven to the fifth

「二次方」又稱作「平方」，英文是 square。「五的平方」我們就會說 five squared。
「三次方」又稱作「立方」，英文是 cube。「五的立方」我們就會說 five cubed。

coner case: because int range: 2147483647 ~ -2147483648
so     int dividend = -2147483648;
       int divisor = -1;
       result is 2147483648, will overflow,
       but if divisor = 1, result is -2147483648, it's ok, no need to check the mix_value condition

 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long Dividend = Math.abs((long)dividend); //!!!!
        long Divisor = Math.abs((long)divisor);  //!!!!
        long res = 0; //!!!!
        while (Dividend >= Divisor) {
            long c = Divisor;
            for (int i = 0; (c << i) <= Dividend; ++i) {
                Dividend -= (c << i);
                res += (1 << i);
            }
        }
        if (isNegative == true) res = -res;

        //int dividend = -2147483648; //coner case: because int range: 2147483647 ~ -2147483648
        //int divisor = -1;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }


    public static void main(String[] args){

        int dividend = -2147483648; //coner case: because int range: 2147483647 ~ -2147483648
        int divisor = -1;

        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
        int i = 1;
        boolean flag = dividend < 0 ^ divisor < 0;
        System.out.println("變數值...:"+ flag);
        System.out.println(" i = " + i);

        System.out.println("位移運算...");
        System.out.println(" i << 1 = " + (i << 1)); //2
        System.out.println(" i << 2 = " + (i << 2)); //4
        System.out.println(" i << 3 = " + (i << 3)); //8

        i = 5;

        System.out.println("變數值...");
        System.out.println(" i = " + i);

        System.out.println("位移運算...");
        System.out.println(" i << 1 = " + (i << 1)); //5*2 = 10
        System.out.println(" i << 2 = " + (i << 2)); //5*4 = 20
        System.out.println(" i << 3 = " + (i << 3)); //5*8 = 40

    }
}
