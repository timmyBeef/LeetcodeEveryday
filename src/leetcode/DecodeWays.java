package leetcode;

// https://leetcode.com/problems/decode-ways/

/*
I used a dp array of size n + 1 to save subproblem solutions.
dp[0] means an empty string will have one way to decode, 空字串的decode方法

dp[1] means the way to decode a string of size 1. 大小1的decode方法

I then check one digit and two digit combination and save the results along the way.

In the end, dp[n] will be the end result.
*/
public class DecodeWays {
}
