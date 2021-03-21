package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 31. 下一个排列
 * 解法二：野路子解法
 */
public class NextPermutation2 {

    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2) {
            return;
        }
        boolean flag=false;
        for(int i=nums.length-2;i>=0;--i){
            if(nums[i]>=nums[i+1]) {
                continue;
            }
            flag=true;
            int j=nums.length-1;
            while(nums[j]<=nums[i]) {
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            Arrays.sort(nums,i+1,nums.length);
            break;
        }
        if(!flag) {
            Arrays.sort(nums);
        }
    }
}
