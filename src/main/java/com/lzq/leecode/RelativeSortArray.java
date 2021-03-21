package com.lzq.leecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RelativeSortArray {

    public static void main(String[] args) {


        RelativeSortArray re = new RelativeSortArray();

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        re.relativeSortArray(arr1,arr2);

        Arrays.stream(arr1).forEach(System.err::println);
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int len = arr1.length;

        List<Integer> ls = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len-1; j++) {
                if (arr1[i]>arr1[j] && !ls.contains(arr1[i]) && !ls.contains(arr1[j])){
                    int temp = arr1[i];
                    arr1[j] = arr1[i];
                    arr1[i] = temp;
                }else if (arr1[i]==arr1[j]){

                }
            }
        }

        return arr1;
    }

}
