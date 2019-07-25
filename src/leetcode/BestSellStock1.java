package leetcode;

/*

We need to find the largest peak following the smallest valley.

We can maintain two variables - minprice and maxprofit corresponding
to the smallest valley and maximum profit

Time complexity : O(n). Only a single pass is needed.

Space complexity : O(1). Only two variables are used.
 */
public class BestSellStock1 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length ; i++) {
            if(prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
