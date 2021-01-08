package com.lzq.leecode;

/**
 * LeeCode
 *
 * 189. 旋转数组
 * @author lzq
 */
public class Rotate {

    public static void main(String[] args) {

        Rotate rotate = new Rotate();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate.rotate(nums,k);

    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            for (int j = nums.length-2; j >=0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }
}
