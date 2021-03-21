package com.lzq.leecode;

/**
 * LeeCode
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author lzq
 */
public class SearchRange {

    public static void main(String[] args) {

        SearchRange searchRange = new SearchRange();

//        int[] nums = {0,1,2,3,4,4,4};
//        int target = 2;
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] result = searchRange.searchRange(nums,target);
        System.out.println(result);
    }


    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        if (len==0){ return new int[]{-1, -1};}

        int pos = compare(nums,len,0,len-1,target);
        if (pos==-1){
            return new int[]{-1, -1};
        }

        int start = pos;
        int end = pos;

        while (start>=0 && nums[start]==target){
            start--;
        }
        while (end<=len-1 && nums[end]==target){
            end++;
        }
        return new int[]{Math.max(-1,start+1),Math.max(-1,end-1)};
    }


    private int compare(int[] nums,int len ,int start,int end,int target){

        if (nums[start]>target || nums[end]<target){
            return -1;
        }else if (nums[start]==target){
            return start;
        }else if (nums[end]==target){
            return end;
        }

        // 1 2 3 4 5 6
        // 0 1 1 2 2 3
        int mid = (start + end)/2;
        if (nums[mid]<target){
            return compare(nums,len,mid,end,target);
        }else if (nums[mid]>target){
            int temp = mid+1;
            if (mid>=len){
                temp = mid;
            }
            return compare(nums,len,start,temp,target);
        }else if (nums[mid]==target){
            return mid;
        }

        return -1;
    }

}
