package com.lzq.leecode;

/**
 * LeeCode
 *
 * 283. 移动零
 *
 * 解题3：双指针
 */
public class MoveZeroes3 {

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                if (left != right){
                    swap(nums, left, right);
                }
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
