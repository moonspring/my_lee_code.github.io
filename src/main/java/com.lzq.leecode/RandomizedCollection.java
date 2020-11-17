package com.lzq.leecode;

import java.util.*;

/**
 * LeeCode 381
 */
public class RandomizedCollection {

    /* key为元素。set元素：添加元素时，该元素在list中的位置。set个数为添加次数 */
    private Map<Integer, Set<Integer>> idx;

    /* 存储的是添加的元素，不管顺序  */
    private List<Integer> nums;


    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /* 新增 */
    public boolean insert(int val){

        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val,new HashSet<>());
        set.add(nums.size()-1);
        idx.put(val,set);

        return set.size()==1;
    }

    /* 删除 */
    public boolean remove(int val) {

        /* 不存在 */
        if (!idx.containsKey(val)){
            return false;
        }

        Set<Integer> set = idx.get(val);
        Iterator<Integer> iterator = set.iterator();

        /* 该删除元素在list中的位置 */
        int i = iterator.next();

        /* 最后一个元素 换到 被删除的元素 的位置 */
        int lastNum = nums.get(nums.size()-1);
        nums.set(i,lastNum);

        /* 删除元素的位置信息 */
        idx.get(val).remove(i);
        /* 删除最后一个元素位置信息 */
        idx.get(lastNum).remove(nums.size()-1);

        /* List中，添加该元素的位置 */
        if (i<nums.size()-1){
            idx.get(lastNum).add(i);
        }

        /* 空元素时，清空列表 */
        if (idx.get(val).size()==0){
            idx.remove(val);
        }

        /* 删除list中元素 */
        nums.remove(nums.size()-1);

        return true;
    }

    /* List是带重复元素的列表，random之后，乘以List中元素的总数，即等于根据该元素的比例，随机获取 */
    public int getRandom() {
        return nums.get((int)(Math.random() * nums.size()));
    }
}
