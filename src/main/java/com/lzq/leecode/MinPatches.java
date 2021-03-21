package com.lzq.leecode;

/**
 * LeeCode
 *
 * 330. 按要求补齐数组
 * @author lzq
 */
public class MinPatches {

    public static void main(String[] args) {
        MinPatches minPatches = new MinPatches();

        int[] nums = {1,5,10};
        int n = 20;
        int res = minPatches.minPatches(nums,n);

        System.out.println(res);
    }


    public int minPatches(int[] nums, int n) {
        //累加的总和
        long total = 1;
        //需要补充的数字个数
        int res = 0;
        //访问的数组下标索引
        int index = 0;
        while (total <= n) {
            if (index < nums.length && nums[index] <= total) {
                //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
                //就变成了[1,total]U[nums[index],total+nums[index]]
                //结果就是[1,total+nums[index]]
                total += nums[index++];
            } else {
                //添加一个新数字，并且count加1
                total <<= 1;
                res++;
            }
        }
        return res;
    }
}
