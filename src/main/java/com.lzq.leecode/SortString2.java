package com.lzq.leecode;

/**
 * LeeCode
 *
 * 1370. 上升下降字符串
 * 解法二：构造哈希表，哈希表数据没了，就排完序了
 */
public class SortString2 {


    public String sortString(String s) {

        if (s == null || "".equals(s)) {return s;}

        /* 构造哈希表 */
        int[] countMap = new int[26];
        for (char item:s.toCharArray()) {
            countMap[item-'a']++;
        }

        int len = s.length();
        int index = 0;
        char[] result = new char[len];
        while (index<len){
            for (int i = 0; i < len; i++) {
                if (countMap[i]>0){
                    result[index++] = (char)(i+'a');
                    countMap[i]--;
                }
            }
            for (int i = len-1; i >=0; i--) {
                if (countMap[i]>0){
                    result[index++] = (char)(i+'a');
                    countMap[i]--;
                }
            }
        }
        return new String(result);
    }
}
