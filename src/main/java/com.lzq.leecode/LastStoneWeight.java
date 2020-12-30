package com.lzq.leecode;

import java.util.PriorityQueue;

/**
 * LeeCode
 *
 * 1046. 最后一块石头的重量
 * 堆排序
 * @author lzq
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);

        for (int item: stones) {
            queue.offer(item);
        }

        while (queue.size()>1){
            Integer one = queue.poll();
            Integer two = queue.poll();
            if (!one.equals(two)){
                queue.offer(one-two);
            }
        }
        return queue.size()==0?0:queue.poll();
    }

}
