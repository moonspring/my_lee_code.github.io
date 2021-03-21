package com.lzq.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * LeeCode
 *
 * 57. 插入区间
 */
public class Insert {

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        int[][] result = insert(intervals,newInterval);

        Arrays.stream(result).forEach(System.out::println);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int left = newInterval[0];
        int  right  = newInterval[1];

        boolean isPlaced = false;

        for (int i = 0; i < intervals.length; i++) {

            if (right < intervals[i][0]){
                if (!isPlaced){
                    isPlaced = true;
                    result.add(new int[]{left, right});
                }
                result.add(intervals[i]);
            }else if (left>intervals[i][1]){
                result.add(intervals[i]);
            }else {
                //交叉的情况
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }
        if (!isPlaced) {
            result.add(new int[]{left, right});
        }

//        int[][] ans = new int[result.size()][2];
//        for (int i = 0; i < result.size(); ++i) {
//            ans[i] = result.get(i);
//        }
//        return ans;

        return result.toArray(new int[result.size()][2]);

    }
}
















