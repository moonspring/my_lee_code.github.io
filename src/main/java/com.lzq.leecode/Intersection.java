package com.lzq.leecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeeCode
 * 349. 两个数组的交集
 */
public class Intersection {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        intersection(num1,num2);
    }


    public static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list1 = Arrays.stream(nums1).boxed().distinct().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().distinct().collect(Collectors.toList());

        List<Integer> results = list1.stream().filter(item-> list2.contains(item)).collect(Collectors.toList());
////        Set<Integer> simpleSet = new HashSet<>(results);
//        simpleSet.stream().forEach(System.out::println);
        int[] array = results.stream().mapToInt(i->i).toArray();

        return array;
    }
}

