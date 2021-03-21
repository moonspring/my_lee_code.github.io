package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 283. 移动零
 *
 * 解题1：插入排序思想
 */
public class MoveZeroes {


    public static void main(String[] args) {

//        MoveZeroes moveZeroes = new MoveZeroes();
//        MoveZeroes2 moveZeroes = new MoveZeroes2();


        MoveZeroes3 moveZeroes = new MoveZeroes3();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.err::println);

    }

    public void moveZeroes(int[] nums) {

        int zeroNum = 0;
        int step = 0;
        int len = nums.length;
        while(step+zeroNum<len){
            if(nums[step]==0){
                zeroNum++;
                for(int i =step;i<len-zeroNum;i++){
                    nums[i] = nums[i+1];
                }
                nums[len-zeroNum] = 0;
            }else{
                step++;
            }
        }
    }
}
