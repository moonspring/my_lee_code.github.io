package com.lzq.leecode;

/**
 * LeeCode
 *
 * 122. 买卖股票的最佳时机 II
 * @author lzq
 */
public class MaxProfit122 {

    public int maxProfit(int[] prices){

        if (prices==null || prices.length==0){ return 0;}

        int[][] dp = new int[prices.length][2];

        /** dp[i][0] 表示第i 天不持有可获得的最大利润*/
        dp[0][0] = 0;
        /** dp[i][1] 表示第i 天交易完后手里持有一支股票的最大利润 */
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            /**dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，
             或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益*/
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            /**dp[i][1]的转移方程，如果转移状态为前一天已经持有一支股票，即dp[i−1][1]，
             * 或者前一天结束时还没有股票，即dp[i−1][0]，这时候我们要将其买入，并减少prices[i] 的收益。*/
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        return dp[prices.length-1][0];
    }
}
