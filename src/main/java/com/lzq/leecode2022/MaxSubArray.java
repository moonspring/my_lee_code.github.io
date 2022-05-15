package com.lzq.leecode2022;

/**
 * 53.最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * @author liuzhengquan
 * @date 2022/05/13 09:45
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int pre = 0;
        int maxAns = nums[0];

        for (int num:nums){
            pre = Math.max(pre+num,num);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
