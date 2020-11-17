package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 1356. 根据数字二进制下 1 的数目排序
 * 解法二：位运算
 */
public class SortByBits2 {


    public int[] sortBits(int[] arr){

        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            int bigCount = Integer.bitCount(arr[i]);

            int item = bigCount*10000000+arr[i];
            map[i] = item;
        }
        Arrays.sort(map);

        for (int i = 0; i < arr.length; i++) {
            map[i] = map[i] % 10000000;
        }

        return map;
    }

}
