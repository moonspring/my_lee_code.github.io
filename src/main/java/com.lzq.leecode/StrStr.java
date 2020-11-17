package com.lzq.leecode;

/**
 * LeeCode
 *
 * 28. 实现 strStr()
 *
 * 解法一：直接调用java indexOf
 */
public class StrStr {


    /* 解法二： */
    private StrStr2KMP strStr2KMP;

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";

        int result = strStr(haystack,needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        if (needle==null || needle.equals("") || haystack==null){
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
