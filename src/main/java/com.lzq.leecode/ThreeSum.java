package com.lzq.leecode;

import java.util.*;

/**
 * LeeCode
 *
 * 15. 三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {


        List<Integer> re = new ArrayList<>();



        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums);

    }


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums==null){ return null; }
        if (nums.length<3){ return Collections.EMPTY_LIST;}

        List<String> strs = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Integer> set;
        List<Integer> item;
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            for (int j = i+1; j < nums.length; j++) {

                for (int k = j+1; k < nums.length; k++) {

                    if (nums[i]+nums[j]+nums[k]==0){

                        item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);

                        set = new TreeSet<>(item);
                        if (strs.contains(set.toString())){
                            continue;
                        }else {
                            strs.add(set.toString());
                        }
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSumA(int[] nums) {

        if (nums==null){ return null; }
        if (nums.length<3){ return Collections.EMPTY_LIST;}

        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i]>0) {
                break;
            }
            if (i>0 && nums[i]==nums[i-1]){ continue; }
            int L = i + 1;
            int R = len -1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                }
                else if (sum < 0) {
                    L++;
                }
                else if (sum > 0) {
                    R--;
                }
            }

        }
        return ans;
    }


}
