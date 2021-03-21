package com.lzq.leecode;


/**
 * LeeCode
 *
 * 239. 滑动窗口最大值
 * 解法一：暴力法：超时
 * @author lzq
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow.maxSlidingWindow(nums,k);

        System.out.println(res);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int resultLen = len - k + 1;
        int[] res = new int[resultLen];
        int index = 0;
        while (index+k<=len){

            int max = Integer.MIN_VALUE;
            for (int i = index; i < index+k; i++) {
                if (nums[i]>max){ max = nums[i]; }
            }
            res[index] = max;
            index++;
        }
        return res;
    }
}
