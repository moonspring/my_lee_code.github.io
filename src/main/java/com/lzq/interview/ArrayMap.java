package com.lzq.interview;

import java.util.*;

/**
 * sogou
 * 对正整数数组arr，实现一个方法，将数组中的数分组并输出，分组规则如下：
 * 1~10、11~100、101~1000、1001~10000 …… 10000001~100000000 ……；
 * 例：
 *
 * public static Map<String, List<Long>> grouping(long[] arr);
 *
 * @author adam
 */
public class ArrayMap {

    /**
     * 注意点：
     *  系统边界问题
     *
     * @param args
     */
    public static void main(String[] args) {

//        long[] arr = {2,18,100,101,201,1300,1500,4300,Long.MAX_VALUE-200,Long.MAX_VALUE};
        long[] arr = {Long.MAX_VALUE-200,Long.MAX_VALUE-2};

        Map<String, List<Long>> map = grouping(arr);
        System.out.println(map);

    }
    public static Map<String, List<Long>> grouping(long[] arr){
        Arrays.sort(arr);
        Map<String,List<Long>> map = new HashMap<>();
        long base = 10,times;
        for (long item:arr) {
            while ((times = item/base)!=0 && base*10>0){ base *=10; }
            if (times==0 || base*10<0){
                String key = String.format("%s~%s",base/10,(base+1));
                if (map.get(key)==null){
                    List<Long> ls = new ArrayList<>();
                    ls.add(item);
                    map.put(key,ls);
                }else {
                    map.get(key).add(item);
                }
            }else if (base*10>0){
                base *=10;
            }
        }
        return map;
    }
}
