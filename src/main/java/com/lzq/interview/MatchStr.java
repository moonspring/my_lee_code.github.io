package com.lzq.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 有序的整数数组[2,3,5,7,9,10,11,12,13,14]，寻找满足[]+[]=K条件的值。
 * 如果 K=12，则输出(2,10)(3,9)(5,7)组合的对，
 * 要求时间和空间复杂度尽可能的低。
 */
public class MatchStr {

    public List<int[]> matchResult(int[] arrays,int k){

        List<int[]> items = new ArrayList<>();
        int left = 0;
        int right =arrays.length-1;
        while (left<right){
            int tmpRes = arrays[left]+arrays[right];
            if (tmpRes>k){
                int curLeft = left;
                int curRight = right;
                for (int i = curRight;i>curLeft;--i) {
                    tmpRes = arrays[curLeft]+arrays[i];
                    if (tmpRes<k){
                        left++;
                        break;
                    }else if (tmpRes == k){
                        int[] subItem =  {arrays[left],arrays[right]};
                        items.add(subItem);
                        left++;
                        right--;
                        break;
                    }
                }
            }else if (tmpRes == k){
                int[] subItem =  {arrays[left],arrays[right]};
                items.add(subItem);
                left++;
                right--;
            }else if (tmpRes < k){
                return items;
            }
        }
        return items;
    }


    private void compare(int[] arrays,int k,int left,int right){
        int sum = arrays[left]+arrays[right];

    }

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            table.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer key = target-numbers[i];
//            if(table.containsKey((key) && table.get(key)!=i){
//                System.out.println(key + "," + numbers[i]);
//            }
        }
        return result;
    }





}
