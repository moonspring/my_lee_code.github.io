package com.lzq.leecode;

/**
 * LeeCode
 *
 * 148. 排序链表
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        if (head==null){ return null; }

        ListNode left = head;
        ListNode right = head.next;

        while (right!=null){
            if (left.val<=right.val){

            }else {
                while (left.next!=null && left.val<=right.val){

                }
            }
            right = right.next;
        }
        return null;
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
