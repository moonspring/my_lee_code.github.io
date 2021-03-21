package com.lzq.leecode;

/**
 * LeeCode
 *
 * 27. 移除元素
 *
 * 解法一：移动图片
 */
public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = removeElement(nums,val);
        System.out.println(result);
    }


    public static int removeElement(int[] nums, int val) {
        if (nums==null){ return 0; }

        int len = nums.length;
        int step = 0;

        while (step < len){

            if (nums[step] == val){
                for (int i = step; i < len-1; i++) {
                    nums[i] = nums[i+1];
                }
                len--;
            }else {
                step++;
            }
        }

        return step;
    }

}
