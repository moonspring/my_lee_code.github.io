package com.lzq.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 松果出行
 *
 *  输入：(1 -> 6 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 2 -> 7
 *  原因：163 + 564 = 727
 */
public class SongGuo {


    public static void main(String[] args) {

        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(6);
        LinkNode node3 = new LinkNode(3);
        LinkNode node = new LinkNode(1);
    }

    public static class LinkNode {
        int val;
        LinkNode next;
        public LinkNode (int x) {
            val = x; next =null;}
    }


    public int sum(LinkNode one, LinkNode two){
        int oneSum = sumValue(one);
        int twoSum = sumValue(two);
        return oneSum+twoSum;
    }

    private int sumValue(LinkNode node){
        List<Integer> ls = new ArrayList<>();

        ls.add(node.val);
        LinkNode oneNext;
        while ((oneNext=node.next)!=null){
            ls.add(oneNext.val);
        }

        int sum = 0;
        int base = 10;
        boolean first = true;
        for (int i = ls.size()-1; i >=0; i--) {
            if (first){
                sum +=ls.get(i);
                first = false;
            }else {
                sum +=ls.get(i)*base;
            }
        }
        return sum;
    }




}
