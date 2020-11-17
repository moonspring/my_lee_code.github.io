package com.lzq.leecode;

import java.util.Arrays;

/**
 *
 * LeeCode
 *
 *
 * 1030. 距离顺序排列矩阵单元格
 */
public class MatrixCellsInDistanceOrder {


    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*C+j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }

//        Arrays.sort(re, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });

        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = distance(arr1[0], arr1[1], r0, c0);
            int d2 = distance(arr2[0], arr2[1], r0, c0);
            return d1-d2;
//            return Integer.compare(d1, d2);
        });

        return re;
    }

    // |r1 - r2| + |c1 - c2|
    private int distance(int currentR0,int currentC0,int r0, int c0){
        return  Math.abs(currentC0-c0)+Math.abs(currentR0-r0);
    }

}
