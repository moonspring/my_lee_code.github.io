package com.lzq.leecode;

/**
 * LeeCode
 *
 * 26. 删除排序数组中的重复项
 *
 * 解法二 双指针移动
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {

        int[] nums = {0,0,0};
        int l = removeDuplicates(nums);
        System.out.println(l);
    }

    /**
     * 双指针移动
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if (nums==null){return 0;}

        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[k]){
                k++;
                nums[k] = nums[i];
            }
        }

        return k+1;
    }



}
