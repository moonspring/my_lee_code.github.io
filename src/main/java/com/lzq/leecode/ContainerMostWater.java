package com.lzq.leecode;

public class ContainerMostWater {


    public static void main(String[] args) {

//        ContainerMostWater.maxArea();

    }


    public static int maxArea(int[] height) {

        int n = height.length;
        int maxArea = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int high = Math.min(height[i],height[j]);
                int width = j-i;
                maxArea = Math.max(maxArea,high*width);
            }
        }
        return maxArea;
    }

}
