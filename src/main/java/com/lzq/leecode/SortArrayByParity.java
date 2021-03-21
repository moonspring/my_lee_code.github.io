package com.lzq.leecode;


import java.util.Arrays;

/**
 *
 * LeeCode
 *
 * 922. 按奇偶排序数组 II
 */
public class SortArrayByParity {

    public static void main(String[] args) {

        SortArrayByParity sort = new SortArrayByParity();
        int[] A = {2,0,3,4,1,3};
        sort.sortArrayByParityII(A);

        Arrays.stream(A).forEach(System.err::println);
    }


    public int[] sortArrayByParityII(int[] A) {

        for(int i=0;i<A.length-1;i++){

            int flag = 0;
            /* 偶数位为偶数,奇数位为奇数 */
            if((i%2 ==0 && A[i]%2==0) || (i%2 ==1 && A[i]%2==1)){
                continue;
            }else if(i%2 ==0 && A[i]%2==1){
                flag = 1;
            }else if(i%2 ==1 && A[i]%2==0){
                flag = 0;
            }
            /* 奇数位 */
            int j = i+1;
            int index = findIndex(A,j,A.length,flag);
            if(index>i){swap(A,i,index);}
        }
        return A;
    }

    // flag = 1 是奇数找偶数; flag = 0 是偶数找奇数
    private int findIndex(int[] A,int j,int len,int flag){
        while(j+1<len && A[j]%2==flag){
            j+=2;
        }
        return j;
    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
