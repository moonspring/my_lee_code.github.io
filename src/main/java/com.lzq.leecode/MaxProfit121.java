package com.lzq.leecode;

/**
 * LeeCode
 *
 * 121. 买卖股票的最佳时机
 * @author lzq
 */
public class MaxProfit121 {

    public static void main(String[] args) {

        int[] prices = {7,6,4,3,1};
//        MaxProfit121 maxProfit = new MaxProfit121();
        MaxProfit121_2 maxProfit = new MaxProfit121_2();

        int res = maxProfit.maxProfit(prices);
        System.out.println(res);
    }


    public int maxProfit(int[] prices) {

        if (prices==null || prices.length==0){ return 0;}

        int res = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = i;
            if (prices[i]<start){
                start = prices[i];
                tmp = i+1;
            }
            int max = max(prices,tmp,prices.length)-start;
            res = Math.max(res,max);
        }

        return res;
    }

    private int max(int[] prices,int cur,int size){
        if (cur>=size){
            return 0;
        }
        int max = prices[cur];
        for (int i = cur+1; i < size; i++) {
            if (prices[i]>prices[cur]){
                max = prices[i];
            }
        }
        return max;
    }

}
