package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 188. 买卖股票的最佳时机 IV
 * @author lzq
 */
public class MaxProfit188 {

    public int maxProfit(int k, int[] prices) {

        if (prices==null || prices.length == 0) {
            return 0;
        }

        int size = prices.length;

        k = Math.min(k, size / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < size; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }

}
