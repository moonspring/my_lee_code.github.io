package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 164. 最大间距
 *
 * @author lzq
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {

        if (nums==null || nums.length<2) {return 0;}
        Arrays.sort(nums);

        int max = 0;

        int len = nums.length;
        int left;
        int right;
        for (int i = 0; i < len-1; i++) {
            left = nums[i];
            right = nums[i+1];
            max = Math.max(max,right-left);
        }

        return max;
    }

}
