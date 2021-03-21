package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 435. 无重叠区间
 * TODO：没搞懂
 * @author lzq
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals==null || intervals.length==0){
            return 0;
        }

//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//
//        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        Arrays.sort(intervals);

        int len = intervals.length;
        int[] f = new int[len];
        Arrays.fill(f,1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1]<=intervals[i][0]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
        }

        return len - Arrays.stream(f).max().getAsInt();
    }
}
