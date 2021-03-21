package com.lzq.leecode;

/**
 * LeeCode
 *
 * 27. 移除元素
 *
 * 解法二：双指针
 */
public class RemoveElement2 {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = removeElement(nums,val);
        System.out.println(result);
    }


    public static int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
}





















