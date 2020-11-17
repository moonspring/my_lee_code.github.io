package com.lzq.leecode;

/**
 * LeeCode
 *
 * 31. 下一个排列
 *
 * 解法一：官方解法
 */
public class NextPermutation {

    //野路子解法
    private NextPermutation2 nextPermutation2;

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {9, 8 ,7, 6, 5,4 ,3,2,1};
//        int[] nums = {9, 8 ,7, 5 ,6,1,4,3,2};
//        int[] nums ={3,2,1};
        int[] nums ={1,1,5};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);

        System.out.println("nums="+nums);
        System.out.println("nums.length="+nums.length);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        /* 循环一：正儿八经循环，可以 */
        for(int k = i;k>=0;k--){
            if(nums[k]>=nums[k+1]){
                i--;
            }else {
                break;
            }
        }

        /* 循环二：while巧妙循环，也可以 */
//        while(i>=0 && nums[i]>=nums[i+1]){
//            i--;
//        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 反转
     * @param nums
     * @param start
     */
    private void reverse(int[] nums,int start){

        int i = start;
        int j = nums.length-1;

        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    /**
     * 交换
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}























