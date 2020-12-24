package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 135. 分发糖果
 * @author lzq
 */
public class Candy {

    public static void main(String[] args) {
        boolean[] isCover = new boolean[2];
        System.out.println(isCover[0]);
    }


    public int candy(int[] ratings){

        int size = ratings.length;

        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for (int i = 1; i < size; i++) {
            if (ratings[i]>ratings[i-1]){left[i] = left[i-1]+1;}
        }

        int count = left[size-1];
        for (int i = size-2; i >= 0; i--) {
            if (ratings[i]>ratings[i+1]){right[i] = right[i+1]+1;}

            count += Math.max(left[i],right[i]);
        }
        return count;
    }
}
