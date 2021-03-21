package com.lzq.leecode;

/**
 * LeeCode
 *
 * 86. 分隔链表
 * @author lzq
 */
public class Partition {

    public static void main(String[] args) {

        ListNode a = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));

        Partition partition = new Partition();
        partition.partition(a,3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private void removeNode(ListNode node){

    }

    private void addNode(ListNode node){

    }




}
