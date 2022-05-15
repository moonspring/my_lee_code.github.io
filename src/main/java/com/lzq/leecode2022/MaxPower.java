package com.lzq.leecode2022;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串 s 的 能量。
 *
 * @author liuzhengquan
 * @date 2022/05/13 18:10
 **/
public class MaxPower {

    public static void main(String[] args) {
        String s = "cc";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {

        int max = 1;

        int tmp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1)==s.charAt(i)){
                tmp++;
            }else {
                max = Math.max(max,tmp);
                tmp = 1;
            }
        }
        return Math.max(max,tmp);
    }
}
