package com.lzq.leecode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeeCode
 *
 * 409. 最长回文串
 * 解法二：Java8 使用Java8 利用map做hash表+位运算
 */
public class LongestPalindrome4092 {



    public int longestPalindrome(String s) {

        /* 每个字符，转ASCII码 */

        Map<Integer,Integer> num = s.chars().boxed().collect(Collectors.toMap(k -> k,v -> 1, Integer::sum));
        int ans = num.values().stream().mapToInt(i->i-(i & 1)).sum();

        return ans < s.length() ? ans + 1 : ans;
    }
}
