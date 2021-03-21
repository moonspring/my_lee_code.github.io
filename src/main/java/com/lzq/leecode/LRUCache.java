package com.lzq.leecode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeeCode
 *
 * 面试题 16.25. LRU 缓存
 *
 * 解法一：LinkedHashMap实现
 * @author lzq
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int category;

    public LRUCache( int category) {
        super(category,0.75F,true);
        this.category = category;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key,-1);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>category;
    }
}
