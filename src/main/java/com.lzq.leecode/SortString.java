package com.lzq.leecode;


import java.util.Arrays;

/**
 * LeeCode
 *
 * 1370. 上升下降字符串
 */
public class SortString {


    public static void main(String[] args) {
        SortString sortString = new SortString();
//        String s = sortString.sortString("aaaabbbbcccc");
//        String s = sortString.sortString("rat");
        String s = sortString.sortString("leetcode");
        System.out.println(s);
    }


    public String sortString(String s) {
        if (s==null){ return null; }
        if ("".equals(s)){ return ""; }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int index =0;
        boolean first = true;
        int len = s.toCharArray().length;

        char[] result = new char[len];
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            flag[i] = false;
        }

        while (index<len){
            for (int i = 0; i < len; i++) {
                if(first && !flag[i]){
                    result[index++] = chars[i];
                    flag[i] = true;
                    first = false;
                }else if (!flag[i] && result[index-1]<chars[i]){
                    result[index++] = chars[i];
                    flag[i] = true;
                    first = false;
                }else if (!flag[i] && result[index-1]>chars[i]){
                    break;
                }
            }
            if (index>=len){
                break;
            }
            first = true;
            for (int i = len-1; i >=0 ; i--) {
                if (first && !flag[i]){
                    result[index++] = chars[i];
                    flag[i] = true;
                    first = false;
                }else if(!flag[i] && result[index-1]>chars[i]){
                    result[index++] = chars[i];
                    flag[i] = true;
                    first = false;
                }else if (!flag[i] && result[index-1]<chars[i]){
                    break;
                }
            }
            first = true;
        }

        return new String(result);
    }

}
