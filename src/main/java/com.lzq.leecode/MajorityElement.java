package com.lzq.leecode;

/**
 *
 * 面试题 17.10. 主要元素
 * @author lzq
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement.majorityElement(null);
    }

    public static int majorityElement(int[] nums) {

        int temp = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0){
                temp = num;
                count = 1;
            } else {
                if (temp == num){
                    count++;
                } else{
                    count--;
                }
            }
        }
        if (count > 0){
            int n = 0;
            for (int i : nums) {
                if (i == temp){
                    n++;
                }
            }
            if (n > nums.length/2){
                return temp;
            }
        }
        return -1;
    }
}
