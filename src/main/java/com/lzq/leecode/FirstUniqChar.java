package com.lzq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeeCode
 *
 * 387. 字符串中的第一个唯一字符
 * @author lzq
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {

        Map<Integer,Integer> hash = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        Integer temp;
        for (char item: chars) {
            temp = item-'a';
            hash.put(temp,hash.getOrDefault(temp,0)+1);
        }

        int index = 0;

        for (char item:chars) {
            temp = item-'a';
            if ( hash.get(temp)!=null && hash.get(temp)==1){
                return index;
            }
            index++;
        }

        return -1;
    }
}
