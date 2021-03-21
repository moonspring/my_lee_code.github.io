package com.lzq.leecode;

/**
 * LeeCode
 *
 * 509. 斐波那契数
 * @author lzq
 */
public class Fib {

    public int fib(int n) {

        if (n==0){ return 0;}
        if (n==1){ return 1;}
        return fib(n-1)+fib(n-2);
    }
}
