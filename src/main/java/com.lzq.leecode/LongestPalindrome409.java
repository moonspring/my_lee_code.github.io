package com.lzq.leecode;

/**
 * LeeCode
 *
 * 409. 最长回文串
 * 解法一：ASCII码+Hash表+位运算
 */
public class LongestPalindrome409 {

    public static void main(String[] args) {
//        LongestPalindrome409 longestPalindrome409 = new LongestPalindrome409();
        LongestPalindrome4092 longestPalindrome409 = new LongestPalindrome4092();

        String s = "dsjfioadsfafmosfifmAMFLSLF";
        int result = longestPalindrome409.longestPalindrome(s);

        System.out.println(result);
    }


    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
//        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}
