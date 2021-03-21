package com.lzq.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeeCode
 *
 * 155. 最小栈
 *
 * 解法二
 * @author adam
 */
public class MinStack2 {

    LinkedList<Integer> itemList = new LinkedList();
    LinkedList<Integer> minList = new LinkedList<>();
    public MinStack2(){
        minList.push(Integer.MAX_VALUE);
    }
    public void push(int x) {
        itemList.push(x);
        Integer tmp = Math.min(minList.peek(), x);
        minList.push(tmp);
    }

    public void pop() {
        itemList.pop();
        minList.pop();
    }
    public int top(){
        return itemList.peek();
    }
    public int getMin() {
        return minList.peek();
    }


}
