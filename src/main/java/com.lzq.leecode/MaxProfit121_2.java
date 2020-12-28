package com.lzq.leecode;
/**
 * LeeCode
 *
 * 121. 买卖股票的最佳时机
 * @author lzq
 */
public class MaxProfit121_2 {

    public int maxProfit(int[] prices) {

        if (prices==null || prices.length==0){ return 0;}

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice>prices[i]){
                minPrice = prices[i];
            }else if (maxProfit>prices[i]-minPrice){
                maxProfit = prices[i]-minPrice;
            }
        }

        return maxProfit;
    }
}
