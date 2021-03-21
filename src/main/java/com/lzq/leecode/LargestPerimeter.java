package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 976. 三角形的最大周长
 * @author lzq
 */
public class LargestPerimeter {

    private static final int C_THREE = 3;


    public static void main(String[] args) {

        LargestPerimeter largestPerimeter = new LargestPerimeter();
        int[] A = {1,2,1};
        int result = largestPerimeter.largestPerimeter(A);
        System.out.println(result);
    }

    public int largestPerimeter(int[] A) {

        if (A==null || A.length< C_THREE ){ return 0; }

        Arrays.sort(A);
        int len = A.length;

        int k = len;

        int first = A[k-1];
        int second = A[k-2];
        int third = A[k-3];

        while (k>=C_THREE && second + third <=first){
            if ( third== 0){
                return 0;
            }
            k--;
            if (k<=2){
                return 0;
            }
            first = A[k-1];
            second = A[k-2];
            third = A[k-3];
        }

        return first + second + third;
    }

}
