package com.lzq.leecode;

/**
 * LeeCode
 *
 * 605. 种花问题
 * @author lzq
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int flowerbed[] ={1,0,0,0,1,0,0};
        CanPlaceFlowers a = new CanPlaceFlowers();
        boolean aa = a.canPlaceFlowers(flowerbed,2);
        System.out.println(aa);
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int cur = 0;
        int size = flowerbed.length;
        int res = 0;

        while (cur<size){
            if (size==1 && flowerbed[cur]==0){
                res++;
            }else if (cur+1<size && cur==0 && flowerbed[cur]==0 && flowerbed[cur+1]==0){
                flowerbed[cur]=1;
                res++;
            }else if (cur+2<size && flowerbed[cur]==0 && flowerbed[cur+1]==0 && flowerbed[cur+2]==0){
                flowerbed[cur+1]=1;
                res++;
            }else if (cur+1==size-1 && flowerbed[cur]==0 && flowerbed[cur+1]==0){
                res++;
            }
            cur++;
        }
        return res>=n;
    }
}
