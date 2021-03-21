package com.lzq.leecode;

import java.util.Arrays;

/**
 * 最小差值题
 */
public class SmallestRange {

    public static void main(String[] args) {

        int[] A = new int[5];
        A[0] = 4;
        A[1] = 3;
        A[2] = 19;
        A[3] = 7;
        A[4] = 40;
        int k = smallestRangeII(A,7);
        System.out.println(k);

    }

    public static int smallestRangeII(int[] A, int K) {

        /*
         * a = A[0]+K
         * b = A[i]+K
         * c = A[i+1]-K
         * d = A[A.length-1]-K
         *
         * min = Math.min(a,c) = Math.min(A[0]+K,A[i+1]-K);
         * max = Math.max(b,d) = Math.max(A[i]+K,A[A.length-1]-K);
         */
        //切点是i点。a、b、c、d
        Arrays.sort(A);
        int a = A[0] + K;
        int d = A[A.length-1] - K;

        int res = A[A.length-1] - A[0];
        for (int i = 0; i < A.length-1; i++) {
            int b = A[i]+K;
            int c = A[i+1]-K;
            int minB = Math.min(a,c);
            int maxB = Math.max(b,d);
            res = Math.min(maxB-minB,res);
        }

        return res;
    }
}
