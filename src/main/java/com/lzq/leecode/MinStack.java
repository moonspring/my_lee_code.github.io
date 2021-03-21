package com.lzq.leecode;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeeCode
 *
 * 155. 最小栈
 * @author adam
 */
class MinStack {

//    LinkedBlockingQueue itemQueue = new LinkedBlockingQueue();
//    ArrayBlockingQueue<Integer> itemQueue = new ArrayBlockingQueue<>(20);
//    ArrayBlockingQueue<Integer> minQueue = new ArrayBlockingQueue<>(20);

    LinkedList<Integer> itemList = new LinkedList<>();
    LinkedList<Integer> minList = new LinkedList<>();

    public MinStack(){

        minList.addFirst(Integer.MAX_VALUE);
    }
    public void push(int x) {
        itemList.addFirst(x);
        Integer tmp = Math.min(minList.getFirst(), x);
        minList.addFirst(tmp);
    }

    public void pop() {
        itemList.removeFirst();
        minList.removeFirst();
    }
    public int top(){
        return itemList.getFirst();
    }
    public int getMin() {
        return minList.getFirst();
    }
}
