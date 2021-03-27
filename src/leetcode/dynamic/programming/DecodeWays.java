package leetcode.dynamic.programming;

// https://leetcode.com/problems/decode-ways/


import java.time.LocalDate;

/*
I used a dp array of size n + 1 to save subproblem solutions.

dp[0] means an empty string will have one way to decode, 空字串的decode方法

dp[1] means the way to decode a string of size 1. 大小1的decode方法

I then check
"one digit" and "two digit"
combination and save the results along the way.

In the end, dp[n] will be the end result.

如果 長度2的字串, 1位或2位都可以解碼的範圍的話那 dp[2] = dp[1] + dp[0] 否则 dp[2]=dp[1]。
dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]。

// https://www.jianshu.com/p/4c4314799662

Time: O( n )
Memoization prunes our recursion tree and we will do a linear amount of work
to solve the problem.

Space: O( n )
We will need to store the answer to up to n subproblems that we will need to calculate

*/
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {//!!
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];//!!
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0; //!!
        for(int i = 2; i <= n; i++) {

            // 枚舉最後一個字母對應2位, 成立代表在 i-2 位置上可以有方法
            int twoDigit = Integer.valueOf(s.substring(i-2, i)); //i=2, 0~2
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }

            // 枚舉最後一個字母對應1位, 成立代表在 i-1 位置上可以有方法
            int oneDigit = Integer.valueOf(s.substring(i-1, i)); //i=2, 1~2
            if(oneDigit >= 1 && oneDigit <= 9) {//!!
                dp[i] += dp[i-1];
            }

        }
        return dp[n];
    }

    public void test() {
        System.out.println("test!!!!");
    }
    public static void main(String[] args) throws Exception {
//        String s = "227";
//        //System.out.println(String.valueOf(new DecodeWays().numDecodings(s)));
//        LocalDate end = LocalDate.now();
//        int count = 0;
//        for (int i = 0; i < 24; i++) {
//            System.out.println(end);
//            end = end.minusMonths(1);
//            count++;
//
//        }
//        System.out.println(count);

        System.out.println(LocalDate.now().getDayOfWeek());
//        Method m = DecodeWays.class.getDeclaredMethod("test");
//        m.invoke(new DecodeWays());

    }
}
