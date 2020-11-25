package com.lzq.leecode;

/**
 *
 * LeeCode
 *
 * 300. 最长上升子序列
 */
public class LengthOfLIS {

    public static void main(String[] args) {

        int[] nums = {1,2,43,3,6};
        int result = lengthoflis2(nums);

        System.out.println(result);

    }

    public static int lengthoflis2(int[] nums){

        if (nums==null || nums.length==0) {return 0; }

        int[] dp = new int[nums.length];
        int maxLen = 1;
        for (int i = 0 ; i < nums.length; i++) {
            dp[i] = 1;
            if (i==0){ continue; }
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

}
