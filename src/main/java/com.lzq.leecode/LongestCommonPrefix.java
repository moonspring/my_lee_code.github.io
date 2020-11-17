package com.lzq.leecode;

/**
 * LeeCode
 *
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {

        String[] strs = {"ab","a"};

        LongestCommonPrefix item = new LongestCommonPrefix();
        String result = item.longestCommonPrefix(strs);
        System.out.println(result);

    }

    public String longestCommonPrefix(String[] strs) {


        if (strs==null) { return null; }
        if (strs.length==0) { return "";}
        if (strs.length == 1){ return strs[0]; }

        String firstItem = strs[0];
        int len = strs.length;

        /* 一位一位的遍历 */
        int i;
        outer:
        for(i = 0;i<firstItem.length();i++) {

            /* 对比其他len -1 个数的对应位数 */
            for (int j = 1; j < len; j++) {
                if (i<strs[j].length()){
                    if (firstItem.charAt(i)!=strs[j].charAt(i)){
                        break outer;
                    }
                }else if (i == strs[j].length()){
                    break outer;
                }
            }

        }

        return firstItem.substring(0,i);
    }
}
