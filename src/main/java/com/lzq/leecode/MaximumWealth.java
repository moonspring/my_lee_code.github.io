package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 1672. 最富有客户的资产总量
 * @author lzq
 */
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {

        int max = Integer.MIN_VALUE;
        int temp;
        for (int[] item:accounts) {
            temp = Arrays.stream(item).sum();
            if (max<temp){ max = temp; }
        }
        return max;
    }
}
