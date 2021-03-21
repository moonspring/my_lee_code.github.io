package com.lzq.leecode;


/**
 * LeeCode
 *
 * 387. 字符串中的第一个唯一字符
 *
 * 解法二：没有类型转换
 * @author lzq
 */
public class FirstUniqChar2 {

    public static final char ITEM_A = 'a';

    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char item: chars) { hash[item-ITEM_A]++; }
        int index = 0;
        for (char item:chars) {
            if (hash[item-ITEM_A]==1){ return index; }
            index++;
        }
        return -1;
    }
}
