package com.lzq.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeeCode
 *
 * 217. 存在重复元素
 *
 * 解法二：哈希表
 * @author lzq
 */
public class ContainsDuplicate2 {

    public boolean containsDuplicate(int[] nums) {

        if (nums==null) {return false;}

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length-1; i++) {
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}
