package com.lzq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeeCode
 *
 * 454. 四数相加 II
 *
 * @author lzq
 */
public class FourSumCount {

    public static void main(String[] args) {

        int[] A = {-1,-1};
        int[] B = {-1,1};
        int[] C = {-1,1};
        int[] D = {1,-1};

        FourSumCount fourSumCount = new FourSumCount();
        int result = fourSumCount.fourSumCount(A,B,C,D);
        System.out.println(result);
    }


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> countAB = new HashMap<>();
        int sumAB;
        for (int a : A) {
            for (int b : B) {
                sumAB = a +b;
                countAB.put(sumAB, countAB.getOrDefault(sumAB, 0) + 1);
            }
        }

        int ans = 0;
        int sumCD;
        for (int c : C) {
            for (int d : D) {
                sumCD = -c - d;
                if (countAB.containsKey(sumCD)) {
                    ans += countAB.get(sumCD);
                }
            }
        }
        return ans;
    }
}
