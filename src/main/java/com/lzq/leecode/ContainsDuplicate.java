package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 217. 存在重复元素
 *
 * 解法一：排序
 * @author lzq
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
//        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        ContainsDuplicate2 containsDuplicate = new ContainsDuplicate2();

        boolean flag = containsDuplicate.containsDuplicate(null);

        System.out.println(flag);
    }

    public boolean containsDuplicate(int[] nums) {

        if (nums==null) {return false;}
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }

        return false;
    }

}
