package com.lzq.leecode;

/**
 * LeeCode
 *
 * 122. 买卖股票的最佳时机 II
 * @author lzq
 */
public class MaxProfit122_2 {

    public int maxProfit(int[] prices) {

        if (prices==null || prices.length==0){ return 0;}

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
