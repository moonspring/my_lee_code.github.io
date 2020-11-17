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
        int[] A = {0,1,2,3,4,5,4,3,2,1,0};
        int length = longestMountain(A);
        System.out.println(length);
    }

    public static int longestMountain(int[] A) {
        if (A==null || A.length<3){ return 0; }
        boolean[] flag = new boolean[A.length];
        for (int i = 1; i < A.length-1; i++) {
            if (A[i-1]<A[i] && A[i]>A[i+1]){
                flag[i] = true;
            }else {
                flag[i] = false;
            }
        }
        flag[0] = false;
        flag[A.length-1] = false;

        int maxLength = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]){
                int left = 0;
                int right = 0;
                for (int j = i; j >0 ; j--) {
                    if (A[j-1]<A[j]){
                        left++;
                    }else {
                        break;
                    }
                }
                for (int j = i;j<A.length-1;j++){
                    if (A[j]>A[j+1]){
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
