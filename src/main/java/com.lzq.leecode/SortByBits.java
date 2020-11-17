package com.lzq.leecode;

/**
 * LeeCode
 *
 * 1356. 根据数字二进制下 1 的数目排序
 *
 */
public class SortByBits {

    private SortByBits2 sortByBits2;


    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8};
        arr = new SortByBits().sortByBits(arr);
        System.out.println(arr);
    }

    public int[] sortByBits(int[] arr) {

        if (arr==null) return null;
        int size = arr.length;
        int[] arr1Size = new int[size];
        for (int i = 0; i < size; i++) {
            int temp = arr[i];
            int mod;
            while (temp>0){
                mod = temp%2;
                temp = temp/2;
                if (mod==1){
                    arr1Size[i] = arr1Size[i]+1;
                }
            }
        }
        for(int i = 0; i < size; i++){
            for (int j = i+1; j < size; j++) {
                if (arr1Size[i]>arr1Size[j]){
                    swap(arr,arr1Size,i,j,true);
                }else if (arr1Size[i]==arr1Size[j] && arr[i]>arr[j]){
                    swap(arr,arr1Size,i,j,false);
                }
            }
        }
        return arr;
    }
    private void swap(int[] arr,int[] arr1Size,int i,int j,boolean isIndex){
        if (isIndex){
            int temp = arr1Size[j];
            arr1Size[j] = arr1Size[i];
            arr1Size[i] = temp;
        }
        int temp1 = arr[i];
        arr[i] = arr[j];
        arr[j] = temp1;
    }

}
