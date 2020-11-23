package com.lzq.leecode;

/**
 * LeeCode
 *
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {


    public static void main(String[] args) {

//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = {{1,2}};
//        int[][] points = {{2,3},{2,3}};
//        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] points = {{7,15},{6,14},{8,12},{3,4},{4,13},{6,14},{9,11},{6,12},{4,13}};
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();

        int result = findMinArrowShots.findMinArrowShots(points);
        System.out.println(result);

    }


    public int findMinArrowShots(int[][] points) {
        if (points==null){ return 0; }
        if (points.length == 1){ return 1;}
        /* 至少一次 */
        int result = 0;
        /* 一共有多少个区间 */
        int len = points.length;
        /* 按照x0排序 */
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (points[i][0]>points[j][0]){
                    int[] temp = points[i];
                    points[i] = points[j];
                    points[j]= temp;
                }
            }
        }
        /* 相交  VS  不相交 */
        int max,left = 0,cur = 1;
        while (left < len){
            result++;
            //不相交
            while (left+cur < len && points[left][1] < points[left+cur][0]){ result++;left++; }
            //相交
            if (left+cur<len){
                max = Math.min(points[left][1],points[left+cur][1]);
            }else { return result; }
            cur++;
            while (left + cur < len && max>=points[left+cur][0]){
                max = Math.min(max,points[left+cur][1]);
                cur++;
            }
            left += cur;
            cur = 1;
        }
        return result;
    }
}
