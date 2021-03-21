package com.lzq.leecode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * LeeCode
 *
 * 1319. 连通网络的操作次数
 * @author lzq
 */
public class MakeConnected {

    public static void main(String[] args) {
        MakeConnected makeConnected = new MakeConnected();
        System.out.println(makeConnected.makeConnected(-1,null));
    }

    public int makeConnected(int n, int[][] connections) {

        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1-o2);

        int num = 0;
        for (int[] item:connections) {
            if (set.contains(item[0]) && set.contains(item[1])){
                num++;
            }else {
                set.add(item[0]);
                set.add(item[1]);
            }
        }

        int t = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)){
                t++;
            }
        }

        if (t>num){
            return -1;
        }else {
            return t;
        }

    }
}
