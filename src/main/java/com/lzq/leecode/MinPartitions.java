package com.lzq.leecode;

/**
 * LeeCode
 *
 * 1689. 十-二进制数的最少数目
 * @author lzq
 */
public class MinPartitions {

    public static void main(String[] args) {
        System.out.println('1'-'0');
    }


    public int minPartitions(String n) {

        if (n.length()<2){
            return Integer.valueOf(n);
        }
        int first = Integer.valueOf(n.charAt(0)-'0');
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            if (max<n.charAt(i)-'0'){
                max = n.charAt(i)-'0';
            }
        }
        if (first>=max){
            return first;
        }else {
            return max;
        }
    }

}
