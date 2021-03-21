package com.lzq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeeCode
 *
 * 面试题 16.25. LRU 缓存
 *
 * 解法二：哈希表 + 双向链表
 * @author lzq
 */
public class LRUCache2 {

    static class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node==null){
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        move2Head(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if (node==null){
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            // 添加至双向链表的头部
            add2Head(newNode);
            size++;
            if (size>capacity){
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            move2Head(node);
        }
    }


    private void move2Head(DLinkedNode node){
        removeNode(node);
        add2Head(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }



    private void add2Head(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}
