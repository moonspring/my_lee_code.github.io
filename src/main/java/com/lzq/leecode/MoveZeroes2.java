package com.lzq.leecode;

/**
 * LeeCode
 *
 * 283. 移动零
 *
 * 解题2：统计思想
 */
public class MoveZeroes2 {

    public void moveZeroes(int[] nums) {

        int noZeroStep = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0){
                nums[noZeroStep++] = nums[i];
            }
        }
        for (int i = noZeroStep; i < len; i++) {
            nums[i] = 0;
        }
    }
}
