package com.lzq.leecode;

/**
 * LeeCode
 *
 * 剑指 Offer 64. 求1+2+…+n
 * @author lzq
 */
public class SumNums {

    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }
}
