package com.lzq.leecode;

/**
 * LeeCode
 *
 * 26. 删除排序数组中的重复项
 * 解法一：元素移动
 */
public class RemoveDuplicates {

    /* 解法二 */
    private RemoveDuplicates2 removeDuplicates;


    public static void main(String[] args) {

        int[] nums = {0,0,0};
        int l = removeDuplicates(nums);
        System.out.println(l);
    }


    public static int removeDuplicates(int[] nums) {
        if (nums==null){ return 0; }
        if (nums.length == 1){ return 1;}

        int len = nums.length;

        int step1 = 0;
        int step2 = 1;

        while (step1 < len && step2 < len){

            if (nums[step1] == nums[step2]){
                for (int i = step1; i < len-1; i++) {
                    nums[i] = nums[i+1];
                }
                len--;
            }else {
                step1++;
                step2++;
            }
        }

        return len;
    }
}
