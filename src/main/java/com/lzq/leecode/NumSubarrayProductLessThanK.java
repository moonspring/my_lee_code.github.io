package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 713. 乘积小于K的子数组
 *
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(nums==null || k <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int prod = 1;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
