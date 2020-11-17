package com.lzq.leecode;

/**
 * LeeCode
 *
 * 941. 有效的山脉数组
 */
public class ValidMountainArray {

    public static void main(String[] args) {

        int[] A = {9,8,7,6,5,4,3,2,1,0};
        boolean flag = validMountainArray(A);
        System.out.println(flag);
    }

    public static boolean validMountainArray(int[] A) {
        /* 小于三个 */
        if (A.length<3){ return false; }
        int maxIndex = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i]>max){
                max = A[i];
                maxIndex = i;
            }else if (A[i]==max){
                return false;
            }
        }
        /* 最大在边上 */
        if (maxIndex==0|| maxIndex+1==A.length){  return false; }

        for (int i = 0; i < A.length; i++) {
            if (i<maxIndex){
                if (A[i]>=A[i+1]){
                    return false;
                }
            }else if (i>maxIndex && i<A.length-1){
                if (A[i]<=A[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
