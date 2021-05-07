package com.lzq.leecode;


/**
 * LeeCode
 * 83. 删除排序链表中的重复元素
 * @author adam
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode first = head;

        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return first;
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
