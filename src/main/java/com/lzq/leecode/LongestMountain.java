package com.lzq.leecode;

/**
 * LeeCode
 *
 * 845. 数组中的最长山脉
 */
public class LongestMountain {

    public static void main(String[] args) {

//        int[] A = {2,1,4,7,3,2,5,4};
//        int[] A = {2,1,4,7,3,2,5};
        int[] a = {0,1,2,3,4,5,4,3,2,1,0};
        int length = longestMountain(a);
        System.out.println(length);
    }

    public static int longestMountain(int[] a) {
        if (a==null || a.length<3){ return 0; }
        boolean[] flag = new boolean[a.length];
        for (int i = 1; i < a.length-1; i++) {
            if (a[i-1]<a[i] && a[i]>a[i+1]){
                flag[i] = true;
            }else {
                flag[i] = false;
            }
        }
        flag[0] = false;
        flag[a.length-1] = false;

        int maxLength = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]){
                int left = 0;
                int right = 0;
                for (int j = i; j >0 ; j--) {
                    if (a[j-1]<a[j]){
                        left++;
                    }else {
                        break;
                    }
                }
                for (int j = i;j<a.length-1;j++){
                    if (a[j]>a[j+1]){
                        right++;
                    }else {
                        break;
                    }
                }
                maxLength = Math.max(left+right+1,maxLength);
            }
        }
        return maxLength;
    }

}
