package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 164. 最大间距
 *
 * 解答：应该使用基数排序和桶排序，本题解虽然能过，但是不符合要求
 *
 * @author lzq
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {

        if (nums==null || nums.length<2) {return 0;}
        Arrays.sort(nums);

        int max = 0;

        int len = nums.length;

        int currentDiff;
        for (int i = 0; i < len-1; i++) {
            currentDiff = nums[i+1]-nums[i];
            if (currentDiff>max){
                max = currentDiff;
            }
        }
        return max;
    }

}
