package com.lzq.interview;


/**
 * 跃盟科技
 * int[] a = int[] {1,33,41,55};
 * int[] b = int[] {2,21,43,100,111};
 * int[] c= int[];
 *
 * @author lzq
 */
public class ArrayInOrder {


    public static void main(String[] args) {

    }


    public int[] orderArray(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int index = 0;

        int curA = 0,curB = 0;

        while (curA<a.length || curB<b.length){

            if (curA==a.length && curB<b.length){
                c[index++] = a[curB++];
            }else if (curB==b.length && curA<a.length){
                c[index++] = b[curA++];
            }else if (a[curA]<=b[curB]){
                c[index++] = a[curA++];
            }else if (a[curA]>b[curB]){
                c[index++] = b[curB++];
            }
        }

        return c;
    }

//    public int[] orderArray(int[] a, int[] b){
//        int[] c = new int[a.length+b.length];
//        int index = 0;
//
//        int curA = 0,curB = 0;
//        while (curA<a.length && curB<b.length){
//            if (a[curA]<=b[curB]){
//                c[index++] = a[curA++];
//            }else {
//                c[index++] = b[curB++];
//            }
//        }
//        if (curA+1<a.length){
//            for (int i = curA+1; i < a.length; i++) {
//                c[index++] = a[i];
//            }
//        }
//        if (curB+1<b.length){
//            for (int i = curB+1; i < a.length; i++) {
//                c[index++] = a[i];
//            }
//        }
//        return c;
//    }

}
